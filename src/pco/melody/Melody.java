package pco.melody;

// missing append. Test2 works, needs more testing.
// cenas

public class Melody {

    private Note[] SeqNotes;
    private int n;
    private String title;
    private String author;


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
          dur = dur + this.SeqNotes[this.n].getDuration();
      }

      return dur;
  }

  public void reverse() {
      for (int i = 0; i <this.n/2; i++) {
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
      for (int i = 0; i <this.n ; i++) {
          this.SeqNotes[this.n].octaveDown();
      }
  }

  public void octaveUp() {
      for (int i = 0; i <this.n ; i++) {
          this.SeqNotes[this.n].octaveUp();
      }
  }

  public void append(Melody m) {
    //TO COMPLETE
  }
}
