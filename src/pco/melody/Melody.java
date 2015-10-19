package pco.melody;

/**
 * A Classe Melody permite armazenar e manipular sequencias de notas, alem de ter associado um
 * titulo e autor. Para armazenar as notas internamente devera apenas usar um vector ("array")
 * do objecto Note. Alem disso, nao pode usar metodos da classe java.util.Arrays. Os metodos
 * a seguir descritos deverao ser implementados
 *
 * @author Ana Espinheira
 * @author Francisco Pires
 * @version %I%, %G%
 * @since 1.0
 */

public class Melody {

    // Atributos

    private Note[] SeqNotes;
    private int n;
    private String title;
    private String author;

    /**
     *
     * @param title
     * @param author
     * @param n
     */

    public Melody(String title, String author, int n) {

        Note[] SeqNotes = new Note[n];

        for (int i = 0; i < n; i++) {
            SeqNotes[i] = new Note(0);
        }

        this.n = n;
        this.title = title;
        this.author = author;
        this.SeqNotes = SeqNotes;

    }

    // getters and setters

    /**
     *
     * @return
     */

    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */

    public String getAuthor() {
        return this.author;
    }

    /**
     *
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     */

    public int notes() {
        return this.n;
    }

    /**
     *
     * @param index
     * @return
     */
    public Note get(int index) {
        return this.SeqNotes[index];
    }

    /**
     *
     * @param index
     * @param note
     */

    public void set(int index, Note note) {
        this.SeqNotes[index] = note;
    }

    /**
     *
     * @return
     */

    public double getDuration() {
        double dur = 0;

        for (int i = 0; i < this.n; i++) {
            dur = dur + this.SeqNotes[i].getDuration();
        }
        return dur;
    }

    /**
     *
     */
    public void reverse() {
        for (int i = 0; i < this.n / 2; i++) {
            Note temp = this.SeqNotes[i];
            this.SeqNotes[i] = this.SeqNotes[this.n - i - 1];
            this.SeqNotes[this.n - i - 1] = temp;
        }
    }

    /**
     *
     * @param factor
     */
    public void changeTempo(double factor) {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].changeTempo(factor));
        }
    }

    /**
     *
     */
    public void octaveDown() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveDown());
        }
    }

    /**
     *
     */
    public void octaveUp() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveUp());
        }
    }

    /**
     *
     * @param m
     */
    public void append(Melody m) {

        Note[] tmp = new Note[this.n + m.notes()];

        for (int i = 0; i < this.n; i++) {
            tmp[i] = this.get(i);
        }

        for (int i = this.n - 1; i < m.notes(); i++) {
            tmp[i] = m.get(i);
        }

        Melody novaMelody = new Melody(this.author, this.author, this.n + m.notes());

        for (int i = 0; i < m.notes() - 1; i++) {
            novaMelody.set(i, tmp[i]);
        }
    }
}
