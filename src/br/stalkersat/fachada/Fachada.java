package br.stalkersat.fachada;

import java.util.ArrayList;

import br.stalkersat.bem.Bem;
import br.stalkersat.bem.ControladorBem;
import br.stalkersat.contato.Contato;
import br.stalkersat.contato.ControladorContato;
import br.stalkersat.endereco.ControladorEndereco;
import br.stalkersat.endereco.Endereco;
import br.stalkersat.exceptions.ErrorException;
import br.stalkersat.localizacao.ControladorLocalizacao;
import br.stalkersat.localizacao.Localizacao;
import br.stalkersat.tipobem.ControladorTipoBem;
import br.stalkersat.tipobem.TipoBem;
import br.stalkersat.tipocontato.ControladorTipoContato;
import br.stalkersat.tipocontato.TipoContato;
import br.stalkersat.tipousuario.ControladorTipoUsuario;
import br.stalkersat.tipousuario.TipoUsuario;
import br.stalkersat.usuario.ControladorUsuario;
import br.stalkersat.usuario.Usuario;

public class Fachada {
	
	private ControladorBem controladorBem;
	private ControladorContato controladorContato;
	private ControladorEndereco controladorEndereco; 
	private ControladorLocalizacao controladorLocalizacao;
	private ControladorTipoBem controladorTipoBem;
	private ControladorTipoContato controladorTipoContato;
	private ControladorTipoUsuario controladorTipoUsuario;
	private ControladorUsuario controladorUsuario;
	
	private static Fachada fachada;
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	private Fachada() {
		controladorBem = new ControladorBem();
		controladorContato = new ControladorContato();
		controladorEndereco = new ControladorEndereco();
		controladorLocalizacao = new ControladorLocalizacao();
		controladorTipoBem = new ControladorTipoBem();
		controladorTipoContato = new ControladorTipoContato();
		controladorTipoUsuario = new ControladorTipoUsuario();
		controladorUsuario = new ControladorUsuario();
	}
	
	//Bem 
	
	public void cadastrarBem (Bem bem) throws ErrorException{
		controladorBem.cadastrarBem(bem);
	}
	
	public void atualizarBem (Bem bem)throws ErrorException{
		controladorBem.atualizarBem(bem);
	}
	
	public boolean removerBem(Integer id)throws ErrorException{
		return controladorBem.removerBem(id);
	}
	
	public Bem procurarBem (Integer id)throws ErrorException{
		Bem bem = controladorBem.procurarBem(id);
		return bem;
	}
	
	public ArrayList<Bem> listarBens (){
		return controladorBem.listarBens();
	}
	
	public ArrayList<Bem> listarBemPorUsuario(Integer id) throws ErrorException{
		return controladorBem.listarBemPorUsuario(id);
	}
	
	//Contato
	
	public void cadastrarContato(Contato contato)throws ErrorException{
		controladorContato.cadastrarContato(contato);
	}
	
	public void atualizarContato(Contato contato)throws ErrorException{
		controladorContato.atualizarContato(contato);
	}
	
	public boolean removerContato (Integer id)throws ErrorException{
		return controladorContato.removerContato(id);
	}
	
	public Contato procurarContato (Integer id)throws ErrorException{
		return controladorContato.procurarContato(id);
	}
	
	public ArrayList<Contato> listarContato(){
		return controladorContato.listarContato();
	}
	
	public ArrayList<Contato> listarContatoPorUsuario(Integer id)throws ErrorException{
		return controladorContato.listarContatoPorUsuario(id);
	}
	
	// endereco
	

	public void cadastrarEndereco (Endereco endereco) throws ErrorException{
		controladorEndereco.cadastrarEndereco(endereco);
	}
	
	public void atualizarEndereco (Endereco endereco) throws ErrorException{
		controladorEndereco.atualizarEndereco(endereco);
	}
	
