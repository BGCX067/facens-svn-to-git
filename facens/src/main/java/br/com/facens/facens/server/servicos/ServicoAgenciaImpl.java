package br.com.facens.facens.server.servicos;

import br.com.facens.facens.client.servicos.ServicoAgencia;
import br.com.facens.facens.shared.beans.Agencia;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ServicoAgenciaImpl 
		extends RemoteServiceServlet 
		implements ServicoAgencia {

	private Agencia[] agencias = new Agencia[10];
	private int indice = 0;
	
	public void salvarAgencia(Agencia agencia) {
		agencias[indice++] = agencia;
	}

	public Agencia consultarAgencia(int codigo) {
		
		for(int i = 0 ; i < agencias.length ; i++) {
			if (agencias[i] != null &&
				agencias[i].getCodigo() == codigo) {
				return agencias[i];
			}
		}
			
		return null;
	}

	public boolean desativarAgencia(int codigo) {
		for (Agencia a:agencias) {
			if (a.getCodigo() == codigo) {
				a.setAtiva(false);
				return true;
			}
		}
		return false;
	}

	public boolean reativarAgencia(int codigo) {
		Agencia a = consultarAgencia(codigo);
		if (a != null) {
			a.setAtiva(true);
			return true;
		}
		return false;
	}
	
	public ServicoAgenciaImpl() {
		
	}
}
