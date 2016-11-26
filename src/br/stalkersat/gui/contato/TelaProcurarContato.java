package br.stalkersat.gui.contato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import br.stalkersat.contato.Contato;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaProcurarContato extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaProcurarContato() {
		setBorder(new TitledBorder(null, "Procurar Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdContato = new JLabel("Id Contato:");
		lblIdContato.setBounds(10, 24, 70, 14);
		add(lblIdContato);
		
		idTf = new JTextField();
		idTf.setBounds(77, 21, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procurarContato();
			}
		});
		btnProcurar.setBounds(303, 83, 89, 23);
		add(btnProcurar);
		
		
		textPane.setBounds(10, 130, 720, 287);
		add(textPane);

	}
	
	public void procurarContato(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Contato contato = fachada.procurarContato(Integer.parseInt(idTf.getText()));

			if(contato == null){
				textPane.setText("Contato não encontrado");
			}else{
				textPane.setText(contato.toString());
			}

			idTf.setText("");
		} catch (NumberFormatException | ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
