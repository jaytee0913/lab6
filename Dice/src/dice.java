import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class dice implements ActionListener{
	
	String s = "";
	JPanel panel;
	JButton button;
	JLabel label1;
	JLabel label2;
	JTextField textfield;
	int i=0;
	int j=0;
	Random dice=new Random();

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		s = textfield.getText();
		if(!intCheck(s))
		{
			
			label2.setText("Please give a number (integer)");
			
			
		}
		else
		{
			
			i= Integer.parseInt(s); 
			j=dice.nextInt(i);
			j=j+1;
			label2.setText("You rolled a: " + String.valueOf(j));
		}
		
	}
	
	public Component getContent()
	{
		return(panel);
	}
	
	public boolean intCheck(String v)
	{
		try
		{
			Integer.parseInt(v);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		catch(NullPointerException e) {
	        return false;
	    }
		return true;
	}
	
	public dice()
	{
		panel = new JPanel(new GridLayout(5,5));
		button = new JButton("Roll");
		label1 = new JLabel("Enter an integer for the sides of dice and press roll:");
		label2 = new JLabel("");
		textfield=new JTextField(null,20);
		button.addActionListener(this);
		panel.add(label1);
		panel.add(textfield);
		panel.add(button);
		panel.add(label2);
	}
}
