package com.greenenergycorp.dojo.tdd.hashtable;

public class HashTable
{
    private static final int defaultSize = 16;

    private HashTableEntry[] table;

    public static void main(String[] args)
    {}

    public HashTable()
    {
        setTable(new HashTableEntry[defaultSize]);
    }

    public HashTable(int initialSize)
    {
        setTable(new HashTableEntry[initialSize]);
    }

    public HashTableEntry[] getTable()
    {
        return table;
    }

    public void setTable(HashTableEntry[] table)
    {
        this.table = table;
    }
}
