package com.romanisecke.PokerStyle;

import com.romanisecke.AbstractDeck;
import com.romanisecke.PlayingCard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of AbstractDeck, with the intention of holding poker style playing cards
 * Initializes to hold a deck with 52 playing cards in four suits: hearts, spades, clubs, diamonds, with
 face values of Ace, 2-10, Jack, Queen, and King.
 */
public class PokerDeck extends AbstractDeck {
    private LinkedList<PlayingCard> pokerCards = new LinkedList<PlayingCard>();

    private LinkedList<PlayingCard> getPokerCards() {
        // Just in case pokerCards gets set to null along the way, this should prevent a NullPointerException
        if (pokerCards == null) {
            return new LinkedList<>();
        }
        return pokerCards;
    }

    private void setPokerCards(LinkedList<PlayingCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    /**
     *
     * @return current list of playing cards being used
     */
    public List<PlayingCard> getPlayingCards() {
        return getPokerCards();
    }

    /**
     *
     * @param playingCard - The playing card item to add to the current list of cards in the deck
     */
    public void addCard(PlayingCard playingCard) {
        pokerCards.add(playingCard);
    }

    public PokerDeck() {
        initializeDeck();
    }

    /**
     * Initialize the deck to the standard 52 playing cards
     */
    public void initializeDeck() {
        for (String suit : PokerPlayingCard.possibleSuits) {
            for (String value : PokerPlayingCard.possibleValue) {
                pokerCards.add(new PokerPlayingCard(suit, value));
            }
        }
    }

    /**
     * Get the size of the deck based on the list of cards
     * @return
     */
    public int getSize() {
        return getPlayingCards().size();
    }

    /**
     * Set the deck to hold an empty list of cards
     */
    public void setEmpty() {
        setPokerCards(new LinkedList<PlayingCard>());
    }




}
