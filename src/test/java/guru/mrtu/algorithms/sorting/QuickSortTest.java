package guru.mrtu.algorithms.sorting;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.java.quickcheck.generator.iterable.Iterables;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Theories.class)
public class QuickSortTest {

    private final static Random RND = new Random();

    @DataPoints("numbersArray")
    public static Iterable<Integer[]> numbersArray() {
        return Iterables.toIterable(
            () -> RND.ints()
                .limit(RND.nextInt(10000) + 1)
                .boxed()
                .toArray(Integer[]::new));
    }

    @Theory
    public void filenameIncludesUsername(@FromDataPoints("numbersArray") Integer[] values) {
        assertEquals("Lists must match", sortArrayDefault(values), sortArrayQuick(values));
    }

    private Collection<Integer> sortArrayDefault(Integer[] values) {
        List<Integer> integerList = Arrays.asList(values);
        Collections.sort(integerList);
        return integerList;
    }

    private Collection<Integer> sortArrayQuick(Integer[] values) {
        List<Integer> integerList = Arrays.asList(values);
        QuickSort<Integer> quickSort = new QuickSort<>();
        return quickSort.sort(integerList);
    }
}