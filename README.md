# Звіт о виконання роботи

## Завдання 1

> Модифікувати стартовий код таким чином, щоб метод findrowWithMaxSum класу Exercise містив код обчислення значення у відповідності до обраного вами завдання - 12 варіант. Рядок, який виводиться у результаті виконання методу main класу TestResult теж слід скоригувати у відповідності до специфіки завдання.

> 12 варіант - Перевірити чи задане слово є паліндромом (метод Calculate має повернути булевське значення)

1. Клас Exercise Клас Exercise приймає двовимірний масив, рахує суму елементів для кожного окремого рядка, знаходить серед них найбільшу суму, визначає порядковий номер цього рядка, повертає ці два значення у вигляді масиву чисел int[]. Клас є універсальним, не містить інтерфейсу користувача чи виведення в консоль - лише чисту логіку.
2. В класі TestResult готова тестова матриця чисел, яка передається в метод класу Exercise. Через метод main здійснюється виклик логіки та виводиться фінальний зрозумілий звіт для користувача: який саме рядок має максимальну суму та чому ця сума дорівнює. Метод main не містить жодних обчислень чи циклів для підрахунку сум.
   
### Exercise.java
``` java
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
```

### TestResult.java
``` java
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

```

## Результат

![task1](https://github.com/ppc-ntu-khpi/java-6-kachka16/blob/master/img/result.png?raw=true)
