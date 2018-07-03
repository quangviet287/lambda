package intergratingdefaultmethods;

import java.util.Comparator;

public class SortByRankThenSuit implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int comVal = o1.getRank().value() - o2.getRank().value();
        if(comVal !=0) return comVal;
        else return o1.getSuit().value() - o2.getSuit().value();
    }

    public static void main(String[] args) {
        StandardDeck standardDeck = new StandardDeck();
        standardDeck.shuffle();
        standardDeck.sort((o1,o2)->o1.getRank().value() - o2.getRank().value());

        standardDeck.sort(Comparator.comparing((card -> card.getRank())));

        standardDeck.sort(Comparator.comparing(Card::getRank));

        standardDeck.sort((firstCard,secondCard)->{
            int compare = firstCard.getRank().value() - secondCard.getRank().value();
            if(compare !=0) return compare;
            else return firstCard.getSuit().value() - secondCard.getSuit().value();
        });

        standardDeck.sort(
                Comparator.comparing(Card::getRank).thenComparing(Comparator.comparing(Card::getSuit)));
        //sort the deck of playing cards first by descending order of rank
        standardDeck.sort(Comparator.comparing((Card::getRank)).reversed().thenComparing(Comparator.comparing(Card::getSuit)));
    }
}
