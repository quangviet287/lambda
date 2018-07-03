package intergratingdefaultmethods;

public class PlayingCard implements Comparable<Card> {

    Card.Suit suit;
    Card.Rank rank;
    public int hashCode(){
        return ((suit.value()-1)*13)+rank.value();
    }

    @Override
    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }
}
