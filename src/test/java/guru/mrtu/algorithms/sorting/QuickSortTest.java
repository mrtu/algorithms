package guru.mrtu.algorithms.sorting;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Random;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class QuickSortTest {

    private final static Random RND = new Random();

    @DataPoints("numbersArray")
    public static Integer[] numbersArray() {
        return RND.ints()
                .limit(RND.nextInt(10000) + 1)
                .boxed()
                .toArray(Integer[]::new);
    }

    @Theory
    public void filenameIncludesUsername(@FromDataPoints("numbersArray") Integer[] values) {
        assertTrue(values.length > 0);
    }
}