package br.stalkersat.gui.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.contato.Contato;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaListarContatoCliente extends JPanel {
	private JTextField idTf;
	private JTextPane textPane = new JTextPane();

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
		btnListar.setBounds(321, 69, 89, 23);
		add(btnListar);
		
		
		textPane.setBounds(10, 108, 720, 308);
		add(textPane);

	}
	
	public void listarContatos(Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			ArrayList<Contato> lista = fachada.listarContatoPorUsuario(id);

			if(lista.isEmpty()){
				textPane.setText("Lista vazia");
			}else{
				textPane.setText(lista.toString());
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
