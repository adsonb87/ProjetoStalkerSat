package br.stalkersat.gui.usuario;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.usuario.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaProcurarUsuario extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();

	/**
	 * Create the panel.
	 */
	public TelaProcurarUsuario() {
		setBorder(new TitledBorder(null, "Procurar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 33, 71, 14);
		add(lblIdUsuario);
		
		idTf = new JTextField();
		idTf.setBounds(71, 30, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id;
				procurarUsuario(id = Integer.parseInt(idTf.getText()));
			}
		});
		btnProcurar.setBounds(250, 90, 89, 23);
		add(btnProcurar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampo();
			}
		});
		btnLimpar.setBounds(394, 90, 89, 23);
		add(btnLimpar);
		
		textPane.setEditable(false);
		textPane.setBounds(10, 134, 720, 281);
		add(textPane);

	}
	
	public void procurarUsuario(int id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Usuario usuario = fachada.procurarUsuario(id);
			
			if(usuario == null){
				textPane.setText("Usuario Não encontrado");
			}else{
				textPane.setText(usuario.toString());
			}
			
			idTf.setText("");
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public void limparCampo(){
		idTf.setText("");
		textPane.setText("");
	}
}
