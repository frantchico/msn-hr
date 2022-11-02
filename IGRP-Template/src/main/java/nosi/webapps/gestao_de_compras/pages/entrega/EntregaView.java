package nosi.webapps.gestao_de_compras.pages.entrega;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class EntregaView extends View {

	public Field joja;
	public Field total_item;
	public Field custo_total;
	public Field produto;
	public Field quantidade;
	public Field custo;
	public IGRPBox box_1;
	public IGRPView view_1;
	public IGRPTable table_1;


	public EntregaView(){

		this.setPageTitle("Entrega");
			
		box_1 = new IGRPBox("box_1","");

		view_1 = new IGRPView("view_1","");

		table_1 = new IGRPTable("table_1","");

		joja = new TextField(model,"joja");
		joja.setLabel(gt("Joja"));
		joja.propertie().add("name","p_joja").add("type","text").add("maxlength","250").add("class","default").add("img","").add("showlabel","true");
		
		total_item = new TextField(model,"total_item");
		total_item.setLabel(gt("Total Item"));
		total_item.propertie().add("name","p_total_item").add("type","text").add("maxlength","250").add("class","default").add("img","").add("showlabel","true");
		
		custo_total = new TextField(model,"custo_total");
		custo_total.setLabel(gt("Custo Total"));
		custo_total.propertie().add("name","p_custo_total").add("type","text").add("maxlength","250").add("class","default").add("img","").add("showlabel","true");
		
		produto = new TextField(model,"produto");
		produto.setLabel(gt("Produto"));
		produto.propertie().add("name","p_produto").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		quantidade = new TextField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		custo = new NumberField(model,"custo");
		custo.setLabel(gt("Custo"));
		custo.propertie().add("name","p_custo").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","30").add("showLabel","true").add("total_footer","false").add("group_in","").add("java-type","BigDecimal");
		


		
	}
		
	@Override
	public void render(){
		

		view_1.addField(joja);
		view_1.addField(total_item);
		view_1.addField(custo_total);

		table_1.addField(produto);
		table_1.addField(quantidade);
		table_1.addField(custo);

		this.addToPage(box_1);
		this.addToPage(view_1);
		this.addToPage(table_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		joja.setValue(model);
		total_item.setValue(model);
		custo_total.setValue(model);
		produto.setValue(model);
		quantidade.setValue(model);
		custo.setValue(model);	

		table_1.loadModel(((Entrega) model).getTable_1());
		}
}
