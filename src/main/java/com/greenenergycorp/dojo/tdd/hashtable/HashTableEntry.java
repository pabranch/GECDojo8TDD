package com.greenenergycorp.dojo.tdd.hashtable;

public class HashTableEntry
{
    String key;

    int value;

    public HashTableEntry()
    {}

    public HashTableEntry(String key, int value)
    {
        this.key = key;
        this.value = value;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public static int getIndex(String key)
    {
        return -1;
    }

    @Override
    public String toString()
    {
        return "key=" + key + ", value=" + value;
    }
}
