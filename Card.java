public class Card{

  private int num;
  private int suit;
  private int value;

  private String[] SUITES;
  private String[] VALUES;
  private int[] POINTS;

  public void SUITES(String[] ooga){
    SUITES = ooga;
  }

  public void VALUES(String[] ooga) {
    VALUES = ooga;
  }

  public void POINTS(int[] ooga) {
    POINTS = ooga;
  }

  public Card() {

  }

  public Card(int num) {

    this.num = num;
  }

  public Card(int value, int suit){
    this.value = value;
    this.suit = suit;
  }

  public void set(int num) {
    this.num = num;
  }

  public int points(){
    return POINTS[num % VALUES.length];
  }

  public String toString() {
    return SUITES[suit] + VALUES[value];
  }

  public int num() {
    return num;
  }

  
  
}