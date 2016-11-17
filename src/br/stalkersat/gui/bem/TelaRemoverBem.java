package br.stalkersat.gui.bem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.stalkersat.fachada.Fachada;

public class TelaRemoverBem extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaRemoverBem() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Remover Bem", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 27, 46, 14);
		add(lblId);
		
		idTf = new JTextField();
		idTf.setBounds(32, 24, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removerBem(Integer.parseInt(idTf.getText()));
			}
		});
		btnRemover.setBounds(261, 72, 89, 23);
		add(btnRemover);
		
		
		textPane.setBounds(10, 99, 620, 340);
		add(textPane);

	}
	
	public void removerBem(Integer id){
		Fachada fachada = Fachada.getInstance();
		
		boolean remover = fachada.removerBem(id);
		
		if(remover){
			textPane.setText("Bem removido com sucesso"); 
		}else{
			textPane.setText("Bem n�o encontrado");
		}
		
		idTf.setText("");
	}
}