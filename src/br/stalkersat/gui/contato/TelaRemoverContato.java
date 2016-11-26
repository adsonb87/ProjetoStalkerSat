package br.stalkersat.gui.contato;

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

public class TelaRemoverContato extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaRemoverContato() {
		setBorder(new TitledBorder(null, "Remover Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdContato = new JLabel("Id Contato:");
		lblIdContato.setBounds(10, 31, 66, 14);
		add(lblIdContato);
		
		idTf = new JTextField();
		idTf.setBounds(86, 28, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removerContato(Integer.parseInt(idTf.getText()));
			}
		});
		btnRemover.setBounds(333, 90, 89, 23);
		add(btnRemover);
		
		
		textPane.setBounds(10, 124, 720, 305);
		add(textPane);

	}
	
	public void removerContato(Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			boolean remover = fachada.removerContato(id);

			if(remover){
				textPane.setText("Contato removido com sucesso");
			}else{
				textPane.setText("Contato não encontrado");
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
