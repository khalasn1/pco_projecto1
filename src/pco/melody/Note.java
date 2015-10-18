package pco.melody;

/**
 * A Classe Melody permite armazenar e manipular sequencias de notas, alem de ter associado um
 * titulo e autor. Para armazenar as notas internamente devera apenas usar um vector ("array")
 * do objecto Note. Alem disso, nao pode usar metodos da classe java.util.Arrays. Os metodos
 * a seguir descritos deverao ser implementados
 *
 * @author Ana Espinheira, fc45810
 * @author Francisco Pires, fc44314
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

    public Pitch getPitch() {
        return this.pitch;
    }

    public Acc getAccidental() {
        return this.acc;
    }

    public int getOctave() {
        return this.octave;
    }

    public double getDuration() {
        return this.duration;
    }

    public boolean isSilence() {
        return this.pitch == Pitch.S;
    }

    public String toString() {

        return this.duration + " " + this.pitch + " " + this.octave + " " + this.acc;
    }

    public Note octaveDown() {

        return new Note(this.duration, this.pitch, this.octave - 1, this.acc);
    }

    public Note octaveUp() {

        return new Note(this.duration, this.pitch, this.octave + 1, this.acc);
    }

    public Note changeTempo(double factor) {

        return new Note(this.duration * factor, this.pitch, this.octave, this.acc);
    }

}
