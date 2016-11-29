package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;
import javax.swing.JFormattedTextField;

public class TelaAtualizarEndereco extends JPanel {
	private JTextField idTf;
	private JTextField ruaTf;
	private JTextField numeroTf;
	private JTextField complementoTf;
	private JTextField statusTp;
	private JFormattedTextField cepTf = new JFormattedTextField();

	/**
	 * Create the panel.
	 */
	public TelaAtualizarEndereco() {
		setBorder(new TitledBorder(null, "Atualizar Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdEndereco = new JLabel("Id Endereco:");
		lblIdEndereco.setBounds(10, 22, 79, 14);
		add(lblIdEndereco);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 54, 46, 14);
		add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 79, 67, 14);
		add(lblNmero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 114, 89, 14);
		add(lblComplemento);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 142, 46, 14);
		add(lblCep);
		
		idTf = new JTextField();
		idTf.setBounds(97, 19, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		ruaTf = new JTextField();
		ruaTf.setBounds(97, 51, 479, 20);
		add(ruaTf);
		ruaTf.setColumns(10);
		
		numeroTf = new JTextField();
		numeroTf.setBounds(97, 76, 86, 20);
		add(numeroTf);
		numeroTf.setColumns(10);
		
		complementoTf = new JTextField();
		complementoTf.setBounds(99, 111, 439, 20);
		add(complementoTf);
		complementoTf.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarEndereco();
			}
		});
		btnGravar.setBounds(210, 228, 89, 23);
		add(btnGravar);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!idTf.getText().isEmpty()){
					procurarEndereco();
				}
			}
		});
		btnProcurar.setBounds(355, 228, 89, 23);
		add(btnProcurar);
		
		statusTp = new JTextField();
		statusTp.setBounds(210, 182, 229, 20);
		add(statusTp);
		statusTp.setColumns(10);
		
		
		cepTf.setBounds(97, 139, 99, 20);
		add(cepTf);
		
		MaskFormatter mf2;
		try {
			mf2 = new MaskFormatter("##.###-###");
			mf2.install(cepTf);
			add(cepTf);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void atualizarEndereco(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Endereco endereco = new Endereco(Integer.parseInt(idTf.getText()), numeroTf.getText(), complementoTf.getText(), ruaTf.getText(), cepTf.getText());
			
			fachada.atualizarEndereco(endereco);
			
			limpar();
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void procurarEndereco(){
		Fachada fachada = Fachada.getInstance();
		
		try {
			Endereco endereco = fachada.procurarEndereco(Integer.parseInt(idTf.getText()));
			
			if(endereco != null){
				statusTp.setText("");
				idTf.setText(endereco.getIdEndereco().toString());
				numeroTf.setText(endereco.getNumero());
				complementoTf.setText(endereco.getComplemento());
				ruaTf.setText(endereco.getRua());
				cepTf.setText(endereco.getCep());
			}else{
				statusTp.setText("Endereço não existe");
				limpar();
			}
		} catch (NumberFormatException | ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}
	public void limpar(){
		idTf.setText("");
		numeroTf.setText("");
		complementoTf.setText("");
		ruaTf.setText("");
		cepTf.setText("");
	}
	
	

}
