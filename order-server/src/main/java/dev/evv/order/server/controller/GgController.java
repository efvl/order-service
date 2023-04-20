package dev.evv.order.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping(path="/gg")
public class GgController {

    @Autowired
    private Environment environment;

    @GetMapping("/info")
    public ResponseEntity<String> getName(){

        String serverPort = environment.getProperty("local.server.port");
        String info = "first service (port:"+ serverPort +") time: " +  LocalTime.now();
        return ResponseEntity.ok(info);
    }

}
