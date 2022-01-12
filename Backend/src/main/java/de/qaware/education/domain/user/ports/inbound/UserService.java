package de.qaware.education.domain.user.ports.inbound;

import de.qaware.education.domain.user.business.UserDTO;

public interface UserService {

    UserDTO getUserById(long id);

    void createUser(UserDTO newUser);

    UserDTO getUserByUsername(String username);
}
