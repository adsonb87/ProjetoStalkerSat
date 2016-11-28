package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaProcurarEndereco extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaProcurarEndereco() {
		setBorder(new TitledBorder(null, "Procurar Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdEndereco = new JLabel("Id Endereco:");
		lblIdEndereco.setBounds(10, 33, 80, 14);
		add(lblIdEndereco);
		
		idTf = new JTextField();
		idTf.setBounds(84, 30, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarEndereco(Integer.parseInt(idTf.getText()));
			}
		});
		btnProcurar.setBounds(303, 83, 89, 23);
		add(btnProcurar);
		
		
		textPane.setBounds(10, 122, 720, 295);
		add(textPane);

	}
	
	public void procurarEndereco(Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Endereco endereco = fachada.procurarEndereco(id);
			
			if(endereco == null){
				textPane.setText("Endereco não encontrado");
			}else{
				textPane.setText(endereco.toString());
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

}
