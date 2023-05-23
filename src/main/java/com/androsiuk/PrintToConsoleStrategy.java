package com.androsiuk;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class PrintToConsoleStrategy implements Strategy{
    @Override
    public void writeDataset(List<DatasetEntry> dataset) {
        for (DatasetEntry entry : dataset) {
            System.out.println(entry.toString());
        }
    }
}
