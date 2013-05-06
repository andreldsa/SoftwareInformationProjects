package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class FileChooser implements ActionListener {
	
	private JFileChooser chooser;
	private Contador contador;
	
	
	public FileChooser(Window window) {
		contador = Contador.getInstance(window);
		chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			contador.inicia(chooser.getSelectedFile());
		}
	}
}
