package projectWork;
import javax.swing.*;

import java.io.*;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
// this class forms the frame which the application will show on start. It uses the methods in the Consumption panel class to perform some useful actions like drawing.
public class DataFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	 private final JMenuBar menuBar = new JMenuBar(); //Menu bar
	 private final JMenu fileMenu = new JMenu("Menu"); //File menu
	 private final JFileChooser fileDialog = new JFileChooser(); //standard file dialog
	 private final JLabel statusLabel = new JLabel(""); //label for a status bar
	 
	private ConsumptionPanel messagePanel = new ConsumptionPanel();	//object of the consumption panel created

	private JTextField ConsumptionVal=new JTextField(3);	//text fields added
	private JTextField MonthVal=new JTextField(2);
	
	//constructor method
	public DataFrame() {

		setTitle("Data Consumption");
		setJMenuBar(menuBar);
		//Create the menu items
        JMenuItem t = null;
        t = new JMenuItem("New");
        fileMenu.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doNew();
            }
        });
        t = new JMenuItem("Open");
        fileMenu.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doOpen();
            }
        });
        t = new JMenuItem("Save"); 
        fileMenu.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { 
                doSave();
            }
        });
        t = new JMenuItem("Exit");
        fileMenu.add(t);
        t.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                doExit();
            }
        });
        menuBar.add(fileMenu); //adds the file menu to the menu bar
        menuBar.add(statusLabel);
		
		
		JPanel FirstBar = new JPanel();	//panel created
		
		FirstBar.add(new JLabel ("Consumption:(in KWh)"));	//label given to new text field
		FirstBar.add(ConsumptionVal);
		FirstBar.add(new JLabel ("Month:(1 for January)"));
		FirstBar.add(MonthVal);	//the text field added to the first panel
		
		JButton insertBttn=new JButton("insert");	//insert button added
		insertBttn.addActionListener(this);	//action listener to insert button added
		FirstBar.add(insertBttn);	//insert button added to the panel


		add(FirstBar, BorderLayout.SOUTH);	//new panel positioned to the bottom of the box
		add(messagePanel, BorderLayout.CENTER);	         

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(550, 550);
		setLocationRelativeTo(null);
	}  
	//HashMap created for saving the data
	HashMap<Integer,Integer> data=new HashMap<>();
	
	//Ending the execution
    private void doExit() {
        this.dispose(); //close the frame and release resources
    }

    //Opens a file
    private void doOpen() {
    	messagePanel.clears();
        int returnVal = fileDialog.showOpenDialog(this); //for choosing the file
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader inputfile = 
                new BufferedReader(new FileReader(fileDialog
                        .getSelectedFile().getAbsolutePath()))) {
                statusLabel.setText("      File name: " + fileDialog.getSelectedFile().getName());
                String line;
                while ((line = inputfile.readLine()) != null){
                    String[] in=line.split(":");
                    int in1=Integer.parseInt(in[0]); 
                    int in2=Integer.parseInt(in[1]); 
                    if(in1< 12){
    					messagePanel.setConsumption(in2,in1);//gets data from file and sends it to be drawn
    				}
    				else
    					JOptionPane.showMessageDialog(this, "Month can't be greater than 12",
    							"Error", JOptionPane.ERROR_MESSAGE);
                }
                
            } 
            catch (IOException ex) {
                statusLabel.setText("Open failed");
            } 
        }
    }
            
    //Saves the file
    private void doSave() {
        int returnVal = fileDialog.showSaveDialog(this); //for choosing the file
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter outputfile = new PrintWriter(
                    new FileOutputStream(fileDialog.getSelectedFile().getAbsolutePath()),
                    true)) {
            	data.forEach((key, value) -> outputfile.print(key + ":" + value+"\n"));	//saves each data on one line
            	statusLabel.setText("Saved as: " + fileDialog.getSelectedFile().getName());
            } 
            catch (Exception ex) {
                statusLabel.setText("Saving failed");
            }
        }
    }
            
    //Opens a New file
    private void doNew() {
    	messagePanel.clears();
        statusLabel.setText("New File opened");
    }
    
    
	public void actionPerformed(ActionEvent evt) {
		//Gets the command text on the button which was clicked
		String command = evt.getActionCommand(); 

		if (command.equals("insert")){
			try{
				int input1= Integer.parseInt((ConsumptionVal.getText()));
				int input2= Integer.parseInt((MonthVal.getText()));
				if(input2< 12){
					data.put(input2, input1);
					messagePanel.setConsumption(input1,input2);
				}
				else
					JOptionPane.showMessageDialog(this, "Month can't be greater than 12",
							"Error", JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "Please insert an integer",
						"Error", JOptionPane.ERROR_MESSAGE);

			}

		}
	}
	
	//main method
	public static void main(String[] args) {
		DataFrame myframe = new DataFrame();
		myframe.setVisible(true);
	} 

}
