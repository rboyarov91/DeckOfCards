package com.romanisecke.UnoStyle;

import com.romanisecke.PlayingCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An uno implementation of a playing card with a suit and color value
 * Not as fully documented as the poker style as this is solely meant to show the simplicity
 * allowed by Java's polymorphism
 */
public class UnoPlayingCard implements PlayingCard {

    public static final List<String> possibleSuits =
            new ArrayList(Arrays.asList("red", "green", "yellow", "blue", null));
    public static final List<String> possibleValue =
            new ArrayList(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "draw 2", "skip", "reverse", "wild_draw4", "wild"));

    private String suit;

    private String value;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getFirstValue() {
        return getSuit();
    }

    @Override
    public String getSecondValue() {
        return getValue();
    }

    @Override
    public boolean isEqual(Object obj) {
        return obj instanceof UnoPlayingCard
                && ((UnoPlayingCard)obj).getFirstValue().equals(getFirstValue())
                && ((UnoPlayingCard)obj).getSecondValue().equals(getSecondValue());
    }

    @Override
    public boolean isFirstValueValid(String suit) {
        return possibleSuits.contains(suit);
    }

    @Override
    public boolean isSecondValueValid(String value) {
        return possibleValue.contains(value);
    }

    public UnoPlayingCard(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return getFirstValue() == null ? getSecondValue() : String.format("%s %s", getFirstValue(), getSecondValue());
    }
}
