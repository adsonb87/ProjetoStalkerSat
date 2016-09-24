package br.stalkersat.gui.usuario;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastrarUsuario extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaCadastrarUsuario() {
		setBorder(new TitledBorder(null, "Cadastrar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 438, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 277, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}

}
