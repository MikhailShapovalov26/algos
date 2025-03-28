import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        compare(1);
        compare(2);
        compare(5);
        compare(10);
        compare(13);
        compare(14);
        compare(15);
    }

    public static void compare(int day) {
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = { 21, 1, 20, 23 };
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day, new int[day + 1]);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day, int memory[]) {
        if (day < 1) {
            return 0;
        }
        if (memory[day] != 0) {
            return memory[day];
        }
        // Вычисляем предыдущий день и день, отстоящий на три дня назад
        int prev = day -1;
        int prePrePrev = day - 3;

        // Проверяем, совпадает ли prev или prePrePrev с каким-либо числом в startNumbers
        for (int number : startNumbers) {
            if (prev == number){
                memory[day] = prev; // Сохраняем значение в memory
                return prev;
            } else if (prePrePrev == number){
                memory[day] = prePrePrev; // Сохраняем значение в memory
                return prePrePrev;
            }

        }
        // Если совпадений не найдено, рекурсивно вычисляем значение для текущего дня
        memory[day] = chooseHobbyRecursive(startNumbers, prev, memory) + chooseHobbyRecursive(startNumbers, prePrePrev, memory);

        return memory[day];
    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4; // индексы дней в массиве сдвинуты на 4
            int prev = numbers.get(index - 1); // предыдущее значение
            int prePrePrev = numbers.get(index - 3); // пре-пре-предыдущее значение
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}