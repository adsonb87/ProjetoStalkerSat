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

public class TelaListarBensUsuarioRastreamento extends JPanel {
	private Integer idUsuario;
	JTextPane textPane = new JTextPane();
	
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
		
		
		textPane.setBounds(10, 99, 720, 330);
		add(textPane);

	}
	
	public void Listar (Integer id){
		
		try {
			Fachada fachada = Fachada.getInstance();
			
			ArrayList<Bem> listaBens = fachada.listarBemPorUsuario(id);
			
			if(listaBens.isEmpty()){
				textPane.setText("Bens não localizados");
			}else{
				textPane.setText(listaBens.toString());
			}
			
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
}
