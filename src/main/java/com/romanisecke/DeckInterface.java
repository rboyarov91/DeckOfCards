package com.romanisecke;

import java.util.List;

/**
 * Interface that includes all functionality that should exist across Deck object
 */
public interface DeckInterface {

    /**A simple getter method for the playing cards in the deck
     *
     * @return A List containing all the playing cards being used in the current deck
     */
    List<PlayingCard> getPlayingCards();


    /**
     *
     * @param playingCard - The playing card item to add to the current list of cards in the deck
     */
    void addCard(PlayingCard playingCard);

    /**
     *
     * @return Returns a single card from the current list of playing cards in the deck
     */
    PlayingCard dealOneCard();
}
