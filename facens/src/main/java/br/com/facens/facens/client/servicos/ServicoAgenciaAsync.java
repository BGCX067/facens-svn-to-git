package br.com.facens.facens.client.servicos;

import br.com.facens.facens.shared.beans.Agencia;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ServicoAgenciaAsync {

	void salvarAgencia(Agencia agencia, AsyncCallback<Void> callback);

	void consultarAgencia(int codigo, AsyncCallback<Agencia> callback);

	void desativarAgencia(int codigo, AsyncCallback<Boolean> callback);

	void reativarAgencia(int codigo, AsyncCallback<Boolean> callback);

}
