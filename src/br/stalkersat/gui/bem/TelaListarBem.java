package br.stalkersat.gui.bem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.fachada.Fachada;

public class TelaListarBem extends JPanel {
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaListarBem() {
		setBorder(new TitledBorder(null, "Listar Bem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBens();
			}
		});
		btnListar.setBounds(269, 33, 89, 23);
		add(btnListar);
		
		
		textPane.setBounds(10, 80, 630, 323);
		add(textPane);

	}
	
	public void listarBens(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Bem> listaBens = fachada.listarBens();
		
		textPane.setText(listaBens.toString());
	}

}
