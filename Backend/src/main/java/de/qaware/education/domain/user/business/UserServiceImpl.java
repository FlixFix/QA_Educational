package de.qaware.education.domain.user.business;

import de.qaware.education.core.Simple;
import de.qaware.education.domain.user.ports.outbound.UserRepository;
import de.qaware.education.domain.user.ports.inbound.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserServiceImpl implements UserService {

    @Inject
    @Simple
    private UserRepository repository;

    public UserDTO getUserById(long id) {
        return repository.getUserById(id);
    }

    public void createUser(UserDTO newUser) {
        repository.createUser(newUser.getUsername(), newUser.getPassword());
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return null;
    }
}
