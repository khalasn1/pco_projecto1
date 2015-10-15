package pco.melody;

// COMPLETE ESTA CLASSE
public class Note {

    private Acc acc;
    private int octave;
    private Pitch pitch;
    private double duration;

    public Note(double duration) {

        this(duration, Pitch.S, 0, (Acc)null);
    }

    public Note(double duration, Pitch pitch, int octave, Acc acc) {

        this.acc=acc;
        this.pitch=pitch;
        this.octave=octave;
        this.duration=duration;
    }

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

        return this.duration + "" + this.pitch + "" + this.octave + "" + this.acc;
  }

    public Note octaveDown() {

        return new Note(this.duration, this.pitch, this.octave-1, this.acc);
  }

    public Note octaveUp() {

        return new Note(this.duration, this.pitch, this.octave+1, this.acc);
  }

    public Note changeTempo(double factor) {

        return new Note(this.duration*factor, this.pitch, this.octave, this.acc);
  }

}
