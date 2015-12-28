package br.com.facens.facens.client.editores;

import br.com.facens.facens.shared.beans.UnidadeFederativa;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class ClienteView extends Composite {

	private static ClienteViewUiBinder uiBinder = GWT
			.create(ClienteViewUiBinder.class);

	interface ClienteViewUiBinder extends UiBinder<Widget, ClienteView> {
	}
	
	@UiField
	ListBox lstUF;
	
	public ClienteView() {
		initWidget(uiBinder.createAndBindUi(this));
		for (UnidadeFederativa unfr:UnidadeFederativa.values()) {
			lstUF.addItem(unfr.getDescricao(), unfr.name());
		}
	}

}
