import javax.swing.*;

public class safeDriver {

	public static void main(String[] args)
	{
		run_safeco();
		
	}
	
	private static void run_safeco()
	{
		JFrame frame=new JFrame("Safe Converter");
		safeConverter a=new safeConverter();
		frame.getContentPane().add(a.content);
		frame.pack();
		frame.setVisible(true);
		
	}
}
