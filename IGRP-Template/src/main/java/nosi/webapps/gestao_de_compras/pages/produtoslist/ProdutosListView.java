package nosi.webapps.gestao_de_compras.pages.produtoslist;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class ProdutosListView extends View {

	public Field nome_f;
	public Field referencia_f;
	public Field foto;
	public Field produto;
	public Field referencia;
	public Field registado_por;
	public Field id;
	public Field id_user;
	public IGRPForm form_1;
	public IGRPTable table_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_adicionar_produto;
	public IGRPButton btn_filtar;
	public IGRPButton btn_editar;
	public IGRPButton btn_eliminar;

	public ProdutosListView(){

		this.setPageTitle("Produtos");
			
		form_1 = new IGRPForm("form_1","Filtra por...");

		table_1 = new IGRPTable("table_1","");

		nome_f = new TextField(model,"nome_f");
		nome_f.setLabel(gt("Nome"));
		nome_f.propertie().add("name","p_nome_f").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		referencia_f = new TextField(model,"referencia_f");
		referencia_f.setLabel(gt("Referência"));
		referencia_f.propertie().add("name","p_referencia_f").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		foto = new TextField(model,"foto");
		foto.setLabel(gt("Foto"));
		foto.setValue(gt(""));
		foto.propertie().add("name","p_foto").add("type","img").add("img","../images/IGRP/IGRP2.3/assets/img/jon_doe.jpg").add("width","").add("height","").add("croppie","false").add("rounded","false").add("autoupload","false").add("maxlength","3000").add("showLabel","true").add("group_in","");
		
		produto = new TextAreaField(model,"produto");
		produto.setLabel(gt("Produto"));
		produto.propertie().add("name","p_produto").add("type","textarea").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		referencia = new TextField(model,"referencia");
		referencia.setLabel(gt("Referência"));
		referencia.propertie().add("name","p_referencia").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		registado_por = new TextField(model,"registado_por");
		registado_por.setLabel(gt("Registado por"));
		registado_por.propertie().add("name","p_registado_por").add("type","text").add("maxlength","300").add("showLabel","true").add("group_in","");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","Integer").add("tag","id");
		
		id_user = new HiddenField(model,"id_user");
		id_user.setLabel(gt(""));
		id_user.propertie().add("name","p_id_user").add("type","hidden").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","Integer").add("tag","id_user");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_adicionar_produto = new IGRPButton("Adicionar Produto","gestao_de_compras","ProdutosList","adicionar_produto","right_panel|refresh","link|fa-plus","","");
		btn_adicionar_produto.propertie.add("type","specific").add("rel","adicionar_produto").add("refresh_components","");

		btn_filtar = new IGRPButton("Filtar","gestao_de_compras","ProdutosList","filtar","submit_ajax","link|fa-search","","");
		btn_filtar.propertie.add("id","button_e5a0_f340").add("type","form").add("class","link").add("rel","filtar").add("refresh_components","table_1");

		btn_editar = new IGRPButton("Editar","gestao_de_compras","ProdutosList","editar","right_panel|refresh","link|fa-edit","","");
		btn_editar.propertie.add("id","button_a4d4_3b54").add("type","specific").add("class","link").add("rel","editar").add("refresh_components","");

		btn_eliminar = new IGRPButton("Eliminar","gestao_de_compras","ProdutosList","eliminar","submit_ajax","link|fa-trash-o","","");
		btn_eliminar.propertie.add("id","button_684d_cc4a").add("type","specific").add("flg_transaction","true").add("class","link").add("rel","eliminar").add("refresh_components","table_1");

		
	}
		
	@Override
	public void render(){
		
		form_1.addField(nome_f);
		form_1.addField(referencia_f);


		table_1.addField(foto);
		table_1.addField(produto);
		table_1.addField(referencia);
		table_1.addField(registado_por);
		table_1.addField(id);
		table_1.addField(id_user);

		toolsbar_1.addButton(btn_adicionar_produto);
		form_1.addButton(btn_filtar);
		table_1.addButton(btn_editar);
		table_1.addButton(btn_eliminar);
		this.addToPage(form_1);
		this.addToPage(table_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome_f.setValue(model);
		referencia_f.setValue(model);
		produto.setValue(model);
		referencia.setValue(model);
		registado_por.setValue(model);
		id.setValue(model);
		id_user.setValue(model);	

		table_1.loadModel(((ProdutosList) model).getTable_1());
		}
}
