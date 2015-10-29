package pco.melody;

/**
 * Melody permite armazenar e manipular sequencias de notas, alem de ter associado um
 * titulo e autor. Para armazenar as notas internamente devera apenas usar um vector ("array")
 * do objecto Note. Nao foram utilizados metodos da classe java.util.Arrays.
 *
 * @author Ana Espinheira, 45810
 * @author Francisco Pires, 44314
 * @version %I%, %G%
 * @since 1.0
 */

public class Melody {

    /**
     * Atributos da Melodia
     */

    /**
     * Sequencia de notas do tipo Note;
     */
    private Note[] SeqNotes;
    /**
     * Numero de notas;
     */
    private int n;
    /**
     * titulo da melodia
     */
    private String title;
    /**
     * autor da melodia
     */
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
     * @return string titulo da melodia
     */

    public String getTitle() {
        return this.title;
    }

    /**
     * Define o titulo da melodia
     *
     * @param title novo titulo da melodia
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna o autor da melodia
     *
     * @return string autor da melodia
     */

    public String getAuthor() {
        return this.author;
    }

    /**
     * Define o autor da melodia
     *
     * @param author  novo autor da melodia
     */

    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Retorna o numero de notas da melodia
     *
     * @return numero de notas em int.
     */

    public int notes() {
        return this.n;
    }

    /**
     * Retorna uma nota da melodia, dado um index
     *
     * @param index index para retornar
     * @return o index do array que contem a sequencia de notas
     */
    public Note get(int index) {
        return this.SeqNotes[index];
    }

    /**
     * Insire uma nota nova na melodia
     *
     * @param index posicao onde a nota vai ser introduzida
     * @param note nota que vai ser introduzida
     */

    public void set(int index, Note note) {
        this.SeqNotes[index] = note;
    }

    /**
     * Retorna a duracao da melodia
     *
     * @return duracao em double
     */

    public double getDuration() {
        double dur = 0;

        for (int i = 0; i < this.n; i++) {
            dur = dur + this.SeqNotes[i].getDuration();
        }
        return dur;
    }

    /**
     * Reverte as notas do objecto melody
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
     * @param factor valor double para executar o metodo changeTempo da classe Note
     */
    public void changeTempo(double factor) {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].changeTempo(factor));
        }
    }

    /**
     * Aumenta uma octava em todas as notas
     */

    // @requires octaveDown > 0 && octaveUp < 9
    public void octaveDown() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveDown());
        }
    }

    /**
     * Diminui uma octava em todas as notas
     */

    // @requires octaveUp > 0 && octaveUp < 9
    public void octaveUp() {
        for (int i = 0; i < this.n; i++) {
            set(i, this.SeqNotes[i].octaveUp());
        }
    }

    /**
     * Acrescenta uma melodia ao fim de outra.
     * Atencao: cria uma novo SeqNotes, visto que os arrays sao de tamanho fixo.
     *
     * @param m nova melodia (this.n = notes() + m.notes();)
     */
    public void append(Melody m) {

        Note[] tmp = SeqNotes;
        SeqNotes = new Note[notes() + m.notes()];


        for (int i = 0; i < this.n ; i++) {
            SeqNotes[i] = tmp[i];
        }

        this.n = notes() + m.notes();

        for (int i = 0; i < m.notes(); i++) {
            SeqNotes[tmp.length+i] = m.get(i);
        }

    }
}
