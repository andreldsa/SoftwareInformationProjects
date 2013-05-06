package main;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Janela implements Window{
	private JFrame frame;
	private JPanel panel;
	private JPanel panelSouth;
	private JTextArea outputPane;
	private JLabel outputProgress;
	private JButton botao, botaoVerificar;
	
	public Janela() {
		iniciaFrame();
		iniciaPaineis();
		iniciaOutputPane();
		iniciaOutputProgress();
		iniciaBotoes();
	}

	private void iniciaOutputProgress() {
		outputProgress = new JLabel("Total de Arquivos: 0" 
				+ " | Total Lido: 0%"
				+ " | Atual: .");
		panelSouth.add(outputProgress, BorderLayout.CENTER);
	}

	private void iniciaBotoes() {
		botao = new JButton();
		botao.setText("Abrir");
		panelSouth.add(botao, BorderLayout.EAST);
		botao.addActionListener(new FileChooser(this));
		
		botaoVerificar = new JButton();
		botaoVerificar.setText("Verificar");
		botaoVerificar.setEnabled(false);
		botaoVerificar.addActionListener(new KeyCounter(this));
		panelSouth.add(botaoVerificar, BorderLayout.WEST);
	}

	private void iniciaOutputPane() {
		outputPane = new JTextArea();
		JScrollPane scroll = new JScrollPane(outputPane);
		outputPane.setEditable(false);
		panel.add(scroll, BorderLayout.CENTER);
	}

	private void iniciaFrame() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
	}

	public void inicia() {
		frame.setVisible(true);
	}
	
	private void iniciaPaineis() {
		panel = new JPanel();
		panel.setBackground(new Color(255,255,255));
		BorderLayout border = new BorderLayout();
		panel.setLayout(border);
		frame.add(panel, BorderLayout.CENTER);
		
		panelSouth = new JPanel();
		panelSouth.setBackground(new Color(255,255,255));
		BorderLayout borderSouth = new BorderLayout();
		panelSouth.setLayout(borderSouth);
		frame.add(panelSouth, BorderLayout.SOUTH);
	}

	@Override
	public JTextArea getOutputPane() {
		return outputPane;
	}

	@Override
	public JLabel getOutputProgress() {
		return outputProgress;
	}

	@Override
	public void setVerifiable(boolean verifiable) {
		botaoVerificar.setEnabled(true);
		botao.setEnabled(false);
		frame.repaint();
	}

	@Override
	public void repaint() {
		frame.repaint();
	}

	@Override
	public void iniciouLeitura() {
		
	}

	@Override
	public int getNumThreads() {
		return 100;
	}
}