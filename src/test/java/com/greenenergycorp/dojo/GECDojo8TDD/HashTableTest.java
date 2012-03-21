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
}
