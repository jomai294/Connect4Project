public class Connect4 {
		
	private boolean winState;
	public Connect4() {
		winState = false;
	}
	
	public void setWinState(boolean s)
	{
			winState = s;
	}
	public boolean getWinState()
	{
			return winState;
	}
	public boolean win(Board grid) {
		
		if (winHorizontal(grid)||winVerticle(grid)||winDiagonal1(grid)||winDiagonal2(grid)||winDiagonal3(grid)||winDiagonal4(grid)) {
			winState = true;
			return true;
		}
		return false;
	}
	private boolean winHorizontal(Board grid) {
				
		Chip[][] board = grid.getGrid();
		int lastRow = grid.getLastRow();
		int counter = 0;
		for (int i = 0 ; i < board.length ; i++) {
			if (board[lastRow][i].getOwner() == grid.getPlayer()) {
				counter++;
			} else { counter = 0; }
			if (counter >= grid.getWinBy()) {
				System.out.println(board[lastRow][i].getOwner() + " has won");
			
				return true;
			}
						
		}		
		return false;		
		}
		
	private boolean winVerticle(Board grid) {
		
		Chip[][] board = grid.getGrid();
		int lastCol = grid.getLastCol();	
		int counter = 0;
			
		for (int i = 0 ; i < board.length ; i++) {
				
			if (board[i][lastCol].getOwner() == grid.getPlayer()) {
				counter++;
			}else { counter = 0; }
			
			if (counter >= grid.getWinBy()) {
				System.out.println(board[i][lastCol].getOwner() + " has won");
				
				return true;
			}		
		}
		return false;
	}
		
	private boolean winDiagonal1(Board grid) {
			Chip[][] board = grid.getGrid();	
			int lastCol = grid.getLastCol();
			int lastRow = grid.getLastRow();
			int counter = 0;
			
			for (int i = lastRow,j = lastCol ; i < board.length && j >= 0; i++,j--) {	
			//System.out.println(lastRow + " , " + lastCol);
					System.out.println("The counter is " + counter);
					if (board[i][j].getOwner() == grid.getPlayer()) {	
						counter++;
					} else { counter = 0; }
					if (counter >= grid.getWinBy()) {
						System.out.println(board[lastRow][lastCol].getOwner() + " wins");
						
						return true;
					}		
			}
			return false;
	}
	
	private boolean winDiagonal2(Board grid) {
		Chip[][] board = grid.getGrid();	
		
		int lastCol = grid.getLastCol();
		int lastRow = grid.getLastRow();
		
		int counter = 0;
		for (int i = lastRow,j = lastCol ; i >= 0 && j < board.length ; i--,j++) {	
				//System.out.println(lastRow + " , " + lastCol);
				//System.out.println("The counter is " + counter);
				if (board[i][j].getOwner() == grid.getPlayer()) {
						counter++;
				} else { counter = 0; }
				if (counter >= grid.getWinBy()) {
						System.out.println(board[lastRow][lastCol].getOwner() + "wins");
						
						return true;
				}
		}
		return false;
	}
	
	private boolean winDiagonal3(Board grid) {
		Chip[][] board = grid.getGrid();	
		
		int lastCol = grid.getLastCol();
		int lastRow = grid.getLastRow();
		
		int counter = 0;
		for (int i = lastRow,j = lastCol ; i >= 0 && j >= 0 ; i--,j--) {	
				//System.out.println(lastRow + " , " + lastCol);
				//System.out.println("The counter is " + counter);
				if (board[i][j].getOwner() == grid.getPlayer()) {	
					counter++;
				} else {
					counter = 0;
				}
				if (counter >= grid.getWinBy()) {
					System.out.println(board[lastRow][lastCol].getOwner() + "wins");
					
					return true;
				}
		}
		return false;
	}
	
	private boolean winDiagonal4(Board grid)
	{
		Chip[][] board = grid.getGrid();	
		
		int lastCol = grid.getLastCol();
		int lastRow = grid.getLastRow();
		
		int counter = 0;
		for (int i = lastRow,j = lastCol ; i < board.length && j < board.length ; i++,j++)
		{	
					//System.out.println(lastRow + " , " + lastCol);
					//System.out.println("The counter is " + counter);
					if (board[i][j].getOwner() == grid.getPlayer())
					{	
							counter++;
					}
					else
					{
							counter = 0;
					}
			
					if (counter >= grid.getWinBy())
					{
							System.out.println(board[lastRow][lastCol].getOwner() + "wins");
							
							return true;
					}
		}
		return false;
}

}

