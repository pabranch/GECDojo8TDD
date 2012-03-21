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

        HashTable.printTable(hashTableUnderTest);

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
}
