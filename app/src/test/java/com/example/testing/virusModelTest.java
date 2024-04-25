package com.example.testing;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * This class is used to test the virusModel class to make sure it works properly.
 * @since JDK 17
 * @version 1.2
 */

public class virusModelTest {

    /**
     * A preloaded object of virusModel
     */
    private static virusModel makeEntryA() {
        return new virusModel("Red", "Bacteria", "Covid 19",  11111);
    }
    /**
     * A preloaded object of virusModel
     */
    private static virusModel makeEntryB() {
        return new virusModel("Black", "Virus", "Covid 20",  11112);
    }
    /**
     * A preloaded object of virusModel
     */
    private static virusModel makeEntryC() {
        return new virusModel("Yellow", "Bacteria", "Covid 21",  11113);
    }

    /**
     * Test method for {@link virusModel#virusModel(String, String, String, int)}
     */
    @Test
    public void testVirusModel(){

        assertEquals("Red", makeEntryA().getVirusColor());
        assertEquals("Black", makeEntryB().getVirusColor());
        assertEquals("Yellow", makeEntryC().getVirusColor());

        assertEquals("Bacteria", makeEntryA().getVirusType());
        assertEquals("Virus", makeEntryB().getVirusType());
        assertEquals("Bacteria", makeEntryC().getVirusType());

        assertEquals("Covid 19", makeEntryA().getVirusName());
        assertEquals("Covid 20", makeEntryB().getVirusName());
        assertEquals("Covid 21", makeEntryC().getVirusName());

        assertEquals(11111, makeEntryA().getImage());
        assertEquals(11112, makeEntryB().getImage());
        assertEquals(11113, makeEntryC().getImage());

    }
    /**
     * Test method for {@link virusModel#getVirusColor()}
     */
    @Test
    public void testGetVirusColor() {

        assertEquals("Red", makeEntryA().getVirusColor());
        assertEquals("Black", makeEntryB().getVirusColor());
        assertEquals("Yellow", makeEntryC().getVirusColor());
        assertNotEquals("Green", makeEntryA().getVirusColor());
        assertNotEquals("Blue", makeEntryB().getVirusColor());
        assertNotEquals("Gray", makeEntryC().getVirusColor());

    }

    /**
     * Test method for {@link virusModel#getVirusType()}
     */
    @Test
    public void testGetVirusType() {

        assertEquals("Bacteria", makeEntryA().getVirusType());
        assertEquals("Virus", makeEntryB().getVirusType());
        assertEquals("Bacteria", makeEntryC().getVirusType());
        assertNotEquals("Virus", makeEntryA().getVirusType());
        assertNotEquals("Bacteria", makeEntryB().getVirusType());
        assertNotEquals("Virus", makeEntryC().getVirusType());

    }

    /**
     * Test method for {@link virusModel#getVirusName()}
     */
    @Test
    public void testGetVirusName() {

        assertEquals("Covid 19", makeEntryA().getVirusName());
        assertEquals("Covid 20", makeEntryB().getVirusName());
        assertEquals("Covid 21", makeEntryC().getVirusName());
        assertNotEquals("Covid 20", makeEntryA().getVirusName());
        assertNotEquals("Covid 21", makeEntryB().getVirusName());
        assertNotEquals("Covid 22", makeEntryC().getVirusName());
    }

    /**
     * Test method for {@link virusModel#getImage()}
     */
    @Test
    public void testGetImage() {

        assertEquals(11111, makeEntryA().getImage());
        assertEquals(11112, makeEntryB().getImage());
        assertEquals(11113, makeEntryC().getImage());
        assertNotEquals(11112, makeEntryA().getImage());
        assertNotEquals(11113, makeEntryB().getImage());
        assertNotEquals(11114, makeEntryC().getImage());
    }
}