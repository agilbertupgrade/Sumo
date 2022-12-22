package org.stapledon.sumo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

@Configuration
public class ParserConfig {

    @Bean
    public String pclBackupJson()  {
        try {
            var jsonPath = new ClassPathResource("data/PCL.json").getFile();
            return FileUtils.readFileToString(jsonPath);
        } catch (IOException e) {
            throw new NoBackupException(e);
        }
    }
    @Bean
    public Gson gson() {
       var gsonBuilder = new GsonBuilder();
       gsonBuilder.setLenient();
       gsonBuilder.setPrettyPrinting();
       return gsonBuilder.create();
    }

    @Bean
    public CSVPrinter destinationFile() {
        try {
            Writer writer = new FileWriter("./schedules.csv");
            return new CSVPrinter(writer, CSVFormat.EXCEL);
        } catch (IOException e) {
            throw new NoBackupException(e);
        }
    }

}
