package br.stalkersat.gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;

public class TelaLogin {

	private JFrame frame;
	private JTextField loginTF;
	private JPasswordField senhaTF;
	JTextPane textPane = new JTextPane();

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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adson\\Google Drive\\Projeto 4 periodo montadora\\StalkerSAT-transp2.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblLogin = new JLabel("Login");
		
		JLabel lblSenha = new JLabel("Senha");
		
		loginTF = new JTextField();
		loginTF.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fazerLogin();
			}
		});
		
	
		
		senhaTF = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addComponent(lblLogin))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(senhaTF, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginTF, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(182)
							.addComponent(btnLogin)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(loginTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(senhaTF, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void fazerLogin(){
		Fachada fachada = Fachada.getInstance();
		
		ArrayList<Usuario> lista = fachada.listarUsuario();
		
		for(int i=0; i<lista.size(); i++){
			if(lista.get(i).getLogin().equalsIgnoreCase(loginTF.getText())){
				if(lista.get(i).getSenha().equalsIgnoreCase(senhaTF.getText())){
					if(lista.get(i).getTipoUsuario().getIdTipoUsuario() == 1){
						TelaPrincipalAdministrador tPrincipalAdministrador = new TelaPrincipalAdministrador();
											
						frame.setContentPane(tPrincipalAdministrador);
						frame.getContentPane().revalidate();
						frame.setVisible(true);
					}else if(lista.get(i).getTipoUsuario().getIdTipoUsuario() == 2){
						TelaRastreamentoCliente2 telaRastreamentoCliente = new TelaRastreamentoCliente2();
						
						frame.setContentPane(telaRastreamentoCliente);
						frame.getContentPane().revalidate();
						frame.setVisible(true);
					}
				}
			}
		}
		
//		JOptionPane.showConfirmDialog(null, "Usuario não localizado");
		
		
	}
}
