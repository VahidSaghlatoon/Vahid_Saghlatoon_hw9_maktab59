package com.vahidsaghlatoon;

import java.util.Random;
import java.util.Set;

public class TreeSet {


    public static void main(String[] args) {
        //new object from treeSetEx class
        TreeSet treeSet = new TreeSet();
        //new treeSet
        Set<Character> treeSet1 = new java.util.TreeSet();
        treeSet1 = treeSet.SetRandomChars(treeSet1);
        treeSet.printTreeSetElements("Tree set 1", treeSet1);
        //new treeSet
        Set<Character> treeSet2 = new java.util.TreeSet();
        treeSet2 = treeSet.SetRandomChars(treeSet2);
        treeSet.printTreeSetElements("Tree set 2", treeSet2);

        Set<Character> combinationTreeSets ;
        combinationTreeSets = treeSet.combination(treeSet1, treeSet2);
        treeSet.printTreeSetElements("combination of treeSet 1 and 2",combinationTreeSets);

        Set<Character> share ;
        share = treeSet.share(treeSet1, treeSet2);
        treeSet.printTreeSetElements("share of treeSet 1 and 2",share);
    }

    public Set<Character> SetRandomChars(Set<Character> treeSet) {
        Random random = new Random();
        while (treeSet.size() < 10) {
            int randomInt = random.nextInt(97, 123);
            Character newChar = (char) randomInt;
            treeSet.add(newChar);
        }
        return treeSet;
    }

    public void printTreeSetElements(String name, Set<Character> treeSet) {
        System.out.println(name);
        for (Character chars : treeSet) {
            System.out.print(chars + " ");
        }
        System.out.println();
    }

    public Set<Character> combination(Set<Character> treeSet1, Set<Character> treeSet2) {
        return new java.util.TreeSet(){{addAll(treeSet1); addAll(treeSet2);}};
    }

    public Set<Character> share(Set<Character> treeSet1, Set<Character> treeSet2)
    {
        Set<Character> share = new java.util.TreeSet();
        for (char newChar : treeSet1) {
            if (treeSet2.contains(newChar))
                share.add(newChar);
        }
        return share ;
    }
}


