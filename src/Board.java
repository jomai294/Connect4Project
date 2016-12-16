
import java.util.Scanner;
public class Board {
		
		private Chip[][] grid;
		private Connect4 c;
		//keeps track of the players on the board
		public static final int Player1 = 1;
		public static final int Player2 = 2;
		public static final int NoPlayer = 0;
		
		private int player;
		private int turns;
		private int row;
		
		private int lastRow;
		private int lastCol;
		private final int dimension;
		private final int WinBy;
		
		private boolean finalStop;
		
		public boolean getFinalStop()
		{
				return finalStop;
		}
		public int getRow()
		{
				return row;
		}
		
		public Board() {
				Scanner kb = new Scanner(System.in);
				System.out.println("Enter the dimension for the board");
				dimension = kb.nextInt();
				System.out.println("Enter winning condition");
				WinBy = kb.nextInt();
//				dimension = Integer.parseInt(ConnectGUI.getArguments()[0]);
//				WinBy = Integer.parseInt(ConnectGUI.getArguments()[1]);
				
				grid = new Chip[dimension][dimension];
				for (int i = 0 ; i < dimension ; i++)
				{
						for (int j = 0 ; j < dimension ; j++)
						{
								grid[i][j] = new Chip();
								
						}
						
				}
				finalStop = false;
				turns = 1;
				c = new Connect4();
				
				
		}
		
		
		public int getDimension() {	
				return dimension;
		}
		public int getWinBy() {
			return WinBy;
		}
		
		public void setLastCol(int s)
		{
				lastCol = s;
		}
		
		public int getLastCol()
		{
				return lastCol;
		}
		
		public void setLastRow(int s)
		{
				lastRow = s;
		}
		
		public int getLastRow()
		{
				return lastRow;
		}
		public void print()
		{
				
				for (int i = 0 ; i < grid.length ; i++)
				{
						for (int j = 0 ; j < grid[i].length ; j++)
						{
								//Displays the current player while keeping track of the owner in background
								grid[i][j].display();
								
						}
						System.out.println();
				}
		}
		
		public void put(int column)
		{
				
				boolean stop = false;
				
				for (int row = grid.length -1 ; row >= 0 && !stop && !finalStop; row--)
				{
						//bottom row
						if (grid[row][column].getOwner() == 0)
						{
								
								grid[row][column] = new Chip();
								grid[row][column].setOwner(getPlayer());
								setLastRow(row);
								setLastCol(column);
								
								
								
								if (!c.win(this))
								{
										
										turns++;
								}
								else
								{
										finalStop = true;
								}
								
								
								stop = true;
								
						}
						
						
				}
				//switchPlayer();
				
		}

		public Chip[][] getGrid()
		{
				return grid;
		}
		
		public void setTurn(int t)
		{
				turns = t;
		}
		public int getTurn()
		{
				return turns;
		}
		//gets the current player based on turns
		public int getPlayer()
		{
				if (turns % 2 == 1)
				{
						player = Player1;

				}
				else if (turns % 2 == 0)
				{
						player = Player2;
				}
				else
				{
						player = NoPlayer;
				}
				return player;
				
		}
		public int getNumTurns()
		{
				return turns;
		}
		
		public static void main(String[] args)
		{
				ConnectGUI c = new ConnectGUI();
				Board b = new Board();
			
				
				
		}
		
		
		
}