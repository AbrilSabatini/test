package org.mock;

import org.mock.persistence.entity.Player;
import org.mock.persistence.repository.ImplPlayerRepository;
import org.mock.service.ImplPlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }
}