package com.androsiuk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatasetEntry {
    private String date;
    private String sample_location;
    private String time1;
    private String vocs1_ppm;
    private String temp1_f;
    private String humidity1;
    private String observations1;
    private String time2;
    private String vocs2_ppm;
    private String temp2_f;
    private String humidity2;
    private String observations2;
    private String time3;
    private String vocs3_ppm;
    private String temp3_f;
    private String humidity3;
    private String observations3;

    public Map<String, String> toHashMap(){
        Map<String, String> hash = new HashMap<>();;
        hash.put("date", date);
        hash.put("sample_location", sample_location);
        hash.put("time1", time1);
        hash.put("vocs1_ppm", vocs1_ppm);
        hash.put("temp1_f", temp1_f);
        hash.put("humidity1", humidity1);
        hash.put("observations1", observations1);
        hash.put("time2", time2);
        hash.put("vocs2_ppm", vocs2_ppm);
        hash.put("temp2_f", temp2_f);
        hash.put("humidity2", humidity2);
        hash.put("observations2", observations2);
        hash.put("time3", time3);
        hash.put("vocs3_ppm", vocs3_ppm);
        hash.put("temp3_f", temp2_f);
        hash.put("humidity3", humidity3);
        hash.put("observations3", observations3);
        return hash;
    }

    @Override
    public String toString(){
        return "{" + "date: " + date + ", sample_location: " + sample_location + ", time1: " + time1 + ", vocs1_ppm: " +
                vocs1_ppm + ", temp1_f: " + temp1_f + ", humidity1: " + humidity1 + ", observations1: " + observations1 +
                ", time2: " + time2 + ", vocs2_ppm: " + vocs2_ppm + ", temp2_f: " + temp2_f + ", humidity2:" + humidity2 +
                ", observations2: " + observations2 + ", time3: " + time3 + ", vocs3_ppm: " + vocs3_ppm + ",temp3_f: " +
                temp2_f + ", humidity3: " + humidity3 + ", observations3: " + observations3 + "}";
    }


}
