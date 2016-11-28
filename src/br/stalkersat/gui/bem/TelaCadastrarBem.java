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
import br.stalkersat.tipobem.TipoBem;

public class TelaCadastrarBem extends JPanel {
	private JTextField idTf;
	private JTextField chassiTf;
	private JTextField placaTf;
	JComboBox tipoBemCb = new JComboBox();
	
	/**
	 * Create the panel.
	 */
	public TelaCadastrarBem() {
		setBorder(new TitledBorder(null, "Cadastrar Bem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblIdUsuario = new JLabel("Id Usuario:");
		lblIdUsuario.setBounds(10, 30, 62, 14);
		add(lblIdUsuario);
		
		idTf = new JTextField();
		idTf.setBounds(82, 27, 86, 20);
		add(idTf);
		idTf.setColumns(10);
		
		JLabel lblChassi = new JLabel("Chassi:");
		lblChassi.setBounds(10, 66, 46, 14);
		add(lblChassi);
		
		chassiTf = new JTextField();
		chassiTf.setBounds(82, 58, 407, 20);
		add(chassiTf);
		chassiTf.setColumns(10);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(10, 95, 46, 14);
		add(lblPlaca);
		
		placaTf = new JTextField();
		placaTf.setBounds(82, 92, 86, 20);
		add(placaTf);
		placaTf.setColumns(10);
		
		
		tipoBemCb.setToolTipText("");
		tipoBemCb.setModel(new DefaultComboBoxModel(new String[] {"Carro", "Moto"}));
		tipoBemCb.setBounds(10, 136, 62, 20);
		add(tipoBemCb);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravarBem();
			}
		});
		btnGravar.setBounds(180, 200, 89, 23);
		add(btnGravar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(367, 200, 89, 23);
		add(btnLimpar);

	}
	
	public void gravarBem(){
		try {
			Fachada fachada = Fachada.getInstance();
			
			Bem bem = new Bem(chassiTf.getText(), placaTf.getText(), fachada.procurarTipoBem(tipoBemCb.getSelectedIndex()+1), fachada.procurarUsuario(Integer.parseInt(idTf.getText())));
			
			fachada.cadastrarBem(bem);
			
			limpar();
		} catch (ErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public void limpar(){
		idTf.setText("");
		placaTf.setText("");
		chassiTf.setText("");
	}

}
