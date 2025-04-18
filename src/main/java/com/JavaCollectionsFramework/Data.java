package com.JavaCollectionsFramework;

import java.util.Iterator;
import java.util.NoSuchElementException;

@lombok.Data
public class Data implements Iterable<Integer> {
    private String name;
    private Group[] groups;

    public Data(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }

    public int getCountOfGroups() {
        return groups.length;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new DataIterator();
    }

    private class DataIterator implements Iterator<Integer> {
        private int groupIndex = 0;
        private int numIndex = 0;

        @Override
        public boolean hasNext() {
            while (groupIndex < groups.length) {
                if (numIndex < groups[groupIndex].getNums().length) {
                    return true;
                } else {
                    groupIndex++;
                    numIndex = 0;
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return groups[groupIndex].getNums()[numIndex++];
        }
    }
}