package br.stalkersat.gui.usuario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class TelaListarUsuario extends JPanel {
	private JTextField idTf;
	private JTextPane textPane;

	/**
	 * Create the panel.
	 */
	public TelaListarUsuario() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		
		idTf = new JTextField();
		idTf.setColumns(10);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarUsuarios();
			}
		});
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIdUsuario)
							.addGap(18)
							.addComponent(idTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(307)
							.addComponent(btnListar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdUsuario)
						.addComponent(idTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnListar)
					.addGap(18)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	private void listarUsuarios(){
		Fachada fachada = Fachada.getInstance();
		ArrayList<Usuario> lista = fachada.listarUsuario();
		if(!lista.isEmpty()){
			textPane.setText(lista.toString());	
		}else{
			textPane.setText("Não há usuários para serem listados");
		}
	}
}
