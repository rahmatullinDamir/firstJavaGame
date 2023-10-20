import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        drawGameField();
    }

    public static void winGame() {
        System.out.println("Поздравляю!!! ПОБЕДА");
    }

    public static void gameOver() {
        System.out.println("Вы проиграли.......");

    }

    public static void drawGameField() {

        final int[][] defaultPlayerPos = {{2}, {1}}; // x y cords

        char[][] playground = {
                "##########".toCharArray(),
                "##  ######".toCharArray(),
                "##  ######".toCharArray(),
                "##    ####".toCharArray(),
                "## ## ####".toCharArray(),
                "## ## ####".toCharArray(),
                "## ##   ##".toCharArray(),
                "## #######".toCharArray(),
                "##     ###".toCharArray(),
                "#####?####".toCharArray()
        };

        System.out.println("Приветствую в игре ЛАБИРИНТ! Ваша цель дойти до символа '?' игрок обозначается символом '@'");
        System.out.println("Для управления используй клавиши w(вверх)  a(влево) s(вправо) d(вниз)");

        printGame(playground, defaultPlayerPos);

    }

    public static void printGame(char[][] playground, int[][] playerPos) {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if (y == playerPos[1][0] && x == playerPos[0][0]) {
                    playground[y][x] = '$';
                }
                System.out.print(playground[y][x]);
            }
            System.out.println();
        }
        System.out.println("твой ход: ");
        checkUserAnswer(new Scanner(System.in).nextLine(), playground, playerPos);
    }

    public static void checkUserAnswer(String userAnswer, char[][] playGround, int[][] playerPos) {
        int[][] mapWinPos = {{5}, {9}};
        if (userAnswer.length() != 0) {
            switch (userAnswer.charAt(0)) {
                case 'w':
                    if (playGround[playerPos[1][0] - 1][playerPos[0][0]] != '#') {
                        playGround[playerPos[1][0]][playerPos[0][0]] = '#';
                        playerPos[1][0]--;
                    }
                    else {
                        System.out.println("Вы не можете пойти сюда, здесь стена.....");
                    }
                    break;
                case 'a':
                    if (playGround[playerPos[1][0]][playerPos[0][0] - 1] != '#') {
                        playGround[playerPos[1][0]][playerPos[0][0]] = '#';
                        playerPos[0][0]--;
                    }
                    else {
                        System.out.println("Вы не можете пойти сюда, здесь стена.....");
                    }
                    break;
                case 's':
                    if (playGround[playerPos[1][0] + 1][playerPos[0][0]] != '#') {
                        playGround[playerPos[1][0]][playerPos[0][0]] = '#';
                        playerPos[1][0]++;
                    }
                    else {
                        System.out.println("Вы не можете пойти сюда, здесь стена.....");
                    }
                    break;
                case 'd':
                    if (playGround[playerPos[1][0]][playerPos[0][0] + 1] != '#') {
                        playGround[playerPos[1][0]][playerPos[0][0]] = '#';
                        playerPos[0][0]++;
                    }
                    else {
                        System.out.println("Вы не можете пойти сюда, здесь стена.....");
                    }
                    break;
                default:
                    System.out.println("вы ввели что-то не то, попробуйте еще раз...");
            }
            if (playerPos[1][0] == mapWinPos[1][0] && playerPos[0][0] == mapWinPos[0][0]) {
                winGame();
            } else if (playGround[playerPos[1][0] + 1][playerPos[0][0]] == '#' && playGround[playerPos[1][0]][playerPos[0][0] + 1] == '#') {
                gameOver();
            } else {
                printGame(playGround, playerPos);
            }
        }
        else {
            System.out.println("вы ввели что-то не то, попробуйте еще раз...");
            printGame(playGround, playerPos);
        }
    }
}