package nosi.webapps.gestao_de_compras.pages.verificacao;

import java.math.BigInteger;
import java.math.BigDecimal;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import nosi.core.validator.constraints.*;

public class Verificacao extends Model{		

	@NotNull()
	@RParam(rParamName = "p_retificar")
	private String retificar;

	@RParam(rParamName = "p_observacao")
	private String observacao;

	@RParam(rParamName = "p_total_de_item")
	private BigInteger total_de_item;

	@RParam(rParamName = "p_custo")
	private BigDecimal custo;
	
	@SeparatorList(name = Separatorlist_1.class)
	@Valid
	private List<Separatorlist_1> separatorlist_1 = new ArrayList<>();	
	public void setSeparatorlist_1(List<Separatorlist_1> separatorlist_1){
		this.separatorlist_1 = separatorlist_1;
	}
	public List<Separatorlist_1> getSeparatorlist_1(){
		return this.separatorlist_1;
	}
	@RParam(rParamName = "p_separatorlist_1_id")
	private String[] p_separatorlist_1_id;
	@RParam(rParamName = "p_separatorlist_1_del")
	private String[] p_separatorlist_1_del;
	@RParam(rParamName = "p_separatorlist_1_edit")
	private String[] p_separatorlist_1_edit;
	
	public void setP_separatorlist_1_id(String[] p_separatorlist_1_id){
		this.p_separatorlist_1_id = p_separatorlist_1_id;
	}
	public String[] getP_separatorlist_1_id(){
		return this.p_separatorlist_1_id;
	}
	
	public void setP_separatorlist_1_del(String[] p_separatorlist_1_del){
		this.p_separatorlist_1_del = p_separatorlist_1_del;
	}
	public String[] getP_separatorlist_1_del(){
		return this.p_separatorlist_1_del;
	}
	
	public void setP_separatorlist_1_edit(String[] p_separatorlist_1_edit){
		this.p_separatorlist_1_edit = p_separatorlist_1_edit;
	}
	public String[] getP_separatorlist_1_edit(){
		return this.p_separatorlist_1_edit;
	}
	
	public void setRetificar(String retificar){
		this.retificar = retificar;
	}
	public String getRetificar(){
		return this.retificar;
	}
	
	public void setObservacao(String observacao){
		this.observacao = observacao;
	}
	public String getObservacao(){
		return this.observacao;
	}
	
	public void setTotal_de_item(BigInteger total_de_item){
		this.total_de_item = total_de_item;
	}
	public BigInteger getTotal_de_item(){
		return this.total_de_item;
	}
	
	public void setCusto(BigDecimal custo){
		this.custo = custo;
	}
	public BigDecimal getCusto(){
		return this.custo;
	}


	public static class Separatorlist_1{
		private Pair separatorlist_1_id;
private Pair produto;
private Pair preco_unitario;
private Pair quantidade;
private Pair em_stock;
		public void setSeparatorlist_1_id(Pair separatorlist_1_id){
			this.separatorlist_1_id = separatorlist_1_id;
		}
		public Pair getSeparatorlist_1_id(){
			return this.separatorlist_1_id;
		}
		public void setProduto(Pair produto){
			this.produto = produto;
		}
		public Pair getProduto(){
			return this.produto;
		}

		public void setPreco_unitario(Pair preco_unitario){
			this.preco_unitario = preco_unitario;
		}
		public Pair getPreco_unitario(){
			return this.preco_unitario;
		}

		public void setQuantidade(Pair quantidade){
			this.quantidade = quantidade;
		}
		public Pair getQuantidade(){
			return this.quantidade;
		}

		public void setEm_stock(Pair em_stock){
			this.em_stock = em_stock;
		}
		public Pair getEm_stock(){
			return this.em_stock;
		}

	}

	public void loadSeparatorlist_1(BaseQueryInterface query) {
		this.setSeparatorlist_1(this.loadFormList(query,Separatorlist_1.class));
	}

}
