package com.example.practise;

import com.example.practise.Main;  // твой класс с меню
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages = "com.example.practise")
@EnableAspectJAutoProxy
public class PractiseApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PractiseApplication.class);
        app.setBannerMode(Banner.Mode.OFF);  // убираем стандартный баннер
        ApplicationContext ctx = app.run(args);

        // Получаем бин консольного меню и запускаем его
        Main console = ctx.getBean(Main.class);
        console.run();
    }
}
