/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

/**
 *
 * @author e1500943
 */
/* An example of textfiles and menus */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextEditor extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private final JMenuBar menuBar = new JMenuBar(); //Menubar
    private final JMenu fileMenu = new JMenu("File"); //File menu
    private final JFileChooser fileDialog = new JFileChooser(); //standard file dialog
    private final JTextArea data = new JTextArea();
    private final JLabel statusLabel = new JLabel(""); //label for a status bar

    public TextEditor() {
        this.setTitle("SmallTextEditor");
        this.setJMenuBar(menuBar); //sets for the frame's menubar
        
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
        menuBar.add(fileMenu); //add the file menu to the menu bar
        
        //set the properties of text area and add it to the frame
        data.setLineWrap(true);
        data.setWrapStyleWord(true);
        JScrollPane sp = new JScrollPane(data);
        this.add(sp, BorderLayout.CENTER);
        
        this.add(statusLabel, BorderLayout.SOUTH);
        
        //what to do when closing the frame
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                doExit();
            }			
        });
    }

    //Ending the execution
    private void doExit() {
        this.dispose(); //close the frame and release resources
        /*or System.exit(0); //close the program*/
    }

    //Open a file
    private void doOpen() {
        data.setText(null);
        int returnVal = fileDialog.showOpenDialog(this); //for choosing the file
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader inputfile = 
                new BufferedReader(new FileReader(fileDialog
                        .getSelectedFile().getAbsolutePath()))) {
                statusLabel.setText("File: " + fileDialog.getSelectedFile().getName());
                String line;
                data.setText(null); //empty the text area
                while ((line = inputfile.readLine()) != null){
                    data.append(line + "\n"); //appends to the text area
                }
                data.setCaretPosition(0); //cursor in the beginning of the text
            } 
            catch (IOException ex) {
                statusLabel.setText("Open failed");
            } 
        }
    }
            
    //Save a file
    private void doSave() {
        int returnVal = fileDialog.showSaveDialog(this); //for choosing the file
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try (PrintWriter outputfile = new PrintWriter(
                    new FileOutputStream(fileDialog.getSelectedFile().getAbsolutePath()),
                    true)) {
                outputfile.print(data.getText()); //write the text from the text area into the file
                statusLabel.setText("Saved: " + fileDialog.getSelectedFile().getName());
            } 
            catch (Exception ex) {
                statusLabel.setText("Save failed");
            }
        }
    }
            
    //New text
    private void doNew() {
        data.setText("");
        statusLabel.setText("");
    }

    //The main method
    public static void main(String[] args) {
        TextEditor f = new TextEditor();
        f.setSize(600, 300);
        f.setVisible(true);
    }	
}
