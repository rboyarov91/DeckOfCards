package com.romanisecke;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class PlayCardsTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlayCardsTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PlayCardsTest.class );
    }

    /**
     * Test that all cards are unique in a deck
     */
    public void testUniqueness()
    {
        Set<PlayingCard> uniqueCards = new HashSet<PlayingCard>();
        PokerDeck pokerDeck = new PokerDeck();
        uniqueCards.addAll(pokerDeck.getPlayingCards());

        assertEquals(pokerDeck.getSize(), uniqueCards.size());
    }
}
