import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Random;

public class Uno {

  public static void main(String[] args) {
    Player[] playersgo = {new Player("one")};
    play(playersgo);
  }

  private static CardList deck;
  private static CardList discard;
  private static CardList[] hands;
  private static Scanner scan;
  private static Player[] players;

  public static Player[] play(Player[] playersIn) {

    players = playersIn;
    scan = new Scanner(System.in);
    deck = new CardList(unoDeck());
    deck.shuffle();
    discard = new CardList();
    discard.add(deck.draw(1));
    hands = new CardList[players.length];
    
    for(int i = 0; i < hands.length; i++) {
      hands[i] = new CardList(deck.draw(7));
    }

    int player = 0;
    while(true) {
      if(player >= players.length) {
        player = 0;
      }

      if (turn(player)) {break;}


    }

    
    

    
    






    return players;
    
  }



  public static boolean turn(int player) { // returns true if win
    System.out.println(players[player].name() + "'s turn, press enter when ready");
    scan.nextLine();

    System.out.println("Discard: " + discard.get(discard.length() - 1));

    System.out.println(getDisplay(hands[player]));

    hands[player].add(new UnoCard(52));

    while(true) {
      System.out.print("Input the position of the card you want to play: ");
      int input = scan.nextInt();
      System.out.println();
      // plays card. Returns played card if succesful, else retuns null
      Card result = attemptPlay(hands[player].get(input - 1));

      if(result == null) {
        System.out.println("That is not a valid play.");
      } else {
        System.out.println("Successfully played " + result + ".");
        hands[player].take(input - 1);
        System.out.println();
        break;
      }
    }


    return false;
  }



  public static Card attemptPlay(Card card) {
    // Because the given card and the discard pile card could possibly be normal Cards, and not UnoCards (Even though in the actual process they will never be normal cards), I have to convert them into UnoCards to make sure. I love and hate subclasses. I've spent a little less than an hour trying to figure this out, and now I'm just out of time.
    boolean wild = (new UnoCard(card).value() < 0);
    if(wild || (new UnoCard(card).color() == new UnoCard(discard.get(discard.length() - 1)).color() || new UnoCard(card).value() == new UnoCard(discard.get(discard.length() - 1)).value())) {

      if(wild) {
        System.out.print("Input desired color (r/b/g/y): ");
        while(true) {
          String input = scan.next();
          int plus4 = (new UnoCard(card).value() + 1) * -4; // magically turns into 0 for wilds, 4 for +4s. kinda silly way of doing this, but it is very concise
          if(input.equals("r")) {
            card.set(52 + plus4);
            break;
          } else if(input.equals("b")) {
            card.set(53 + plus4);
            break;
          } else if(input.equals("g")) {
            card.set(54 + plus4);
            break;
          } else if(input.equals("y")) {
            card.set(55 + plus4);
            break;
          }
          System.out.println("That is not a valid color.");
        }
      }

      discard.add(card);
      return card;
    }
    
    return null;
  }



  public static String getDisplay(CardList cards) {
    String str = "You have: ";
    for(int i = 0; i < cards.cardArr().length; i++) {
      str += cards.get(i);
      if(i != cards.cardArr().length - 1) {
        str += ", ";
      }
    }

    return str;
  }



  public static void reshuffleDeck() {
    deck = discard;
    discard = new CardList();
    deck.shuffle();
    discard.add(deck.draw(1));
  }



  public static UnoCard[] unoDeck() {

    /* close to working, but I'm running out of time
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

    UnoCard[] output = new UnoCard[108];

    // entire uno deck, 108 values representing cards. This is a terrible solution considering the deck repeats itself SOMETIMES, but this is also the easiest solution. Above is the better method, but i couldn't get it working and I'm running out of time
    int[] cards = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, /*blue*/ 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, /* green */ 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, /* yellow */ 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, /* wild */ 52, 52, 52, 52, 53, 53, 53, 53};

    for(int i = 0; i < output.length; i++) {
      output[i] = new UnoCard(cards[i]);
    }

    return output;
  }


  
  // returns a given CardList with a given Card appended. I used to use this method, but not anymore. Ill keep it in here just in case though.
  public static UnoCard[] add(UnoCard[] org, UnoCard add) {
    UnoCard[] output = new UnoCard[org.length + 1];
    for(int i = 0; i < org.length; i++) {
      output[i] = org[i];
    }
    output[org.length] = add;
    return output;
  }

  
}