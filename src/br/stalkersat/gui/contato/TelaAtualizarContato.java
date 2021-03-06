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
import javax.swing.JTextPane;

public class TelaAtualizarContato extends JPanel {
	private JTextField idUsuarioTf;
	private JTextField idContatoTf;
	private JTextField telefoneTf;
	private JComboBox tipoContatoCb = new JComboBox();
	private JTextPane statusTp = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaAtualizarContato() {	
		
		setBorder(new TitledBorder(null, "Atualizar Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 56, 74, 14);
		add(lblIdUsuario);
		
		JLabel lblIdContato = new JLabel("Id Contato:");
		lblIdContato.setBounds(10, 26, 74, 14);
		add(lblIdContato);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 91, 63, 14);
		add(lblTelefone);
		
		
		tipoContatoCb.setModel(new DefaultComboBoxModel(new String[] {"Fixo", "Celular"}));
		tipoContatoCb.setBounds(10, 131, 74, 20);
		add(tipoContatoCb);
		
		idUsuarioTf = new JTextField();
		idUsuarioTf.setBounds(83, 53, 86, 20);
		add(idUsuarioTf);
		idUsuarioTf.setColumns(10);
		
		idContatoTf = new JTextField();
		idContatoTf.setBounds(83, 23, 86, 20);
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
		btnAtualiar.setBounds(158, 179, 89, 23);
		add(btnAtualiar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idContatoTf.getText().isEmpty()){
					
				}else{
					procurarContato();
				}
			}
		});
		btnPesquisar.setBounds(330, 179, 110, 23);
		add(btnPesquisar);
		
		
		statusTp.setBounds(121, 131, 226, 20);
		add(statusTp);
		
	}
	
	public void atualizarContato(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Contato contato = new Contato(Integer.parseInt(idContatoTf.getText()), telefoneTf.getText(), fachada.procurarUsuario(Integer.parseInt(idUsuarioTf.getText())), fachada.procurarTipoContato(tipoContatoCb.getSelectedIndex()+1));
			
			fachada.atualizarContato(contato);

			limpar();
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void procurarContato(){		
			try {
				Fachada fachada = Fachada.getInstance();
				
				Contato contato = fachada.procurarContato(Integer.parseInt(idContatoTf.getText()));
				
				if(contato != null){
					statusTp.setText("");
					idUsuarioTf.setText(contato.getUsuario().getIdUsuario().toString());
					telefoneTf.setText(contato.getTelefone().toString());					
				}else{
					statusTp.setText("Contato n�o existe");
					limpar();
				}
				
				
			} catch (ErrorException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		
	}
	
	public void limpar(){
		idContatoTf.setText("");
		idUsuarioTf.setText("");
		telefoneTf.setText("");
	}
}
