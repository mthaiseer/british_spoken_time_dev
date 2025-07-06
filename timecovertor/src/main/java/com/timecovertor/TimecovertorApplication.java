package com.timecovertor;

import com.timecovertor.controller.TimeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * -----------------------------------------------------------------------------
 * File        : TimecovertorApplication.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
@SpringBootApplication
public class TimecovertorApplication {

	public static void main(String[] args) {
		new TimeController().start();
	}

}
