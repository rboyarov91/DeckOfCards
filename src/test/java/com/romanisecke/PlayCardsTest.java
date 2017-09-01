package com.romanisecke;

import com.romanisecke.PokerStyle.PokerDeck;
import com.romanisecke.PokerStyle.PokerPlayingCard;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
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

    /**
     * Test to make sure the initial deck is set up with 52 cards
     */
    public void testInitialSize() {
        PokerDeck pokerDeck = new PokerDeck();
        assertEquals(52, pokerDeck.getSize());
    }

    /**
     * Test to make sure the shuffle method doesn't alter the size of the deck
     */
    public void testSizeIntegrityOnShuffle() {
        PokerDeck pokerDeck = new PokerDeck();
        int initialSize = pokerDeck.getSize();
        pokerDeck.shuffle();
        assertEquals(initialSize, pokerDeck.getSize());
    }

    /**
     * Test that an appropriate card is created and added to the deck
     */
    public void testSuccessfullCardAddition() {
        PokerDeck pokerDeck = new PokerDeck();
        pokerDeck.setEmpty();
        pokerDeck.addCard(new PokerPlayingCard("hearts", "5"));
    }

    /**
     * Test that an unsuccessful card throws the appropriate error based on suit
     */
    public void testWrongSuitCardAddition() {
        PokerDeck pokerDeck = new PokerDeck();
        pokerDeck.setEmpty();
        String expectedString = String.format("suit value must be one of: %s",
                StringUtils.join(PokerPlayingCard.possibleSuits, ","));
        try {
            pokerDeck.addCard(new PokerPlayingCard("circles", "6"));
            fail(String.format("Expected exception with message:\n %s", expectedString));
        } catch (Exception e) {
            assertEquals(e.getMessage(), expectedString);
        }
    }

    /**
     * Test that an unsuccessful card throws the appropriate error based on value
     */
    public void testWrongValueCardAddition() {
        PokerDeck pokerDeck = new PokerDeck();
        pokerDeck.setEmpty();
        String expectedString = String.format("card value must be one of: %s",
                StringUtils.join(PokerPlayingCard.possibleValue, ","));
        try {
            pokerDeck.addCard(new PokerPlayingCard("hearts", "1"));
            fail(String.format("Expected exception with message:\n %s", expectedString));
        } catch (Exception e) {
            assertEquals(e.getMessage(), expectedString);
        }
    }

    /**
     * Test that a a full deck is dealt based on knowing it should be of length 52
     */
    public void testSuccessfulCardsDealt() {
        int deckSize = 52;
        PokerDeck pokerDeck = new PokerDeck();
        for (int i = 0; i < deckSize; i++) {
            pokerDeck.dealOneCard();
        }
    }

    /**
     * Test that trying to deal more than 52 cards throws the appropriate out of bounds error
     */
    public void testUnsuccessfulCardsDealt() {
        int wrongDeckSize = 53;
        PokerDeck pokerDeck = new PokerDeck();
        String expectedMessage = "Index: 0, Size: 0";
        String expectedName = "java.lang.IndexOutOfBoundsException";
        try {
            for (int i = 0; i < wrongDeckSize; i++) {
                pokerDeck.dealOneCard();
            }
            fail(String.format("Exception expected with name %s", expectedName));
        } catch (Exception e) {
            assertEquals(expectedMessage, e.getMessage());
            assertEquals(expectedName, e.getClass().getName());
        }
    }
    public void testSuccessfullDeckEquality() {
        PokerDeck pokerDeck1 = new PokerDeck();
        PokerDeck pokerDeck2 = new PokerDeck();
        boolean equals = pokerDeck1.isEqual(pokerDeck2);
        assertEquals(true, equals);
    }

    public void testUnsuccessfullDeckEqualityDueToDeckSize() {
        PokerDeck pokerDeck1 = new PokerDeck();
        PokerDeck pokerDeck2 = new PokerDeck();
        pokerDeck2.dealOneCard();
        boolean equals = pokerDeck1.isEqual(pokerDeck2);
        assertEquals(false, equals);
    }

    public void testUnsuccessfullDeckEqualityDueToDeckContent() {
        PokerDeck pokerDeck1 = new PokerDeck();
        PokerDeck pokerDeck2 = new PokerDeck();
        pokerDeck2.dealOneCard();
        pokerDeck2.addCard(new PokerPlayingCard("hearts", "8"));
        boolean equals = pokerDeck1.isEqual(pokerDeck2);
        assertEquals(false, equals);
    }
}
