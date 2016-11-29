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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaListarEndereco extends JPanel {
	private JTextArea textArea = new JTextArea();
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 85, 720, 344);
		add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

	}
	
	public void listarEndereco(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Endereco> listaEndereco = fachada.listarEndereco();
		
		if(listaEndereco.isEmpty()){
			textArea.setText("lista de endereços vazia");
		}else{
			textArea.setText(listaEndereco.toString());
		}
	}

}
