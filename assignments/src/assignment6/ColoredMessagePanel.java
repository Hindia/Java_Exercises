package assignment6;

import javax.swing.*;
import java.awt.*;

	/*
	 *  Component for showing text on a white
	 *  background, using bold font. The text and its color can be changed.
	 */
	public class ColoredMessagePanel extends JPanel {

	    private static final long serialVersionUID = 1L;

	    private Color textColor;
	    private Font textFont;
	    private String text;

	    public ColoredMessagePanel() {
	        setBackground(Color.white);
	        textColor = Color.red;
	        textFont = new Font("Serif", Font.BOLD, 24);
	        text="Hello World!";	//gives default message 
	    }

	    @Override
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        //Sets the drawing color and font of the graphics context
	        g.setColor(textColor);
	        g.setFont(textFont);
	        //Draws text, baseline of the leftmost character is at position (100, 65)
	        g.drawString(text, 100, 65);
	    }

	    //Sets a new text color and repaints this component
	    public void setTextColor(Color color) {
	        textColor = color;
	        repaint();
	    }
	    
	    public void setText(String t) {
	        text=t;	//assigns text value to message panel
	        repaint();
	    }
	    
	} 


