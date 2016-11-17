package br.stalkersat.gui.endereco;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.CellRendererPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.endereco.Endereco;
import br.stalkersat.fachada.Fachada;

public class TelaCadastrarEndereco extends JPanel {
	private JTextField ruaTf;
	private JTextField numeroTf;
	private JTextField complementoTf;
	private JTextField cepTf;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarEndereco() {
		setBorder(new TitledBorder(null, "Cadstrar Endereco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setBounds(10, 30, 46, 14);
		add(lblRua);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(10, 55, 46, 14);
		add(lblNmero);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(10, 80, 82, 14);
		add(lblComplemento);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 108, 46, 14);
		add(lblCep);
		
		ruaTf = new JTextField();
		ruaTf.setBounds(66, 27, 558, 20);
		add(ruaTf);
		ruaTf.setColumns(10);
		
		numeroTf = new JTextField();
		numeroTf.setBounds(66, 52, 86, 20);
		add(numeroTf);
		numeroTf.setColumns(10);
		
		complementoTf = new JTextField();
		complementoTf.setBounds(98, 77, 537, 20);
		add(complementoTf);
		complementoTf.setColumns(10);
		
		cepTf = new JTextField();
		cepTf.setBounds(66, 105, 86, 20);
		add(cepTf);
		cepTf.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarEndereco();
			}
		});
		btnGravar.setBounds(209, 167, 89, 23);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(356, 167, 89, 23);
		add(btnLimpar);

	}
	
	public void cadastrarEndereco(){
		Fachada fachada = Fachada.getInstance();
		
		Endereco endereco = new Endereco(numeroTf.getText(), complementoTf.getText(), ruaTf.getText(), cepTf.getText());
		
		fachada.cadastrarEndereco(endereco);
		
		limpar();
	}
	
	public void limpar(){
		numeroTf.setText("");
		complementoTf.setText("");
		ruaTf.setText("");
		cepTf.setText("");
	}

}
