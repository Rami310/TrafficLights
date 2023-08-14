import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Circle extends JPanel{

	private static final long serialVersionUID = 1L;
	private Timer timer;
    private int state = 0;
    private JLabel label;
    private Border b;
    
	public Circle() {
        setLayout(new BorderLayout());
 // Using null layout to freely position the label panel
	        label = new JLabel();
		    label.setFont(new Font("MV Boli", Font.PLAIN, 30));
		    label.setBackground(Color.black);
		    label.setOpaque(true);
		    label.setVerticalAlignment(JLabel.CENTER);
		    label.setHorizontalAlignment(JLabel.CENTER);
	        add(label, BorderLayout.PAGE_START);
		timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                state++;
	                if (state > 4) {
	                    state = 0; // Stop the timer when the final state is reached
	                } else {
	                    repaint(); // Trigger repaint on timer tick
	                }
	            }
	        }, 0, 2000);
    }
	
	 @Override
	    public void paint(Graphics g) {
		 	
	        switch (state) {
	            case 1:
	                stop(g);
	                break;
	            case 2:
	                getReady(g);
	                break;
	            case 3:
	                go(g);
	                break;
	            case 4:
	            	slowDown(g);
	            	break;
	           
	        }
	    }
	
	void drawRectangle(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(430, 150, 100, 290);
		g.fillRect(430, 150, 100, 290);
	}
	
	void stop(Graphics g) {
		
		//Stop
		
		drawRectangle(g);
		
		//drawing the label
		
	    label.setForeground(Color.red);
	    label.setText("STOP!");
	    b = BorderFactory.createLineBorder(Color.red, 3);
		label.setBorder(b);
	    //drawing the red light
		g.setColor(Color.red);
		g.fillOval(445, 170, 70, 70);
		

	}
	
	void getReady(Graphics g) {
		//Get Ready
		
		//drawing the label
		label.setForeground(Color.orange);
		label.setText("GET READY");
		b = BorderFactory.createLineBorder(Color.orange, 3);
		label.setBorder(b);

		//draw orange light
		g.setColor(Color.orange);
		g.fillOval(445, 250, 70, 70);
	}
	
	void go(Graphics g) {
		//Go
		
		//drawing the label
		label.setForeground(Color.green);
		label.setText("GO");
		b = BorderFactory.createLineBorder(Color.green, 3);
		label.setBorder(b);

		//Clear red light
		g.setColor(Color.black);
		g.fillOval(445, 170, 70, 70);
		
		//Clear orange light
		g.setColor(Color.black);
		g.fillOval(445, 250, 70, 70);
		
		//draw green light
		g.setColor(Color.green);
		g.fillOval(445, 330, 70, 70);
	}
	
	void slowDown(Graphics g) {
		//Slow Down
		//drawing the label
		label.setForeground(Color.orange);
		label.setText("SLOW DOWN!");
		b = BorderFactory.createLineBorder(Color.orange, 3);
		label.setBorder(b);

		// Clear green light
		g.setColor(Color.black);
		g.fillOval(445, 330, 70, 70);
		
		//draw Orange light
		g.setColor(Color.orange);
		g.fillOval(445, 250, 70, 70);
	}
	
}
