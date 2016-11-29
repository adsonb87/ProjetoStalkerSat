package br.stalkersat.gui.usuario;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TelaListarUsuario extends JPanel {
	private JTextArea textArea = new JTextArea();
	/**
	 * Create the panel.
	 */
	public TelaListarUsuario() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(319, 59, 72, 23);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsuarios();
			}
		});
		setLayout(null);
		add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 720, 436);
		add(scrollPane);	
		
		scrollPane.setViewportView(textArea);

	}
	
	private void listarUsuarios(){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Usuario> lista = fachada.listarUsuario();
		if(!lista.isEmpty()){
			textArea.setText(lista.toString());
		}else{
			textArea.setText("Não há usuários para serem listados");
		}
	}
}
