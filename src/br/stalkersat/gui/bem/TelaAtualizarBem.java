package br.stalkersat.gui.bem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.fachada.Fachada;

public class TelaAtualizarBem extends JPanel {
	private JTextField idBemTf;
	private JTextField idUsuarioTf;
	private JTextField chassiTf;
	private JTextField placaTf;
	JComboBox comboBox = new JComboBox();

	/**
	 * Create the panel.
	 */
	public TelaAtualizarBem() {
		setBorder(new TitledBorder(null, "Atualizar Bem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdBem = new JLabel("Id bem:");
		lblIdBem.setBounds(10, 23, 46, 14);
		add(lblIdBem);
		
		idBemTf = new JTextField();
		idBemTf.setBounds(76, 20, 86, 20);
		add(idBemTf);
		idBemTf.setColumns(10);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 58, 73, 14);
		add(lblIdUsuario);
		
		idUsuarioTf = new JTextField();
		idUsuarioTf.setBounds(76, 51, 86, 20);
		add(idUsuarioTf);
		idUsuarioTf.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi:");
		lblChassi.setBounds(10, 94, 46, 14);
		add(lblChassi);
		
		chassiTf = new JTextField();
		chassiTf.setBounds(76, 91, 334, 20);
		add(chassiTf);
		chassiTf.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 128, 46, 14);
		add(lblPlaca);
		
		placaTf = new JTextField();
		placaTf.setBounds(76, 125, 86, 20);
		add(placaTf);
		placaTf.setColumns(10);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Carro", "Moto"}));
		comboBox.setBounds(10, 170, 59, 20);
		add(comboBox);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarBem();
			}
		});
		btnGravar.setBounds(157, 243, 89, 23);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(372, 243, 89, 23);
		add(btnLimpar);

	}
	
	public void atualizarBem(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Bem bem = new Bem(Integer.parseInt(idBemTf.getText()), chassiTf.getText(), placaTf.getText(), fachada.procurarTipoBem(comboBox.getSelectedIndex()+1), fachada.procurarUsuario(Integer.parseInt(idUsuarioTf.getText())));
			
			fachada.atualizarBem(bem);
			
			limpar();
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void limpar(){
			idBemTf.setText("");
			idUsuarioTf.setText("");
			placaTf.setText("");
			chassiTf.setText("");
	}
	
}
