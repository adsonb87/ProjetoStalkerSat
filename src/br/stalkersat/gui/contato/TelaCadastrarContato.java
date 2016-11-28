package br.stalkersat.gui.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.contato.Contato;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaCadastrarContato extends JPanel {
	private JTextField idUsuarioTf;
	private JTextField telefoneTf;
	JComboBox comboBox = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public TelaCadastrarContato() {
		setBorder(new TitledBorder(null, "Cadastrar Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 26, 65, 14);
		add(lblIdUsuario);
		
		idUsuarioTf = new JTextField();
		idUsuarioTf.setBounds(95, 23, 86, 20);
		add(idUsuarioTf);
		idUsuarioTf.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 57, 65, 14);
		add(lblTelefone);
		
		telefoneTf = new JTextField();
		telefoneTf.setBounds(95, 54, 258, 20);
		add(telefoneTf);
		telefoneTf.setColumns(10);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fixo", "Celular"}));
		comboBox.setBounds(10, 103, 79, 20);
		add(comboBox);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarContato();
			}
		});
		btnGravar.setBounds(321, 154, 89, 23);
		add(btnGravar);

	}
	
	public void cadastrarContato(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Contato contato = new Contato(telefoneTf.getText(), fachada.procurarUsuario(Integer.parseInt(idUsuarioTf.getText())), fachada.procurarTipoContato(comboBox.getSelectedIndex()+1));
			
			fachada.cadastrarContato(contato);

			telefoneTf.setText("");
			idUsuarioTf.setText("");
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
