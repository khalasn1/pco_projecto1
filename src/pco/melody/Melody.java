package pco.melody;

// missing append. Test2 works, needs more testing.

public class Melody {

    // Atributos

    private Note[] SeqNotes;
    private int n;
    private String title;
    private String author;

    // Construtor

  public Melody(String title, String author, int n) {

      Note[] SeqNotes = new Note[n];

      for (int i = 0; i <n ; i++) {
          SeqNotes[i] = new Note(0);
      }

      this.n=n;
      this.title=title;
      this.author=author;
      this.SeqNotes=SeqNotes;

  }

    // getters and setters

  public String getTitle() {
      return this.title;
  }

  public void setTitle(String title) {
      this.title=title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author=author;
  }

  public int notes() {
    return this.n;
  }

  public Note get(int index) {
    return this.SeqNotes[index];
  }

  public void set(int index, Note note) {
      this.SeqNotes[index] = note;
  }

  public double getDuration() {
      double dur = 0;

      for (int i = 0; i < this.n; i++) {
          dur = dur + this.SeqNotes[i].getDuration();
      }
      return dur;
  }

  public void reverse() {
      for (int i = 0; i < this.n/2; i++) {
          Note temp = this.SeqNotes[i];
          this.SeqNotes[i]=this.SeqNotes[this.n - i - 1];
          this.SeqNotes[this.n - i -1] = temp;
      }
  }

  public void changeTempo(double factor) {
      for (int i = 0; i < this.n; i++) {
          this.SeqNotes[this.n].changeTempo(factor);
      }
  }

  public void octaveDown() {
      for (int i = 0; i < this.n ; i++) {
          this.SeqNotes[this.n].octaveDown();
      }
  }

  public void octaveUp() {
      for (int i = 0; i <this.n ; i++) {
          this.SeqNotes[this.n].octaveUp();
      }
  }

  public void append(Melody m) {

      Note[] tmp = new Note[this.n + m.notes()];

      for (int i=0; i < this.n-1; i++) {
          tmp[i] = this.get(i);
      }

      for (int i = this.n-1; i < m.notes()-1; i++) {
          tmp[i] = m.get(i);
      }

      Melody novoMelody = new Melody(this.author, this.author, this.n + m.notes());

      for (int i = 0; i < m.notes()-1; i++) {
          novoMelody.set(i, tmp[i]);
      }
  }
}
