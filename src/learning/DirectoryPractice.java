package learning;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DirectoryPractice {

    public static void main(String[] args) {

        // Create a File object representing a folder
        File folder = new File("dataFile/expenses/2026");

        // Create the complete directory structure
        // mkdir() can create only ONE directory at a time.
        // mkdirs() can create the complete directory structure.
        System.out.println(folder.mkdirs());

        /*
         * list() returns the names of all files and directories
         * present inside the folder.
         */

        // Create a file inside the 2026 directory
        File expenseFile = new File(folder, "expense.txt");

        try {

            /*
             * createNewFile() creates the actual file
             * inside the 2026 folder.
             */
            System.out.println(expenseFile.createNewFile());

        } catch (IOException e) {

            // Handle any file creation error
            System.out.println("Error: " + e.getMessage());
        }


        //
        // Old list() practice — keeping it commented for reference
        //
        // String[] names = folder.list();
        //
        // // Print each name
        // if (names != null) {
        //     for (String name : names) {
        //         System.out.println(name);
        //     }
        // }


        /*
         * =========================================================
         * listFiles()
         * =========================================================
         *
         * listFiles() returns an array of File objects
         * present inside the folder.
         *
         * It can return null if the folder doesn't exist
         * or cannot be accessed.
         */
        File[] files = folder.listFiles();

        if (files != null) {

            // Go through every File object
            for (File file : files) {

                // Print the name of the file or directory
                System.out.println(file.getName());

                // Check whether it is a file
                System.out.println(file.isFile());

                // Check whether it is a directory
                System.out.println(file.isDirectory());
            }
        }


        /*
         * =========================================================
         * APPEND MODE
         * =========================================================
         *
         * APPEND means:
         * Add new data at the end of the existing file
         * without deleting the old data.
         */

        /*
         * Convert the File object into a Path object.
         *
         * expenseFile represents:
         * dataFile/expenses/2026/expense.txt
         */
        Path writePath = expenseFile.toPath();

        try {

            /*
             * Write new data at the end of the file.
             *
             * StandardOpenOption.APPEND tells Java:
             * "Do not replace the existing content.
             *  Add the new content after it."
             */
            Files.writeString(
                    writePath,
                    "\nmy second expense",
                    StandardOpenOption.APPEND
            );

            System.out.println("Data appended successfully");

        } catch (IOException e) {

            // Handle any error while appending data
            System.out.println("Error appending data: " + e.getMessage());
        }


        /*
         * =========================================================
         * READING THE COMPLETE FILE USING readString()
         * =========================================================
         */

        try {

            /*
             * readString() reads the complete content
             * of the file and returns it as a String.
             */
            String data = Files.readString(writePath);

            // Print the complete content of the file
            System.out.println(data);

        } catch (IOException e) {

            // Handle any error while reading the file
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}