package com.androsiuk;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Context context;
    public static void main(String[] args) {
        Config config = ConfigReader.readConfig();
        try(JedisPool pool = new JedisPool("localhost", Integer.parseInt(config.port));
            Jedis jedis = pool.getResource()) {
            jedis.auth(config.password);
            List<DatasetEntry> data = APIReader.getDataByUrl(config.dataset_url, "src/main/resources/dsyc-npkh.csv");
            if(config.strategy.equals("redis")){
                context = new Context(new SaveToRedisStrategy(jedis));
            } else if (config.strategy.equals("console")) {
                context = new Context(new PrintToConsoleStrategy());
            }
            context.writeData(data);

            //System.out.println(jedis.hgetAll("user-session:123"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}