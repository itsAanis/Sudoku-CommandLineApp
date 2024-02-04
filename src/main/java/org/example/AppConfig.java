package org.example;

import org.example.factory.GridFactory;
import org.example.model.IGrid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public IGrid grid() {
        // Assuming GridFactory is a Spring-managed bean itself,
        // you could inject it here too.
        return GridFactory.createGrid(GridFactory.GridType.Physical);
    }

}
