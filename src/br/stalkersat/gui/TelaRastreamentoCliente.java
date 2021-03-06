package br.stalkersat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.localizacao.Localizacao;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaRastreamentoCliente extends JPanel {
	private JTextField idTf;
	private Integer idUsuario;
	private JTextArea textArea = new JTextArea();
	
	public void setIdUsuario(Integer id){
		idUsuario = id;
	}
	
	public Integer getIdUsuario(){
		return idUsuario;
	}
	
	/**
	 * Create the panel.
	 */
	public TelaRastreamentoCliente() {
		setBorder(new TitledBorder(null, "Rastreamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdBem = new JLabel("Id Bem:");
		lblIdBem.setBounds(10, 24, 46, 14);
		add(lblIdBem);
		
		idTf = new JTextField();
		idTf.setBounds(59, 21, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnRastrear = new JButton("Rastrear");
		btnRastrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rastrearBem(Integer.parseInt(idTf.getText()));
			}
		});
		btnRastrear.setBounds(321, 98, 89, 23);
		add(btnRastrear);
		
		JButton btnListarBens = new JButton("Listar bens");
		btnListarBens.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListarBensUsuarioRastreamento tListar = new TelaListarBensUsuarioRastreamento();
				
				tListar.setIdUsuario(idUsuario);
				
				JFrame frame = new JFrame();
				
				frame.setBounds(100, 100, 740, 440);
				frame.setContentPane(tListar);
				frame.getContentPane().revalidate();
				frame.setVisible(true);
			}
		});
		btnListarBens.setBounds(308, 20, 118, 23);
		add(btnListarBens);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 720, 291);
		add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

	}
	
	public void rastrearBem(Integer idBem){
		try {
			Integer idLocalizacao = sortearLocalizacao();
			
			Fachada fachada = Fachada.getInstance();
						
			Localizacao localizacao = fachada.procurarLocalizacao(idLocalizacao);
			
			Bem bem = fachada.procurarBem(idBem);
			
			if(bem == null){
				textArea.setText("Bem " + idBem + " n�o existe");
			}else if(bem.getUsuario().getIdUsuario() == idUsuario){
				textArea.setText(bem.toString() + localizacao.toString());
			}else{
				textArea.setText("Bem " + idBem + " n�o pertence ao cliente");
			}
			
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		idTf.setText("");
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
