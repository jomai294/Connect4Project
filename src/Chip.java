
public class Chip {
		private int owner;
		
		public Chip()
		{
				owner = Board.NoPlayer;
		}
		
		//who owns the chip
		public int getOwner()
		{
				return owner;
		}
		
		public void setOwner(int o)
		{
				owner = o;
		}
		
		public void display()
		{
				if (owner == 1)
				{
						System.out.print(1);
				}
				else if (owner == 2)
				{
						System.out.print(2);
				}
				else
				{
						System.out.print(0);
				}
		}
		
		
		
		
		
}
