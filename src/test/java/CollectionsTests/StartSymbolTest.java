package CollectionsTests;

import com.JavaCollectionsFramework.CollectionsDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StartSymbolTest {

    @Test
    public void testStartSymbol() {
        List<String> list = new ArrayList<>();
        list.add("10000000");
        list.add("10000001");
        list.add("10000002");
        list.add("20000000");
        list.add("20000001");
        list.add("20000002");
        list.add("30000000");
        list.add("40000000");

        Assertions.assertEquals(3, CollectionsDemo.stringsWithStartSymbol(list, '1'));
        Assertions.assertEquals(3, CollectionsDemo.stringsWithStartSymbol(list, '2'));
        Assertions.assertEquals(1, CollectionsDemo.stringsWithStartSymbol(list, '3'));
        Assertions.assertEquals(0, CollectionsDemo.stringsWithStartSymbol(list, 'a'));

    }
}
