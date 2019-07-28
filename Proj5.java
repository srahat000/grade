
//program calculates the average letter grade the student will receive for
//their class at the end of the semester

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Proj5 extends Applet implements ActionListener
{

	Label lblGrade, lblEnd;
	TextField txtResponse;
	String resp;
	char response;
	
	
	int  counter; //counter to keep track of how many assignments there were
	double avg, total;
	
	public void init()
	{
		setLayout(null);
		
		//set counter to 0 and add 1 every time a letter grade is entered
		total = counter = 0;
		lblGrade = new Label("Enter your letter grade for each "
				+ "assignment one by one");
		lblGrade.setBounds(30, 30, 400, 30);
		add(lblGrade);
		
		//this label instructs the user about what to press when
		//they have finished entering their grades
		lblEnd = new Label("Enter 'P' when you have finished "
				+ "adding all the grades.");
		lblEnd.setBounds(30, 70, 500, 30);
		add(lblEnd);
		
		txtResponse = new TextField(10);
		txtResponse.setBounds(90, 100, 50, 50);
		add(txtResponse);
		txtResponse.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//the text input is turned to a String
		//then the string is turned into a character
		//and a while loop executes keeping track of all the characters 
		//entered and calculates the total as each character is entered
		resp = txtResponse.getText();
		response = resp.charAt(0);
		while(response != 'P')
		{
			resp = txtResponse.getText();
			response = resp.charAt(0);
			
			switch(response)
			{
			case 'A':
				total = total + 95; //a 95 is associated with an A
				counter++;
				//every time a character is entered, the text field is cleared
				//so user can input more data
				txtResponse.setText("");
				break;
				
			case 'B':
				total= total + 85; //an 85 is associated with a B
				counter++;
				txtResponse.setText("");
				break;
				
			case 'C':
				total = total + 75; //a 75 is associated with a C
				counter++;
				txtResponse.setText("");
				break;
				
			case 'D':
				total = total + 67; //a 65 is associated with a D
				counter++;
				txtResponse.setText("");
				break;
				
			case 'F':
				total = total + 40; //a 40 is associated with an F
				counter++;
				txtResponse.setText("");
				break;
				
			default:
				showStatus("Please enter a correct letter grade!");
				txtResponse.setText("");
				break;
			
			}
			
		}
		//the average is calculated after a 'P' is entered and the user has 
		//finished entering all the grades
		avg = total / counter; 
		repaint();
	}
	
	
	//The student's average grade is calculated and a letter grade is assigned
	//to it depending on the range the average grade falls in
	//the results are then printed
	public void paint(Graphics g)
	{
		if(avg >= 90 && avg <= 100)
			g.drawString("Your average grade is an A.", 30, 210);
		
		if(avg >= 80 && avg < 90)
			g.drawString("Your average grade is a B.", 30, 210);
		
		if(avg >= 70 && avg < 80)
			g.drawString("Your average grade is a C.", 30, 210);
		
		if(avg >= 60 && avg < 70)
			g.drawString("Your average grade is a D.", 30, 210);
		
		if(avg < 60)
			g.drawString("Your average grade is an F.", 30, 210);
	}
	
}
