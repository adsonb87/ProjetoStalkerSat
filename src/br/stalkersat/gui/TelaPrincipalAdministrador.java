package br.stalkersat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.stalkersat.gui.bem.TelaAtualizarBem;
import br.stalkersat.gui.bem.TelaCadastrarBem;
import br.stalkersat.gui.bem.TelaListarBem;
import br.stalkersat.gui.bem.TelaListarBemCliente;
import br.stalkersat.gui.bem.TelaProcurarBem;
import br.stalkersat.gui.bem.TelaRemoverBem;
import br.stalkersat.gui.contato.TelaAtualizarContato;
import br.stalkersat.gui.contato.TelaCadastrarContato;
import br.stalkersat.gui.contato.TelaListarContato;
import br.stalkersat.gui.contato.TelaListarContatoCliente;
import br.stalkersat.gui.contato.TelaProcurarContato;
import br.stalkersat.gui.contato.TelaRemoverContato;
import br.stalkersat.gui.endereco.TelaAtualizarEndereco;
import br.stalkersat.gui.endereco.TelaCadastrarEndereco;
import br.stalkersat.gui.endereco.TelaListarEndereco;
import br.stalkersat.gui.endereco.TelaProcurarEndereco;
import br.stalkersat.gui.endereco.TelaRemoverEndereco;
import br.stalkersat.gui.usuario.TelaAtualizarUsuario;
import br.stalkersat.gui.usuario.TelaCadastrarUsuario;
import br.stalkersat.gui.usuario.TelaListarUsuario;
import br.stalkersat.gui.usuario.TelaProcurarUsuario;
import br.stalkersat.gui.usuario.TelaRemoverUsuario;

public class TelaPrincipalAdministrador extends JPanel {
	private JFrame frame = new JFrame();
	
	/**
	 * Create the panel.
	 */
	public TelaPrincipalAdministrador() {
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 660, 21);
		add(menuBar);
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		JMenuItem CadastrarUsuario = new JMenuItem("Cadastrar");
		CadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				TelaCadastrarUsuario tCadastrarUsuario = new TelaCadastrarUsuario();				
				
				frame.setBounds(100, 100, 740, 590);
				frame.setContentPane(tCadastrarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnUsuario.add(CadastrarUsuario);
		
		JMenuItem AtualizarUsuario = new JMenuItem("Atualizar");
		AtualizarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarUsuario tAtualizarUsuario = new TelaAtualizarUsuario();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tAtualizarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnUsuario.add(AtualizarUsuario);
		
		JMenuItem ProcurarUsuario = new JMenuItem("Procurar");
		ProcurarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarUsuario tProcurarUsuario = new TelaProcurarUsuario();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tProcurarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnUsuario.add(ProcurarUsuario);
		
		JMenuItem RemoverUsuario = new JMenuItem("Remover");
		RemoverUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverUsuario tRemoverUsuario = new TelaRemoverUsuario();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tRemoverUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnUsuario.add(RemoverUsuario);
		
		JMenuItem ListarUsuario = new JMenuItem("Listar");
		ListarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarUsuario tListarUsuario = new TelaListarUsuario();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tListarUsuario);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnUsuario.add(ListarUsuario);
		
		JMenu mnBem = new JMenu("Bem");
		menuBar.add(mnBem);
		
