public class UnoCard extends Card{

    private String[] VALUES = {"r-0", "r-1", "r-2", "r-3", "r-4", "r-5", "r-6", "r-7", "r-8", "r-9", "rSK", "rRV", "r+2", "b-0", "b-1", "b-2", "b-3", "b-4,", "b-5", "b-6", "b-7", "b-8", "b-9", "bSK", "bRV", "b+2", "g-0", "g-1", "g-2", "g-3", "g-4", "g-5", "g-6", "g-7", "g-8", "g-9", "gSK", "gRV", "g+2", "y-0", "y-1", "y-2", "y-3", "y-4", "y-5", "y-6", "y-7", "y-8", "y-9", "ySK", "yRV", "y+2", "W--", "W+4"};
  
    public UnoCard(int num) {
        super(num);
        super.VALUES(VALUES);
    }

    public void set(int num) {
        super.set(num);
    }

    public String toString() {
        return VALUES[super.num()];
    }
    
}