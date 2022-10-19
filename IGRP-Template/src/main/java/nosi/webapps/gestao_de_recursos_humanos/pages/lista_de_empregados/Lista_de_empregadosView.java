package nosi.webapps.gestao_de_recursos_humanos.pages.lista_de_empregados;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class Lista_de_empregadosView extends View {

	public Field departamento_id;
	public Field funcao_id;
	public Field departamento;
	public Field funcao;
	public Field nome;
	public Field apelido;
	public Field email;
	public Field salario;
	public Field ver_foto;
	public Field ver_foto_desc;
	public Field id;
	public IGRPForm form_1;
	public IGRPTable table_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_novo;
	public IGRPButton btn_filtrar;
	public IGRPButton btn_editar;
	public IGRPButton btn_eliminar;
	public IGRPButton btn_declaracao_vencimento;

	public Lista_de_empregadosView(){

		this.setPageTitle("Lista de Empregados");
			
		form_1 = new IGRPForm("form_1","Filtrar por...");

		table_1 = new IGRPTable("table_1","Empregados");

		departamento_id = new ListField(model,"departamento_id");
		departamento_id.setLabel(gt("Departamento"));
		departamento_id.propertie().add("name","p_departamento_id").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		funcao_id = new ListField(model,"funcao_id");
		funcao_id.setLabel(gt("Função"));
		funcao_id.propertie().add("name","p_funcao_id").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		departamento = new TextField(model,"departamento");
		departamento.setLabel(gt("Departamento"));
		departamento.propertie().add("name","p_departamento").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		funcao = new TextField(model,"funcao");
		funcao.setLabel(gt("Função"));
		funcao.propertie().add("name","p_funcao").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		apelido = new TextField(model,"apelido");
		apelido.setLabel(gt("Apelido"));
		apelido.propertie().add("name","p_apelido").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		email = new TextField(model,"email");
		email.setLabel(gt("Email"));
		email.propertie().add("name","p_email").add("type","text").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		salario = new NumberField(model,"salario");
		salario.setLabel(gt("Salário"));
		salario.propertie().add("name","p_salario").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","30").add("showLabel","true").add("total_footer","false").add("group_in","").add("java-type","BigDecimal");
		
		ver_foto = new LinkField(model,"ver_foto");
		ver_foto.setLabel(gt("Ver Foto"));
		ver_foto.setValue(Core.getIGRPLink("gestao_de_recursos_humanos","Lista_de_empregados","index"));

									ver_foto_desc = new LinkField(model,"ver_foto_desc");
		ver_foto_desc.setLabel(gt("Ver Foto"));
		ver_foto.propertie().add("name","p_ver_foto").add("type","link").add("target","_blank").add("request_fields","").add("list_source","").add("refresh_components","").add("refresh_submit","false").add("adbcli","").add("class","link").add("img","fa-picture-o").add("maxlength","30").add("showLabel","true").add("group_in","").add("show_header","true").add("desc","true");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","").add("tag","id");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_novo = new IGRPButton("Novo","gestao_de_recursos_humanos","Lista_de_empregados","novo","modal|refresh","primary|fa-user-plus","","");
		btn_novo.propertie.add("type","specific").add("rel","novo").add("refresh_components","");

		btn_filtrar = new IGRPButton("Filtrar","gestao_de_recursos_humanos","Lista_de_empregados","filtrar","submit_ajax","grey|fa-filter","","");
		btn_filtrar.propertie.add("id","button_3487_9a97").add("type","form").add("class","grey").add("rel","filtrar").add("refresh_components","table_1");

		btn_editar = new IGRPButton("Editar","gestao_de_recursos_humanos","Lista_de_empregados","editar","modal|refresh","warning|fa-edit","","");
		btn_editar.propertie.add("id","button_fea9_89a6").add("type","specific").add("class","warning").add("rel","editar").add("refresh_components","");

		btn_eliminar = new IGRPButton("Eliminar","gestao_de_recursos_humanos","Lista_de_empregados","eliminar","confirm","danger|fa-user-times","","");
		btn_eliminar.propertie.add("id","button_1450_0e67").add("type","specific").add("class","danger").add("rel","eliminar").add("refresh_components","").add("labelConfirm","Deseja realmente realizar esta operação?");

		btn_declaracao_vencimento = new IGRPButton("Declaração Vencimento","gestao_de_recursos_humanos","Lista_de_empregados","declaracao_vencimento","_blank","info|fa-file-pdf-o","","");
		btn_declaracao_vencimento.propertie.add("id","button_b15d_43c4").add("type","specific").add("class","info").add("rel","declaracao_vencimento").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		
		form_1.addField(departamento_id);
		form_1.addField(funcao_id);


		table_1.addField(departamento);
		table_1.addField(funcao);
		table_1.addField(nome);
		table_1.addField(apelido);
		table_1.addField(email);
		table_1.addField(salario);
		table_1.addField(ver_foto);
		table_1.addField(ver_foto_desc);
		table_1.addField(id);

		toolsbar_1.addButton(btn_novo);
		form_1.addButton(btn_filtrar);
		table_1.addButton(btn_editar);
		table_1.addButton(btn_eliminar);
		table_1.addButton(btn_declaracao_vencimento);
		this.addToPage(form_1);
		this.addToPage(table_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		departamento_id.setValue(model);
		funcao_id.setValue(model);
		departamento.setValue(model);
		funcao.setValue(model);
		nome.setValue(model);
		apelido.setValue(model);
		email.setValue(model);
		salario.setValue(model);
		ver_foto.setValue(model);
		ver_foto_desc.setValue(model);
		id.setValue(model);	

		table_1.loadModel(((Lista_de_empregados) model).getTable_1());
		}
}
