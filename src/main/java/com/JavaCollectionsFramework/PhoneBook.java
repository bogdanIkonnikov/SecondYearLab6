package com.JavaCollectionsFramework;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
public class PhoneBook {
    private HashMap<Human, List<String>> map;
    public void addNumber(Human human, String number) {
        if (!map.containsKey(human)) {
            map.put(human, new ArrayList<>());
        }
        map.get(human).add(number);
    }
    public void deleteNumber(Human human, String number) {
        if (map.containsKey(human)) {
            map.get(human).remove(number);
        }
    }

    public List<String> getNumbers(Human human) {
        return map.get(human);
    }

    public Human getHuman(String number) {
        for (Human human : map.keySet()) {
            if (map.get(human).contains(number)) {
                return human;
            }
        }
        return null;
    }

    public HashMap<Human, List<String>> getBookByLastNamePart(String lastNamePart) {
        HashMap<Human, List<String>> book = new HashMap<>();
        for (Human human : map.keySet()) {
            if (human.getLastName().startsWith(lastNamePart)) {
                book.put(human, map.get(human));
            }
        }
        return book;
    }
}
