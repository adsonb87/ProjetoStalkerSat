package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.fachada.Fachada;

public class TelaAtualizarEndereco extends JPanel {
	private JTextField idTf;
	private JTextField ruaTf;
	private JTextField numeroTf;
	private JTextField complementoTf;
	private JTextField cepTf;

	/**
	 * Create the panel.
	 */
	public TelaAtualizarEndereco() {
		setBorder(new TitledBorder(null, "Atualizar Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdEndereco = new JLabel("Id Endereco:");
		lblIdEndereco.setBounds(10, 22, 67, 14);
		add(lblIdEndereco);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 54, 46, 14);
		add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 91, 67, 14);
		add(lblNmero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 126, 79, 14);
		add(lblComplemento);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 163, 46, 14);
		add(lblCep);
		
		idTf = new JTextField();
		idTf.setBounds(87, 19, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		ruaTf = new JTextField();
		ruaTf.setBounds(63, 47, 479, 20);
		add(ruaTf);
		ruaTf.setColumns(10);
		
		numeroTf = new JTextField();
		numeroTf.setBounds(73, 88, 86, 20);
		add(numeroTf);
		numeroTf.setColumns(10);
		
		complementoTf = new JTextField();
		complementoTf.setBounds(113, 123, 439, 20);
		add(complementoTf);
		complementoTf.setColumns(10);
		
		cepTf = new JTextField();
		cepTf.setBounds(57, 160, 133, 20);
		add(cepTf);
		cepTf.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarEndereco();
			}
		});
		btnGravar.setBounds(210, 228, 89, 23);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(355, 228, 89, 23);
		add(btnLimpar);

	}
	
	public void atualizarEndereco(){
		Fachada fachada = Fachada.getInstance();
		
		Endereco endereco = new Endereco(Integer.parseInt(idTf.getText()), numeroTf.getText(), complementoTf.getText(), ruaTf.getText(), cepTf.getText());
		
		fachada.atualizarEndereco(endereco);
		
		limpar();
	}
	
	public void limpar(){
		idTf.setText("");
		numeroTf.setText("");
		complementoTf.setText("");
		ruaTf.setText("");
		cepTf.setText("");
	}
	
	

}
