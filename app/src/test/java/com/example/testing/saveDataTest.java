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
     * Test method for {@link saveData#getClickNum()}
     */
    @Test
    public void testGetClickNum(){

        saveData entryA = new saveData();
        AtomicInteger expected1 = new AtomicInteger();

        // AtomicInteger(expected1) = 1
        expected1.incrementAndGet();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());

        // AtomicInteger(expected1) = 3
        expected1.incrementAndGet();
        expected1.incrementAndGet();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());

        // AtomicInteger(expected1) = 2
        expected1.getAndDecrement();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());
    }

    /**
     * Test method for {@link saveData#setClickNum(AtomicInteger)}
     */
    @Test
    public void testSetClickNum(){

        saveData entryA = new saveData();
        AtomicInteger expected1 = new AtomicInteger();


        // AtomicInteger(expected1) = 2
        expected1.incrementAndGet();
        expected1.incrementAndGet();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());

        // AtomicInteger(expected1) = 4
        expected1.incrementAndGet();
        expected1.incrementAndGet();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());

        // AtomicInteger(expected1) = 3
        expected1.getAndDecrement();
        entryA.setClickNum(expected1);
        assertEquals(expected1, entryA.getClickNum());


    }

    /**
     * Test method for {@link saveData#getCurrentCustomizations()}
     */
    @Test
    public void testGetCurrentCustomizations(){

        saveData entryA = new saveData();
        int expected1 = 0;

        expected1 = 1;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(2, entryA.getCurrentCustomizations());

        expected1 = 5;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(6, entryA.getCurrentCustomizations());

        expected1 = 10;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(11, entryA.getCurrentCustomizations());

    }

    /**
     * Test method for {@link saveData#setCurrentCustomizations(int)}
     */
    @Test
    public void testSetCurrentCustomizations(){

        saveData entryA = new saveData();
        int expected1 = 0;

        expected1 = 2;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(1, entryA.getCurrentCustomizations());

        expected1 = 6;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(5, entryA.getCurrentCustomizations());

        expected1 = 9;
        entryA.setCurrentCustomizations(expected1);
        assertEquals(expected1, entryA.getCurrentCustomizations());
        assertNotEquals(8, entryA.getCurrentCustomizations());

    }

    /**
     * Test method for {@link saveData#getCurrentProgress()}
     */
    @Test
    public void getCurrentProgress(){
        saveData entryA = new saveData();
        int expected1 = 0;

        expected1 = 25;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(24, entryA.getCurrentProgress());

        expected1 = 50;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(49, entryA.getCurrentProgress());

        expected1 = 75;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(74, entryA.getCurrentProgress());

    }

    /**
     * Test method for {@link saveData#setCurrentProgress(int)}
     */
    @Test
    public void setCurrentProgress(){

        saveData entryA = new saveData();
        int expected1 = 0;

        expected1 = 100;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(99, entryA.getCurrentProgress());

        expected1 = 90;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(89, entryA.getCurrentProgress());

        expected1 = 80;
        entryA.setCurrentProgress(expected1);
        assertEquals(expected1, entryA.getCurrentProgress());
        assertNotEquals(79, entryA.getCurrentProgress());

    }

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