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
    //System.out.println(num);
    this.num = num;
  }

  public int points(){
    return POINTS[num % VALUES.length];
  }

  public String toString() {
    //System.out.println("num: " + num);
    //System.out.println(num / VALUES.length + " - " + num % VALUES.length);
    return SUITES[num / VALUES.length] + VALUES[num % VALUES.length];
  }

  public int num() {
    return num;
  }

  
  
}