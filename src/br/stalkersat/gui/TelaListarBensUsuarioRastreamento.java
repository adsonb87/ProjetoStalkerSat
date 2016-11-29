package br.stalkersat.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TelaListarBensUsuarioRastreamento extends JPanel {
	private Integer idUsuario;
	private JTextArea textArea = new JTextArea();
	
	public Integer getIdUsuario(){
		return idUsuario;
	}
	
	public void setIdUsuario(Integer id){
		this.idUsuario = id;
	}
	
	/**
	 * Create the panel.
	 */
	public TelaListarBensUsuarioRastreamento() {
		setBorder(new TitledBorder(null, "Rastrear bens cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listar(idUsuario);	
			}
		});
		btnListar.setBounds(323, 50, 89, 23);
		add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 90, 720, 339);
		add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);

	}
	
	public void Listar (Integer id){
		
		try {
			Fachada fachada = Fachada.getInstance();
			
			ArrayList<Bem> listaBens = fachada.listarBemPorUsuario(id);
			
			if(listaBens.isEmpty()){
				textArea.setText("Bens não localizados");
			}else{
				textArea.setText(listaBens.toString());
			}
			
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
}
