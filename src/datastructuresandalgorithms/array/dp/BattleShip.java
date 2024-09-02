package datastructuresandalgorithms.array.dp;

import java.util.Random;
import java.util.Scanner;

public class BattleShip {

    public static void main(String[] args) {
        int[][] board = new int[5][5];
        int[][] ships = new int[3][2];
        int[] shoot = new int[2];
        int attempts = 0,
                shotHit = 0;

        initBoard(board);

        initShips(ships);
        for (int i = 0; i < ships.length; i++) {
            System.out.println(ships[i][0] + ", " + ships[i][1]);
        }
        System.out.println();

        do {
            showBoard(board);
            shoot(shoot);
            attempts++;

            if (hit(shoot, ships)) {
                hint(shoot, ships, attempts);
                shotHit++;
            } else
                hint(shoot, ships, attempts);

            changeboard(shoot, ships, board);


        } while (shotHit != 3);

        System.out.println("\n\n\nBattleship Java game finished! You hit 3 ships in " + attempts + " attempts");
        showBoard(board);
    }

    public static void initBoard(int[][] board) {
        for (int row = 0; row < 5; row++)
            for (int column = 0; column < 5; column++)
                board[row][column] = -1;
    }

    public static void showBoard(int[][] board) {
        System.out.println("\t1 \t2 \t3 \t4 \t5");
        System.out.println();

        for (int row = 0; row < 5; row++) {
            System.out.print((row + 1) + "");
            for (int column = 0; column < 5; column++) {
                if (board[row][column] == -1) {
                    System.out.print("\t" + "~");
                } else if (board[row][column] == 0) {
                    System.out.print("\t" + "*");
                } else if (board[row][column] == 1) {
                    System.out.print("\t" + "X");
                }

            }
            System.out.println();
        }

    }

    public static void initShips(int[][] ships) {
        //randomly calculate the positions where the ships are to be put
        // and store those pos in ships[]

        // ship to i, last to j
        //renamed
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int temp = random.nextInt(5);
            ships[i][0] = temp; //place horizontally
            int tempoo = random.nextInt(5);
            ships[i][1] = tempoo;

            //let's check if that shot was already tried 
            //if it was, just finish the do...while when a new pair was randomly selected
            for (int j = 0; j < i; j++) {
                //taken?
                if ((ships[i][0] == ships[j][0]) && (ships[i][1] == ships[j][1]))
                    do {
                        ships[i][0] = random.nextInt(5);
                        ships[i][1] = random.nextInt(5);
                    } while ((ships[i][0] == ships[j][0]) && (ships[i][1] == ships[j][1]));
            }

        }
    }

    public static void shoot(int[] shoot) {
        Scanner input = new Scanner(System.in);

        System.out.print("Row: ");
        shoot[0] = input.nextInt();
        shoot[0]--;

        System.out.print("Column: ");
        shoot[1] = input.nextInt();
        shoot[1]--;

    }

    public static boolean hit(int[] shot, int[][] ships) {

        for (int ship = 0; ship < ships.length; ship++) {
            if (shot[0] == ships[ship][0] && shot[1] == ships[ship][1]) {
                System.out.printf("You hit a ship located in (%d,%d)\n", shot[0] + 1, shot[1] + 1);
                return true;
            }
        }
        return false;
    }

    public static void hint(int[] shot, int[][] ships, int attempt) {
        int row = 0,
                column = 0;

        for (int i = 0; i < ships.length; i++) {
            if (ships[i][0] == shot[0])
                row++;
            if (ships[i][1] == shot[1])
                column++;
        }

        System.out.printf("\nHint %d: \nRow %d -> %d ships\n" +
                "Column %d -> %d ships\n", attempt, shot[0] + 1, row, shot[1] + 1, column);
    }

    public static void changeboard(int[] shoot, int[][] ships, int[][] board) {
        if (hit(shoot, ships))
            board[shoot[0]][shoot[1]] = 1;
        else
            board[shoot[0]][shoot[1]] = 0;
    }
}