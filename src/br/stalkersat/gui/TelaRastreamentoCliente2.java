package br.stalkersat.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.localizacao.Localizacao;

public class TelaRastreamentoCliente2 extends JFrame {

	private JPanel contentPane;
	private JTextField idBemTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRastreamentoCliente2 frame = new TelaRastreamentoCliente2();
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
	public TelaRastreamentoCliente2() {
		setTitle("Rastreamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIdBem = new JLabel("Id Bem");
		
		idBemTF = new JTextField();
		idBemTF.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				localizarBem(textPane);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblIdBem)
							.addGap(18)
							.addComponent(idBemTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(14, Short.MAX_VALUE))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(174)
					.addComponent(btnLocalizar)
					.addContainerGap(177, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdBem)
						.addComponent(idBemTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLocalizar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void localizarBem(JTextPane textPane){
		Integer id = sortearLocalizacao();
		
		Fachada fachada = Fachada.getInstance();
		
		Localizacao localizacao = fachada.procurarLocalizacao(id);
		
//		Bem bem = fachada.procurarBem(Integer.parseInt(idBemTF.getText()));
		
		textPane.setText(localizacao.toString());
				
	}
	
	public int sortearLocalizacao(){
		Random r = new Random();
		int num = r.nextInt(10);
		if(num == 0){
			return sortearLocalizacao();
		}else{
			return num;
		}
	}
}
