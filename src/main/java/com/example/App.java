package com.example;

import java.util.logging.Logger;
import java.util.logging.Level;

public class App {

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();

        Logger logger = Logger.getLogger(App.class.getName());
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.valueOf(calc.calculate(10, 5, "add")));
        }

        UserService service = new UserService();
        service.findUser("admin");
    }
}