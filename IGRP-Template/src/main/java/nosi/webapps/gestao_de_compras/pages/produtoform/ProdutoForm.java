package nosi.webapps.gestao_de_compras.pages.produtoform;

import java.math.BigDecimal;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.uploadfile.UploadFile;

import nosi.core.validator.constraints.*;

public class ProdutoForm extends Model{		

	@RParam(rParamName = "p_foto")
	private String foto;
	@RParam(rParamName = "p_foto_uuid")
	private String foto_uuid;

	@NotNull()
	@RParam(rParamName = "p_descricao")
	private String descricao;

	@RParam(rParamName = "p_referencia")
	private String referencia;

	@RParam(rParamName = "p_file")
	private UploadFile file;

	@RParam(rParamName = "p_preco_unitario")
	private BigDecimal preco_unitario;

	@RParam(rParamName = "p_registado_por")
	private String registado_por;

	@RParam(rParamName = "p_id")
	private Integer id;

	@RParam(rParamName = "p_id_user")
	private Integer id_user;
	
	public void setFoto(String foto){
		this.foto = foto;
	}
	public String getFoto(){
		return this.foto;
	}
	public void setFoto_uuid(String foto_uuid){
		this.foto_uuid = foto_uuid;
	}
	public String getFoto_uuid(){
		return this.foto_uuid;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao(){
		return this.descricao;
	}
	
	public void setReferencia(String referencia){
		this.referencia = referencia;
	}
	public String getReferencia(){
		return this.referencia;
	}
	
	public void setFile(UploadFile file){
		this.file = file;
	}
	public UploadFile getFile(){
		return this.file;
	}
	
	public void setPreco_unitario(BigDecimal preco_unitario){
		this.preco_unitario = preco_unitario;
	}
	public BigDecimal getPreco_unitario(){
		return this.preco_unitario;
	}
	
	public void setRegistado_por(String registado_por){
		this.registado_por = registado_por;
	}
	public String getRegistado_por(){
		return this.registado_por;
	}
	
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	
	public void setId_user(Integer id_user){
		this.id_user = id_user;
	}
	public Integer getId_user(){
		return this.id_user;
	}



}
