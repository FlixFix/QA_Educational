package de.qaware.education.frontend;

import de.qaware.education.core.LoginState;
import de.qaware.education.domain.message.ports.inbound.TweetService;
import de.qaware.education.domain.user.business.UserDTO;
import de.qaware.education.domain.user.ports.inbound.LoginService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("landingPageController")
@ViewScoped
public class LandingPageController implements Serializable {

    private String tweet = "...";

    private List<String> tweets = new ArrayList<>();

    @Inject
    private TweetService tweetService;

    @Inject
    private LoginService loginService;

    @Inject
    private LoginState loginState;

    private String userName;
    private String password;
    private boolean registering = false;
    private boolean pendingLogin;

    @PostConstruct
    public void init() {
        reloadTweets();
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void saveTweet(){
        tweetService.saveTweet(tweet);
        reloadTweets();
    }

    public List<String> getTweets() {
        return tweets;
    }

    private void reloadTweets() {
        tweets = tweetService.getAllTweets();
    }

    public void showLogin() {
        pendingLogin = true;
        //loginService.login(getUserFromInput());
    }

    public void login() {
        loginService.login(getUserFromInput());
        pendingLogin = false;
    }

    public void logout() {
        loginService.logout();
    }

    public void register() {
        loginService.register(getUserFromInput());
        registering = false;
    }

    private UserDTO getUserFromInput() {
        return new UserDTO(userName, password);
    }

    public boolean isRegistering() {
        return registering;
    }

    public boolean isLoggedIn() {
        return loginState.isLoggedIn();
    }

    public void showRegisteringPanel() {
        registering = true;
    }

    public boolean isPendingLogin() {
        return pendingLogin;
    }
}
