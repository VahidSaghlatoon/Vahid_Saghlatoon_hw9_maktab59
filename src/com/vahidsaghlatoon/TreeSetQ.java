package com.vahidsaghlatoon;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetQ {


    public static void main(String[] args) {
        //new object from treeSetEx class
        TreeSetQ treeSetQ = new TreeSetQ();
        //new treeSet
        Set<Character> treeSet1 = new TreeSet<>();
        treeSet1 = treeSetQ.SetRandomChars(treeSet1);
        treeSetQ.printTreeSetElements("Tree set 1", treeSet1);
        //new treeSet
        Set<Character> treeSet2 = new TreeSet<>();
        treeSet2 = treeSetQ.SetRandomChars(treeSet2);
        treeSetQ.printTreeSetElements("Tree set 2", treeSet2);

        Set<Character> combinationTreeSets ;
        combinationTreeSets = treeSetQ.combination(treeSet1, treeSet2);
        treeSetQ.printTreeSetElements("combination of treeSet 1 and 2",combinationTreeSets);

        Set<Character> share ;
        share = treeSetQ.share(treeSet1, treeSet2);
        treeSetQ.printTreeSetElements("share of treeSet 1 and 2",share);
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
        return new TreeSet<>(){{addAll(treeSet1); addAll(treeSet2);}};
    }

    public Set<Character> share(Set<Character> treeSet1, Set<Character> treeSet2)
    {
        Set<Character> share = new TreeSet<>();
        for (char newChar : treeSet1) {
            if (treeSet2.contains(newChar))
                share.add(newChar);
        }
        return share ;
    }
}