	public boolean removerEndereco (Integer id) throws ErrorException{
		return controladorEndereco.removerEndereco(id);
	}
	
	public Endereco procurarEndereco (Integer id) throws ErrorException{
		return controladorEndereco.procurarEndereco(id);
	}
	
	public ArrayList<Endereco> listarEndereco(){
		return controladorEndereco.listarEndereco();
	}
	
	// localizacao
	
	public void cadastrarLocalizacao(Localizacao localizacao){
		controladorLocalizacao.cadastrarLocalizacao(localizacao);
	}
	
	public void atualizarLocalizacao(Localizacao localizacao){
		controladorLocalizacao.atualizarLocalizacao(localizacao);
	}
	
	public boolean removerLocalizacao(Integer id){
		return controladorLocalizacao.removerLocalizacao(id);
	}
	
	public Localizacao procurarLocalizacao (Integer id){
		return controladorLocalizacao.procurarLocalizacao(id);
	}
	
	public ArrayList<Localizacao> listarLocalizacao(){
		return controladorLocalizacao.listarLocalizacao();
	}
	
	// tipo bem
	
	public void cadastrarTipoBem(TipoBem tipoBem){
		controladorTipoBem.cadastrarTipoBem(tipoBem);
	}
	
	public void atualizarTipoBem(TipoBem tipoBem){
		controladorTipoBem.atualizarTipoBem(tipoBem);
	}
	
	public boolean removerTipoBem(Integer id){
		return controladorTipoBem.removerTipoBem(id);
	}
	
	public TipoBem procurarTipoBem (Integer id){
		return controladorTipoBem.procurarTipoBem(id);
	}
	
	public ArrayList<TipoBem> listarTipoBem(){
		return controladorTipoBem.listarTipoBem();
	}
	
	// tipo contato
	
	public void cadastrarTipoContato(TipoContato tipoContato){
		controladorTipoContato.cadastrarTipoContato(tipoContato);
	}
	
	public void atualizarTipoContato(TipoContato tipoContato){
		controladorTipoContato.atualizarTipoContato(tipoContato);
	}
	
	public boolean removerTipoContato(Integer id){
		return controladorTipoContato.removerTipoContato(id);
	}
	
	public TipoContato procurarTipoContato (Integer id){
		return controladorTipoContato.procurarTipoContato(id);
	}
	
	public ArrayList<TipoContato> listarTipoContato(){
		return controladorTipoContato.listarTipoContato();
	}
	
	// tipo usuario
	
	public void cadastrarTipoUsuario(TipoUsuario tipoUsuario){
		controladorTipoUsuario.cadastrarTipoUsuario(tipoUsuario);
	}
	
	public void atualizarTipoUsuario (TipoUsuario tipoUsuario){
		controladorTipoUsuario.atualizarTipoUsuario(tipoUsuario);
	}
	
	public boolean removerTipoUsuario(Integer id){
		return controladorTipoUsuario.removerTipoUsuario(id);
	}
	
	public TipoUsuario procurarTipoUsuario (Integer id){
		return controladorTipoUsuario.procurarTipoUsuario(id);
	}
	
	public ArrayList<TipoUsuario> listarTipoUsuario(){
		return controladorTipoUsuario.listarTipoUsuario();
	}
	
	// usuario
	
	public void cadastrarUsuario(Usuario usuario) throws ErrorException{
		controladorUsuario.cadastrarUsuario(usuario);
	}
	
	public void atualizarUsuario(Usuario usuario) throws ErrorException{
		controladorUsuario.atualizarUsuario(usuario);
	}
	
	public Usuario procurarUsuario (Integer id) throws ErrorException{
		return controladorUsuario.procurarUsuario(id);
	}
	
	public boolean removerUsuario(Integer id) throws ErrorException{
		return controladorUsuario.removerUsuario(id);
	}
	
	public ArrayList<Usuario> listarUsuario(){
		return controladorUsuario.listarUsuario();
	}
}
