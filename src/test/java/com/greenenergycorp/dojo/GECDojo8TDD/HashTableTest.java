package com.greenenergycorp.dojo.GECDojo8TDD;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.greenenergycorp.dojo.tdd.hashtable.HashTable;
import com.greenenergycorp.dojo.tdd.hashtable.HashTableEntry;

public class HashTableTest
{
    HashTable hashTableUnderTest;
    HashTableEntry[] table;

    @Before
    public void setUp()
    {
        hashTableUnderTest = new HashTable();
        table = hashTableUnderTest.getTable();
    }

    @Test
    public void testEmptyHashTable()
    {
        final int emptyTableSize = 0;
        hashTableUnderTest = new HashTable(emptyTableSize);
        table = hashTableUnderTest.getTable();

        assertEquals("Empty hash table", emptyTableSize, table.length);
    }

    @Test
    public void testDefaultHashTableNothingAdded()
    {
        final int defaultTableSize = 16;
        assertEquals("Default hash table", defaultTableSize, table.length);

        HashTable.printTable(hashTableUnderTest);

        for (int i = 0; i < defaultTableSize; i++)
        {
            HashTableEntry expectedTableEntry = null;
            assertEquals("Default hash table", expectedTableEntry, table[i]);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexWithEmptyKey()
    {
        String key = "";
        HashTableEntry.getIndex(key);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIndexWithNullKey()
    {
        String key = null;
        HashTableEntry.getIndex(key);
    }

    @Test
    public void testIndexWithValidKey_1()
    {
        String key = "testKey";

        int expectedIndex = 3;
        int actualIndex = HashTableEntry.getIndex(key);

        assertEquals("Index with valid key 1", expectedIndex, actualIndex);
    }

    @Test
    public void testIndexWithValidKey_2()
    {
        String key = "testKey2";

        int expectedIndex = 11;
        int actualIndex = HashTableEntry.getIndex(key);

        assertEquals("Index with valid key 2", expectedIndex, actualIndex);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullEntry()
    {
        HashTableEntry entry = null;

        hashTableUnderTest.add(entry);
    }

    @Test
    public void testAddOneEntry()
    {
        String key = "testKey";
        int value = 0;
        int index = 3;

        HashTableEntry entry = new HashTableEntry(key, value);

        hashTableUnderTest.add(entry);

        HashTableEntry entryAfterAdd = table[index];

        assertEquals("Add one entry", entry, entryAfterAdd);
    }

    @Test
    public void testAddTwoEntries()
    {
        String firstKey = "testKey";
        int firstValue = 0;
        int firstKeyIndex = 3;

        HashTableEntry firstEntry = new HashTableEntry(firstKey, firstValue);
        hashTableUnderTest.add(firstEntry);
        HashTableEntry firstEntryAfterAdd = table[firstKeyIndex];

        assertEquals("Add two entries, first entry: ", firstEntry, firstEntryAfterAdd);

        String secondKey = "testKey2";
        int secondValue = 1;
        int secondKeyIndex = 11;

        HashTableEntry secondEntry = new HashTableEntry(secondKey, secondValue);
        hashTableUnderTest.add(secondEntry);
        HashTableEntry secondEntryAfterAdd = table[secondKeyIndex];

        assertEquals("Add two entries, second entry: ", secondEntry, secondEntryAfterAdd);
    }

    @Test
    public void testAddTwoEntriesWithCollision()
    {
        String firstKey = "testKey";
        int firstValue = 0;
        int firstKeyIndex = 3;

        HashTableEntry firstEntry = new HashTableEntry(firstKey, firstValue);
        hashTableUnderTest.add(firstEntry);
        HashTableEntry firstEntryAfterAdd = table[firstKeyIndex];

        String secondKey = "worldsCollide";
        int secondValue = 1;
        int secondKeyComputedIndex = 4;

        // "Now this is what it's like when worlds collide"  -Powerman 5000
        // getIndex() for a key of "worldsCollide" is 3. Since the requirement
        // is to use open addressing for hash collisions, the computed index
        // for a collision is to use the next available slot, which is 4.

        HashTableEntry secondEntry = new HashTableEntry(secondKey, secondValue);
        hashTableUnderTest.add(secondEntry);
        HashTableEntry secondEntryAfterAdd = table[secondKeyComputedIndex];

        assertEquals("Add two entries with collision, first entry: ", firstEntry, firstEntryAfterAdd);
        assertEquals("Add two entries with collision, second entry: ", secondEntry, secondEntryAfterAdd);
    }

    @Test
    public void testAddThreeEntriesWithCollisionAndAdjacentIndex()
    {
        String firstKey = "testKey";
        int firstValue = 0;
        int firstKeyIndex = 3;

        HashTableEntry firstEntry = new HashTableEntry(firstKey, firstValue);
        hashTableUnderTest.add(firstEntry);

        HashTable.printTable(hashTableUnderTest);

        String secondKey = "theBlackEyedKeys!";
        int secondValue = 1;
        int secondKeyIndex = 4;

        HashTableEntry secondEntry = new HashTableEntry(secondKey, secondValue);
        hashTableUnderTest.add(secondEntry);

        HashTable.printTable(hashTableUnderTest);

        String thirdKey = "worldsCollide";
        int thirdValue = 2;
        int thirdKeyComputedIndex = 5;

        HashTableEntry thirdEntry = new HashTableEntry(thirdKey, thirdValue);
        hashTableUnderTest.add(thirdEntry);

        HashTable.printTable(hashTableUnderTest);

        HashTableEntry firstEntryAfterAdd = table[firstKeyIndex];
        HashTableEntry secondEntryAfterAdd = table[secondKeyIndex];
        HashTableEntry thirdEntryAfterAdd = table[thirdKeyComputedIndex];

        assertEquals("Add three entries with adjacent collision, first entry: ", firstEntry, firstEntryAfterAdd);
        assertEquals("Add three entries with adjacent collision, second entry: ", secondEntry, secondEntryAfterAdd);
        assertEquals("Add three entries with adjacent collision, third entry: ", thirdEntry, thirdEntryAfterAdd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetWithEmptyKey()
    {
        String key = "";

        hashTableUnderTest.get(key);
    }
}
