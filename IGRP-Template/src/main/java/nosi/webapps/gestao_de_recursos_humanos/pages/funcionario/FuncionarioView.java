package nosi.webapps.gestao_de_recursos_humanos.pages.funcionario;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class FuncionarioView extends View {

	public Field nome;
	public Field apelido;
	public Field email;
	public Field salario;
	public Field data_contratacao;
	public Field telefone;
	public Field funcao;
	public Field departamento;
	public Field coordenador;
	public Field emitir_declaracao_de_vencimento;
	public Field fotografia;
	public Field id;
	public IGRPForm form_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_gravar;

	public FuncionarioView(){

		this.setPageTitle("Funcionário");
			
		form_1 = new IGRPForm("form_1","Ficha do Funcionário");

		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		apelido = new TextField(model,"apelido");
		apelido.setLabel(gt("Apelido"));
		apelido.propertie().add("name","p_apelido").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		email = new EmailField(model,"email");
		email.setLabel(gt("Email"));
		email.propertie().add("name","p_email").add("type","email").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		salario = new NumberField(model,"salario");
		salario.setLabel(gt("Salario"));
		salario.propertie().add("name","p_salario").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","BigDecimal").add("tooltip","false").add("disable_copy_paste","false");
		
		data_contratacao = new DateField(model,"data_contratacao");
		data_contratacao.setLabel(gt("Data Contratação"));
		data_contratacao.propertie().add("name","p_data_contratacao").add("type","date").add("range","false").add("disableWeekends","false").add("disabledBeforetoday","false").add("daysoff","false").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		telefone = new TextField(model,"telefone");
		telefone.setLabel(gt("Telefone"));
		telefone.propertie().add("name","p_telefone").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		funcao = new ListField(model,"funcao");
		funcao.setLabel(gt("Função"));
		funcao.propertie().add("name","p_funcao").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		departamento = new ListField(model,"departamento");
		departamento.setLabel(gt("Departamento"));
		departamento.propertie().add("name","p_departamento").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		coordenador = new ListField(model,"coordenador");
		coordenador.setLabel(gt("Coordenador"));
		coordenador.propertie().add("name","p_coordenador").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		emitir_declaracao_de_vencimento = new LinkField(model,"emitir_declaracao_de_vencimento");
		emitir_declaracao_de_vencimento.setLabel(gt("Emitir Declaração de Vencimento"));
		emitir_declaracao_de_vencimento.setValue(Core.getIGRPLink("gestao_de_recursos_humanos","Lista_de_empregados","index"));

									emitir_declaracao_de_vencimento.propertie().add("name","p_emitir_declaracao_de_vencimento").add("type","link").add("target","_blank").add("request_fields","").add("refresh_components","").add("refresh_submit","false").add("adbcli","").add("class","primary").add("img","fa-file-text-o").add("maxlength","250").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		fotografia = new FileField(model,"fotografia");
		fotografia.setLabel(gt("Fotografia"));
		fotografia.propertie().add("name","p_fotografia").add("type","file").add("accept","image/*").add("targetrend","").add("multiple","false").add("rendvalue","false").add("maxlength","2000").add("required","false").add("disabled","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("name","p_id").add("type","hidden").add("maxlength","250").add("java-type","").add("tooltip","false").add("disable_copy_paste","false").add("tag","id");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_gravar = new IGRPButton("Gravar","gestao_de_recursos_humanos","Funcionario","gravar","submit","primary|fa-save","","");
		btn_gravar.propertie.add("type","specific").add("rel","gravar").add("refresh_components","");

		
	}
		
	@Override
	public void render(){
		
		form_1.addField(nome);
		form_1.addField(apelido);
		form_1.addField(email);
		form_1.addField(salario);
		form_1.addField(data_contratacao);
		form_1.addField(telefone);
		form_1.addField(funcao);
		form_1.addField(departamento);
		form_1.addField(coordenador);
		form_1.addField(emitir_declaracao_de_vencimento);
		form_1.addField(fotografia);
		form_1.addField(id);


		toolsbar_1.addButton(btn_gravar);
		this.addToPage(form_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome.setValue(model);
		apelido.setValue(model);
		email.setValue(model);
		salario.setValue(model);
		data_contratacao.setValue(model);
		telefone.setValue(model);
		funcao.setValue(model);
		departamento.setValue(model);
		coordenador.setValue(model);
		emitir_declaracao_de_vencimento.setValue(model);
		fotografia.setValue(model);
		id.setValue(model);	

		}
}
