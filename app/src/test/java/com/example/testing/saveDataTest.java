package com.example.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class is used to test the saveData class to make sure it works properly.
 * @since JDK 17
 * @version 1.2
 */
public class saveDataTest {

    /**
     * Test method for {@link saveData#getVirusPicture()}
     */
    @Test
    public void testGetVirusPicture() {

        saveData entryA = new saveData();

        int[] virusPicture = entryA.getVirusPicture();
        assertEquals(R.drawable.question_mark, virusPicture[0]);
        assertEquals(R.drawable.question_mark, virusPicture[1]);
        assertEquals(R.drawable.question_mark, virusPicture[2]);
        assertNotEquals(R.drawable.bacteria_enemy, virusPicture[0]);
        assertNotEquals(R.drawable.cell_enemy, virusPicture[1]);
        assertNotEquals(R.drawable.cell_enemy, virusPicture[2]);


    }

    /**
     * Test method for {@link saveData#getVirusName()}
     */
    @Test
    public void testGetVirusName() {

        saveData entryA = new saveData();

        String[] virusName = entryA.getVirusName();

        assertEquals("Name: A", virusName[0]);
        assertEquals("Name: B", virusName[1]);
        assertEquals("Name: C", virusName[2]);
        assertNotEquals("Name: B", virusName[0]);
        assertNotEquals("Name: C", virusName[1]);
        assertNotEquals("Name: D", virusName[2]);
    }

    /**
     * Test method for {@link saveData#setVirusNamePart(String, int)}
     */
    @Test
    public void testSetVirusNamePart() {

        saveData entryA = new saveData();


        String[] virusName = entryA.getVirusName();


        entryA.setVirusNamePart("Test1", 0);
        entryA.setVirusNamePart("Test2", 1);
        entryA.setVirusNamePart("Test3", 2);
        assertEquals("Test1", virusName[0]);
        assertEquals("Test2", virusName[1]);
        assertEquals("Test3", virusName[2]);
        assertNotEquals("Name: A", virusName[0]);
        assertNotEquals("Name: B", virusName[1]);
        assertNotEquals("Name: C", virusName[2]);
    }

    @Test
    public void testGetLevelCount(){
        saveData level = new saveData();
        AtomicInteger newLevel = new AtomicInteger(5);
        level.setLevelCount(newLevel);

        AtomicInteger newLevel1 = new AtomicInteger(6);
        AtomicInteger newLevel2 = new AtomicInteger(5);

        assertEquals(5, level.getLevelCount().get());
        level.setLevelCount(newLevel1);
        assertEquals(6, level.getLevelCount().get());
        level.setLevelCount(newLevel2);

        assertEquals(5, level.getLevelCount().get());



    }

    @Test
    public void testSetLevelCount(){
        saveData level = new saveData();
        AtomicInteger newLevel = new AtomicInteger(5);

        level.setLevelCount(newLevel);
        assertEquals(newLevel.get(),level.getLevelCount().get());

        newLevel.incrementAndGet();
        level.setLevelCount(newLevel);
        assertEquals(newLevel.get(),level.getLevelCount().get());

        newLevel.incrementAndGet();
        level.setLevelCount(newLevel);
        assertEquals(newLevel.get(),level.getLevelCount().get());


    }


}