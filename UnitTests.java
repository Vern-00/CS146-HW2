import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTests {

    // Lomuto Tests

    @Test
    void lomutoSortedArrayTest() {
        int[] array = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int pivotIndex = Partitions.lomutoPartition(array, 0, array.length - 1);

        assertEquals(9, pivotIndex);
        assertArrayEquals(
            new int[]{10, 17, 19, 21, 44, 55, 57, 63, 65, 67},
            array
        );
    }

    @Test
    void lomutoEmptyArrayTest() {
        int[] array = {};

        // with input checks added, empty arrays should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            Partitions.lomutoPartition(array, 0, -1);
        });
    }

    @Test
    void lomutoUnsortedArrayTest() {
        int[] array = {84, 3, 7, 1, 9, 6, 2, 5};

        int pivotIndex = Partitions.lomutoPartition(array, 0, array.length - 1);

        assertEquals(3, pivotIndex);
        assertArrayEquals(
            new int[]{3, 1, 2, 5, 9, 6, 7, 84},
            array
        );
    }

    // Hoare Tests

    @Test
    void hoareSortedArrayTest() {
        int[] array = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};

        int splitIndex = Partitions.hoarePartition(array, 0, array.length - 1);

        assertEquals(0, splitIndex);
        assertArrayEquals(
            new int[]{10, 17, 19, 21, 44, 55, 57, 63, 65, 67},
            array
        );
    }

    @Test
    void hoareEmptyArrayTest() {
        int[] array = {};

        // with input checks added, empty arrays should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            Partitions.hoarePartition(array, 0, -1);
        });
    }

    @Test
    void hoareUnsortedArrayTest() {
        int[] array = {84, 3, 7, 1, 9, 6, 2, 5};

        int splitIndex = Partitions.hoarePartition(array, 0, array.length - 1);

        assertEquals(6, splitIndex);
        assertArrayEquals(
            new int[]{5, 3, 7, 1, 9, 6, 2, 84},
            array
        );
    }
}
