## Synopsis

This project is one of the supporting projects for Song Recommender application which can be found on https://github.com/Igor-Jovic/SongRecommenderWeb. The purpose of this app is to post a Song Recommender's dynamic IP address to Twitter so that it is accessible at any time. 

## Code Example

The Twitter Status Updater uses Spring Boot as it's base and makes usage of  @Scheduled annotation to schedule the status update task. 

    @Scheduled(fixedRate = 3600000)
    public void reportCurrentTime() throws IOException {
        String ipAddress = getIpAddress();
        System.out.println("Current ip address is: " + ipAddress);
        System.out.println("Posting to twitter, time: " + LocalDateTime.now());
        try {
            TwitterApi.destroyLastTweet();
            TwitterApi.tweetMessage(ipAddress);
        } catch (TwitterException e) {
            System.err.println("There was a problem posting to application.twitter");
            e.printStackTrace();
        }

## Motivation

Since the Song Recommender has dynamic IP address this bypasses that constraint and provides always up to date IP address using a twitter account. 

## Installation

To use different Twitter account change the twitter4j.properties file in resources package. 
To build the project simply clone the repository, cd to the root directory and use the following maven commands to build a jar:

- mvn compile
- mvn package

## Tests
