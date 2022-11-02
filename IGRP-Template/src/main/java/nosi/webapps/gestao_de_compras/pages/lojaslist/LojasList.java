package nosi.webapps.gestao_de_compras.pages.lojaslist;

import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class LojasList extends Model{		

	@RParam(rParamName = "p_localizacao_f")
	private String localizacao_f;
	
	private List<Table_1> table_1 = new ArrayList<>();	
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> getTable_1(){
		return this.table_1;
	}

	
	public void setLocalizacao_f(String localizacao_f){
		this.localizacao_f = localizacao_f;
	}
	public String getLocalizacao_f(){
		return this.localizacao_f;
	}


	public static class Table_1 extends IGRPTable.Table{
		private String nome;
		private String localizacao;
		private String registado_por;
		private Integer id;
		public void setNome(String nome){
			this.nome = nome;
		}
		public String getNome(){
			return this.nome;
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

		public void setId(Integer id){
			this.id = id;
		}
		public Integer getId(){
			return this.id;
		}

	}

	public void loadTable_1(BaseQueryInterface query) {
		this.setTable_1(this.loadTable(query,Table_1.class));
	}

}
