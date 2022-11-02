package nosi.webapps.gestao_de_compras.pages.lojaslist;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class LojasListView extends View {

	public Field localizacao_f;
	public Field nome;
	public Field localizacao;
	public Field registado_por;
	public Field id;
	public IGRPForm form_1;
	public IGRPTable table_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_adicionr_loja;
	public IGRPButton btn_filtrar;
	public IGRPButton btn_editar;
	public IGRPButton btn_eliminar;

	public LojasListView(){

		this.setPageTitle("Lojas");
			
		form_1 = new IGRPForm("form_1","Filtrar por...");

		table_1 = new IGRPTable("table_1","");

		localizacao_f = new TextField(model,"localizacao_f");
		localizacao_f.setLabel(gt("Localização"));
		localizacao_f.propertie().add("name","p_localizacao_f").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		localizacao = new TextField(model,"localizacao");
		localizacao.setLabel(gt("Localização"));
		localizacao.propertie().add("name","p_localizacao").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		registado_por = new TextField(model,"registado_por");
		registado_por.setLabel(gt("Registado por..."));
		registado_por.propertie().add("name","p_registado_por").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","Integer").add("tag","id");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_adicionr_loja = new IGRPButton("Adicionr Loja","gestao_de_compras","LojasList","adicionr_loja","right_panel|refresh","link|fa-plus","","");
		btn_adicionr_loja.propertie.add("type","specific").add("rel","adicionr_loja").add("refresh_components","");

		btn_filtrar = new IGRPButton("Filtrar","gestao_de_compras","LojasList","filtrar","submit_ajax","link|fa-search","","");
		btn_filtrar.propertie.add("id","button_ec31_12f6").add("type","form").add("class","link").add("rel","filtrar").add("refresh_components","table_1");

		btn_editar = new IGRPButton("Editar","gestao_de_compras","LojasList","editar","right_panel|refresh","link|fa-edit","","");
		btn_editar.propertie.add("id","button_7a1f_29d7").add("type","specific").add("class","link").add("rel","editar").add("refresh_components","");

		btn_eliminar = new IGRPButton("Eliminar","gestao_de_compras","LojasList","eliminar","submit_ajax","link|fa-trash-o","","");
		btn_eliminar.propertie.add("id","button_106a_13a7").add("type","specific").add("flg_transaction","true").add("class","link").add("rel","eliminar").add("refresh_components","table_1");

		
	}
		
	@Override
	public void render(){
		
		form_1.addField(localizacao_f);


		table_1.addField(nome);
		table_1.addField(localizacao);
		table_1.addField(registado_por);
		table_1.addField(id);

		toolsbar_1.addButton(btn_adicionr_loja);
		form_1.addButton(btn_filtrar);
		table_1.addButton(btn_editar);
		table_1.addButton(btn_eliminar);
		this.addToPage(form_1);
		this.addToPage(table_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		localizacao_f.setValue(model);
		nome.setValue(model);
		localizacao.setValue(model);
		registado_por.setValue(model);
		id.setValue(model);	

		table_1.loadModel(((LojasList) model).getTable_1());
		}
}
