package com.romanisecke;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokerPlayingCard implements PlayingCard {

    public static final List<String> possibleSuits =
            new ArrayList(Arrays.asList("hearts", "spades", "clubs", "diamonds"));
    public static final List<String> possibleValue =
            new ArrayList(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"));

    private String suit;

    private String value;

    public void setSuit(String suit) throws IllegalArgumentException {
        checkCardSuit(suit);
        this.suit = suit;
    }

    public void setValue(String value) throws IllegalArgumentException {
        checkCardValue(value);
        this.value = value;
    }

    public PokerPlayingCard(String suit, String value) {
        checkCardValue(value);
        checkCardSuit(suit);

        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    private void checkCardValue(String card) {
        if (!possibleValue.contains(card)) {
            throw new IllegalArgumentException(String.format("card value must be one of: %s",
                    StringUtils.join(possibleValue, ",")));
        }
    }

    private void checkCardSuit(String suit) {
        if (!possibleSuits.contains(suit)) {
            throw new IllegalArgumentException(String.format("suit value must be one of: %s",
                    StringUtils.join(possibleSuits, ",")));
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s", getValue(), getSuit());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof PlayingCard
        && ((PlayingCard) obj).getSuit().equals(getSuit())
        && ((PlayingCard) obj).getValue().equals(getValue());
    }
}

