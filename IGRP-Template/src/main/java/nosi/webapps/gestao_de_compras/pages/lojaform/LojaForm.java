package nosi.webapps.gestao_de_compras.pages.lojaform;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

import nosi.core.validator.constraints.*;

public class LojaForm extends Model{		

	@NotNull()
	@RParam(rParamName = "p_designacao")
	private String designacao;

	@RParam(rParamName = "p_localizacao")
	private String localizacao;

	@RParam(rParamName = "p_registado_por")
	private String registado_por;

	@RParam(rParamName = "p_form_1_lookup_1")
	private String form_1_lookup_1;

	@RParam(rParamName = "p_id")
	private Integer id;

	@RParam(rParamName = "p_id_user")
	private Integer id_user;
	
	public void setDesignacao(String designacao){
		this.designacao = designacao;
	}
	public String getDesignacao(){
		return this.designacao;
	}
	
	public void setLocalizacao(String localizacao){
		this.localizacao = localizacao;
	}
	public String getLocalizacao(){
		return this.localizacao;
	}
	
	public void setRegistado_por(String registado_por){
		this.registado_por = registado_por;
	}
	public String getRegistado_por(){
		return this.registado_por;
	}
	
	public void setForm_1_lookup_1(String form_1_lookup_1){
		this.form_1_lookup_1 = form_1_lookup_1;
	}
	public String getForm_1_lookup_1(){
		return this.form_1_lookup_1;
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
