package br.stalkersat.gui.bem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaListarBemCliente extends JPanel {
	private JTextField idTf;
	private JTextArea textArea = new JTextArea();
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
		idTf.setBounds(73, 23, 86, 20);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 730, 431);
		add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

	}
	
	public void listarBens(Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			ArrayList<Bem> listaBem = fachada.listarBemPorUsuario(id);
			if(listaBem.isEmpty()){
				textArea.setText("Lista vazia");
			}else{
				textArea.setText(listaBem.toString());
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
