package com.vahidsaghlatoon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class HashMapQ {




        public static void main(String[] args) {
            String str = "abc";
            Set<String> permutations = getPermutations(str);

            int i = 1;
            for(String s : permutations){
                System.out.println(i++ + ": " + s);
            }

            /* check correctness */
            System.out.println("\nThere must be " +  numOfArrangements(str) + " values");

        }

        public static Set<String> getPermutations(String remained){
            if(remained.length() <= 1){
                Set<String> set = new HashSet<String>();
                set.add(remained);
                return set;
            }

            char c = remained.charAt(0);
            Set<String> old_permutations = getPermutations(remained.substring(1));
            Set<String> new_permutations = new HashSet<String>();

            for(String old_s : old_permutations){
                for(int j = 0; j < old_s.length(); j++){
                    new_permutations.add(old_s.substring(0, j) + c + old_s.substring(j));
                }
                new_permutations.add(old_s + c);
            }

            return new_permutations;
        }

        public static int factorial(int num){
            int result = 1;

            for (int i = 1; i <= num; i++) {
                result = result * i;
            }

            return result;
        }

        public static int numOfArrangements(String str){
            HashMap<Character, Integer> hm = new HashMap<>();

            for(char key : str.toCharArray()){
                if(hm.containsKey(key))
                    hm.put(key, hm.get(key) + 1);
                else hm.put(key, 1);
            }

            int divisor = 1;
            for(Integer value : hm.values()){
                divisor *= factorial(value);
            }

            return factorial(str.length()) / divisor;
        }
    }

