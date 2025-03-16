import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        // Ваш код
        int[] result = teams[0]; // Начинаем с первого массива

        for (int i = 1; i < teams.length; i++) {
            result = merge(result, teams[i]); // Сливаем текущий результат с очередным массивом
        }
        return result;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        if (teamA.length < 2 && teamB.length < 2) {
            return null;
        }

        int[] newTeamResult = new int[10];
        int i = 0, j = 0, k = 0;
        while (i+j <10) {
            if (teamA[i] > teamB[j]) {
                newTeamResult[k++] = teamA[i++];
            } else {
                newTeamResult[k++] = teamB[j++];
            }
        }

        return newTeamResult;
    }
}