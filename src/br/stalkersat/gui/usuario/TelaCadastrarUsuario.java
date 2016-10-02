package br.stalkersat.gui.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import br.stalkersat.bem.Bem;
import br.stalkersat.contato.Contato;
import br.stalkersat.endereco.Endereco;
import br.stalkersat.fachada.Fachada;
import br.stalkersat.gui.TelaPrincipalAdministrador;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.tipocontato.TipoContato;
import br.stalkersat.tipousuario.TipoUsuario;
import br.stalkersat.usuario.Usuario;

public class TelaCadastrarUsuario extends JPanel {
	private JTextField nomeTf;
	private JTextField cpfTf;
	private JTextField loginTf;
	private JPasswordField senhaTf;
	private JTextField ruaTf;
	private JTextField numeroTf;
	private JTextField complementoTf;
	private JTextField cepTf;
	private JTextField telefoneTf;
	private JTextField chassiTf;
	private JTextField placaTf;
	private JComboBox tipoUsuarioCB;
	private JComboBox tipoContatoCB;
	private JComboBox tipoBemCB;

	/**
	 * Create the panel.
	 */
	public TelaCadastrarUsuario() {
		setBorder(new TitledBorder(null, "Cadastrar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome:");
		
		JLabel lblNewLabel = new JLabel("Cpf:");
		
		JLabel lblNewLabel_1 = new JLabel("Login:");
		
		JLabel lblSenha = new JLabel("Senha:");
		
		tipoUsuarioCB = new JComboBox();
		tipoUsuarioCB.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Usuario"}));
		
		
		JLabel lblTipoUsuario = new JLabel("Tipo Usuario:");
		
		JLabel lblRua = new JLabel("Rua:");
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		
		JLabel lblComplemento = new JLabel("Complemento:");
		
		JLabel lblCep = new JLabel("CEP:");
		
		JLabel lblTelefone = new JLabel("Telefone:");
		
		tipoContatoCB = new JComboBox();
		tipoContatoCB.setModel(new DefaultComboBoxModel(new String[] {"Celular", "Fixo"}));
		
		JLabel lblChassi = new JLabel("Chassi:");
		
		JLabel lblPlaca = new JLabel("Placa");
		
		JLabel lblTipoDoBem = new JLabel("Tipo do bem:");
		
		tipoBemCB = new JComboBox();
		tipoBemCB.setModel(new DefaultComboBoxModel(new String[] {"Carro", "Moto"}));
		
		nomeTf = new JTextField();
		nomeTf.setColumns(10);
		
		cpfTf = new JTextField();
		cpfTf.setColumns(10);
		
		loginTf = new JTextField();
		loginTf.setColumns(10);
		
		senhaTf = new JPasswordField();
		
		ruaTf = new JTextField();
		ruaTf.setColumns(10);
		
		numeroTf = new JTextField();
		numeroTf.setColumns(10);
		
		complementoTf = new JTextField();
		complementoTf.setColumns(10);
		
		cepTf = new JTextField();
		cepTf.setColumns(10);
		
		telefoneTf = new JTextField();
		telefoneTf.setColumns(10);
		
		chassiTf = new JTextField();
		chassiTf.setColumns(10);
		
		placaTf = new JTextField();
		placaTf.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravarUsuario();
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparCampos();
			}
		});
		
		JButton btnAdicionarBem = new JButton("Adicionar Bem");
		btnAdicionarBem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton btnAdicionarContato = new JButton("Adicionar Contato");
		btnAdicionarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPlaca)
							.addContainerGap(412, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTipoDoBem)
							.addGap(18)
							.addComponent(tipoBemCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(305, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSenha)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblComplemento)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(complementoTf, 359, 359, 359))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTipoUsuario)
									.addGap(18)
									.addComponent(tipoUsuarioCB, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNome)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cpfTf, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
										.addComponent(nomeTf, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(senhaTf, Alignment.LEADING)
											.addComponent(loginTf, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNmero)
										.addComponent(lblRua))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ruaTf, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
										.addComponent(numeroTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTelefone)
										.addComponent(lblChassi)
										.addComponent(lblCep))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cepTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(telefoneTf, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
												.addGap(18)
												.addComponent(tipoContatoCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(112))
											.addComponent(chassiTf, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
											.addComponent(placaTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGravar)
							.addGap(18)
							.addComponent(btnLimpar)
							.addGap(18)
							.addComponent(btnAdicionarBem)
							.addGap(18)
							.addComponent(btnAdicionarContato)
							.addGap(58))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(nomeTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(cpfTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(loginTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSenha)
						.addComponent(senhaTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoUsuario)
						.addComponent(tipoUsuarioCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua)
						.addComponent(ruaTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNmero)
						.addComponent(numeroTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComplemento)
								.addComponent(complementoTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep)
								.addComponent(cepTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone)
								.addComponent(tipoContatoCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(telefoneTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblChassi)
								.addComponent(chassiTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPlaca)
								.addComponent(placaTf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblTipoDoBem))
						.addComponent(tipoBemCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGravar)
						.addComponent(btnLimpar)
						.addComponent(btnAdicionarBem)
						.addComponent(btnAdicionarContato))
					.addGap(20))
		);
		setLayout(groupLayout);

	}
	
	private void gravarUsuario(){
		Fachada fachada = Fachada.getInstance();
		
		Endereco end = new Endereco(numeroTf.getText(), complementoTf.getText(), ruaTf.getText(), cepTf.getText());
		
		fachada.cadastrarEndereco(end);
		
		TipoUsuario tipoUsuario = null;
		
		if(tipoUsuarioCB.getSelectedItem().equals("Usuario")){
			tipoUsuario = fachada.procurarTipoUsuario(2);
		}else if(tipoUsuarioCB.getSelectedItem().equals("Administrador")){
			tipoUsuario = fachada.procurarTipoUsuario(1);
		}
		
		Usuario user = new Usuario(cpfTf.getText(), nomeTf.getText(), loginTf.getText(), senhaTf.getText(), tipoUsuario, end);
		
		fachada.cadastrarUsuario(user);
		
		
		TipoContato tipoContato = null;
		
		if(tipoContatoCB.getSelectedItem().equals("Fixo")){
			tipoContato = fachada.procurarTipoContato(1);
		}else if(tipoContatoCB.getSelectedItem().equals("Celular")){
			tipoContato = fachada.procurarTipoContato(2);
		}
		
		Contato contato = new Contato(telefoneTf.getText(), user, tipoContato);
		
		fachada.cadastrarContato(contato);
		
		
		TipoBem tipoBem = null;
		
		if(tipoBemCB.getSelectedItem().equals("Moto")){
			tipoBem = fachada.procurarTipoBem(2);
		}else if(tipoContatoCB.getSelectedItem().equals("Carro")){
			tipoBem = fachada.procurarTipoBem(1);
		}
		
		Bem bem = new Bem(chassiTf.getText(), placaTf.getText(), tipoBem, user);
		
		fachada.cadastrarBem(bem);
		
		limparCampos();
		
	}
	
	private void limparCampos(){
		nomeTf.setText("");
		cpfTf.setText("");
		loginTf.setText("");
		senhaTf.setText("");;
		ruaTf.setText("");;
		numeroTf.setText("");;
		complementoTf.setText("");;
		cepTf.setText("");;
		telefoneTf.setText("");;
		chassiTf.setText("");;
		placaTf.setText("");;
	}
}
