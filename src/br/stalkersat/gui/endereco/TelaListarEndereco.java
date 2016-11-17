package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.fachada.Fachada;

public class TelaListarEndereco extends JPanel {
	JTextPane textPane = new JTextPane();
	/**
	 * Create the panel.
	 */
	public TelaListarEndereco() {
		setBorder(new TitledBorder(null, "Listar Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEndereco();
			}
		});
		btnListar.setBounds(305, 40, 89, 23);
		add(btnListar);
		
		
		textPane.setBounds(10, 84, 720, 330);
		add(textPane);

	}
	
	public void listarEndereco(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Endereco> listaEndereco = fachada.listarEndereco();
		
		if(listaEndereco.isEmpty()){
			textPane.setText("lista de endereços vazia");
		}else{
			textPane.setText(listaEndereco.toString());
		}
	}

}
