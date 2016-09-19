package daggerok;

import daggerok.config.WsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WsConfig.class)
public class WsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);
    }
}
