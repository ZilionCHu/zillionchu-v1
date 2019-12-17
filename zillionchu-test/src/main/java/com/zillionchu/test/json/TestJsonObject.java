package com.zillionchu.test.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Auther: ZiLlionChu
 * @Date: 2019/12/13 15:40
 * @Description:
 */
public class TestJsonObject {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper getInstance() {
        return objectMapper;
    }


    public static void main(String[] args) {

        try {
            String s = getInstance().writeValueAsString(getJsonUser());
            System.out.println(s);


        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


    public static JsonUser getJsonUser() {
        JsonUser jsonUser = new JsonUser("Tom", "1001");
        return jsonUser;
    }

    public static <T> T readValue(String json, Class<T> clazz) {
        try {
            return getInstance().readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
