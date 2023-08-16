import java.util.Random;

//Есть одномерный массив, заполненный случайными
//числами. На основании данных этого массива нужно:
// ■ Создать одномерный массив, содержащий только
//четные числа из первого массива;
// ■ Создать одномерный массив, содержащий только
//нечетные числа из первого массива;
// ■ Создать одномерный массив, содержащий только
//отрицательные числа из первого массива;
// ■ Создать одномерный массив, содержащий только
//положительные числа из первого массива.

public class Task10 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] originalArray = new int[15];

        for (int i = 0; i < originalArray.length; ++i) {
            originalArray[i] = random.nextInt(-100, 100);
        }

        int evenCount = 0;
        int oddCount = 0;
        int negativeCount = 0;
        int positiveCount = 0;

        for (int num : originalArray) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            }
        }

        int[] evenArray = new int[evenCount];
        int[] oddArray = new int[oddCount];
        int[] negativeArray = new int[negativeCount];
        int[] positiveArray = new int[positiveCount];

        int evenIndex = 0;
        int oddIndex = 0;
        int negativeIndex = 0;
        int positiveIndex = 0;

        for (int num : originalArray) {
            if (num % 2 == 0) {
                evenArray[evenIndex++] = num;
            } else {
                oddArray[oddIndex++] = num;
            }
            if (num < 0) {
                negativeArray[negativeIndex++] = num;
            } else if (num > 0) {
                positiveArray[positiveIndex++] = num;
            }
        }

        System.out.println("Масив випадкових чисел:");
        printArray(originalArray);

        System.out.println("Масив парних чисел:");
        printArray(evenArray);

        System.out.println("Масив непарних чисел:");
        printArray(oddArray);

        System.out.println("Масив від'ємних чисел:");
        printArray(negativeArray);

        System.out.println("Масив додатніх чисел:");
        printArray(positiveArray);
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
