package br.stalkersat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.localizacao.Localizacao;

public class TelaRastreamentoCliente extends JPanel {
	private JTextField idTf;
	private JTextPane textPane = new JTextPane();
	private Integer idUsuario;
	
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
		btnRastrear.setBounds(313, 90, 89, 23);
		add(btnRastrear);
		
		
		textPane.setBounds(10, 132, 720, 297);
		add(textPane);

	}
	
	public void rastrearBem(Integer idBem){
		try {
			Integer idLocalizacao = sortearLocalizacao();
			
			Fachada fachada = Fachada.getInstance();
			
			Localizacao localizacao = fachada.procurarLocalizacao(idLocalizacao);
			
			Bem bem = fachada.procurarBem(idBem);
			
			if(bem == null){
				textPane.setText("Bem não existe");
			}else {
				textPane.setText(bem.toString() + localizacao.toString());
			}
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
