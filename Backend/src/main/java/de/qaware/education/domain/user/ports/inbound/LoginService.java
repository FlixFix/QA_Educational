package de.qaware.education.domain.user.ports.inbound;

import de.qaware.education.domain.user.business.UserDTO;

public interface LoginService {

    void login(UserDTO user);

    void logout();

    void register(UserDTO newUser);

}
