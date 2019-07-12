package com.travala.socketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("file:/home/ubuntu/env/socket_server.properties")
})
public class SocketServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketServerApplication.class, args);
    }

}
