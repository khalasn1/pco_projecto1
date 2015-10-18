package pco.melody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;
import java.lang.String;

/**
 * Melody I/O utility class.
 */
public class MelodyIO {


    public static Melody load(File file) throws IOException {


        try {
            String title = ("");
            String author = ("");
            int notes = 0;

            Scanner sc = new Scanner(file);
            sc.useLocale(Locale.ENGLISH);

            // set title (first line)
            if (sc.hasNextLine()) {
                title = sc.nextLine();
            }

            // set author (second line)
            if (sc.hasNextLine()) {
                author = sc.nextLine();
            }

            // set notes (third line)
            if (sc.hasNextLine()) {
                notes = Integer.parseInt(sc.nextLine());
            }

            //iniciate melody
            Melody m = new Melody(title, author, notes);

            // set notes ( remaining lines )
            int i=0;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                line.split(" ");

                m.set(i, );

                i++;

            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new IOException("File not found");
        }

        return null;
    }

    public static void save(Melody melody, File file) throws IOException {
        try {
            PrintStream out = new PrintStream(file);

            String i = melody.getAuthor();


            out.close();
        } catch (FileNotFoundException e) {
            throw new IOException("File not found");
        }
    }

    // DEIXAR COMO ESTÁ
    private MelodyIO() {
    }
}
