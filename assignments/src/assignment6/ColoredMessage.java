package assignment6;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class ColoredMessage extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private ColoredMessagePanel messagePanel = new ColoredMessagePanel();

	private JTextField textVal=new JTextField(10);	//text field added

    public ColoredMessage() {

          setTitle("Colored Message");
          JPanel buttonBar = new JPanel();
          JPanel anotherBar = new JPanel();	//another panel created
          
          
          anotherBar.add(new JLabel ("Text:"));	//label given to new text field
          anotherBar.add(textVal);	//the text field added to the north panel
          
          JButton insertBttn=new JButton("insert");	//insert button added
          insertBttn.addActionListener(this);	//action listener to insert button added
          anotherBar.add(insertBttn);	//insert button added to the north panel

          JButton redBttn = new JButton("Red");
          redBttn.addActionListener(this);
          buttonBar.add(redBttn);

          JButton greenBttn = new JButton("Green");
          greenBttn.addActionListener(this);
          buttonBar.add(greenBttn);

          JButton blueBttn = new JButton("Blue");
          blueBttn.addActionListener(this);
          buttonBar.add(blueBttn);
          
          add(anotherBar, BorderLayout.NORTH);	//new panel positioned to north 
          add(buttonBar, BorderLayout.SOUTH);
          add(messagePanel, BorderLayout.CENTER);	         

          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setSize(350, 200);
          setLocationRelativeTo(null);
       }  

       public void actionPerformed(ActionEvent evt) {
          //Gets the command text on the button which was clicked
          String command = evt.getActionCommand(); 

          if (command.equals("Red"))
              messagePanel.setTextColor(Color.red);
          else if (command.equals("Green"))
              messagePanel.setTextColor(Color.green);
          else if (command.equals("Blue"))
              messagePanel.setTextColor(Color.blue);
         else if (command.equals("insert"))
        	  messagePanel.setText(textVal.getText());	//gives text value to message panel
          
       } 

       public static void main(String[] args) {
          ColoredMessage myframe = new ColoredMessage();
          myframe.setVisible(true);
       } 
} 
