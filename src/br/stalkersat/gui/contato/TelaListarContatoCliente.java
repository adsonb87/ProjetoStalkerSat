package br.stalkersat.gui.contato;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarContatoCliente extends JPanel {
	private JTextField idTf;

	/**
	 * Create the panel.
	 */
	public TelaListarContatoCliente() {
		setBorder(new TitledBorder(null, "Listar contatos por cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdCliente = new JLabel("Id cliente:");
		lblIdCliente.setBounds(10, 25, 57, 14);
		add(lblIdCliente);
		
		idTf = new JTextField();
		idTf.setBounds(65, 22, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarContatos(Integer.parseInt(idTf.getText()));
			}
		});
		btnListar.setBounds(297, 71, 89, 23);
		add(btnListar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 108, 720, 321);
		add(textPane);

	}
	
	public void listarContatos(Integer id){
		
	}

}
