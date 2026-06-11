import java.util.Arrays;
/**
 * 12. Знайти рядок матриці розміром N x M з максимальною сумою елементів
 * Клас, який містить методи для роботи з матрицями. 
 * 
 * @author Левковська Марія, 35 група
 * @version 1.0
 */

public class Exercise{
/**
 * Метод шукає рядок у матриці, елементи якого в сумі дають найбільше число.
 * 
 * Рахує суму для кожного рядка та щаписує в масив sumOfRows
 * Робить копію цього масиву під назвою origMatrix для того,щоб зберегти оригінальні індекси рядків.
 * Сортує масив sumOfRows, тепер найбільша сума опинилася в самому кінці
 * Шукає під яким індексом ця сума стояла в оригінальному (origMatrix) масиві.
 * 
 * @param matrix двовимірний масив чисел
 * @return повертає масив із двох чисел
 */

    public static int[] findrowWithMaxSum(short[][] matrix){
    int[] sumOfRows = new int[matrix.length];

    /** Рахуємо суми рядків*/
    for(int i =0; i<matrix.length; i++){
        int sum = 0;
        for(int row=0; row<matrix[i].length; row++){
           sum+=matrix[i][row];
        }   
        sumOfRows[i] = sum;
    }

     /** Копіюємо масив сум, щоб зберегти оригінальні індекси рядків*/
    int[] origMatrix = Arrays.copyOf(sumOfRows, sumOfRows.length);

    /**Сортуємо масив сум за зростанням*/
    Arrays.sort(sumOfRows);

    /**Найбільше число тепер в самому кінці масиву*/
    int maxSum = sumOfRows[sumOfRows.length - 1];

    /**Шукаємо, на якому місці це число стояв до сортування*/
    int maxIndex = 0;
        for (short i = 0; i < origMatrix.length; i++) {
            if (origMatrix[i] == maxSum) {
                maxIndex = i; 
                break;
            }
    }

    /**Повертаємо результат*/
    return new int[]{maxSum, maxIndex+1};
}
}