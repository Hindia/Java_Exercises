package projectWork;
/**
 *
 * @author e1500943
 */
import java.awt.*;
import javax.swing.*;
// this class uses the distribution class to get the values of the data distribution in order to draw the bars and print the necessary values
public class ConsumptionPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	DataDistribution d1=new DataDistribution(12,1);	//object of the distribution class

	public ConsumptionPanel() {
		setBackground(Color.gray);

	}

	public void setConsumption(int cons, int mon){
		d1.insert(cons,mon);
		repaint();

	}
	public void clears(){
		d1.clear();
		repaint();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Sets the text color 
		g.setColor(Color.BLACK);
		g.drawString("Consumption(KWh)", 20, 45);
		g.drawString("2018 G.C", 150, 15);
		g.drawLine(25, 50, 25, 400);//y axis of the graph::x1,y1,x2,y2
		g.drawString("200", 5, 200);
		g.drawString("300", 5, 100);
		g.drawLine(25, 400, 400, 400);//x axis of the graph::x1,y1,x2,y2
		g.drawString("100", 5, 300);
		g.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		g.drawString("Jan", 35, 420);
		g.drawString("Feb", 65, 420);	//string,x,y
		g.drawString("Mar", 95, 420);
		g.drawString("Apr", 125, 420);
		g.drawString("May", 155, 420);
		g.drawString("June", 185, 420);
		g.drawString("July", 215, 420);
		g.drawString("Aug", 245, 420);
		g.drawString("Sep", 275, 420);	
		g.drawString("Oct", 305, 420);
		g.drawString("Nov", 335, 420);
		g.drawString("Dec", 365, 420);

		//prints max, min, average and total
		g.setFont(new Font("Lucida Sans", Font.BOLD, 14));
		g.drawString("Min="+d1.Min(),370, 25);
		g.drawString("Max="+d1.Max(), 370, 45);
		g.drawString("Total="+d1.total(), 370, 65);
		g.drawString("Avg="+ String.format("%.2f", d1.average()) , 370, 85);
		g.setColor(Color.white);	//bar color changes to white
		//Jan
		g.drawRect(35, 400-(d1.val(0)), 25,d1.val(0) );	//x,y(top),w,h
		g.fillRect(35, 400-(d1.val(0)), 25,d1.val(0) );	//x,y,w,h
		//Feb
		g.drawRect(65, 400-(d1.val(1)), 25, d1.val(1) );
		g.fillRect(65, 400-(d1.val(1)), 25, d1.val(1) );
		//Mar
		g.drawRect(95, 400-(d1.val(2)), 25, d1.val(2) );
		g.fillRect(95, 400-(d1.val(2)), 25, d1.val(2) );
		//Apr
		g.drawRect(125, 400-(d1.val(3)), 25, d1.val(3) );
		g.fillRect(125, 400-(d1.val(3)),25, d1.val(3) );
		//May
		g.drawRect(155, 400-(d1.val(4)), 25, d1.val(4) );
		g.fillRect(155, 400-(d1.val(4)), 25, d1.val(4) );
		//June
		g.drawRect(185, 400-(d1.val(5)), 25, d1.val(5) );
		g.fillRect(185, 400-(d1.val(5)), 25, d1.val(5) );
		//July
		g.drawRect(215, 400-(d1.val(6)), 25, d1.val(6) );
		g.fillRect(215, 400-(d1.val(6)), 25, d1.val(6) );
		//August
		g.drawRect(245, 400-(d1.val(7)), 25, d1.val(7) );
		g.fillRect(245, 400-(d1.val(7)), 25, d1.val(7) );
		//September
		g.drawRect(275, 400-(d1.val(8)), 25, d1.val(8) );
		g.fillRect(275, 400-(d1.val(8)), 25, d1.val(8) );
		//Oct
		g.drawRect(305, 400-(d1.val(9)), 25, d1.val(9) );
		g.fillRect(305, 400-(d1.val(9)), 25, d1.val(9) );
		//Nov
		g.drawRect(335, 400-(d1.val(10)),25, d1.val(10) );
		g.fillRect(335, 400-(d1.val(10)), 25, d1.val(10) );
		//Dec
		g.drawRect(365, 400-(d1.val(11)), 25, d1.val(11) );
		g.fillRect(365, 400-(d1.val(11)), 25, d1.val(11) );
		//prints the values
		g.setColor(Color.BLACK);
		g.setFont(new Font("Lucida Sans", Font.BOLD, 12));
		g.drawString(""+d1.val(0) , 40, 400);	//string,x,y
		g.drawString(""+d1.val(1), 70, 400);
		g.drawString(""+d1.val(2), 100, 400);
		g.drawString(""+d1.val(3), 130, 400);
		g.drawString(""+d1.val(4), 160, 400);
		g.drawString(""+d1.val(5), 190, 400);
		g.drawString(""+d1.val(6), 220, 400);
		g.drawString(""+d1.val(7), 250, 400);
		g.drawString(""+d1.val(8), 280, 400);
		g.drawString(""+d1.val(9), 310, 400);
		g.drawString(""+d1.val(10), 340, 400);
		g.drawString(""+d1.val(11), 370, 400);


	}

}
