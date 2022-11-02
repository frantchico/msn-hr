package nosi.webapps.gestao_de_compras.pages.lojaform;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class LojaFormView extends View {

	public Field designacao;
	public Field localizacao;
	public Field registado_por;
	public Field form_1_lookup_1;
	public Field id;
	public Field id_user;
	public IGRPBox box_1;
	public IGRPForm form_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_gravar;

	public LojaFormView(){

		this.setPageTitle("Loja");
			
		box_1 = new IGRPBox("box_1","Loja");

		form_1 = new IGRPForm("form_1","");

		designacao = new TextField(model,"designacao");
		designacao.setLabel(gt("Designação"));
		designacao.propertie().add("name","p_designacao").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("Introduzir o nome da loja")).add("desclabel","true").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		localizacao = new TextField(model,"localizacao");
		localizacao.setLabel(gt("Localização"));
		localizacao.propertie().add("name","p_localizacao").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		registado_por = new TextField(model,"registado_por");
		registado_por.setLabel(gt("Registado por..."));
		registado_por.propertie().add("name","p_registado_por").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","true").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		form_1_lookup_1 = new LookupField(model,"form_1_lookup_1");
		form_1_lookup_1.setLabel(gt("Lookup"));
		form_1_lookup_1.setLookup("igrp_studio","Pesquisa_geografia","index");
		form_1_lookup_1.addParam("target","_blank");
		form_1_lookup_1.addLookupParam("p_form_1_lookup_1","treemenu_1_tmid");
		form_1_lookup_1.propertie().add("name","p_form_1_lookup_1").add("type","lookup").add("lookup_eraser","false").add("lookup_type","LOOKUP").add("class","primary").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","250").add("java-type","Integer").add("tooltip","false").add("disable_copy_paste","false").add("tag","id");
		
		id_user = new HiddenField(model,"id_user");
		id_user.setLabel(gt(""));
		id_user.propertie().add("name","p_id_user").add("type","hidden").add("maxlength","250").add("java-type","Integer").add("tooltip","false").add("disable_copy_paste","false").add("tag","id_user");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_gravar = new IGRPButton("Gravar","gestao_de_compras","LojaForm","gravar","submit","link|fa-save","","");
		btn_gravar.propertie.add("type","specific").add("rel","gravar").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		

		form_1.addField(designacao);
		form_1.addField(localizacao);
		form_1.addField(registado_por);
		form_1.addField(form_1_lookup_1);
		form_1.addField(id);
		form_1.addField(id_user);


		toolsbar_1.addButton(btn_gravar);
		this.addToPage(box_1);
		this.addToPage(form_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		designacao.setValue(model);
		localizacao.setValue(model);
		registado_por.setValue(model);
		form_1_lookup_1.setValue(model);
		id.setValue(model);
		id_user.setValue(model);	

		}
}
