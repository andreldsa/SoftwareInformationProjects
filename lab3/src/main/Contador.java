package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Contador {
	private static Contador contador;

	private Map<Keyword, Integer> keywords = new HashMap<Keyword, Integer>();
	
	private ExecutorService executorService;

	private Window window;

	private JTextArea outputPane;
	private List<File> files;
	private int encontrados;
	private int arquivosLidos;

	private JLabel progresso;

	public static Contador getInstance(Window window) {
		if (contador == null) {
			contador = new Contador(window);
		}
		return contador;
	}

	private Contador(Window window) {
		this.window = window;
		this.outputPane = window.getOutputPane();
		this.progresso = window.getOutputProgress();
		files = new ArrayList<File>();
	}

	public void inicia(File file) {
		entraNaPasta(file);
		progresso.setText("Arquivos .java Encontrados: " + encontrados
				+ " | Arquivos Lidos: " + arquivosLidos);
		window.setVerifiable(true);
	}

	private void entraNaPasta(File directory) {
		for (final File file : directory.listFiles()) {
			if (file.isDirectory()) {
				try {
					entraNaPasta(file);
				} catch (Exception exception) {
					System.err.println("A pasta " + file
							+ " não pode ser acessada. Erro: "
							+ exception.getMessage());
				}
			} else if (file.isFile()) {
				String path = file.toString();
				if (path.matches(".*java$")) {
					setFile(file);
				}
				arquivosLidos++;
			}
		}
	}

	private void setFile(File file) {
		files.add(file);
		outputPane.append(file.toString());
		outputPane.append("\n");
		encontrados++;
	}

	public void iniciaVerificacao(int numThreads) {
		for(Keyword key : Keyword.values()) {
			keywords.put(key, 0);
		}
		executorService = Executors.newFixedThreadPool(numThreads);
		for(final File file: files) {
			Callable<Float> task = new Callable<Float>() {

				@Override
				public Float call() throws Exception {
					for(Keyword key: Keyword.values()) {
						keywords.put(key, keywords.get(key)+getKeyCounter(file, key));
						System.out.println(key+": "+keywords.get(key));
					}
					return 42f;
				}
			}; 
			executorService.submit(task);
		}
		executorService.shutdown();
	}

	public static int getKeyCounter(File file, Keyword key) {
		int cont = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String lido = "";
			while (in.ready()) {
				lido += in.readLine();
			}
			in.close();

			String[] codigo = lido.split("\\W");
			List<String> palavras = Arrays.asList(codigo);

			for (String palavra : palavras)
				if (palavra.equals(key.getValue())) {
					cont++;
				}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		return cont;
	}
}
