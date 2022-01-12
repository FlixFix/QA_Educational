package de.qaware.education.domain.message.business;

import de.qaware.education.domain.message.ports.outbound.TweetRepository;
import de.qaware.education.domain.message.ports.inbound.TweetService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TweetServiceImpl implements TweetService {

    @Inject
    private TweetRepository tweetRepository;

    @Override
    public void saveTweet(String message) {
        tweetRepository.saveTweet(message);
    }

    @Override
    public List<String> getAllTweets() {
        return tweetRepository.getAllTweets();
    }
}
