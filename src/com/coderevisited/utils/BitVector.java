package com.coderevisited.utils;

/**
 * bit vector with 10 billion bits. methods to to set, toggle, unset a particular bit. Memory used  for storing bits :
 * 1million/32 = (32150 + 1) * 4B = 125004B = 122.07KB
 */
public class BitVector
{

    private int[] bitArray;

    public BitVector(long MAX)
    {
        bitArray = new int[(int) (MAX >> 5) + 1];
    }

    public static void main(String[] args)
    {
        BitVector bitVector = new BitVector(1000000L);
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(783));
        System.out.println(" now setting bit 783  ");
        bitVector.setBit(783);
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(783));
        bitVector.unSet(783);
        System.out.println(" un setting bit 783 ");
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(783));
        bitVector.toggle(783);
        System.out.println(" toggling  bit 783 ");
        System.out.println(" bit 783 is set? ----> " + bitVector.isSet(783));

    }

    public void setBit(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) | (1 << bit);
    }

    public boolean isSet(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        return ((bitArray[index]) & (1 << bit)) != 0;
    }

    public void toggle(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) ^ (1 << bit);
    }

    public void unSet(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) & ~(1 << bit);
    }
}
