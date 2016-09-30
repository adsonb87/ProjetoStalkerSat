package br.stalkersat.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.stalkersat.gui.usuario.TelaAtualizarUsuario;
import br.stalkersat.gui.usuario.TelaCadastrarUsuario;
import br.stalkersat.gui.usuario.TelaListarUsuario;
import br.stalkersat.gui.usuario.TelaProcurarUsuario;
import br.stalkersat.gui.usuario.TelaRemoverUsuario;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class TelaPrincipalAdministrador extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAdministrador frame = new TelaPrincipalAdministrador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalAdministrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\adson\\Google Drive\\Projeto 4 periodo montadora\\StalkerSAT-transp2.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Usu\u00E1rio");
		menuBar.add(menu);
		
		JFrame frame = new JFrame();
		
		JMenuItem mnCadastrarUsuario = new JMenuItem("Cadastrar");
		mnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarUsuario tCadastrarUsuario = new TelaCadastrarUsuario();

				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(tCadastrarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(mnCadastrarUsuario);
		
		JMenuItem mnAtualizarUsuario = new JMenuItem("Atualizar");
		mnAtualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarUsuario tAtualizarUsuario = new TelaAtualizarUsuario();
				
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(tAtualizarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(mnAtualizarUsuario);
		
		JMenuItem mnProcurarUsuario = new JMenuItem("Procurar");
		mnProcurarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaProcurarUsuario tProcurarUsuario = new TelaProcurarUsuario();
				
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(tProcurarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		
		menu.add(mnProcurarUsuario);
		
		JMenuItem mnRemoverUsuario = new JMenuItem("Remover");
		mnRemoverUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverUsuario tRemoverUsuario = new TelaRemoverUsuario();
				
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(tRemoverUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(mnRemoverUsuario);
		
		JMenuItem mnListarUsuario = new JMenuItem("Listar");
		mnListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarUsuario tListarUsuario = new TelaListarUsuario();
				
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(tListarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(mnListarUsuario);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\adson\\Google Drive\\Projeto 4 periodo montadora\\StalkerSAT-transp.png"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblNewLabel)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(72)
					.addComponent(lblNewLabel)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}