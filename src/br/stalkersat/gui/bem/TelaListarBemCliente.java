package br.stalkersat.gui.bem;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaListarBemCliente extends JPanel {
	private JTextField idTf;

	/**
	 * Create the panel.
	 */
	public TelaListarBemCliente() {
		setBorder(new TitledBorder(null, "Listar bens por cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdCliente = new JLabel("Id cliente:");
		lblIdCliente.setBounds(10, 26, 60, 14);
		add(lblIdCliente);
		
		idTf = new JTextField();
		idTf.setBounds(65, 23, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarBens(Integer.parseInt(idTf.getText()));
			}
		});
		btnListar.setBounds(317, 81, 89, 23);
		add(btnListar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 120, 720, 309);
		add(textPane);

	}
	
	public void listarBens(Integer id){
		
	}
}
