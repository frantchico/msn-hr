package nosi.webapps.gestao_de_compras.pages.verificacao;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class VerificacaoView extends View {

	public Field produto;
	public Field preco_unitario;
	public Field quantidade;
	public Field em_stock;
	public Field retificar;
	public Field observacao;
	public Field total_de_item;
	public Field custo;
	public IGRPBox box_1;
	public IGRPSeparatorList separatorlist_1;
	public IGRPForm form_1;


	public VerificacaoView(){

		this.setPageTitle("Verificação");
			
		box_1 = new IGRPBox("box_1","");

		separatorlist_1 = new IGRPSeparatorList("separatorlist_1","");

		form_1 = new IGRPForm("form_1","");

		produto = new ListField(model,"produto");
		produto.setLabel(gt("Produto"));
		produto.propertie().add("remote",Core.getIGRPLink("gestao_de_compras","Verificacao","carregaPreco")).add("name","p_produto").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("desc","true");
		
		preco_unitario = new NumberField(model,"preco_unitario");
		preco_unitario.setLabel(gt("Preço unitario"));
		preco_unitario.propertie().add("name","p_preco_unitario").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","true").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("desc","true");
		
		quantidade = new NumberField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","").add("desc","true");
		
		em_stock = new ListField(model,"em_stock");
		em_stock.setLabel(gt("Em Stock"));
		em_stock.propertie().add("name","p_em_stock").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","DM_Y_N « gestao_de_compras").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","String").add("desc","true");
		
		retificar = new ListField(model,"retificar");
		retificar.setLabel(gt("Retificar"));
		retificar.propertie().add("name","p_retificar").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","DM_Y_N « gestao_de_compras").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		observacao = new TextAreaField(model,"observacao");
		observacao.setLabel(gt("Observação"));
		observacao.propertie().add("name","p_observacao").add("type","textarea").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		total_de_item = new NumberField(model,"total_de_item");
		total_de_item.setLabel(gt("Total de Item"));
		total_de_item.propertie().add("name","p_total_de_item").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","true").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigInteger").add("tooltip","false").add("disable_copy_paste","false");
		
		custo = new NumberField(model,"custo");
		custo.setLabel(gt("Custo"));
		custo.propertie().add("name","p_custo").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","true").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("tooltip","false").add("disable_copy_paste","false");
		


		
	}
		
	@Override
	public void render(){
		

		separatorlist_1.addField(produto);
		separatorlist_1.addField(preco_unitario);
		separatorlist_1.addField(quantidade);
		separatorlist_1.addField(em_stock);

		form_1.addField(retificar);
		form_1.addField(observacao);
		form_1.addField(total_de_item);
		form_1.addField(custo);

		this.addToPage(box_1);
		this.addToPage(separatorlist_1);
		this.addToPage(form_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		produto.setValue(model);
		preco_unitario.setValue(model);
		quantidade.setValue(model);
		em_stock.setValue(model);
		retificar.setValue(model);
		observacao.setValue(model);
		total_de_item.setValue(model);
		custo.setValue(model);	

		separatorlist_1.loadModel(((Verificacao) model).getSeparatorlist_1());
		}
}
