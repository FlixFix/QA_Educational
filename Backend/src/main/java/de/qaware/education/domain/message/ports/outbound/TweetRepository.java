package de.qaware.education.domain.message.ports.outbound;

import java.util.List;

public interface TweetRepository {
    void saveTweet(String message);

    List<String> getAllTweets();
}
