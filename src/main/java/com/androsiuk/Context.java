package com.androsiuk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Context {
    public Strategy strategy;

    public void writeData(List<DatasetEntry> dataset){
        strategy.writeDataset(dataset);
    }
}
