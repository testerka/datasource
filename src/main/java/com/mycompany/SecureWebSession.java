package com.mycompany;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import org.apache.wicket.spring.injection.annot.AnnotProxyFieldValueFactory

public class SecureWebSession extends AuthenticatedWebSession {

    @SpringBean(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    public SecureWebSession(Request request) {
        super(request);
        Injector.get().inject(this);
    }

    protected boolean authenticate(String username, String password) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        if (authenticate.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authenticate);
            return true;
        }
        return false;
    }

    public Roles getRoles() {
        if (isSignedIn()) {
            // If the user is signed in, they have these roles
            return new Roles(Roles.USER);
        }
        return null;
    }
}
