package de.qaware.education.adapter.outbound.database.repository;

import de.qaware.education.core.RequestId;
import de.qaware.education.adapter.outbound.database.entity.UserEntity;
import de.qaware.education.core.Simple;
import de.qaware.education.domain.user.ports.outbound.UserRepository;
import de.qaware.education.domain.user.business.UserDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
@Simple
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "Education")
    private EntityManager em;

    @Inject
    private RequestId requestId;

    private Map<Long, UserDTO> store = new HashMap<>();

    public UserRepositoryImpl() {
        store.put(123L, new UserDTO("test", "pw-test"));
    }

    @Override
    public UserDTO getUserById(long id) {
        System.out.println("The requestId is " +  requestId.getRequestId());

        var userQuery = em.createQuery("select me from UserEntity me where me.id=:userID", UserEntity.class);
        userQuery.setParameter("userID", id);
        var users = userQuery.getResultList();
        var currentUser = users.stream().findFirst().get();
        if (currentUser != null) {
            return new UserDTO(currentUser.getUserName(), currentUser.getPassword());
        }
        return null;

        //return store.get(id);
    }


    @Transactional
    public void createUser(String username, String password) {
        var userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setPassword(password);
        em.persist(userEntity);
    }
}
