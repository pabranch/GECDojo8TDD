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
}
