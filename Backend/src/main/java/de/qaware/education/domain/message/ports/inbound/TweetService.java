package de.qaware.education.domain.message.ports.inbound;

import java.util.List;

public interface TweetService {
    void saveTweet(String message);

    List<String> getAllTweets();
}
