package br.com.facens.facens.client;

import br.com.facens.facens.client.editores.ClienteView;
import br.com.facens.facens.client.editores.EditorAgencia;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Facens implements EntryPoint {

	public void onModuleLoad() {

		RootPanel.get().add(new ClienteView());
		
		// RootPanel.get().add(new EditorAgencia());
		
	}
}
