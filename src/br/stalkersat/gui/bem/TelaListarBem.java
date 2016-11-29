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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaListarBem extends JPanel {
	private JTextArea textArea = new JTextArea();
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
		btnListar.setBounds(300, 32, 89, 23);
		add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 720, 354);
		add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

	}
	
	public void listarBens(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Bem> listaBens = fachada.listarBens();
		
		
		if(!listaBens.isEmpty()){
			textArea.setText(listaBens.toString());		
		}else{
			textArea.setText("Lista de bens Vazia");
		}
	}

}
