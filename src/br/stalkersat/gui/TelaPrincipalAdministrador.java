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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("Usu\u00E1rio");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Cadastrar");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarUsuario t = new TelaCadastrarUsuario();

				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(t);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Atualizar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAtualizarUsuario t2 = new TelaAtualizarUsuario();
				JFrame frame = new JFrame();
				frame.setBounds(100, 100, 450, 300);
				frame.setContentPane(t2);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Procurar");
		menu.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Remover");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Listar");
		menu.add(menuItem_4);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
