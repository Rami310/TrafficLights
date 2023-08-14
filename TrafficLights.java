import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TrafficLights {

	public static void main(String[] args) {
		
		ImageIcon image = new ImageIcon("trafficLightsIcon.png");
		ImageIcon streetImg = new ImageIcon("streetImage.png");
		JLabel background = new JLabel(streetImg);
		Circle c = new Circle();
		
		JFrame frame = new JFrame();
		frame.setTitle("Traffic Lights");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(image.getImage());
		frame.setSize(500, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(background);
		frame.pack();
		frame.add(c);
		
	}

}
