package com.acme.dbo;

import com.acme.dbo.controller.ClientsController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Application {
    public static void main(String... args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.acme.dbo")) {
            final ClientsController controller = context.getBean(ClientsController.class);

            System.out.println("Account operations: create, get, get-by-id");
            Scanner console = new Scanner(System.in);

            while (true) {
                switch (console.next()) {
                    case "create":
                        controller.create(console.next(), console.next());
                        break;
                    case "get-by-id":
                        System.out.println(controller.findById(console.next()));
                        break;
                    case "get":
                        System.out.println(controller.findAll());
                        break;
                    default:
                        System.exit(0);
                }
            }
        }
    }
}
