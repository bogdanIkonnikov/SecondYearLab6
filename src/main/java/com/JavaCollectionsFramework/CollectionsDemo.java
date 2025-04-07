package com.JavaCollectionsFramework;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
public class CollectionsDemo {
    public static int stringsWithStartSymbol(List<String> list, char startSymbol) {
        int counter = 0;
        for (String s : list) {
            if (startSymbol == s.charAt(0)) {
                counter++;
            }
        }
        return counter;
    }
    public static int humansWithSameLastName(List<Human> list, Human human) {
        int counter = 0;
        for (Human h : list) {
            if (h.getLastName().equals(human.getLastName())) {
                counter++;
            }
        }
        return counter;
    }
    public static List<Human> humansWithoutChosen(List<Human> list, Human human) {
        List<Human> humansWithoutChosen = new ArrayList<>();
        for (Human h : list) {
            if (!h.equals(human)) {
                humansWithoutChosen.add(h);
            }
        }
        return humansWithoutChosen;
    }

    public static List<HashSet<Integer>> hashSetsWithoutIntersection(List<HashSet<Integer>> list,
                                                                     HashSet<Integer> hashSet) {
        List<HashSet<Integer>> hashSetsWithoutIntersection = new ArrayList<>();
        for (HashSet<Integer> h : list) {
            for (Integer i : h) {
                if (!hashSet.contains(i)) {
                    hashSetsWithoutIntersection.add(h);
                }
            }
        }
        return hashSetsWithoutIntersection;
    }

    public static List<Human> listOfOldest(List<Human> list) {
        List<Human> humans = new ArrayList<>();
        list.sort(Comparator.comparing(Human::getAge));
        for (int i = list.size() - 1; i >=0; i--) {
            if (list.get(i).getAge() == list.get(list.size()-1).getAge()) {
                humans.add(list.get(i));
            }
        }
        return humans;
    }

    public static List<Human> listOfHumansSort(List<Human> list) {
        TreeSet<Human> humans = new TreeSet<>(Comparator.comparing(Human::getFullName));
        humans.addAll(list);
        return new ArrayList<>(humans);
    }

    public static List<Human> listOfChosenHumans(HashMap<Integer, Human> humans, HashSet<Integer> keys) {
        List<Human> humansChosen = new ArrayList<>();
        for (int i : humans.keySet()) {
            if (keys.contains(i)) {
                humansChosen.add(humans.get(i));
            }
        }
        return humansChosen;
    }

    public static List<Human> listOfChosenHumans(HashMap<Integer, Human> humans) {
        List<Human> humansChosen = new ArrayList<>();
        for (Human h : humans.values()) {
            if (h.getAge() >= 18) {
                humansChosen.add(h);
            }
        }
        return humansChosen;
    }

    public static HashMap<Integer, Integer> mapIdAge(HashMap<Integer, Human> humans) {
        HashMap<Integer, Integer> mapIdAge = new HashMap<>();
        for (int i : humans.keySet()) {
            mapIdAge.put(i, humans.get(i).getAge());
        }
        return mapIdAge;
    }

    public static HashMap<Integer, List<Human>> mapAgeList(List<Human> humans) {
        HashMap<Integer, List<Human>> mapAgeList = new HashMap<>();
        for (Human h : humans) {
            if (!mapAgeList.containsKey(h.getAge())) {
                mapAgeList.put(h.getAge(), new ArrayList<>());
            }
            mapAgeList.get(h.getAge()).add(h);
        }
        return mapAgeList;
    }

    public static HashMap<Integer, HashMap<Character, List<Human>>> mapAgeToLetterToList(List<Human> humans) {
        HashMap<Integer, HashMap<Character, List<Human>>> map = new HashMap<>();
        for (Human h : humans) {
            if (!map.containsKey(h.getAge())) {
                map.put(h.getAge(), new HashMap<>());
            }
            if (!map.get(h.getAge()).containsKey(h.getLastName().charAt(0))) {
                map.get(h.getAge()).put(h.getLastName().charAt(0), new ArrayList<>());
            }
            map.get(h.getAge()).get(h.getLastName().charAt(0)).add(h);
        }
        return map;
    }

}
