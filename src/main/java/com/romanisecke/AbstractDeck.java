package com.romanisecke;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class AbstractDeck implements DeckInterface {

    public void shuffle() {
        Random random = new Random();
        List<PlayingCard> playingCards = this.getPlayingCards();
        for (int i = playingCards.size() - 1; i > 0 ; i--) {
            int randomIndex = random.nextInt(i);
            Collections.swap(playingCards, randomIndex, i);
        }
    }

    public PlayingCard dealOneCard() {
        List<PlayingCard> playingCards = this.getPlayingCards();
        return playingCards.remove(0);
    }
}
