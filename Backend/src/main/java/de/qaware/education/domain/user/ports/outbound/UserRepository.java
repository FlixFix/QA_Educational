package de.qaware.education.domain.user.ports.outbound;

import de.qaware.education.domain.user.business.UserDTO;


public interface UserRepository {

    UserDTO getUserById(long id);

    void createUser(String username, String password);
}

