package com.example;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableProcessApplication
@RestController
public class SbDemoApplication {

//    @Autowired
//    public ReservationDao reservationDao;

    private final static SbDemoApplication instance = new SbDemoApplication();

    public static void main(String[] args) {
        SpringApplication.run(SbDemoApplication.class, args);
    }

//    @RequestMapping("/")
//    @ResponseBody
//    String home() {
//        return "Hello World!";
//    }

    public static SbDemoApplication getInstance()
    {
    	return instance;
    }
}
