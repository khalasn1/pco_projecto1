package pco.melody;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;
import java.lang.String;

/**
 * Melody I/O permite carregar e gravar uma melodia de/para um ficheiro, usando a classe Note e Melody.
 * Tal como indicado no enunciado, foi utilizado os objectos Scanner (para o load) e o PrintScanner (para o save).
 * Os ficheiros devem ser gravados/carregados com o  formato visto nos ficheiros na directoria exemples ou no enunciado.
 *
 * @author Ana Espinheira, 45810
 * @author Francisco Pires, 44314
 * @version %I%, %G%
 * @since 1.0
 */

public class MelodyIO {

    /**
     * metodos nesta classe: load e save
     */


    /**
     * Carrega um ficheiro (file), retornando um objecto melodia.
     *
     * @param file ficheiro para leitura
     * @return m objecto do tipo Melody.
     * @throws IOException Se o ficheiro nao for encontrado/nao permitido aceder.
     */

    public static Melody load(File file) throws IOException {

        try {
            Scanner sc = new Scanner(file);
            sc.useLocale(Locale.ENGLISH);
            String title = ("");
            String author = ("");
            int notes = 0;
            Note temp;

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

            //iniciate melody (with the values already read)
            Melody m = new Melody(title, author, notes);

            // set notes (remaining lines)
            int i = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lines = line.split("\\s+");

                if (lines.length == 2) {
                    temp = new Note(Double.parseDouble(lines[0]));
                } else {
                    temp = new Note(Double.parseDouble(lines[0]), Pitch.valueOf(lines[1]),
                            Integer.parseInt(lines[2]), Acc.valueOf(lines[3]));
                }
                m.set(i, temp);
                i++;
            }
            sc.close();
            return m;

        } catch (IOException e) {
            throw new IOException("File not found");
        }
    }

    /**
     * Salva um objecto melody para um ficheiro (file.txt)
     *
     * @param melody objecto melody que queremos salvar
     * @param file ficheiro onde vai ser guardado
     * @throws IOException Se o ficheiro nao for encontrado/nao permitido aceder.
     */

    public static void save(Melody melody, File file) throws IOException {

        try {

            PrintStream out = new PrintStream(file);
            Note temp;

            out.println(melody.getTitle());
            out.println(melody.getAuthor());
            out.println(melody.notes());

            for (int i = 0; i < melody.notes(); i++) {
                temp = melody.get(i);

                if (temp.getOctave() != 0 || temp.getAccidental() != null) {
                    out.print(temp.getDuration() + " ");
                    out.print(temp.getPitch() + " ");
                    out.print(temp.getOctave() + " ");
                    out.print(temp.getAccidental() + "\n");
                } else {
                    out.print(temp.getDuration() + " ");
                    out.print(temp.getPitch() + "\n");
                }

            }
            out.close();
        } catch (IOException e) {
            throw new IOException("File not found");
        }
    }

    private MelodyIO() {
    }
}
