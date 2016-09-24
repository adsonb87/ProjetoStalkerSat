package br.stalkersat.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;

public class TelaLogin {

	private JFrame frame;
	private JTextField senhaTF;
	private JTextField loginTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		senhaTF = new JTextField();
		senhaTF.setColumns(10);
		
		loginTF = new JTextField();
		loginTF.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fazerLogin();
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(lblLogin))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(senhaTF, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginTF))
							.addContainerGap(101, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnLogin)
							.addGap(167))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(senhaTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(loginTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addContainerGap(157, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void fazerLogin(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Usuario> listaUsuarios = fachada.listarUsuario();
		
		for(int i=0; i<listaUsuarios.size(); i++){
			if(listaUsuarios.get(i).getLogin().equalsIgnoreCase(loginTF.getText()) && listaUsuarios.get(i).getSenha().equalsIgnoreCase(senhaTF.getText())){
				if(listaUsuarios.get(i).getTipoUsuario().getIdTipoUsuario() == 1){
					TelaPrincipalAdministrador telaAdm = new TelaPrincipalAdministrador();
					frame.setContentPane(telaAdm);
					frame.getContentPane().revalidate();
				}else if(listaUsuarios.get(i).getTipoUsuario().getIdTipoUsuario() == 2){
					TelaRastreamentoCliente telaCliente = new TelaRastreamentoCliente();
					frame.setContentPane(telaCliente);
					frame.getContentPane().revalidate();
				}
			}
		}
		
		JOptionPane.showConfirmDialog(null, "Usuario não localizado");
		
	}
}
