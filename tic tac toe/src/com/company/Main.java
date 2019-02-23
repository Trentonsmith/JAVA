package com.company;
import java.util.Scanner;
public class Main {
static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int currentTurn =0;
    	int i = 0;
    	char [] pos = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',};
    	char turn = 'X';
		int input;
    	while(true) {
			// this loop makes it so if you enter a position already in use,
			// it repeats until you put one that isn't already occupied, then continues
    		do {
				System.out.println("enter a position: ");
				input = scanner.nextInt();
				// minus one makes the input 1 = 0 and so on so that we dont have to use 0
			}while(pos[input-1] == 'X'|| pos[input-1] == 'O');
			pos[input - 1] = turn;
			currentTurn++;

			System.out.println(" " + pos[6] + " | " + pos[7] + "   |" + pos[8] + "   ");
			System.out.println("---+-----+----");
			System.out.println(" " + pos[3] + " | " + pos[4] + "   |" + pos[5] + "   ");
			System.out.println("---+-----+----");
			System.out.println(" " + pos[0] + " | " + pos[1] + "   |" + pos[2] + "   ");
			i++;
			if(pos[0] == turn&& pos[1] == turn && pos[2] == turn||pos[3] == turn&& pos[4] == turn && pos[5] == turn
			||pos[6] == turn&& pos[7] == turn && pos[8] == turn
			||pos[0] == turn&& pos[3] == turn && pos[6] == turn
			||pos[1] == turn&& pos[4] == turn && pos[7] == turn
			||pos[2] == turn&& pos[3] == turn && pos[8] == turn
			||pos[0] == turn&& pos[4] == turn && pos[8] == turn
			||pos[6] == turn&& pos[4] == turn && pos[2] == turn
			||pos[8] == turn&& pos[5] == turn && pos[2] == turn
			){
				System.out.println("congrats, " + turn + " won");
				break;
			}

			if (i % 2 == 0)
			{
				turn = 'X';
			}
		else if(i % 2 == 1){
				turn = 'O';
			}

		}

	}
}
//    |     |
//    |     |
// --------------
//    |     |
//    |     |
// --------------
//    |     |
//    |     |
