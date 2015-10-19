package pco.melody;

/**
 * Melody permite armazenar e manipular sequencias de notas, alem de ter associado um
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

    /**
     * Atributos da Melodia
     */

    private Note[] SeqNotes;
    private int n;
    private String title;
    private String author;

    /**
     * Constructor. Inicialmente, a melodia devera guardar
     * uma sequencia de n notas, todas correspondentes
     * a um silencio de duracao 0.
     *
     * @param title titulo da melodia
     * @param author titulo do autor
     * @param n numero de notas
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
     * Retorna o titulo da melodia
     *
     * @return title
     */

    public String getTitle() {
        return this.title;
    }

    /**
     * Define o titulo da melodia
     *
     * @param title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor da melodia
     *
     * @return author
     */

    public String getAuthor() {
        return this.author;
    }

    /**
     * Define o autor da melodia
     *
     * @param author
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna o numero de notas da melodia
     *
     * @return n
     */

    public int notes() {
        return this.n;
    }

    /**
     * Retorna uma nota da melodia, dado um index
     *
     * @param index
     * @return Note[index]
     */
    public Note get(int index) {
        return this.SeqNotes[index];
    }

    /**
     * Define uma nota da melodia, dado um index
     *
     * @param index
     * @param note
     */

    public void set(int index, Note note) {
        this.SeqNotes[index] = note;
    }

    /**
     * Retorna a duracao da melodia
     *
     * @return duration
     */

    public double getDuration() {
        double dur = 0;

        for (int i = 0; i < this.n; i++) {
            dur = dur + this.SeqNotes[i].getDuration();
        }
        return dur;
    }

    /**
     * Reverte as notas da melodia
     * Requires valous bewind 1 and 9
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
     * Muda o "tempo" da melodia
     *
     * @param factor
     */
    public void changeTempo(double factor) {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].changeTempo(factor));
        }
    }

    /**
     * Aumenta uma octava em todas as notas
     *
     * @pre i bewind 1 and 9
     *
     */
    public void octaveDown() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveDown());
        }
    }

    /**
     * Diminui uma octava em todas as notas
     *
     * @pre i bewind 1 and 9
     *
     */
    public void octaveUp() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveUp());
        }
    }

    /**
     * Acrescenta uma melodia ao fim de outra.
     * Atencao: cria uma nova melodia, visto que os arrays sao de tamanho fixo
     *
     * @param m nova melodia
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
