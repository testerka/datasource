package com.mycompany;

import org.apache.wicket.authroles.authentication.panel.SignInPanel;
import org.apache.wicket.markup.html.WebPage;

public class LoginPage extends WebPage {

    public LoginPage() {
        add(new SignInPanel("signInPanel"));
    }
}
