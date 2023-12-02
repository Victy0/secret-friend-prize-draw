package com.victor.secretfriend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
public class SecretfriendApplication extends WebMvcConfigurationSupport
{

    public static void main(String[] args)
    {
        SpringApplication.run(SecretfriendApplication.class, args);
        System.out.println("\nAPLICAÇÃO FUNCIONANDO!!!");
        System.out.println("\nPARA UTILIZAR LOCALMENTE A RAÍZ DA URL PARA ACESSO É: http://localhost:8080/ \n");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**");
    }
}
