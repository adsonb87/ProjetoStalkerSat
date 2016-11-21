package br.stalkersat.gui.usuario;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRemoverUsuario extends JPanel {
	private JTextField idTf;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TelaRemoverUsuario() {
		setBorder(new TitledBorder(null, "Remover Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 25, 62, 14);
		add(lblIdUsuario);
		
		idTf = new JTextField();
		idTf.setBounds(82, 22, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				removerUsuario(id = Integer.parseInt(idTf.getText()));
			}
		});
		btnRemover.setBounds(321, 64, 89, 23);
		add(btnRemover);
		
		textField = new JTextField();
		textField.setBounds(10, 94, 720, 335);
		add(textField);
		textField.setColumns(10);

	}
	
	public void removerUsuario(int id){
		Fachada fachada = Fachada.getInstance();
		
		Usuario usuario = fachada.procurarUsuario(id);
		
		boolean remover = fachada.removerUsuario(id);
		
		if(remover){
			textField.setText("Usuario removido com sucesso");
		}else{
			textField.setText("Usuario não encontrado");
		}
	}
}
