package br.stalkersat.gui.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.contato.Contato;
import br.stalkersat.fachada.Fachada;

public class TelaListarContato extends JPanel {
	JTextPane textPane = new JTextPane();

	/**
	 * Create the panel.
	 */
	public TelaListarContato() {
		setBorder(new TitledBorder(null, "Listar Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarContatos();
			}
		});
		btnListar.setBounds(320, 47, 89, 23);
		add(btnListar);
		
		textPane.setBounds(10, 93, 720, 321);
		add(textPane);
		
	}
	
	public void listarContatos(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Contato> listaContato = fachada.listarContato();
		
		if(!listaContato.isEmpty()){
			textPane.setText(listaContato.toString());		
		}else{
			textPane.setText("Lista de contatos Vazia");
		}
	}

}
