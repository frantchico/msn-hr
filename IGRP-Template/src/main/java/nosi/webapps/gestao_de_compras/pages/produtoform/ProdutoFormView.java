package nosi.webapps.gestao_de_compras.pages.produtoform;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class ProdutoFormView extends View {

	public Field foto;
	public Field descricao;
	public Field referencia;
	public Field file;
	public Field preco_unitario;
	public Field registado_por;
	public Field id;
	public Field id_user;
	public IGRPBox box_1;
	public IGRPForm form_2;
	public IGRPForm form_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_guardar;

	public ProdutoFormView(){

		this.setPageTitle("Produto");
			
		box_1 = new IGRPBox("box_1","Produto");

		form_2 = new IGRPForm("form_2","");

		form_1 = new IGRPForm("form_1","");

		foto = new TextField(model,"foto");
		foto.setLabel(gt("Foto"));
		foto.setValue(gt("../images/IGRP/IGRP2.3/assets/img/jon_doe.jpg"));
		foto.propertie().add("name","p_foto").add("type","img").add("img","../images/IGRP/IGRP2.3/assets/img/jon_doe.jpg").add("width","150").add("height","150").add("croppie","true").add("rounded","false").add("autoupload","true").add("maxlength","250").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		descricao = new TextField(model,"descricao");
		descricao.setLabel(gt("Descrição"));
		descricao.propertie().add("name","p_descricao").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("Nome do produto")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		referencia = new TextField(model,"referencia");
		referencia.setLabel(gt("Referência"));
		referencia.propertie().add("name","p_referencia").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("Referencia do produto")).add("desclabel","true").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		file = new FileField(model,"file");
		file.setLabel(gt("File"));
		file.propertie().add("name","p_file").add("type","file").add("accept","application/pdf").add("targetrend","").add("multiple","false").add("rendvalue","false").add("maxlength","250").add("required","false").add("disabled","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		preco_unitario = new NumberField(model,"preco_unitario");
		preco_unitario.setLabel(gt("Preço Unitario"));
		preco_unitario.propertie().add("name","p_preco_unitario").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("tooltip","false").add("disable_copy_paste","false");
		
		registado_por = new TextField(model,"registado_por");
		registado_por.setLabel(gt("Registado por..."));
		registado_por.propertie().add("name","p_registado_por").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","true").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","250").add("java-type","Integer").add("tooltip","false").add("disable_copy_paste","false").add("tag","id");
		
		id_user = new HiddenField(model,"id_user");
		id_user.setLabel(gt(""));
		id_user.propertie().add("name","p_id_user").add("type","hidden").add("maxlength","250").add("java-type","Integer").add("tooltip","false").add("disable_copy_paste","false").add("tag","id_user");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_guardar = new IGRPButton("Guardar","gestao_de_compras","ProdutoForm","guardar","submit","link|fa-save","","");
		btn_guardar.propertie.add("type","specific").add("rel","guardar").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		

		form_2.addField(foto);

		form_1.addField(descricao);
		form_1.addField(referencia);
		form_1.addField(file);
		form_1.addField(preco_unitario);
		form_1.addField(registado_por);
		form_1.addField(id);
		form_1.addField(id_user);


		toolsbar_1.addButton(btn_guardar);
		this.addToPage(box_1);
		this.addToPage(form_2);
		this.addToPage(form_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		descricao.setValue(model);
		referencia.setValue(model);
		file.setValue(model);
		preco_unitario.setValue(model);
		registado_por.setValue(model);
		id.setValue(model);
		id_user.setValue(model);	

		}
}
