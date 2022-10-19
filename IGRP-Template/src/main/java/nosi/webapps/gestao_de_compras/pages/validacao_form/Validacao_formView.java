package nosi.webapps.gestao_de_compras.pages.validacao_form;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Validacao_formView extends View {

	public Field aprovar;
	public Field justificacao;
	public Field descricao;
	public Field quantidade;
	public IGRPForm form_1;
	public IGRPFormList formlist_1;


	public Validacao_formView(){

		this.setPageTitle("Validação Form");
			
		form_1 = new IGRPForm("form_1","");

		formlist_1 = new IGRPFormList("formlist_1","");

		aprovar = new ListField(model,"aprovar");
		aprovar.setLabel(gt("Aprovar"));
		aprovar.propertie().add("name","p_aprovar").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","DM_Y_N « gestao_de_compras").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		justificacao = new TextAreaField(model,"justificacao");
		justificacao.setLabel(gt("Justificação"));
		justificacao.propertie().add("name","p_justificacao").add("type","textarea").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		descricao = new TextField(model,"descricao");
		descricao.setLabel(gt("Descrição"));
		descricao.propertie().add("name","p_descricao").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("inputmask","").add("desc","true");
		
		quantidade = new NumberField(model,"quantidade");
		quantidade.setLabel(gt("Quantidade"));
		quantidade.propertie().add("name","p_quantidade").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("java-type","").add("total_col","false").add("total_row","false").add("totalrow","false").add("desc","true");
		


		
	}
		
	@Override
	public void render(){
		
		form_1.addField(aprovar);

		form_1.addField(justificacao);

		formlist_1.addField(descricao);
		formlist_1.addField(quantidade);

		this.addToPage(form_1);
		this.addToPage(formlist_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		aprovar.setValue(model);
		justificacao.setValue(model);
		descricao.setValue(model);
		quantidade.setValue(model);	

		formlist_1.loadModel(((Validacao_form) model).getFormlist_1());
		}
}
