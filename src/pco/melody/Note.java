package pco.melody;

/**
 * Note permite armazenar e manipular uma nota, baseado na duracao,
 * tipo, "acidente" e "oitava". Se a nota representar silencio, ignoramos
 * o "acidente" e a "oitava". Foi "previsto" dois construtores nesta classe
 * como vai ser explicado mais a frente.
 *
 * @author Ana Espinheira, 45810
 * @author Francisco Pires, 44314
 * @version %I%, %G%
 * @since 1.0
 */

public class Note {


    /**
     * Atributos da classe Note.
     */
    /**
     * Acidente do tipo Acc
     */
    private Acc acc;
    /**
     * Oitava do tipo int
     */
    private int octave;
    /**
     * tipo de nota do tipo Pitch
     */
    private Pitch pitch;
    /**
     * duracao da nota
     */
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
     * Retorna o Pitch de uma nota, que e um objecto da classe Pitch
     *
     * @return atributo pitch
     */
    public Pitch getPitch() {
        return this.pitch;
    }

    /**
     * Retorna o Acidente de uma nota, que e um objecto classe Acc
     *
     * @return atributo acc
     */
    public Acc getAccidental() {
        return this.acc;
    }

    /**
     * Retorna a "oitava" de uma nota, em int
     *
     * @return atributo octave
     */
    public int getOctave() {
        return this.octave;
    }

    /**
     * Retorna a duracao de uma nota, em double
     *
     * @return atributo duration
     */
    public double getDuration() {
        return this.duration;
    }

    /**
     * Booleano para verificar se a nota e silenciosa
     *
     * @return boolean true if pitch == Pitch.S
     */
    public boolean isSilence() {
        return this.pitch == Pitch.S;
    }

    /**
     * Representacao textual da nota, de acordo com a seccao 5 do enunciado
     *
     * @return string
     */
    public String toString() {

        if (this.pitch == Pitch.S) {
            return this.duration + " " + this.pitch;
        }
        else {
            return this.duration + " " + this.pitch + " " + this.octave + " " + this.acc;
        }
    }

    /**
     * Cria uma nova nota, uma octava mais baixa
     *
     * @return novo objecto Note
     */
    public Note octaveDown() {
        return new Note(this.duration, this.pitch, this.octave-1, this.acc);
    }

    /**
     * Cria uma nova nota, uma octava mais alta
     *
     * @return novo objecto Note
     */
    public Note octaveUp() {
        return new Note(this.duration, this.pitch, this.octave+1, this.acc);
    }

    /**
     * Cria uma nova nota, com um "tempo" diferente
     *
     * @param factor valor double para multiplicar na duration
     * @return novo objecto Note
     */
    public Note changeTempo(double factor) {

        return new Note(this.duration * factor, this.pitch, this.octave, this.acc);
    }

}
