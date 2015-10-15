package pco.melody;

// COMPLETE ESTA CLASSE ...

public class Melody {

    private Note[] numberNotes;
    private String title;
    private String author;


  public Melody(String title, String author, int n) {

      Note[] SeqNotes;
      SeqNotes = new Note[n];

      for(int i=0; i<n; i++){
          SeqNotes[i] = new Note(0);
      }

      this.title=title;
      this.author=author;
      this.numberNotes=SeqNotes;

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
    return -1;
  }

  public Note get(int index) {
    return null;
  }

  public void set(int index, Note note) {
    // COMPLETAR
  }

  public double getDuration() {
    return -1;
  }

  public void reverse() {

  }

  public void changeTempo(double factor) {

  }

  public void octaveDown() {

  }

  public void octaveUp() {

  }

  public void append(Melody m) {

  }
}
