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
            Note temp;
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

            // set number of notes (third line)
            if (sc.hasNextLine()) {
                notes = Integer.parseInt(sc.nextLine());
            }

            //iniciate melody (with the values already read
            Melody m = new Melody(title, author, notes);

            // set notes ( remaining lines )
            int i = 0;
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                String[] lines= line.split("\\s");

                if (lines.length == 2) {
                    temp = new Note(Double.parseDouble(lines[0]));
                }
                else {
                    temp = new Note(Double.parseDouble(lines[0]), Pitch.valueOf(lines[1]), Integer.parseInt(lines[2]), Acc.valueOf(lines[3]));
                }

                m.set(i, temp);

                i++;
            }
            sc.close();
            return m;

        } catch (FileNotFoundException e) {
            throw new IOException("File not found");
        }
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
