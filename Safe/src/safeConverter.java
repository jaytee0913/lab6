import javax.swing.*;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.ButtonGroup;

public class safeConverter implements ActionListener{
	String s = "";
	JPanel content;
	JButton button;
	JLabel label;
	JTextField t;
	ButtonGroup temps;
	JRadioButton fc;
	JRadioButton fk;
	JRadioButton ck;
	JRadioButton cf;
	JRadioButton kf;
	JRadioButton kc;
	double y = 0;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		s=t.getText();
		if(s.isEmpty() || !intcheck(s))
		{
			if(s.isEmpty())
			{
				label.setText("Please give a valid entry");
			}
			else if(!intcheck(s))
			{
				label.setText("Please give an integer");
			}
			
		}
		else
		{
			
			if(fc.isSelected())
			{
				double x = Integer.parseInt(s);
				
				y = (x-32)/1.8;
				label.setText(x + " F = " + y + " Celsius");
				
			}
			else if(fk.isSelected())
			{
				
				double x=Integer.parseInt(s); 
				y = (x+459.67)*(5/9);
				label.setText(x + " F = " + y + " Kelvin");
			}
			else if(ck.isSelected())
			{
				
				double x = Integer.parseInt(s); 
				y = x + 273.15;
				label.setText(x + " C = " + y + " Kelvin");
			}
			else if(cf.isSelected())
			{
				
				double x = Integer.parseInt(s); 
				y = x*(1.8)+32;
				label.setText(x + " C = " + y + " Farenheit");
			}
			else if(kf.isSelected())
			{
				
				double x = Integer.parseInt(s); 
				y = x*(1.8)-459.67;
				label.setText(x + " K = " + y + " Farenheit");
			}
			else if(kc.isSelected())
			{
				
				double x = Integer.parseInt(s); 
				y = x - 273.15;
				label.setText(x + " K = " + y + " Celsius");
			}
		}
	
	}
	
	public boolean intcheck(String v)
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
	
	public Component getContent()
	{
		return(content);
	}
	
	public safeConverter()
	{
		content = new JPanel(new GridLayout(20,20));
		button = new JButton("Submit");
		label = new JLabel("Please enter a value that is a number");
		temps = new ButtonGroup();
		fc=new JRadioButton("F to C");
		fk=new JRadioButton("F to K");
		ck=new JRadioButton("C to K");
		cf=new JRadioButton("C to F");
		kf=new JRadioButton("K to F");
		kc=new JRadioButton("K to C");
		t=new JTextField(null,20);
		button.addActionListener(this);
		content.add(fc);
		content.add(fk);
		content.add(ck);
		content.add(cf);
		content.add(kf);
		content.add(kc);
		content.add(label);
		content.add(button);
		temps.add(fc);
		temps.add(fk);
		temps.add(ck);
		temps.add(cf);
		temps.add(kf);
		temps.add(kc);
		content.add(t);
	}
}
