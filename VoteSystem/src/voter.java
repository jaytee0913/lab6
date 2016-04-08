import static java.lang.System.out;

import javax.swing.*;


import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class voter implements ActionListener
{
	
	String s = "";
	JPanel content;
	JButton button;
	JLabel label;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JTextField t;
	JTextField fn;
	JTextField ln;
	JRadioButton knope;
	JRadioButton dwyer;
	JRadioButton swanson;
	JRadioButton gergich;
	ButtonGroup nominees;
	
	String x="";
	String y="";
	String z="";
	
	
	public void actionPerformed(ActionEvent q) 
	{
		
		if(!checkVote())
		{
			
		}
		x = choice();
		y = ln.getText();
		z = fn.getText();
		String v =y+"_"+z+"_ballot.txt";
		String w = "";
		if(!checkVote())
		{
			label2.setText("Please select a candidate");
		}
		else
		{
			try
			{
				FileReader fr = new FileReader(v);
				BufferedReader br = new BufferedReader(fr);
				String str="";
				
				str=br.readLine();
				w = y+" "+z;
				if(str.equals(w))
				{
					label2.setText("This person voted already");
				}
				
			}
			catch(IOException e)
			{
				label2.setText("Thank you for voting");
				try
				{
					
					FileWriter fw = new FileWriter(v);
					PrintWriter pw=new PrintWriter(fw);
					
					pw.println(y + " " + z);
					pw.println("Voted for: " + x);
							
					pw.close();
				}
				catch(IOException ve)
				{
					out.println("ERROR!");
				}
			}
		}
		
	}
	
	public boolean checkVote()
	{
		if(nominees.getSelection()==null)
		{
			return false;
		}
		return true;
	}
	
	public String choice()
	{
		if(knope.isSelected())
		{
			s = "Leslie Knope";
		}
		else if(dwyer.isSelected())
		{
			s = "Andy Dwyer";
		}
		else if(swanson.isSelected())
		{
			s = "Ron Swanson";
		}
		else if(gergich.isSelected())
		{
			s = "Jerry Gergich";
		}
		
		return s;
	}
	
	public voter()
	{
		content = new JPanel(new GridLayout(20,20));
		button = new JButton("Submit");
		label = new JLabel("Please vote. \n One vote per person.");
		label2 = new JLabel("");
		knope=new JRadioButton("Leslie Knope");
		dwyer=new JRadioButton("Andy Dwyer");
		swanson=new JRadioButton("Ron Swanson");
		gergich=new JRadioButton("Jerry Gergich");
		nominees = new ButtonGroup();
		label3 = new JLabel("Last name:");
		ln=new JTextField("",20);
		label4 = new JLabel("First name:");
		fn=new JTextField("",20);
		
		button.addActionListener(this);
		
		content.add(label);
		content.add(knope);
		content.add(dwyer);
		content.add(swanson);
		content.add(gergich);
		nominees.add(knope);
		nominees.add(dwyer);
		nominees.add(swanson);
		nominees.add(gergich);
		content.add(label3);
		content.add(ln);
		content.add(label4);
		content.add(fn);
		content.add(button);
		content.add(label2);
		
	}
}