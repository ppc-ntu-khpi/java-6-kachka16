import java.util.Arrays;

/**
 * Клас тестування для запуску програми.
 * Створюємо матрицю і перевіряємо, чи правильно працює алгоритм.
 */

public class TestResilt{
/**
 * Головний метод програми.
 * Створює матрицю, виводить її та знаходить рядок
 * з максимальною сумою елементів.
 */    
        public static void main(String[] args) {
/**Тестова матриця розміром 4х4*/
        short [][] matrix = {
        {2,4,5,6},
        {7,4,2,8},
        {7,1,9,9},
        {8,3,1,5}
    };

/**Вивід матриці*/
        System.out.println("-----Matrix-----");
        for(short[] row:matrix)
        System.out.println(Arrays.toString(row));
        System.out.println("----------------");

/**Знаходить рядок з максимальною сумою елементів.
* resultIndex[0] — це максимальна сума
* resultIndex[1] — це номер рядка у матриці
*/
        int[] resultIndex = Exercise.findrowWithMaxSum(matrix);
        System.out.println("Row with max sum is " + resultIndex[1]);
        System.out.println("Max sum is " + resultIndex[0]);
    }
    
}
