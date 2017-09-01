package com.romanisecke;

import com.romanisecke.PokerStyle.PokerDeck;
import com.romanisecke.UnoStyle.UnoDeck;

/**
 * Let's play with out deck!
 *
 */
public class PlayCards
{
    /**
     * Stepping through all the functionality introduced.
     * 1. Choose between playing with an uno or poker style deck
     * 1. Initialize it to contain the default starting list of playing cards
     * 2. Shuffle the deck
     * 3. Deal the whole deck out with a check on the size of what's left in the deck as it's dealt
     * @param args
     */
    public static void main( String[] args )
    {

        String letsPlay = "uno";
        //String letsPlay = "poker";
        AbstractDeck deck;
        if ("uno".equals(letsPlay)) {
            deck = new UnoDeck();
        } else {
            deck = new PokerDeck();
        }
        System.out.println(String.format("Lets play some %s!", letsPlay));
        System.out.println("Starting out with the current deck:\n");
        printCards(deck);
        System.out.println("\nShuffling...");
        deck.shuffle();
        System.out.println();
        System.out.println("Deck after shuffling:");
        System.out.println();
        printCards(deck);
        int startingSize = deck.getPlayingCards().size();
        System.out.println(String.format("\nLets deal it out, starting size of deck: %d\n", startingSize));
        for (int i = 0; i < startingSize; i++) {
            //System.out.println(String.format("Dealing %s, size of deck now: %d", deck.dealOneCard().toString(), deck.getPlayingCards().size()));
        }
        System.out.println("We're done!");

    }

    public static void printCards(AbstractDeck deck) {
        for (PlayingCard card : deck.getPlayingCards()) {
            System.out.println(card.toString());
        }
    }
}
