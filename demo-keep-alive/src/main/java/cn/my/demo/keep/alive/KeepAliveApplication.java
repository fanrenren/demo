package cn.my.demo.keep.alive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.my.demo"})
public class KeepAliveApplication{

    public static void main(String[] args) {
        SpringApplication.run(KeepAliveApplication.class);
    }
}
