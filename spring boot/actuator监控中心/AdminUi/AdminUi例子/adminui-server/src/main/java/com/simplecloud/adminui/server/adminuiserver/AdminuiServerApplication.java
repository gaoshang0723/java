package com.simplecloud.adminui.server.adminuiserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminuiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminuiServerApplication.class, args);
    }
}
