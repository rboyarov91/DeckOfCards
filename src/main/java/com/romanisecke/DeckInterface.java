package com.romanisecke;

import java.util.List;

/**
 * Interface that includes all functionality that should exist across Deck object
 */
public interface DeckInterface {

    /**
     * A simple getter method for the playing cards in the deck
     * @return A List containing all the playing cards being used in the current deck
     */
    List<PlayingCard> getPlayingCards();


    /**
     * Add a single card to the list being used by deck
     * @param playingCard - The playing card item to add
     */
    void addCard(PlayingCard playingCard);

    /**
     *
     * @return Returns a single card from the current list of playing cards in the deck
     */
    PlayingCard dealOneCard();

    /**
     * Returns the equality between the current deck and any object passed in
     * @param obj Object to compare to
     * @return boolean value, true is equal, false if not
     */
    boolean isEqual(Object obj);

    /**
     * Every deck should have a default set of cards, this method initializes that list for that specific implementation
     */
    void initializeDeck();


}
