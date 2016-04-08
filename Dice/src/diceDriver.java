import javax.swing.*;

public class diceDriver {

	public static void main(String[] args)
	{
		roll_dice();
		
	}
	
	private static void roll_dice()
	{
		JFrame frame=new JFrame("Dice");
		dice a=new dice();
		frame.getContentPane().add(a.panel);
		frame.pack();
		frame.setVisible(true);		
	}
}
