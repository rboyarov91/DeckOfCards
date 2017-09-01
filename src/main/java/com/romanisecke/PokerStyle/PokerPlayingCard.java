package com.romanisecke.PokerStyle;

import com.romanisecke.PlayingCard;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Poker style implementation of a playing card with a suit and value. Suits and values are limited to the typical ranges in poker style cards.
 */
public class PokerPlayingCard implements PlayingCard {

    public static final List<String> possibleSuits =
            new ArrayList(Arrays.asList("hearts", "spades", "clubs", "diamonds"));
    public static final List<String> possibleValue =
            new ArrayList(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"));

    private String suit;

    private String value;

    /**
     * Setter for the card suit, checks that the suit passed in is valid before setting
     * @param suit
     * @throws IllegalArgumentException
     */
    public void setSuit(String suit) throws IllegalArgumentException {
        checkFirstValueAndThrowError(suit);
        this.suit = suit;
    }

    /**
     * Setter for the card value, checks that the value passed in is valid before setting
     * @param value
     * @throws IllegalArgumentException
     */
    public void setValue(String value) throws IllegalArgumentException {
        checkSecondValueAndThrowError(value);
        this.value = value;
    }

    /**
     * Constructor taking in a suit and value. Checking both for a validy before setting, otherwise throwing the appropriate error
     * @param suit
     * @param value
     */
    public PokerPlayingCard(String suit, String value) {
        checkSecondValueAndThrowError(value);
        checkFirstValueAndThrowError(suit);

        this.suit = suit;
        this.value = value;
    }

    /**
     * Getter method for suit field
     * @return the String value of the suit field
     */
    public String getFirstValue() {
        return suit;
    }

    /**
     * Getter method for value field
     * @return the String field of the card value field
     */
    public String getSecondValue() {
        return value;
    }

    /**
     * Public method that checks the card value passed in is a valid valie
     * @param value
     */
    public boolean isSecondValueValid(String value) {
        return possibleValue.contains(value);
    }

    /**
     * Method that throws an appropriate error if card value passed is invalid
     * @param value
     */
    private void checkSecondValueAndThrowError(String value) {
        if (!isSecondValueValid(value)) {
            throw new IllegalArgumentException(String.format("card value must be one of: %s",
                    StringUtils.join(possibleValue, ",")));
        }
    }

    /**
     * Public method that checks that the passed in suit is a valid suit
     * @param suit
     */
    public boolean isFirstValueValid(String suit) {
        return possibleSuits.contains(suit);
    }

    /**
     * Method that throws an appropriate error if suit is invalid
     * @param suit
     */
    private void checkFirstValueAndThrowError(String suit) {
        if (!isFirstValueValid(suit)) {
            throw new IllegalArgumentException(String.format("suit value must be one of: %s",
                    StringUtils.join(possibleSuits, ",")));
        }
    }

    /**
     * Custom toString method returning the card in the style: {value-of-card} of {suit-of-card}
     * @return String representation of a poker-style playing card
     */
    @Override
    public String toString() {
        return String.format("%s of %s", getSecondValue(), getFirstValue());
    }

    /**
     * a boolean check for equality based on suit and value
     * @param obj
     * @return  boolean results of the equality check
     */
    public boolean isEqual(Object obj) {
        return obj instanceof PlayingCard
        && ((PlayingCard) obj).getFirstValue().equals(getFirstValue())
        && ((PlayingCard) obj).getSecondValue().equals(getSecondValue());
    }
}

