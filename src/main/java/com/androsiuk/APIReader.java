package com.androsiuk;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APIReader {
    private static final CSVFormat CSV_FORMAT = CSVFormat.DEFAULT
            .builder()
            .setHeader("date","sample_location","time1","vocs1_ppm","temp1_f","humidity1","observations1","time2","vocs2_ppm","temp2_f","humidity2","observations2","time3","vocs3_ppm","temp3_f","humidity3","observations3")
            .setSkipHeaderRecord(true)
            .build();


    public static List<DatasetEntry> getDataByUrl(String urlStr, String file) throws IOException {
        writeDataToCsv(urlStr, file);
        List<DatasetEntry> datasetEntries = new ArrayList<>();
        try (Reader reader = new FileReader(file);
             CSVParser csvParser = new CSVParser(reader, CSV_FORMAT)) {
            for (CSVRecord csvRecord : csvParser.getRecords()) {
                DatasetEntry order = new DatasetEntry(csvRecord.get("date"), csvRecord.get("sample_location"),
                        csvRecord.get("time1"), csvRecord.get("vocs1_ppm"), csvRecord.get("temp1_f"),
                        csvRecord.get("humidity1"), csvRecord.get("observations1"),
                        csvRecord.get("time2"), csvRecord.get("vocs2_ppm"), csvRecord.get("temp2_f"),
                        csvRecord.get("humidity2"), csvRecord.get("observations2"),
                        csvRecord.get("time3"), csvRecord.get("vocs3_ppm"), csvRecord.get("temp3_f"),
                        csvRecord.get("humidity3"), csvRecord.get("observations3"));
                datasetEntries.add(order);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datasetEntries;
    }

    public static void writeDataToCsv(String urlStr, String fileStr) throws IOException {
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(fileStr);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }

}
