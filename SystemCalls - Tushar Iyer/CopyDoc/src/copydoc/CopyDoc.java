/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package copydoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * @date 3rd Feb, 2016
 * @author tushariyer
 * 
 * @assignment CS 451 - Assignment 1.
 */
public class CopyDoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Scanner will be used to take in the strings.s
        Scanner scan = new Scanner(System.in);

        /*  Directory on my mac: /Users/tushariyer/Documents/Uni/Uni Files/Spring 2016/CS 451/Homework 1/
         Add whatever file you want. Don't forget to use the file extention*/
        System.out.println("Enter the directory of the file location:");
        String dir = scan.nextLine();

        /*  Base directory I used for the output location: /Users/tushariyer/Documents/Uni/Uni Files/Spring 2016/CS 451/Homework 1/
         Don't forget to add your own filename, and the file extention must be the same as the file imported. */
        System.out.println("\nEnter the directory of the location you want to copy your file to:");
        String finalDir = scan.nextLine();

        //Send the directories to copyFile so that the file can be copied
        copyFile(dir, finalDir);

        //close out the scanner.
        scan.close();
    }

    /**
     * This method takes in two strings containing file directories. It then copies the file specified in the first
     * string to the location in the second string using the indicated filename. 
     * 
     * @param in is the string containing the directory of the file to import
     * @param out is the string containing the directory to copy to as well as
     * the filename to use for the copied file
     */
    private static void copyFile(String in, String out) {

        //This is in a try catch block for the moment. I thought it would be a good idea.
        try {
            File input = new File(in);
            File copiedFile = new File(out);

            FileInputStream streamIn;
            streamIn = new FileInputStream(input);
            FileOutputStream streamOut;
            streamOut = new FileOutputStream(copiedFile);

            byte[] buffer = new byte[1024];

            int length;

            /*copying the contents from input stream to
             * output stream using read and write methods
             */
            while ((length = streamIn.read(buffer)) > 0) {
                streamOut.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            streamIn.close();
            streamOut.close();

            //Print success message
            System.out.println("File copied successfully!!");
            
            //Goodbye
            System.exit(0);

        } catch (IOException worstCase) {
            System.out.println("Copy didn't work! Please check that you typed everything in correctly.");
            System.exit(1);
        }
    }
}