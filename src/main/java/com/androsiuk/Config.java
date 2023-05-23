package com.androsiuk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {
    public String strategy;
    public String dataset_url;
    public String port;
    public String password;
}
