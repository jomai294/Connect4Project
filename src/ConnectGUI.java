import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ConnectGUI {
    //declaration of gui objects
	//private static String[] arguments;
	
    private JFrame frame;
    private JLabel[][] slots;
    private JButton[] jbs;
    //variables used in grid
    
    private int currentPlayer; 
    //game variables to communicate with top program
    private boolean hasWon = false;
    private boolean hasDraw = false;
    private boolean quit = false;
    private boolean newGame = false;
    //making of grid and logic
    private Board b;
    private int xsize;
    private int ysize;
    private Connect4 c;
    
    private int rowHolder;
    
    //logic my_logic = new logic(my_grid); //create game logic
//    public static void main(String[] args) {
//        ConnectGUI Gui = new ConnectGUI();
//        
//        
//        
//    }
    
    public ConnectGUI() {

        frame = new JFrame("connect four");
        //b = new Board(arguments);
        b = new Board();
        c = new Connect4();
        xsize = b.getDimension();
        ysize = b.getDimension();
        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(new GridLayout(xsize + 1, ysize));

        slots = new JLabel[xsize][ysize];
        jbs = new JButton[xsize];

        for (int i = 0; i < xsize; i++) {
            jbs[i] = new JButton("" + (i + 1));
            jbs[i].setActionCommand("" + i);
            jbs[i].addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        	int a = Integer.parseInt(e.getActionCommand());
                        	System.out.println("Location is "+ a);
                        	b.put(a);
                        	//grid.print();
                        	frame.setTitle("connect 4 - player" + b.getPlayer());
                        	updateBoard();
                        	//System.out.println(c.getWinState());
                        	if (b.getFinalStop())
                        	{
                        			showWon();
                        	}
                        	
                        }
                    });
            panel.add(jbs[i]);
        }
        for (int column = 0; column < xsize; column++) {
            for (int row = 0; row < ysize; row++) {
                slots[row][column] = new JLabel();
                slots[row][column].setHorizontalAlignment(SwingConstants.CENTER);
                slots[row][column].setBorder(new LineBorder(Color.black));
                panel.add(slots[row][column]);
            }
        }

        //jframe stuff
        frame.setContentPane(panel);
        frame.setSize(700,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //updates the board by filling in the slot with appropriate color
    public void updateBoard() {
    	b.print();
    	for (int i = 0 ; i < xsize ; i++) {
    		for (int j = 0 ; j < ysize ; j++) {
    			if (b.getGrid()[i][j].getOwner() == 1) {
    					slots[j][i].setOpaque(true);
    					slots[j][i].setBackground(Color.red);
    			}
    			if (b.getGrid()[i][j].getOwner() == 2) {
    				slots[j][i].setOpaque(true);
    				slots[j][i].setBackground(Color.green);
    			}
    		}
    	}frame.setTitle("connect 4 - player :" + b.getPlayer());
    }

    public void showWon() {
    	//gets the current winner
        String winner = "player " + b.getPlayer() + " wins";
        int n = JOptionPane.showConfirmDialog(
                frame,
                "new game?",
                winner,
                JOptionPane.YES_NO_OPTION);
        if (n < 1) {
            frame.dispose();
            ConnectGUI cgi = new ConnectGUI(); 
            newGame = true;
        } else {
            frame.dispose();
            quit = true;
        }
    }
//    public static String[] getArguments()
//    {
//    		return arguments;
//    }
//    public static void main(String[] args)
//    {
//    		ConnectGUI c = new ConnectGUI();
//    		Board b = new Board(c.getArguments());
//    		
//    		arguments = args;
//    		
//    }
}


