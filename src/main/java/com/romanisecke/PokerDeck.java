package com.romanisecke;

import java.util.LinkedList;
import java.util.List;

public class PokerDeck extends AbstractDeck {
    private LinkedList<PlayingCard> pokerCards = new LinkedList<PlayingCard>();

    private LinkedList<PlayingCard> getPokerCards() {
        return pokerCards;
    }

    private void setPokerCards(LinkedList<PlayingCard> pokerCards) {
        this.pokerCards = pokerCards;
    }

    public List<PlayingCard> getPlayingCards() {
        return getPokerCards();
    }

    public void addCard(PlayingCard playingCard) {
        pokerCards.add(playingCard);
    }

    public PokerDeck() {
        init();
    }

    public void init() {
        for (String suit : PokerPlayingCard.possibleSuits) {
            for (String value : PokerPlayingCard.possibleValue) {
                pokerCards.add(new PokerPlayingCard(suit, value));
            }
        }
    }

    public int getSize() {
        return getPlayingCards().size();
    }


}
