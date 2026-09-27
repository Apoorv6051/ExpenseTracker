import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandlingPractice {

    public static void main(String[] args) {

        /*
         * try-with-resources is being used here.
         *
         * We create the BufferedWriter inside the try(...)
         * parentheses.
         *
         * Because BufferedWriter implements AutoCloseable,
         * Java will automatically close the writer when
         * the try block finishes.
         *
         * Therefore, we DON'T need to write:
         *
         * writer.close();
         */
        try (
                /*
                 * FileWriter connects our Java program
                 * to the "expenses.txt" file.
                 *
                 * BufferedWriter wraps the FileWriter
                 * and provides efficient writing operations.
                 */
                BufferedWriter writer =
                        new BufferedWriter(
                                new FileWriter("expenses.txt")
                        )
        ) {

            /*
             * write() is used to write text into the file.
             *
             * This writes "first text" into expenses.txt.
             */
            writer.write("first text");

            /*
             * newLine() moves the writing position
             * to the next line.
             *
             * Without this, the next text would be written
             * immediately after "first text".
             */
            writer.newLine();

            /*
             * Write the second text.
             *
             * Because we used newLine() before this,
             * "second text" will appear on the next line.
             */
            writer.write("second text");

            /*
             * We do NOT call writer.close() here.
             *
             * try-with-resources will automatically close
             * the BufferedWriter when this try block ends.
             */

        } catch (IOException e) {

            /*
             * IOException handles errors related to
             * file input/output operations.
             *
             * For example:
             * - File cannot be created
             * - File cannot be opened
             * - Permission problem
             * - Writing operation fails
             */
            System.out.println(e.getMessage());
        }
    }
}