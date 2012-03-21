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

        int keyHashCode = abs(key.hashCode());
        String absoluteHexString = Integer.toHexString(keyHashCode);
        String lastDigit = absoluteHexString.substring(absoluteHexString.length() - 1);

        int index = Integer.parseInt(lastDigit, 16);

        return index;
    }

    @Override
    public String toString()
    {
        return "key=" + key + ", value=" + value;
    }
}
