package br.stalkersat.gui.bem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import javax.swing.JTextPane;

public class TelaProcurarBem extends JPanel {
	private JTextField idTf;
	JTextPane textPane = new JTextPane();
	
	/**
	 * Create the panel.
	 */
	public TelaProcurarBem() {
		setBorder(new TitledBorder(null, "Procurar Bem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(10, 26, 24, 14);
		add(lblId);
		
		idTf = new JTextField();
		idTf.setBounds(44, 23, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procurarBem(Integer.parseInt(idTf.getText()));
			}
		});
		btnBuscar.setBounds(311, 65, 89, 23);
		add(btnBuscar);
		
		
		textPane.setBounds(10, 123, 720, 289);
		add(textPane);

	}
	
	public void procurarBem (Integer id){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Bem bem = fachada.procurarBem(id);
			
			if(bem == null){
				textPane.setText("Bem não encontrado");
			}else{
				textPane.setText(bem.toString());			
			}
			
			limpar();
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	public void limpar(){
		idTf.setText("");
	}
}

