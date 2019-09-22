package com.mingyin;

import redis.clients.jedis.Jedis;

public class BasicDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("haha", "xixixi");
        String value = jedis.get("haha");
        System.out.println(value);
    }
}
