package cn.my.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"cn.my.demo"})
public class DemoPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoPoolApplication.class);

//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PoolAutoConfiguration.class);
//
//        System.out.println(context.getBean("initPool"));
//        context.close();
    }
}
