package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaRemoverEndereco extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();

	/**
	 * Create the panel.
	 */
	public TelaRemoverEndereco() {
		setBorder(new TitledBorder(null, "Remover Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdEndereco = new JLabel("Id Endereco:");
		lblIdEndereco.setBounds(10, 26, 77, 14);
		add(lblIdEndereco);
		
		idTf = new JTextField();
		idTf.setBounds(91, 23, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerEndereco(Integer.parseInt(idTf.getText()));
			}
		});
		btnRemover.setBounds(293, 75, 89, 23);
		add(btnRemover);
		
		textPane.setBounds(10, 114, 720, 315);
		add(textPane);

	}
	
	public void removerEndereco(Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			boolean	remover = fachada.removerEndereco(id);
			
			if(remover){
				textPane.setText("Endereco removido com sucesso");
			}else{
				textPane.setText("Endereco não encontrado");
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
