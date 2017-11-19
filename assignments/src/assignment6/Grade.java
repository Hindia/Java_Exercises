package assignment6;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;

public class Grade extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private GradePanel messagePanel = new GradePanel();

	private JTextField textVal=new JTextField(10);	//text field added

	public Grade() {

	          setTitle("Grade Distribution");
	          JPanel anotherBar = new JPanel();	//another panel created
	          
	          
	          anotherBar.add(new JLabel ("Grade:"));	//label given to new text field
	          anotherBar.add(textVal);	//the text field added to the north panel
	          
	          JButton insertBttn=new JButton("insert");	//insert button added
	          insertBttn.addActionListener(this);	//action listener to insert button added
	          anotherBar.add(insertBttn);	//insert button added to the north panel

	          	          
	          add(anotherBar, BorderLayout.NORTH);	//new panel positioned to north 
	          add(messagePanel, BorderLayout.CENTER);	         

	          setDefaultCloseOperation(EXIT_ON_CLOSE);
	          setSize(350, 350);
	          setLocationRelativeTo(null);
	       }  

	       public void actionPerformed(ActionEvent evt) {
	          //Gets the command text on the button which was clicked
	          String command = evt.getActionCommand(); 

	          if (command.equals("insert")){
	        	  try{
	        		  int input= Integer.parseInt((textVal.getText()));
	        		  messagePanel.setGrade(input);
	        	  }
	        	  catch(NumberFormatException e){
	        		  JOptionPane.showMessageDialog(this, "You have an error in the input. Please enter an integer from 0-5",
	      					"Error", JOptionPane.ERROR_MESSAGE);
	                
	        	  }
	        	
	          }
	       }

	       public static void main(String[] args) {
	          Grade myframe = new Grade();
	          myframe.setVisible(true);
	       } 
	}


