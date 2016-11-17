package br.stalkersat.gui.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.contato.Contato;
import br.stalkersat.fachada.Fachada;

public class TelaAtualizarContato extends JPanel {
	private JTextField idUsuarioTf;
	private JTextField idContatoTf;
	private JTextField telefoneTf;
	JComboBox tipoContatoCb = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public TelaAtualizarContato() {
		setBorder(new TitledBorder(null, "Atualizar Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 26, 74, 14);
		add(lblIdUsuario);
		
		JLabel lblIdContato = new JLabel("Id Contato:");
		lblIdContato.setBounds(10, 56, 74, 14);
		add(lblIdContato);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 91, 63, 14);
		add(lblTelefone);
		
		
		tipoContatoCb.setModel(new DefaultComboBoxModel(new String[] {"Fixo", "Celular"}));
		tipoContatoCb.setBounds(10, 131, 74, 20);
		add(tipoContatoCb);
		
		idUsuarioTf = new JTextField();
		idUsuarioTf.setBounds(83, 23, 86, 20);
		add(idUsuarioTf);
		idUsuarioTf.setColumns(10);
		
		idContatoTf = new JTextField();
		idContatoTf.setBounds(83, 53, 86, 20);
		add(idContatoTf);
		idContatoTf.setColumns(10);
		
		telefoneTf = new JTextField();
		telefoneTf.setBounds(83, 88, 264, 20);
		add(telefoneTf);
		telefoneTf.setColumns(10);
		
		JButton btnAtualiar = new JButton("Atualiar");
		btnAtualiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarContato();
			}
		});
		btnAtualiar.setBounds(332, 178, 89, 23);
		add(btnAtualiar);

	}
	
	public void atualizarContato(){
		Fachada fachada = Fachada.getInstance();
		
		Contato contato = new Contato(Integer.parseInt(idContatoTf.getText()), telefoneTf.getText(), fachada.procurarUsuario(Integer.parseInt(idUsuarioTf.getText())), fachada.procurarTipoContato(tipoContatoCb.getSelectedIndex()+1));
		
		fachada.atualizarContato(contato);
		
		limpar();
	}
	
	public void limpar(){
		idContatoTf.setText("");
		idUsuarioTf.setText("");
		telefoneTf.setText("");
	}

}
