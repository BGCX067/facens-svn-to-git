package br.com.facens.facens.client.servicos;

import br.com.facens.facens.shared.beans.Agencia;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("agencia")
public interface ServicoAgencia extends RemoteService{
	
	void salvarAgencia(Agencia agencia);
	
	Agencia consultarAgencia(int codigo);
	
	boolean desativarAgencia(int codigo);
	
	boolean reativarAgencia(int codigo);
	
}
