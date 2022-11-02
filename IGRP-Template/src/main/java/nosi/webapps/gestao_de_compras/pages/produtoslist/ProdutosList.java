package nosi.webapps.gestao_de_compras.pages.produtoslist;

import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class ProdutosList extends Model{		

	@RParam(rParamName = "p_nome_f")
	private String nome_f;

	@RParam(rParamName = "p_referencia_f")
	private String referencia_f;
	
	private List<Table_1> table_1 = new ArrayList<>();	
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> getTable_1(){
		return this.table_1;
	}

	
	public void setNome_f(String nome_f){
		this.nome_f = nome_f;
	}
	public String getNome_f(){
		return this.nome_f;
	}
	
	public void setReferencia_f(String referencia_f){
		this.referencia_f = referencia_f;
	}
	public String getReferencia_f(){
		return this.referencia_f;
	}


	public static class Table_1 extends IGRPTable.Table{
		private String foto="../images/IGRP/IGRP2.3/assets/img/jon_doe.jpg";
		private String foto_uuid;
		private String produto;
		private String referencia;
		private String registado_por;
		private Integer id;
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

		public void setProduto(String produto){
			this.produto = produto;
		}
		public String getProduto(){
			return this.produto;
		}

		public void setReferencia(String referencia){
			this.referencia = referencia;
		}
		public String getReferencia(){
			return this.referencia;
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

	public void loadTable_1(BaseQueryInterface query) {
		this.setTable_1(this.loadTable(query,Table_1.class));
	}

}
