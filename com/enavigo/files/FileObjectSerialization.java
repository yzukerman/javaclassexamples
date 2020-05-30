package com.enavigo.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileObjectSerialization {
    public static void main(String[] args) {
        Player justin = new Player("Justin");
        Player justinToo = null;

        Weapon negev = new Weapon("Negev", 0, 15, 20, 150, 30, 15);
        Weapon ppBison = new Weapon("Bison", 3, 5, 15, 5, 1, 10);
        
        justin.buyWeapon(negev);
        justin.buyWeapon(ppBison);

        System.out.println("This is the Justin we will write...");
        System.out.println("-----------------------------------");
        justin.printPlayerStatus();

        Path justinFile = Paths.get("justin.dat");

        try (OutputStream outputStream = Files.newOutputStream(justinFile)) 
        {
            try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream))
            {
                objectOutputStream.writeObject(justin);
                objectOutputStream.flush();
                objectOutputStream.close();
            }
            catch(IOException ioe)
            {
                System.err.println("Error writing object " + ioe.getLocalizedMessage());
            }

        }
        catch(IOException ioe)
        {
            System.err.println("Error creating output stream " + ioe.getLocalizedMessage());
        }

        try (InputStream inputStream = Files.newInputStream(justinFile))
        {
             try(ObjectInputStream objectInputStream = new ObjectInputStream(inputStream))
             {
                 justinToo = (Player)objectInputStream.readObject();
             }   
             catch(ClassNotFoundException classNotFoundException)
             {
                 System.err.println("Cannot find Player class: " + 
                                classNotFoundException.getLocalizedMessage());
             }
        }
        catch(IOException ioe)
        {
            System.err.println("Error creating output stream " + ioe.getLocalizedMessage());
        }
        
        System.out.println("------- Loaded the other Justin --------");

        justinToo.printPlayerStatus();

    }   
}