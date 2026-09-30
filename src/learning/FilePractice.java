package learning;

import java.io.File;
import java.io.IOException;

public class FilePractice {
    public static void main(String[] args){

        // create a file object represent a expenses.txt
        File file = new File("expenses.txt");

        // check whether the file exists
        System.out.println(file.exists());// it will return true/false
        System.out.println(file.getName());//Returns only the file name
        System.out.println(file.getPath());//Returns the path you provided
        System.out.println(file.isFile());//The path points to a file
        System.out.println(file.isDirectory());// The path is NOT a directory

        // Create a File object representing test.txt
        File filee = new File("test.txt");
        try {
            /*
             * createNewFile() actually tries to create
             * the physical file on the disk.
             *
             * It returns:
             * true  -> file was created
             * false -> file already exists
             */
            System.out.println(filee.createNewFile());
        }catch (IOException e) {

            /*
             * IOException handles errors related
             * to creating or accessing the file.
             */

            System.out.println("Error creating file: " + e.getMessage());
        }

        // now we will learn how to delete file
        if (filee.exists()) {

            // delete() returns true if the file was successfully deleted
            System.out.println(filee.delete());

        } else {

            // File doesn't exist
            System.out.println("File does not exist.");
        }
    }
}
