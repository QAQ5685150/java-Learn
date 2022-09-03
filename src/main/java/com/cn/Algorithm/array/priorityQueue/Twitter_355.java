package com.cn.Algorithm.array.priorityQueue;

import java.util.*;

/**
 * @Auther: @小脑斧不可爱
 * @Time: 2022-04-03 19:08
 * @Description: 355. 设计推特
 * @Project_name: java-learn
 */
class Twitter {

    //key-id  value-followerId
    Map<Integer,List<Integer>> subscribe;
    //key-id  value-tweet they send
    Map<Integer, PriorityQueue<Integer>> news;

    public Twitter() {
        subscribe = new HashMap<>();
        news = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        PriorityQueue<Integer> integers = news.get(userId);
        if (integers == null) {
            PriorityQueue<Integer> queue = new PriorityQueue<>( (a,b) -> b - a);
            queue.add(tweetId);
            news.put(userId,queue);
        }else {
            integers.add(tweetId);
            news.put(userId,integers);
        }

    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        List<Integer> list = subscribe.get(userId);
        for (Integer id : list) {
            PriorityQueue<Integer> queue = this.news.get(id);
            Iterator<Integer> iterator = queue.iterator();
            for (int i = 0; i < 10 && iterator.hasNext(); i++) {
                news.add(iterator.next());
            }
        }
        return news;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> list = subscribe.get(followeeId);
        list.add(followeeId);
        subscribe.put(followerId,list);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = subscribe.get(followeeId);
        list.remove(followeeId);
        subscribe.put(followerId,list);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
