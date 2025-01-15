package com.aluraLatam.literaluraChalllenge;

import com.aluraLatam.literaluraChalllenge.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class LiteraluraChalllengeApplication implements CommandLineRunner {
	@Autowired
	private final Principal principal;
	public LiteraluraChalllengeApplication(Principal principal){
        this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraChalllengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.mostrarMenu();
	}
}