		JMenuItem CadastrarBem = new JMenuItem("Cadastrar");
		CadastrarBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarBem tCadastrarBem = new TelaCadastrarBem();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tCadastrarBem);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(CadastrarBem);
		
		JMenuItem AtualizarBem = new JMenuItem("Atualizar");
		AtualizarBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarBem tAtualizarBem = new TelaAtualizarBem();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tAtualizarBem);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(AtualizarBem);
		
		JMenuItem ProcurarBem = new JMenuItem("Procurar");
		ProcurarBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarBem tProcurarBem = new TelaProcurarBem();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tProcurarBem);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(ProcurarBem);
		
		JMenuItem RemoverBem = new JMenuItem("Remover");
		RemoverBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverBem tRemoverBem = new TelaRemoverBem();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tRemoverBem);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(RemoverBem);
		
		JMenuItem ListarBem = new JMenuItem("Listar");
		ListarBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarBem tListarBem = new TelaListarBem();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tListarBem);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(ListarBem);
		
		JMenuItem ListarPorCliente = new JMenuItem("Listar por cliente");
		ListarPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarBemCliente bemCliente = new TelaListarBemCliente();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(bemCliente);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnBem.add(ListarPorCliente);
		
		JMenu mnEndereo = new JMenu("Endere\u00E7o");
		menuBar.add(mnEndereo);
		
		JMenuItem CadastrarEndereco = new JMenuItem("Cadastrar");
		CadastrarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarEndereco tCadastrarEndereco = new TelaCadastrarEndereco();
				
				frame.setContentPane(tCadastrarEndereco);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnEndereo.add(CadastrarEndereco);
		
		JMenuItem AtualizarEndereco = new JMenuItem("Atualizar");
		AtualizarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarEndereco tAtualizarEndereco = new TelaAtualizarEndereco();
				
				frame.setContentPane(tAtualizarEndereco);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnEndereo.add(AtualizarEndereco);
		
		JMenuItem ProcurarEndereco = new JMenuItem("Procurar");
		ProcurarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarEndereco tProcurarEndereco = new TelaProcurarEndereco();
				
				frame.setContentPane(tProcurarEndereco);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnEndereo.add(ProcurarEndereco);
		
		JMenuItem RemoverEndereco = new JMenuItem("Remover");
		RemoverEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverEndereco tRemoverEndereco = new TelaRemoverEndereco();
				
				frame.setContentPane(tRemoverEndereco);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnEndereo.add(RemoverEndereco);
		
		JMenuItem ListarEndereco = new JMenuItem("Listar");
		ListarEndereco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarEndereco tListarEndereco = new TelaListarEndereco();
				
				frame.setContentPane(tListarEndereco);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnEndereo.add(ListarEndereco);
		
		JMenu mnContato = new JMenu("Contato");
		menuBar.add(mnContato);
		
		JMenuItem CadastrarContato = new JMenuItem("Cadastrar");
		CadastrarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastrarContato tCadastrarContato = new TelaCadastrarContato();
				
				frame.setContentPane(tCadastrarContato);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnContato.add(CadastrarContato);
		
		JMenuItem AtualizarContato = new JMenuItem("Atualizar");
		AtualizarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarContato tAtualizarContato = new TelaAtualizarContato();
				
				frame.setContentPane(tAtualizarContato);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnContato.add(AtualizarContato);
		
		JMenuItem ProcurarContato = new JMenuItem("Procurar");
		ProcurarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaProcurarContato tProcurarContato = new  TelaProcurarContato();
				
				frame.setContentPane(tProcurarContato);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnContato.add(ProcurarContato);
		
		JMenuItem RemoverContato = new JMenuItem("Remover");
		RemoverContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRemoverContato tRemoverContato = new TelaRemoverContato();
				
				frame.setContentPane(tRemoverContato);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnContato.add(RemoverContato);
		
		JMenuItem ListarContato = new JMenuItem("Listar");
		ListarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContato tListarContato = new TelaListarContato();
				
				frame.setContentPane(tListarContato);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
				frame.setBounds(100, 100, 740, 440);
			}
		});
		mnContato.add(ListarContato);
		
		JMenuItem mntmListarPorCliente = new JMenuItem("Listar por cliente");
		mntmListarPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListarContatoCliente contatoCliente = new TelaListarContatoCliente();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(contatoCliente);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		mnContato.add(mntmListarPorCliente);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaPrincipalAdministrador.class.getResource("/br/stalkersat/util/StalkerSAT-transp.png")));
		label.setBounds(163, 32, 354, 383);
		add(label);

	}
}
