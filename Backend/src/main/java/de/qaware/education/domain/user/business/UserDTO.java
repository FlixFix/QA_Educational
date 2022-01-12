package de.qaware.education.domain.user.business;

import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO {

    private String username;

    private String password;


    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}