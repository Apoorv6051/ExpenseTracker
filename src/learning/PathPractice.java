package learning;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PathPractice {

    public static void main(String[] args) {

        // Create a Path object representing expenses.txt
        Path path = Path.of("expenses.txt"); // Sirf ek object/reference banata hai.

        // Print the path
        System.out.println(path);

        // Print only the file name
        System.out.println(path.getFileName());

        /*
         * Files.exists(path) checks whether the file or
         * directory represented by this Path actually exists.
         *
         * It returns:
         * true  -> path exists
         * false -> path does not exist
         */
        System.out.println(Files.exists(path));


        /*
         * Create a new Path object representing a new file.
         *
         * Here "newExpense.txt" is the name of the file
         * that we want to create.
         */
        Path newPath = Path.of("newExpense.txt");

        // Print the new path
        System.out.println(newPath);

        try {

            /*
             * createFile() actually creates the physical file.
             *
             * It throws IOException if there is a problem,
             * so we handle it using try-catch.
             */
            Files.createFile(newPath);

            System.out.println("File created");

        } catch (IOException e) {

            // Handle the file creation error
            System.out.println("File not created");
        }


        /*
         * Create a Path object representing the file
         * where we want to write some data.
         */
        Path writePath = Path.of("newExpense.txt");

        try {

            /*
             * writeString() writes text into the file.
             *
             * By default, existing content is replaced.
             */
            Files.writeString(
                    writePath,
                    "my first experience with it"
            );

            System.out.println("Data written successfully");

        } catch (IOException e) {

            // Handle any error while writing to the file
            System.out.println("Error writing to file: " + e.getMessage());
        }


        /*
         * =========================================================
         * READING FILE LINE-BY-LINE USING readAllLines()
         * =========================================================
         */

        try {

            /*
             * readAllLines() reads every line from the file
             * and stores the lines inside a List<String>.
             */
            List<String> lines = Files.readAllLines(writePath);

            /*
             * Go through each line one by one.
             */
            for (String line : lines) {

                // Print the current line
                System.out.println(line);
            }

        } catch (IOException ex) {

            /*
             * Handle any error while reading the file.
             *
             * We use 'ex' here instead of 'e' because
             * the previous catch block already uses 'e'.
             */
            System.out.println(
                    "Error reading lines: " + ex.getMessage()
            );
        }
    }
}