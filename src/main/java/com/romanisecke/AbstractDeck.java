package com.romanisecke;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Base deck class with defined implementations of shuffle() and dealOneCard()
 */
public abstract class AbstractDeck implements DeckInterface {

    /**
     * Randomizes all the cards in the list of cards belonging to this deck
     */
    public void shuffle() {
        Random random = new Random();
        List<PlayingCard> playingCards = this.getPlayingCards();
        for (int i = playingCards.size() - 1; i > 0 ; i--) {
            int randomIndex = random.nextInt(i);
            Collections.swap(playingCards, randomIndex, i);
        }
    }

    /**
     *
     * @return Removes and returns a single playing card from the deck
     */
    public PlayingCard dealOneCard() {
        List<PlayingCard> playingCards = this.getPlayingCards();
        return playingCards.remove(0);
    }
}
