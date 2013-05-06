package main;

import javax.swing.JLabel;
import javax.swing.JTextArea;

public interface Window {
	
	public JTextArea getOutputPane();
	
	public JLabel getOutputProgress();
	
	public void setVerifiable(boolean verifiable);
	
	public void repaint();
	
	public void iniciouLeitura();
	
	public int getNumThreads();
	
}
