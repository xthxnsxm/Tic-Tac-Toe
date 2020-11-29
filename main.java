import java.util.Scanner;
public class main {
	static Scanner scan = new Scanner(System.in);
	static int[][] board = {
					{0,0,0},
					{0,0,0},
					{0,0,0}
					};
	static boolean running = true;
	static String turn = "Player 1";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(running==true) {
			displayBoard();
			move(turn);
			checkWin(turn);
		}
		System.out.println("Winner");
	}
	public static void move(String name) {
		System.out.println(name + " move: ");
		int move = scan.nextInt();
		int number = 0;
		if(name.equals("Player 1")) {
			number = 1;
		}else if(name.equals("Player 2")) {
			number = 2;
		}
		if(board[(move-1)/3][(move-1)%3] == 0) {
			board[(move-1)/3][(move-1)%3] = number;
		}else {
			System.out.println("Invalid move, try again.");
			move(turn);
		}
	}
	public static void checkWin(String name) {
		for(int i = 0; i<board.length;i++) {//horizontal check and then vertical check
			if(board[i][0]==board[i][1]&&board[i][0]==board[i][2]&&board[i][0]!=0) {
				running = false;
			}
			if(board[0][i]==board[1][i]&&board[0][i]==board[2][i]&&board[0][i]!=0) {
				running = false;
			}
		}
		if(board[0][0]==board[1][1]&&board[0][0]==board[2][2]&&board[1][1]!=0||board[0][2]==board[1][1]&&board[0][2]==board[2][0]&&board[1][1]!=0) {
			running = false;
		}
		if(turn.equals("Player 1")) {
			turn = "Player 2";
		}else {
			turn = "Player 1";
		}
	}
	public static void displayBoard() {
		for(int i = 0;i<board.length;i++) {
			for(int j = 0;j<board.length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println("");
		}
	}
}
