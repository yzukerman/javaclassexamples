package com.enavigo.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The purpose of this class is to demonstrate how to read a file and write a file.
 * We will generate some 
 */

public class FileReadExample
{
    public static void main(String[] args) {
        Path toast = Paths.get("toast.txt");
        try (BufferedReader reader = Files.newBufferedReader(toast)) 
        {
            String line = null;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getLocalizedMessage());
        }
    }
}
