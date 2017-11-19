package assignment6;

import java.awt.*;
import javax.swing.*;

public class GradePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Distribution d1=new Distribution(5,0);
	
	public GradePanel() {
        setBackground(Color.white);

    }
	
	public void setGrade(int g){
		d1.insert(g);
		repaint();
				
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //Sets the text color 
        g.setColor(Color.BLACK);
        g.drawLine(25, 50, 300, 50);
        g.drawString("10", 5, 50);
        g.drawLine(20, 150, 300, 150);
        g.drawString("5", 5, 150);
        g.drawLine(20, 250, 300, 250);
        g.drawString("", 5, 250);
        g.drawString("0", 47, 270);	//string,x,y
        g.drawString("1", 97, 270);
        g.drawString("2", 147, 270);
        g.drawString("3", 197, 270);
        g.drawString("4", 247, 270);
        g.drawString("5", 297, 270);
        
        //prints average and total
        g.setFont(new Font("Lucida Sans", Font.BOLD, 14));
        g.drawString("count= "+d1.total(), 70, 40);
        g.drawString("avg= "+ String.format("%.2f", d1.average()) , 180, 40);
        g.setColor(Color.RED);	//bar color changes to red
        //grade 0
        g.drawRect(30, 250-(d1.freq(0)*20), 30,d1.freq(0)*20 );	//x,y(top),w,h
        g.fillRect(30, 250-(d1.freq(0)*20), 30,d1.freq(0)*20 );	//x,y,w,h
        //grade 1
        g.drawRect(80, 250-(d1.freq(1)*20), 30, d1.freq(1)*20 );
        g.fillRect(80, 250-(d1.freq(1)*20), 30, d1.freq(1)*20 );
        //grade 2
        g.drawRect(130, 250-(d1.freq(2)*20), 30, d1.freq(2)*20 );
        g.fillRect(130, 250-(d1.freq(2)*20), 30, d1.freq(2)*20 );
        //Grade 3
        g.drawRect(180, 250-(d1.freq(3)*20), 30, d1.freq(3)*20 );
        g.fillRect(180, 250-(d1.freq(3)*20), 30, d1.freq(3)*20 );
        //Grade 4
        g.drawRect(230, 250-(d1.freq(4)*20), 30, d1.freq(4)*20 );
        g.fillRect(230, 250-(d1.freq(4)*20), 30, d1.freq(4)*20 );
        //grade 5
        g.drawRect(280, 250-(d1.freq(5)*20), 30, d1.freq(5)*20 );
        g.fillRect(280, 250-(d1.freq(5)*20), 30, d1.freq(5)*20 );
        //prints the frequencies
        g.setColor(Color.BLACK);
        g.drawString(""+d1.freq(0) , 40, 240);	//string,x,y
        g.drawString(""+d1.freq(1), 90, 240);
        g.drawString(""+d1.freq(2), 140, 240);
        g.drawString(""+d1.freq(3), 190, 240);
        g.drawString(""+d1.freq(4), 240, 240);
        g.drawString(""+d1.freq(5), 290, 240);
        
        
    }
	
	
	
	

}
