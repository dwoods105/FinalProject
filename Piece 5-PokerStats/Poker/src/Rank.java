/**
 * @author Daniel Woods
 * This is an enumerated type of playing card ranks. The Ace is 1, so keep that in
 * mind during your comparisons.
 */
public enum Rank {
    Ace(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13);

    private final int value;
    Rank(int i) {
        value = i;
    }

    /**
     * getValue returns the int value of the rank.
     * @return int value of the rank, for comparision.
     */
    public int getValue(){
        return value;
    }
}
