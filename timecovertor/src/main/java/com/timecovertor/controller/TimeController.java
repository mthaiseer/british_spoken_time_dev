package com.timecovertor.controller;

import com.timecovertor.service.TimeWordService;
import com.timecovertor.service.TimeWordServiceImpl;

import java.util.Scanner;


/**
 * -----------------------------------------------------------------------------
 * File        : TimeController.java
 * Author      : Mohamed Thaiseer
 * Date        : July 6, 2025
 * -----------------------------------------------------------------------------
 */
public class TimeController {

    private final TimeWordService service = new TimeWordServiceImpl();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time in HH:mm format: ");
        String input = scanner.nextLine();
        try {
            String result = service.toSpokenTime(input);
            System.out.println("Spoken time: " + result);
        } catch (Exception e) {
            System.out.println("Invalid input format. Please use HH:mm (e.g., 14:30).");
        }
    }
}
