package com.mycompany;

import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class WicketApplication extends AuthenticatedWebApplication {

    @Override
    public void init() {
        super.init();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        mountPage("login", LoginPage.class);
        mountPage("home", HomePage.class);
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
        return SecureWebSession.class;
    }

    protected Class<? extends WebPage> getSignInPageClass() {
        return null;
    }
}

