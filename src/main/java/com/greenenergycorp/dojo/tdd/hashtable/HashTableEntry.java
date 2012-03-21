package com.greenenergycorp.dojo.tdd.hashtable;

import static java.lang.Math.abs;

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
        if (key == null || key.length() == 0)
        {
            throw new IllegalArgumentException("key cannot be null or empty");
        }

        String absoluteHexString = Integer.toHexString(abs(key.hashCode()));
        String lastDigit = absoluteHexString.substring(absoluteHexString.length() - 1);

        return Integer.parseInt(lastDigit, 16);
    }

    @Override
    public String toString()
    {
        return "key=" + key + ", value=" + value;
    }
}
