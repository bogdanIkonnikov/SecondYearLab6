package CollectionsTests;

import com.JavaCollectionsFramework.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AllTests {

    @Test
    void testAddNumber() {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        Human human = new Human("John", "M.", "Doe", 25);
        phoneBook.addNumber(human, "123456789");
        assertEquals(1, phoneBook.getNumbers(human).size());
    }

    @Test
    void testDeleteNumber() {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        Human human = new Human("John", "M.", "Doe", 25);
        phoneBook.addNumber(human, "123456789");
        phoneBook.deleteNumber(human, "123456789");
        assertTrue(phoneBook.getNumbers(human).isEmpty());
    }

    @Test
    void testGetHuman() {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        Human human = new Human("John", "M.", "Doe", 25);
        phoneBook.addNumber(human, "123456789");
        assertEquals(human, phoneBook.getHuman("123456789"));
    }

    @Test
    void testGetBookByLastNamePart() {
        PhoneBook phoneBook = new PhoneBook(new HashMap<>());
        Human human = new Human("John", "M.", "Doe", 25);
        phoneBook.addNumber(human, "123456789");
        assertEquals(1, phoneBook.getBookByLastNamePart("Do").size());
    }

    @Test
    void testStringsWithStartSymbol() {
        List<String> list = Arrays.asList("apple", "banana", "apricot");
        assertEquals(2, CollectionsDemo.stringsWithStartSymbol(list, 'a'));
    }

    @Test
    void testHumansWithoutChosen() {
        List<Human> list = Arrays.asList(
                new Human("John", "M.", "Doe", 25),
                new Human("Jane", "A.", "Doe", 30)
        );
        Human human = new Human("John", "M.", "Doe", 25);
        assertEquals(1, CollectionsDemo.humansWithoutChosen(list, human).size());
    }

    @Test
    void testListOfOldest() {
        List<Human> list = Arrays.asList(
                new Human("John", "M.", "Doe", 25),
                new Human("Jane", "A.", "Doe", 30),
                new Human("Jake", "B.", "Smith", 30)
        );
        assertEquals(2, CollectionsDemo.listOfOldest(list).size());
    }

    @Test
    void testListOfHumansSort() {
        List<Human> list = Arrays.asList(
                new Human("John", "M.", "Doe", 25),
                new Human("Jane", "A.", "Doe", 30)
        );
        List<Human> sorted = CollectionsDemo.listOfHumansSort(list);
        assertEquals("Jane", sorted.get(0).getFirstName());
    }

    @Test
    void testListOfChosenHumansWithKeys() {
        HashMap<Integer, Human> humans = new HashMap<>();
        humans.put(1, new Human("John", "M.", "Doe", 25));
        humans.put(2, new Human("Jane", "A.", "Doe", 30));
        HashSet<Integer> keys = new HashSet<>(Collections.singletonList(1));
        assertEquals(1, CollectionsDemo.listOfChosenHumans(humans, keys).size());
    }

    @Test
    void testListOfChosenHumansAdults() {
        HashMap<Integer, Human> humans = new HashMap<>();
        humans.put(1, new Human("John", "M.", "Doe", 25));
        humans.put(2, new Human("Jane", "A.", "Doe", 17));
        assertEquals(1, CollectionsDemo.listOfChosenHumans(humans).size());
    }

    @Test
    void testMapIdAge() {
        HashMap<Integer, Human> humans = new HashMap<>();
        humans.put(1, new Human("John", "M.", "Doe", 25));
        humans.put(2, new Human("Jane", "A.", "Doe", 30));
        HashMap<Integer, Integer> map = CollectionsDemo.mapIdAge(humans);
        assertEquals(25, map.get(1));
    }

    @Test
    void testMapAgeList() {
        List<Human> humans = Arrays.asList(
                new Human("John", "M.", "Doe", 25),
                new Human("Jane", "A.", "Doe", 25)
        );
        HashMap<Integer, List<Human>> map = (HashMap<Integer, List<Human>>) CollectionsDemo.mapAgeList(humans);
        assertEquals(2, map.get(25).size());
    }

    @Test
    void testMapAgeToLetterToList() {
        List<Human> humans = Arrays.asList(
                new Human("John", "M.", "Doe", 25),
                new Human("Jane", "A.", "Smith", 25)
        );
        HashMap<Integer, HashMap<Character, List<Human>>> map = (HashMap<Integer, HashMap<Character, List<Human>>>) CollectionsDemo.mapAgeToLetterToList(humans);
        assertEquals(1, map.get(25).get('D').size());
    }


    @Test
    void testGetFaculty() {
        Student student = new Student("John", "M.", "Doe", 20, "Engineering");
        assertEquals("Engineering", student.getFaculty());
    }

    @Test
    void testSetFaculty() {
        Student student = new Student("John", "M.", "Doe", 20, "Engineering");
        student.setFaculty("Mathematics");
        assertEquals("Mathematics", student.getFaculty());
    }

    @Test
    void testFullNameInheritance() {
        Student student = new Student("John", "M.", "Doe", 20, "Engineering");
        assertEquals("John M. Doe", student.getFullName());
    }

    @Test
    void testAgeInheritance() {
        Student student = new Student("John", "M.", "Doe", 20, "Engineering");
        assertEquals(20, student.getAge());
    }

    @Test
    void testGroupCreation() {
        Group group = new Group(1, new int[]{1, 2, 3});
        assertEquals(1, group.getId());
        assertArrayEquals(new int[]{1, 2, 3}, group.getNums());
    }

    @Test
    void testSetNums() {
        Group group = new Group(1, new int[]{1, 2, 3});
        group.setNums(new int[]{4, 5, 6});
        assertArrayEquals(new int[]{4, 5, 6}, group.getNums());
    }

    @Test
    void testDataCreation() {
        Group[] groups = {
                new Group(1, new int[]{1, 2, 3}),
                new Group(2, new int[]{4, 5})
        };
        Data data = new Data("TestData", groups);
        assertEquals("TestData", data.getName());
        assertEquals(2, data.getCountOfGroups());
    }

    @Test
    void testDataIterator() {
        Group[] groups = {
                new Group(1, new int[]{1, 2, 3}),
                new Group(2, new int[]{4, 5})
        };
        Data data = new Data("TestData", groups);
        Iterator<Integer> iterator = data.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertEquals(2, iterator.next());
        assertEquals(3, iterator.next());
        assertEquals(4, iterator.next());
        assertEquals(5, iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    void testGetAllNumbers() {
        Group[] groups = {
                new Group(1, new int[]{1, 2, 3}),
                new Group(2, new int[]{4, 5})
        };
        Data data = new Data("TestData", groups);
        List<Integer> allNumbers = DataDemo.getAllNumbers(data);

        assertEquals(5, allNumbers.size());
        assertEquals(List.of(1, 2, 3, 4, 5), allNumbers);
    }


}
