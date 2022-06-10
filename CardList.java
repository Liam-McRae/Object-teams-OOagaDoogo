import java.util.ArrayList;
import java.util.Random;

public class CardList{  
  private ArrayList<Card> cards = new ArrayList<Card>();

  public CardList() {
    
  }

  public CardList(Card[] set) {
    set(set);
  }

  public void set(ArrayList<Card> ooga) {
    cards = ooga;
  }

  public void set(Card[] ooga) {
    for(Card oogs : ooga) {
      cards.add(oogs);
    }
  }
  
  public ArrayList<Card> cards() {
    return cards;
  }

  public Card[] cardArr() {
    Card[] arr = new Card[cards.size()];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = cards.get(i);
    }
    return arr;
  }
  
  public void add(Card card) {
    cards.add(card);
  }

  public Card get(int index) {
    return cards.get(index);
  }

  public Card take(int index) {
    return cards.remove(index);
  }

  public Card[] draw(int num) {
    System.out.println("draw: " + num);
    Card[] returnArr = new Card[num];
    for(int i = 0; i < num; i++) {
      returnArr[i] = cards.remove(0);
    }
    return returnArr;
  }

  public void shuffle() {
    Random rand = new Random();
    
    for(int i = 0; i < cards.size(); i++) {
      Card temp = cards.get(i);
      int rint = rand.nextInt(cards.size());
      cards.set(i, cards.get(rint));
      cards.set(rint, temp);
    }
  }


  
}