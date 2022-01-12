package de.qaware.education.adapter.outbound.database.repository;

import de.qaware.education.adapter.outbound.database.entity.MessageEntity;
import de.qaware.education.adapter.outbound.database.entity.UserEntity;
import de.qaware.education.domain.message.ports.outbound.TweetRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TweetRepositoryImpl implements TweetRepository {


    @PersistenceContext(unitName = "Education")
    private EntityManager em;

    @Transactional
    @Override
    public void saveTweet(String message) {
        var messageEntity = new MessageEntity();
        var user = em.getReference(UserEntity.class, 1L);
        messageEntity.setUser(user);
        messageEntity.setMessage(message);
        em.persist(messageEntity);

    }

    @Transactional
    @Override
    public List<String> getAllTweets() {
        var messagesQuery = em.createQuery("select me from MessageEntity me", MessageEntity.class);
        var messages = messagesQuery.getResultList();
        return messages.stream().map(MessageEntity::getMessage).collect(Collectors.toList());
    }
}
