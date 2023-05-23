package com.androsiuk;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class ConfigReader {
    public static final String CONFIG_YAML = "./src/main/resources/config.yaml";
    public static Config readConfig(){
        Config config = new Config();
        try {
            InputStream inputStream = new FileInputStream(new File(CONFIG_YAML));
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            config = new Config(data.get("strategy").toString(), data.get("dataset_url").toString(),
                    data.get("redis_port").toString(), data.get("redis_password").toString());
        } catch (IOException e){
            e.printStackTrace();
        }
        return config;
    }
}
