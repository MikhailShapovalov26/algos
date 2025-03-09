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
        int[] newTeamsA = new int[teams[0].length];
        int[] newTeamsB = new int[teams[1].length];
        int[] newTeamsC = new int[teams[2].length];
        for (int i = 0; i < newTeamsA.length; i++) {
            newTeamsA[i] = teams[0][i];

        }
        for (int i = 0; i < newTeamsB.length; i++) {
            newTeamsB[i] = teams[1][i];

        }
        for (int i = 0; i < newTeamsC.length; i++) {
            newTeamsC[i] = teams[2][i];

        }
        return Arrays.copyOfRange(merge(merge(newTeamsA, newTeamsB), newTeamsC), 0, 10);

    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        if (teamA.length < 2 && teamB.length < 2) {
            return null;
        }

        int[] newTeamResult = new int[teamA.length + teamB.length];
        int i = 0, j = 0, k = 0;
        while (i < teamA.length && j < teamB.length) {
            if (teamA[i] > teamB[j]) {
                newTeamResult[k++] = teamA[i++];
            } else {
                newTeamResult[k++] = teamB[j++];
            }
        }
        while (i < teamA.length) {
            newTeamResult[k++] = teamA[i++];
        }
        while (j < teamB.length) {
            newTeamResult[k++] = teamB[j++];
        }

        return newTeamResult;
    }
}