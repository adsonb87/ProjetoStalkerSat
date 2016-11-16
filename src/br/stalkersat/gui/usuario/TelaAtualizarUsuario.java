package br.stalkersat.gui.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.tipousuario.TipoUsuario;
import br.stalkersat.usuario.Usuario;
import javax.swing.JTextPane;

public class TelaAtualizarUsuario extends JPanel {
	private JTextField idTf;
	private JTextField nomeTf;
	private JTextField cpfTf;
	private JTextField loginTf;
	private JTextField senhaTf;
	JComboBox tipoUsuarioCB = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public TelaAtualizarUsuario() {
		setBorder(new TitledBorder(null, "Atualizar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 23, 64, 14);
		add(lblIdUsuario);
		
		idTf = new JTextField();
		idTf.setBounds(84, 20, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 48, 46, 14);
		add(lblNome);
		
		nomeTf = new JTextField();
		nomeTf.setBounds(84, 45, 528, 20);
		add(nomeTf);
		nomeTf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(10, 73, 46, 14);
		add(lblCpf);
		
		cpfTf = new JTextField();
		cpfTf.setBounds(84, 70, 233, 20);
		add(cpfTf);
		cpfTf.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 104, 46, 14);
		add(lblLogin);
		
		loginTf = new JTextField();
		loginTf.setBounds(84, 101, 233, 20);
		add(loginTf);
		loginTf.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 135, 46, 14);
		add(lblSenha);
		
		senhaTf = new JTextField();
		senhaTf.setBounds(84, 132, 233, 20);
		add(senhaTf);
		senhaTf.setColumns(10);
		
		tipoUsuarioCB.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));
		tipoUsuarioCB.setBounds(10, 170, 91, 20);
		add(tipoUsuarioCB);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarUsuario();
			}
		});
		btnGravar.setBounds(174, 259, 89, 23);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(322, 259, 89, 23);
		add(btnLimpar);

	}
	
	public void atualizarUsuario(){
		Fachada fachada = Fachada.getInstance();

		Usuario usuario = new Usuario(cpfTf.getText(), nomeTf.getText(), loginTf.getText(), senhaTf.getText(), fachada.procurarTipoUsuario(tipoUsuarioCB.getSelectedIndex()+1));
		usuario.setIdUsuario(Integer.parseInt(idTf.getText()));
		
		fachada.atualizarUsuario(usuario);
		
		limpar();
		
		}
	
	public void limpar(){
		idTf.setText("");
		nomeTf.setText("");
		cpfTf.setText("");
		loginTf.setText("");
		senhaTf.setText("");
	}
}
