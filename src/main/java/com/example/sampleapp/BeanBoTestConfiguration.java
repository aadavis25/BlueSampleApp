package com.example.sampleapp;

import com.example.sampleapp.dao.BookDao;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class BeanBoTestConfiguration {

    @Bean
    @Primary
    public BookDao productService() {
        return Mockito.mock(BookDao.class);
    }
}
