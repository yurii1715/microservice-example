package com.example.config;

import com.mongodb.MongoClientURI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Objects;

@Configuration
public class MongoConfig {

    private final String mongoURI
            = "mongodb://127.0.0.1:27017/training?gssapiServiceName=mongodb";

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory(Objects.requireNonNull(mongoURI));
    }
}
