package org.vaadin.tokenfield.v7.client.ui;

import org.vaadin.tokenfield.v7.TokenComboBox;
import org.vaadin.tokenfield.v7.client.ui.VTokenField.DeleteListener;

import com.google.gwt.core.client.GWT;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.v7.client.ui.combobox.ComboBoxConnector;
import com.vaadin.shared.ui.Connect;

@Connect(TokenComboBox.class)
public class TokenFieldConnector extends ComboBoxConnector {

    private TokenFieldServerRpc rpc = RpcProxy.create(
            TokenFieldServerRpc.class, this);

    protected boolean after = false;

    @Override
    protected void init() {
        getWidget().addListener(new DeleteListener() {
            public void onDelete() {
                rpc.deleteToken();
            }
        });

    }

    @Override
    public VTokenField getWidget() {
        return (VTokenField) super.getWidget();
    }

    @Override
    protected VTokenField createWidget() {
        // TODO Auto-generated method stub
        return GWT.create(VTokenField.class);
    }

}
