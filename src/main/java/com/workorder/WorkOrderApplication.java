package com.workorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author darmi
 */
@EnableFeignClients
@SpringBootApplication
public class WorkOrderApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkOrderApplication.class, args);
  }

}
