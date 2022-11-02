package nosi.webapps.gestao_de_compras.pages.requisicao;

import java.math.BigDecimal;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import nosi.core.gui.components.IGRPSeparatorList.Pair;
import nosi.core.webapp.SeparatorList;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
public class Requisicao extends Model{		

	@RParam(rParamName = "p_loja")
	private Integer loja;
	
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
	
	public void setLoja(Integer loja){
		this.loja = loja;
	}
	public Integer getLoja(){
		return this.loja;
	}


	public static class Separatorlist_1{
		private Pair separatorlist_1_id;
private Pair produto;
private Pair preco_unitario;
private Pair quantidade;
private Pair sub_total;
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

		public void setSub_total(Pair sub_total){
			this.sub_total = sub_total;
		}
		public Pair getSub_total(){
			return this.sub_total;
		}

	}

	public void loadSeparatorlist_1(BaseQueryInterface query) {
		this.setSeparatorlist_1(this.loadFormList(query,Separatorlist_1.class));
	}

}
