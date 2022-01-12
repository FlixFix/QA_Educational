package de.qaware.education.domain.user.business;

import de.qaware.education.core.LoginState;
import de.qaware.education.domain.user.ports.inbound.LoginService;
import de.qaware.education.domain.user.ports.inbound.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class LoginServiceImpl implements LoginService {

    @Inject
    private LoginState loginState;

    @Inject
    private UserService userService;

    @Override
    public void login(UserDTO user) {
        var loginUser = userService.getUserByUsername(user.getUsername());
        if (loginUser != null && passwordVerified())
        loginState.setLoggedIn(true);
    }

    private boolean passwordVerified() {
        return false;
    }

    @Override
    public void logout() {
        loginState.setLoggedIn(false);
    }

    @Override
    public void register(UserDTO newUser) {
        userService.createUser(newUser);
        loginState.setLoggedIn(true);
        System.out.println("User registered and logged in!");
    }
}
