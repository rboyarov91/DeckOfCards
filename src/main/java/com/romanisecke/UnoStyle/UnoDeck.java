package com.romanisecke.UnoStyle;

import com.romanisecke.AbstractDeck;
import com.romanisecke.PlayingCard;

import java.util.LinkedList;
import java.util.List;

/**
 * An deck container for uno playing cards
 * Not as fully documented as the poker style as this is solely meant to show the simplicity
 * allowed by Java's polymorphism
 */
public class UnoDeck extends AbstractDeck {
    private LinkedList<PlayingCard> unoPlayingCards = new LinkedList<PlayingCard>();

    public LinkedList<PlayingCard> getUnoPlayingCards() {
        if (unoPlayingCards == null) {
            return new LinkedList<PlayingCard>();
        }
        return unoPlayingCards;
    }

    public void setUnoPlayingCards(LinkedList<PlayingCard> unoPlayingCards) {
        this.unoPlayingCards = unoPlayingCards;
    }

    @Override
    public List<PlayingCard> getPlayingCards() {
        return getUnoPlayingCards();
    }

    @Override
    public void addCard(PlayingCard playingCard) {
        unoPlayingCards.add(playingCard);
    }

    public UnoDeck() {
        initializeDeck();
    }

    @Override
    public void initializeDeck() {
        for (String suit : UnoPlayingCard.possibleSuits) {
            if (suit == null) {
                continue;
            }
            for (String value : UnoPlayingCard.possibleValue) {
                if ("wild_draw4".equals(value) || "wild".equals(value)) {
                    continue;
                }
                if ("0".equals(value)) {
                    addCard(new UnoPlayingCard(suit, value));
                } else {
                    // Everything else there's 2 of
                    addCard(new UnoPlayingCard(suit, value));
                    addCard(new UnoPlayingCard(suit, value));
                }
            }
            for (int i = 0; i < 4; i++) {
                addCard(new UnoPlayingCard(null, "wild_draw4"));
                addCard(new UnoPlayingCard(null, "wild"));
            }
        }
    }

}
