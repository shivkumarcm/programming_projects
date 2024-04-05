package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCalculator {

    private static String JSON_RESPONSE_FORMAT = "{\"x\": %d, \"y\": %d, \"op\": \"%s\", \"answer\": %d}";

    public static void main(String[] args) {
        SpringApplication.run(SpringCalculator.class, args);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    public String index() {
        return String.format("Spring Demo working!!!");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return String.format("Hello, %s!", name);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/add")
    public String add(@RequestParam(value = "x", defaultValue = "0") int x,
                      @RequestParam(value = "y", defaultValue = "0") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/add", x + y);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sub")
    public String subtract(@RequestParam(value = "x", defaultValue = "0") int x,
                           @RequestParam(value = "y", defaultValue = "0") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/sub", x - y);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/mul")
    public String multiply(@RequestParam(value = "x", defaultValue = "0") int x,
                           @RequestParam(value = "y", defaultValue = "0") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/mul", x * y);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/div")
    public String divide(@RequestParam(value = "x", defaultValue = "0") int x,
                         @RequestParam(value = "y", defaultValue = "1") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/div", x / y);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/pow")
    public String power(@RequestParam(value = "x", defaultValue = "0") int x,
                        @RequestParam(value = "y", defaultValue = "0") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/pow", (int) Math.pow(x, y));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/sqr")
    public String square(@RequestParam(value = "x", defaultValue = "0") int x,
                         @RequestParam(value = "y", defaultValue = "0") int y) {
        return String.format(JSON_RESPONSE_FORMAT, x, y, "/sqr", x * x);
    }

}
