package com.romanisecke;

/**
 * Let's play with out deck!
 *
 */
public class PlayCards
{
    /**
     * Stepping through all the functionality introduced.
     * 1. Initialize a standard poker-style deck (52 cards)
     * 2. Shuffle the deck
     * 3. Deal the whole deck out with a check on the size of what's left in the deck as it's dealt
     * @param args
     */
    public static void main( String[] args )
    {
        System.out.println("Lets play some cards!");
        PokerDeck pokerDeck = new PokerDeck();
        System.out.println("Starting out with the current deck:\n");
        printCards(pokerDeck);
        System.out.println("\nShuffling...");
        pokerDeck.shuffle();
        System.out.println();
        System.out.println("Deck after shuffling:");
        System.out.println();
        printCards(pokerDeck);
        int startingSize = pokerDeck.getSize();
        System.out.println(String.format("\nLets deal it out, starting size of deck: %d\n", startingSize));
        for (int i = 0; i < startingSize; i++) {
            System.out.println(String.format("Dealing %s, size of deck now: %d", pokerDeck.dealOneCard().toString(), pokerDeck.getSize()));
        }
        System.out.println("We're done!");

    }

    public static void printCards(PokerDeck deck) {
        for (PlayingCard card : deck.getPlayingCards()) {
            System.out.println(card.toString());
        }
    }
}
