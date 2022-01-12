package de.qaware.education.core;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class LoginState implements Serializable {
    private boolean loggedIn;


    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
