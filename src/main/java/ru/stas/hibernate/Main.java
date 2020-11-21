package ru.stas.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.stas.hibernate.model.House;
import ru.stas.hibernate.model.User;
import ru.stas.hibernate.repository.userrepository.UserRepoImpl;
import ru.stas.hibernate.repository.userrepository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
public class Main
{
    public static void main( String[] args )
    {
        SpringApplication.run( Main.class, args );



    }
}
