import javax.swing.*;

public class voterdriver {
	
	public static void main(String[] args)
	{
		run_vote();
	}
	
	private static void run_vote()
	{
		JFrame frame = new JFrame("Vote System");
		voter a = new voter();
		frame.getContentPane().add(a.content);
		frame.pack();
		frame.setVisible(true);
	}
}