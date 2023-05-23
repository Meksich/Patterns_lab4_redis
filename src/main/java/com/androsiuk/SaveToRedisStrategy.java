package com.androsiuk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveToRedisStrategy implements Strategy{
    public Jedis jedis;
    @Override
    public void writeDataset(List<DatasetEntry> dataset) {
        int i = 0;
        for (DatasetEntry entry : dataset) {
            Map<String, String> hash = entry.toHashMap();;
            jedis.hset("Entry-No." + (i++), hash);
        }
    }
}
