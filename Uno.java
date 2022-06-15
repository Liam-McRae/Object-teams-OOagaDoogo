import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Uno {

  public static void main(String[] args) {
    Player[] players = {new Player("one")};
    play(players);
  }

  public static Player[] play(Player[] playersIn) {

    Scanner scan = new Scanner(System.in);
    Player[] players = playersIn;
    CardList deck = new CardList(unoDeck());
    CardList discard = new CardList();
    CardList[] hands = new CardList[playersIn.length];

    System.out.println("Select ruleset:");
    System.out.println("1) standard");
    System.out.println("2) 5 card deal");
    System.out.println("3) 7s and 0s hand swapping");
    int ruleset = scan.nextInt();
    System.out.println();
    if(ruleset == 1) {
      for(int i = 0; i < hands.length; i++) {
      }
      
    }
    

    
    






    return players;
    
  }

  public static UnoCard[] unoDeck() {

    /* //close to working, but I'm running out of time
    UnoCard[] output = {};
    for(int i = 0; i < 4; i++) {
      System.out.println("new " + i);
      output = add(output, new UnoCard(i * 13));
      for(int j = 0; j < 24; j++) {
        output = add(output, new UnoCard((j % 13) + 1 + i*13));
      }
    }
    
    for(UnoCard card : output) {
      System.out.println(card);
    }
    return output;
    */

    UnoCard[] output = {};
    int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};

    for(int i = 0; i < cards.length; i++) {
      output = add(output, new UnoCard(cards[i]));
    }

    return output;
  }

  public static UnoCard[] add(UnoCard[] org, UnoCard add) {
    System.out.println(add);
    UnoCard[] output = new UnoCard[org.length + 1];
    for(int i = 0; i < org.length; i++) {
      output[i] = org[i];
    }
    output[org.length] = add;
    return output;
  }






  
}