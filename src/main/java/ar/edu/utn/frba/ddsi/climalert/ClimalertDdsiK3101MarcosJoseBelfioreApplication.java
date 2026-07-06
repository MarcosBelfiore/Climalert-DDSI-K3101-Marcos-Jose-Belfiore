package ar.edu.utn.frba.ddsi.climalert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class ClimalertDdsiK3101MarcosJoseBelfioreApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClimalertDdsiK3101MarcosJoseBelfioreApplication.class, args);
  }

}
