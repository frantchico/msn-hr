package nosi.webapps.gestao_de_compras.pages.requisicao;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class RequisicaoView extends View {

	public Field loja;
	public Field produto;
	public Field preco_unitario;
	public Field quantidade;
	public Field sub_total;
	public IGRPBox box_1;
	public IGRPForm form_1;
	public IGRPSeparatorList separatorlist_1;


	public RequisicaoView(){

		this.setPageTitle("Requisição");
			
		box_1 = new IGRPBox("box_1","");

		form_1 = new IGRPForm("form_1","");

		separatorlist_1 = new IGRPSeparatorList("separatorlist_1","");

		loja = new ListField(model,"loja");
		loja.setLabel(gt("Loja"));
		loja.propertie().add("name","p_loja").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","Integer").add("tooltip","false").add("disable_copy_paste","false");
		
		produto = new ListField(model,"produto");
		produto.setLabel(gt("Produto"));
		produto.propertie().add("remote",Core.getIGRPLink("gestao_de_compras","Requisicao","carregarPreco")).add("name","p_produto").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("desc","true");
		
		preco_unitario = new NumberField(model,"preco_unitario");
		preco_unitario.setLabel(gt("Preço unitario"));
		preco_unitario.propertie().add("name","p_preco_unitario").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("desc","true");
		
		quantidade = new NumberField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","").add("desc","true");
		
		sub_total = new NumberField(model,"sub_total");
		sub_total.setLabel(gt("Sub Total"));
		sub_total.propertie().add("name","p_sub_total").add("type","number").add("min","").add("max","").add("calculation","true").add("mathcal","{preco_unitario} * {quantidade}").add("numberformat","round:2").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("desc","true");
		


		
	}
		
	@Override
	public void render(){
		

		form_1.addField(loja);

		separatorlist_1.addField(produto);
		separatorlist_1.addField(preco_unitario);
		separatorlist_1.addField(quantidade);
		separatorlist_1.addField(sub_total);

		this.addToPage(box_1);
		this.addToPage(form_1);
		this.addToPage(separatorlist_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		loja.setValue(model);
		produto.setValue(model);
		preco_unitario.setValue(model);
		quantidade.setValue(model);
		sub_total.setValue(model);	

		separatorlist_1.loadModel(((Requisicao) model).getSeparatorlist_1());
		}
}
