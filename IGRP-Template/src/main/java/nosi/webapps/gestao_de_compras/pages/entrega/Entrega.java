package nosi.webapps.gestao_de_compras.pages.entrega;

import java.math.BigDecimal;
import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class Entrega extends Model{		

	@RParam(rParamName = "p_joja")
	private String joja;

	@RParam(rParamName = "p_total_item")
	private String total_item;

	@RParam(rParamName = "p_custo_total")
	private String custo_total;
	
	private List<Table_1> table_1 = new ArrayList<>();	
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> getTable_1(){
		return this.table_1;
	}

	
	public void setJoja(String joja){
		this.joja = joja;
	}
	public String getJoja(){
		return this.joja;
	}
	
	public void setTotal_item(String total_item){
		this.total_item = total_item;
	}
	public String getTotal_item(){
		return this.total_item;
	}
	
	public void setCusto_total(String custo_total){
		this.custo_total = custo_total;
	}
	public String getCusto_total(){
		return this.custo_total;
	}


	public static class Table_1 extends IGRPTable.Table{
		private String produto;
		private String quantidade;
		private BigDecimal custo;
		public void setProduto(String produto){
			this.produto = produto;
		}
		public String getProduto(){
			return this.produto;
		}

		public void setQuantidade(String quantidade){
			this.quantidade = quantidade;
		}
		public String getQuantidade(){
			return this.quantidade;
		}

		public void setCusto(BigDecimal custo){
			this.custo = custo;
		}
		public BigDecimal getCusto(){
			return this.custo;
		}

	}

	public void loadTable_1(BaseQueryInterface query) {
		this.setTable_1(this.loadTable(query,Table_1.class));
	}

}
