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

    public static void printTable(HashTable hashTable)
    {
        if (hashTable == null)
        {
            System.out.println("hashTable is null");
            return;
        }

        HashTableEntry[] table = hashTable.getTable();

        if (table.length == 0)
        {
            System.out.println("hashTable is empty");
            return;
        }

        for (int i = 0; i < table.length; i++)
        {
            System.out.println(table[i]);
        }

        return;
    }
}
