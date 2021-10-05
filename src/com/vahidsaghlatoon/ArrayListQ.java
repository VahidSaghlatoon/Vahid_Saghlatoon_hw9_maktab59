package com.vahidsaghlatoon;

import java.util.ArrayList;

public class ArrayListQ {

    public static void main(String[] args) {
        ArrayListQ arrayListQ = new ArrayListQ();
        ArrayList<Integer> newIntegerList = new ArrayList<>();
        newIntegerList.add(3);
        newIntegerList.add(7);
        newIntegerList.add(9);
        newIntegerList.add(2);
        newIntegerList.add(5);
        newIntegerList.add(5);
        newIntegerList.add(8);
        newIntegerList.add(5);
        newIntegerList.add(6);
        newIntegerList.add(3);
        newIntegerList.add(4);
        newIntegerList.add(7);
        newIntegerList.add(3);
        newIntegerList.add(1);

        ArrayList<Integer> integers = arrayListQ.partnerNotMatch(newIntegerList);

        for (int element : integers) {
            System.out.print(element + ",");
        }
    }


    public ArrayList<Integer> partnerNotMatch(ArrayList<Integer> arrayList) {
        ArrayList<Integer> newArrList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i = i + 2) {
            if (arrayList.get(i) < arrayList.get(i + 1) || arrayList.get(i).equals(arrayList.get(i + 1))) {
                newArrList.add(arrayList.get(i));
                newArrList.add(arrayList.get(i + 1));
            }

        }
        return newArrList;
    }
}
