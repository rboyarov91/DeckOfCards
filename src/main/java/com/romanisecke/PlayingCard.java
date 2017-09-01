package com.romanisecke;

/**
 * This interface helps handle all card games where cards can be encompassed with two values
 * i.e. Poker style: suit and value or Uno: color and value
 * This could be generalized further to get a variable length list of attributes describing a card rather than two values
 */
public interface PlayingCard {

    String getFirstValue();

    String getSecondValue();

    boolean isEqual(Object obj);

    void checkFirstValue(String value);

    void checkSecondValue(String suit);
}


