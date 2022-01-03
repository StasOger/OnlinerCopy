package com.example.demo.controllers;

import com.example.demo.DemoApplication;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

public class JavaRush {
    public static String[] strings;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        strings = new String[6];
        for (int i = 0; i < 6; i++)
        {
            strings[i] = console.nextLine();
        }

        for (int i = 0; i < strings.length-1; i++) {
            if (strings[i] == strings[i+1]) {
                strings[i] = null;
                strings[i+1] = null;
            }
        }


        //напишите тут ваш код
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + ", ");
        }
    }
}