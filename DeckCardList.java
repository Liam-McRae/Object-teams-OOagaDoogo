import java.util.ArrayList;

public class DeckCardList extends CardList {

    String[] suites = new String[] {"S", "H", "D", "C"};
    String[] values = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    int[] points = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public DeckCardList() {
        super();
    }

    public DeckCardList(int num) {
        super();
        if(num == 0) {
            for(int i = 0; i < 52; i++) {
                Card card = new Card(i);
                card.SUITES(suites);
                card.VALUES(values);
                card.POINTS(points);
                super.add(card);
            }
        }
    }

    public DeckCardList(Card[] set) {
        for(Card card : set) {
            card.SUITES(suites);
            card.VALUES(values);
            card.POINTS(points);
        }
        super.set(set);
    }

    public void add(Card card) {
        card.SUITES(suites);
        card.VALUES(values);
        card.POINTS(points);
        super.add(card);
    }

    public void set(ArrayList<Card> cards) {

        for(int i = 0; i < cards.toArray().length; i++) {
            Card card = cards.get(i);
            card.SUITES(suites);
            card.VALUES(values);
            card.POINTS(points);
            cards.set(i, card);
        }
        super.set(cards);
    }

    public void set(Card[] cards) {
        for(Card card : cards) {
            card.SUITES(suites);
            card.VALUES(values);
            card.POINTS(points);
        }
        super.set(cards);
    }

    public String display(){
        return display(true, 0);
    }

    public String display(boolean showTotal) {
        return display(showTotal, 0);
    }

    public String display(boolean showTotal, int hideEnd) {
        String print = "";
        for(int i = 0; i < super.cards().size() - hideEnd; i++) {
            print += super.get(i) + ", ";
        }
        for(int i = super.cards().size() - hideEnd; i < super.cards().size(); i++) {
            print += "??, ";
        }
        print = print.substring(0, print.length() - 2);
        if(showTotal) {
            int[] total = this.pointTotal(hideEnd);
            print += " (total points: ";
            for(int i = 0; i < total.length; i++) {
                print += total[i] + ", ";
            }
            if(hideEnd > 0) {
                print += "+ ??";
            } else {
                print = print.substring(0, print.length() - 2);
            }
            print += ")";
        }

        return print;
    }

    public int[] pointTotal(int removeEnd) {
        int aces = 0;
        int points = 0;
        
        for(int i = 0; i < super.cards().size() - removeEnd; i++) {
            if(super.cards().get(i).points() == 1) {
                aces++;
            } else {
                points += super.cards().get(i).points();
            }
        }
    
        int[] total = new int[aces + 1];
    
        for(int i = 0; i < total.length; i++) {
            total[i] = points + (i * 11) + (aces - i);
        }
    
        return total;    
    }

    public int bestPoints() {
        int[] arr = this.pointTotal(0);
        int best = arr[arr.length - 1];
    
        for(int i = arr.length - 2; i >= 0; i--) {
            if((arr[i] > best || best > 21) && arr[i] <= 21) {
                best = arr[i];
            }
        }
    
        return best;
      }

}