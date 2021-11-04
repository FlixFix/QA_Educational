package de.qaware.education.service;

import de.qaware.education.repository.Repository;
import de.qaware.education.repository.UserEntity;

import javax.inject.Inject;

public class UserService {

    @Inject
    private Repository repository;



    public void getUserTest(){
        UserDTO userById = repository.getUserById(1);

    }


}
