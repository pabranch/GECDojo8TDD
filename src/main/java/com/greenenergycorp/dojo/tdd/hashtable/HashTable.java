package com.greenenergycorp.dojo.tdd.hashtable;

public class HashTable
{
    private HashTableEntry[] table;

    public static void main(String[] args)
    {}

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

        System.out.println("-------------------------");

        for (int i = 0; i < table.length; i++)
        {
            System.out.println("i=" + i + ", " + table[i]);
        }

        return;
    }
}
