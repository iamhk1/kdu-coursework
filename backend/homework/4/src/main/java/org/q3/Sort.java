package org.q3;
import logger.Log;

import java.util.*;
public class Sort {
    public static  <T> void swapValues(T[]array ,int index1,int index2)
    {
        if(index1<0||index1>=array.length||index2<0||index2>=array.length)
            throw new IllegalArgumentException("Invalid Index Entered");
        T temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;

    }
    public static void main(String []args)
    {
        Integer[] intArray = {13, 12, 33, 34, 55};
        Log.info("Original Integer Array: " + Arrays.toString(intArray));
        swapValues(intArray, 1, 3);
        Log.info("Array after exchanging elements: " + Arrays.toString(intArray));
        String[] strArray = {"abc", "leng", "ren", "dally", "elc"};
        Log.info("Original String Array: " + Arrays.toString(strArray));
        swapValues(strArray, 0, 4);
        Log.info("Array after exchanging elements: " + Arrays.toString(strArray));

    }
}
