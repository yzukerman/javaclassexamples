package com.enavigo.files;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileWriteExample {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("SuperWord: Where you type your story.");
        System.out.println("-------------------------------------");
        System.out.println("Filename (.txt)");
        String line = scanner.next();
        line = line + ".txt";
        Path outputFilePath = Paths.get(line);
        

        try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath))
        {
            System.out.println("To quit enter /exit");
            System.out.println("------ File Starts Here ------");

            do
            {
                line = scanner.nextLine();
                if(line.equals("/exit"))
                {
                    break;
                }
                writer.write(line);
                writer.newLine();
                
            } while(scanner.hasNext());
            writer.close();
        }
        catch (IOException ioe)
        {
            System.err.println("Error! " + ioe.getLocalizedMessage());
        }
        finally
        {
            scanner.close();
            
        }
        

        
    }
    
}