package pco.melody;

/**
 * Note permite armazenar e manipular uma nota, baseado na duracao,
 * tipo, "acidente" e "oitava". Se a nota representar silencio, ignoramos
 * o "acidente" e a "oitava"
 *
 * @author Ana Espinheira, 45810
 * @author Francisco Pires, 44314
 * @version %I%, %G%
 * @since 1.0
 */

public class Note {


    private Acc acc;
    private int octave;
    private Pitch pitch;
    private double duration;

    /**
     * Constructor para silencio (Pitch.S) com a
     * duracao especificada. Para facilitar a
     * programacao no Melody.
     *
     * @param duration Duracao da nota.
     */

    public Note(double duration) {

        this(duration, Pitch.S, 0, null);
    }

    /**
     * Constructor. Inicialmente, a melodia devera codificar
     * uma sequencia de n notas, todas correspondentes
     * a um silencio de duracao 0.
     *
     * @param duration Duracao da nota.
     * @param pitch    Enumerado da classe Pitch.
     * @param octave   Oitava da nota.
     * @param acc      Enumerado da classe Acidente.
     */

    public Note(double duration, Pitch pitch, int octave, Acc acc) {

        this.acc = acc;
        this.pitch = pitch;
        this.octave = octave;
        this.duration = duration;
    }

    // getters and setters

    /**
     *
     * @return
     */
    public Pitch getPitch() {
        return this.pitch;
    }

    /**
     *
     * @return
     */
    public Acc getAccidental() {
        return this.acc;
    }

    /**
     *
     * @return
     */
    public int getOctave() {
        return this.octave;
    }

    /**
     *
     * @return
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     *
     * @return
     */
    public boolean isSilence() {
        return this.pitch == Pitch.S;
    }

    /**
     *
     * @return
     */
    public String toString() {

        return this.duration + " " + this.pitch + " " + this.octave + " " + this.acc;
    }

    /**
     *
     * @return
     */
    public Note octaveDown() {
        return new Note(this.duration, this.pitch, this.octave-1, this.acc);
    }

    /**
     *
     * @return
     */
    public Note octaveUp() {
        return new Note(this.duration, this.pitch, this.octave+1, this.acc);
    }

    /**
     *
     * @param factor
     * @return
     */
    public Note changeTempo(double factor) {

        return new Note(this.duration * factor, this.pitch, this.octave, this.acc);
    }

}
