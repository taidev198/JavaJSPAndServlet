package com.example.taidev198.javaeehome.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtils {

    private String value;

    public HttpUtils(String value) {
        this.value = value;
    }

    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static HttpUtils of (BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try {
            String line ;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return new HttpUtils(sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
