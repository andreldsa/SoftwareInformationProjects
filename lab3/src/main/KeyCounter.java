package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KeyCounter implements ActionListener{
	
	private Contador contador;
	private Window window;
	
	public KeyCounter(Window window) {
		this.window = window;
		this.contador = Contador.getInstance(window);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		contador.iniciaVerificacao(window.getNumThreads());
	}

}
