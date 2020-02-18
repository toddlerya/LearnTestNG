package com.demo;

/**
 * @Author evi1
 * @Create 2020/2/18 12:14
 * This class prints given message on console
 */

public class MessageUtil {
    private String message;

    /**
     * Constructor
     *
     * @param message to be printed
     */
    public MessageUtil(String message) {
        this.message = message;
    }

    /**
     * print the message
     */
    public String printMessage() {
        System.out.println(message);
        return message;
    }

    /**
     * add "Hi!" to the message
     */
    public String salutationMessage() {
        message = "Hi!" + message;
        System.out.println(message);
        return message;
    }

    /**
     * add "Bye!" to the message
     */
    public String exitMessage() {
        message = "Bye!" + message;
        System.out.println(message);
        return message;
    }

    /**
     * print calculate message
     */
    public void printCalculateMessage() {
        System.out.println(message);
        int a = 0;
        int b = 1 / a;
    }
}
