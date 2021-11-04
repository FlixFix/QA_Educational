package de.qaware.education.repository;

import de.qaware.education.service.UserDTO;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.xml.registry.infomodel.User;

public class Repository {


    @Resource
    private EntityManager em;

    @Transactional
    public UserDTO getUserById(long id){
        UserEntity userEntity = em.find(UserEntity.class, id);
        userEntity.setFirstName("HansWurst");
        return new UserDTO();
    }

    @Transactional
    public void createNewUser(String username, String firstName, String lastName){
        UserEntity userEntity = new UserEntity(username, firstName, lastName);
        em.persist(userEntity);
    }



}
