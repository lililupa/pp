package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;

public class JSONExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = JSONExample.class.getResourceAsStream("/user.json")) {
            User user = objectMapper.readValue(inputStream, User.class);
            System.out.println("Имя: " + user.getName());
            System.out.println("Возраст: " + user.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}