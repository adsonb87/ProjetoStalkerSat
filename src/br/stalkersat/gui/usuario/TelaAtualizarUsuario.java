package br.stalkersat.gui.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;

public class TelaAtualizarUsuario extends JPanel {
	private JTextField idTf;
	private JTextField nomeTf;
	private JTextField loginTf;
	private JComboBox tipoUsuarioCB = new JComboBox();
	private JPasswordField senhaTf;
	private JFormattedTextField cpfTf = new JFormattedTextField();
	private JTextPane statusTp = new JTextPane();
	
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
		
		tipoUsuarioCB.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));
		tipoUsuarioCB.setBounds(10, 170, 91, 20);
		add(tipoUsuarioCB);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizarUsuario();
			}
		});
		btnGravar.setBounds(245, 259, 89, 23);
		add(btnGravar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idTf.getText().isEmpty()){
					
				}else{
					procurarUsuario();
				}
			}
		});
		btnProcurar.setBounds(415, 259, 89, 23);
		add(btnProcurar);
		
		senhaTf = new JPasswordField();
		senhaTf.setBounds(84, 132, 233, 20);
		add(senhaTf);
		
		
		cpfTf.setBounds(84, 70, 233, 20);
		add(cpfTf);
		
		
		statusTp.setBounds(124, 170, 193, 23);
		add(statusTp);
		
		MaskFormatter mf;
		try {
			mf = new MaskFormatter("###.###.###-##");
			mf.install(cpfTf);
			add(cpfTf);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public void atualizarUsuario(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Usuario usuario = new Usuario(cpfTf.getText(), nomeTf.getText(), loginTf.getText(), senhaTf.getText(), fachada.procurarTipoUsuario(tipoUsuarioCB.getSelectedIndex()+1));
			usuario.setIdUsuario(Integer.parseInt(idTf.getText()));
			
			fachada.atualizarUsuario(usuario);

			limpar();
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
	
	public void procurarUsuario(){
		Fachada fachada = Fachada.getInstance();
		
		try {
			Usuario usuario = fachada.procurarUsuario(Integer.parseInt(idTf.getText()));
			
			if(usuario != null){
				statusTp.setText("");
				idTf.setText(usuario.getIdUsuario().toString());
				nomeTf.setText(usuario.getNome().toString());
				cpfTf.setText(usuario.getCpf().toString());
				loginTf.setText(usuario.getLogin().toString());
				senhaTf.setText(usuario.getSenha().toString());
				tipoUsuarioCB.setSelectedItem(usuario.getTipoUsuario().getIdTipoUsuario()+1);
			}else{
				statusTp.setText("Usuario não existe");
				limpar();
			}
			
		} catch (NumberFormatException | ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void limpar(){
		idTf.setText("");
		nomeTf.setText("");
		cpfTf.setText("");
		loginTf.setText("");
		senhaTf.setText("");
	}
}
