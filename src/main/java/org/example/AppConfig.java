package org.example;

import org.example.factory.GridFactory;
import org.example.model.IGrid;
import org.example.service.IService;
import org.example.service.SudokuService;
import org.example.solver.ISolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Configuration
public class AppConfig {

    @Bean
    public GridFactory gridFactory() {
        return new GridFactory();
    }
    @Bean
    public IService service(GridFactory gridFactory, ISolver solver) {
        return new SudokuService(gridFactory, solver);
    }




}
