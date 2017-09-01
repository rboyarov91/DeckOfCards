package com.romanisecke;

import com.romanisecke.PokerStyle.PokerDeck;

import java.util.Collections;
import java.util.Iterator;
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
     * Removes and returns a single playing card from the deck
     * @return A single playing card from the list used by deck
     */
    public PlayingCard dealOneCard() {
        List<PlayingCard> playingCards = this.getPlayingCards();
        return playingCards.remove(0);
    }

    /**
     * Check for equality between this deck and any other object
     * @param obj What the current deck is being checked against
     * @return boolean value indicating equality, true if equal
     */
    public boolean isEqual(Object obj) {
        if (obj instanceof AbstractDeck && this.getPlayingCards().size() == ((AbstractDeck)obj).getPlayingCards().size()) {
            AbstractDeck abstractDeck = (AbstractDeck) obj;
            Iterator target = abstractDeck.getPlayingCards().iterator();
            for (PlayingCard card : this.getPlayingCards()) {
                if (!card.isEqual(target.next())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
