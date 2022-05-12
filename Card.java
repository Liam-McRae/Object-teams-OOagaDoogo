
//'ello A b

public interface Card{

 
  // Gets a random card from the would-be complete deck of cards
  public Card getRandom();

  // Gets a card based on a seed number
  public Card getByNumber(int seed);

  // Gets the index value from the list of possible suites
  public int getSuiteValue();

  // Gets the number value from the card
  public int getCardNumber();

  // Gets a nice looking String showing the card
  public String getLovely();

  // Returns the possible Suites for the card
  public String[] getSuits();
  
}