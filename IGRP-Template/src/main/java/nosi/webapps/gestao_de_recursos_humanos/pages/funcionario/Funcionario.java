package nosi.webapps.gestao_de_recursos_humanos.pages.funcionario;

import java.math.BigDecimal;
import nosi.core.gui.components.IGRPLink;
import nosi.core.webapp.Report;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.uploadfile.UploadFile;

import nosi.core.validator.constraints.*;

public class Funcionario extends Model{		

	@NotNull()
	@RParam(rParamName = "p_nome")
	private String nome;

	@NotNull()
	@RParam(rParamName = "p_apelido")
	private String apelido;

	@RParam(rParamName = "p_email")
	private String email;

	@NotNull()
	@RParam(rParamName = "p_salario")
	private BigDecimal salario;

	@NotNull()
	@RParam(rParamName = "p_data_contratacao")
	private String data_contratacao;

	@NotNull()
	@RParam(rParamName = "p_telefone")
	private String telefone;

	@NotNull()
	@RParam(rParamName = "p_funcao")
	private String funcao;

	@NotNull()
	@RParam(rParamName = "p_departamento")
	private String departamento;

	@RParam(rParamName = "p_coordenador")
	private String coordenador;

	@RParam(rParamName = "p_emitir_declaracao_de_vencimento")
	private IGRPLink emitir_declaracao_de_vencimento;
	@RParam(rParamName = "p_emitir_declaracao_de_vencimento_desc")
	private String emitir_declaracao_de_vencimento_desc;

	@RParam(rParamName = "p_fotografia")
	private UploadFile fotografia;

	@RParam(rParamName = "p_id")
	private String id;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setApelido(String apelido){
		this.apelido = apelido;
	}
	public String getApelido(){
		return this.apelido;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setSalario(BigDecimal salario){
		this.salario = salario;
	}
	public BigDecimal getSalario(){
		return this.salario;
	}
	
	public void setData_contratacao(String data_contratacao){
		this.data_contratacao = data_contratacao;
	}
	public String getData_contratacao(){
		return this.data_contratacao;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public String getTelefone(){
		return this.telefone;
	}
	
	public void setFuncao(String funcao){
		this.funcao = funcao;
	}
	public String getFuncao(){
		return this.funcao;
	}
	
	public void setDepartamento(String departamento){
		this.departamento = departamento;
	}
	public String getDepartamento(){
		return this.departamento;
	}
	
	public void setCoordenador(String coordenador){
		this.coordenador = coordenador;
	}
	public String getCoordenador(){
		return this.coordenador;
	}
	
	public IGRPLink setEmitir_declaracao_de_vencimento(String app,String page,String action){
		this.emitir_declaracao_de_vencimento = new IGRPLink(app,page,action);
		return this.emitir_declaracao_de_vencimento;
	}
	public IGRPLink getEmitir_declaracao_de_vencimento(){
		return this.emitir_declaracao_de_vencimento;
	}
	public void setEmitir_declaracao_de_vencimento_desc(String emitir_declaracao_de_vencimento_desc){
		this.emitir_declaracao_de_vencimento_desc = emitir_declaracao_de_vencimento_desc;
	}
	public String getEmitir_declaracao_de_vencimento_desc(){
		return this.emitir_declaracao_de_vencimento_desc;
	}
	public IGRPLink setEmitir_declaracao_de_vencimento(String link){
		this.emitir_declaracao_de_vencimento = new IGRPLink(link);
		return this.emitir_declaracao_de_vencimento;
	}
	public IGRPLink setEmitir_declaracao_de_vencimento(Report link){
		this.emitir_declaracao_de_vencimento = new IGRPLink(link);
		return this.emitir_declaracao_de_vencimento;
	}
	
	public void setFotografia(UploadFile fotografia){
		this.fotografia = fotografia;
	}
	public UploadFile getFotografia(){
		return this.fotografia;
	}
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}



}
