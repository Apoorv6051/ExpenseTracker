import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
//
public class fileReadingPractice {
    public static void main(String[] args){

        /*
         * =========================================================
         * PART 1: FileReader — Reading character by character
         * =========================================================
         */

        try (
                FileReader reader = new FileReader("expenses.txt");
        ) {

            int data;

            /*
             * read() returns an int.
             * It returns -1 when the end of the file is reached.
             */
            while ((data = reader.read()) != -1) {

                /*
                 * data is an int, so we type-cast it to char
                 * to print the actual character.
                 */
                System.out.print((char) data);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        /*
         * =========================================================
         * PART 2: BufferedReader — Reading line by line
         * =========================================================
         */

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader("expenses.txt")
                        );
        ) {

            /*
             * This variable will store each complete line
             * read from the file.
             */
            String line;

            /*
             * readLine() reads one complete line.
             *
             * When there are no more lines,
             * readLine() returns null.
             */
            while ((line = reader.readLine()) != null) {

                /*
                 * Print the complete line.
                 */
                System.out.println(line);
            }

        } catch (IOException e) {

            /*
             * Handle file-related errors.
             */
            System.out.println(e.getMessage());
        }
   }

}
