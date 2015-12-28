package br.com.facens.facens.client.editores;

import br.com.facens.facens.client.servicos.ServicoAgencia;
import br.com.facens.facens.client.servicos.ServicoAgenciaAsync;
import br.com.facens.facens.shared.beans.Agencia;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class EditorAgencia extends Composite {

	private static EditorAgenciaUiBinder uiBinder = GWT
			.create(EditorAgenciaUiBinder.class);

	interface EditorAgenciaUiBinder extends UiBinder<Widget, EditorAgencia> {
	}

	@UiField
	TextBox txtCodAgencia;

	@UiField
	TextBox txtNome;

	@UiField
	TextBox txtCNPJ;

	@UiField
	CheckBox ckbAtiva;

	@UiField
	TextBox txtEnd;

	private ServicoAgenciaAsync servico = GWT.create(ServicoAgencia.class);

	public EditorAgencia() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnSalvar")
	void qdoSalvar(ClickEvent event) {

		Agencia agencia = new Agencia();
		preencherBeanAgencia(agencia);
		// Window.alert("salvando: " + agencia.getNome());
		servico.salvarAgencia(agencia, new AsyncCallback<Void>() {

			public void onSuccess(Void result) {
				limparTela();

			}

			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});

	}

	@UiHandler("btnConsultar")
	void btnConsultar(ClickEvent event) {

		String textoCodigo = txtCodAgencia.getText();
		int codigo = Integer.parseInt(textoCodigo);

		servico.consultarAgencia(codigo, new AsyncCallback<Agencia>() {

			public void onSuccess(Agencia result) {
				mostrarBeanAgencia(result);
			}

			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());
			}
		});
	}
	
	@UiHandler("desativar")
	void onDesativar(ClickEvent event) {
		int codigo = Integer.parseInt(txtCodAgencia.getText());
		servico.desativarAgencia(codigo, new AsyncCallback<Boolean>() {
			public void onFailure(Throwable caught) {
				Window.alert(caught.getMessage());				
			}
			
			public void onSuccess(Boolean result) {
				if (result == Boolean.TRUE){
					Window.alert("Agencia desativada com sucesso!");
				} else {
					Window.alert("A agencia não foi desativada");
				}
				
			}
		});
	}

	private void preencherBeanAgencia(Agencia agencia) {

		agencia.setCodigo(Integer.parseInt(txtCodAgencia.getValue()));
		agencia.setNome(txtNome.getValue());
		agencia.setCnpj(txtCNPJ.getValue());
		agencia.setAtiva(ckbAtiva.getValue());
		agencia.setEndereco(txtEnd.getValue());

	}

	private void limparTela() {
		txtCodAgencia.setValue("");
		txtNome.setValue("");
		txtCNPJ.setValue("");
		ckbAtiva.setValue(false);
		txtEnd.setValue("");
	}

	private void mostrarBeanAgencia(Agencia agencia) {

		txtCodAgencia.setValue(String.valueOf(agencia.getCodigo()));
		txtNome.setValue(agencia.getNome());
		txtCNPJ.setValue(agencia.getCnpj());
		ckbAtiva.setValue(agencia.isAtiva());
		txtEnd.setValue(agencia.getEndereco());

	}

}
