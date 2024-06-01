package com.example.taidev198.javaeehome.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpUtils {

    private String value;

    public HttpUtils(String value) {
        this.value = value;
    }

    //convert string to class
    public <T> T toModel(Class<T> tClass) {
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    //convert request to string
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

    public String getValue(){
        return value;
    }

    public static Long[] stringRequestToArray(String stringRequest)   {
        String ex = "{'ids':[\"1\"],[\"2\"]}";
        String[] strings = stringRequest.split("[;,]+");
        List<Long> stringList = new ArrayList<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            long id = 0L;
            int next = 1;
            for (char aChar : chars) {
                if (aChar >= '0' && aChar <= '9') {
                    id = id * next + aChar - '0';
                    next *= 10;
                }
            }
            stringList.add(id);
        }
        return stringList.toArray(new Long[0]);
    }

}
