package com.example.demo.controllers;

import java.util.Scanner;

    public class Calculator {
        public int sum(int a, int b) {
            return a + b;
        }

        public int del(int c, int d) {
            if (d != 0) {
                return c / d;
            } else {
                return (0);
            }
        }
    }