package com.mycompany;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;


public class WicketApplication extends WebApplication {

    @Override
    public void init() {
        super.init();

        // add your configuration here
    }

    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

}

