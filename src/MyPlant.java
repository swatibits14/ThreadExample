import java.awt.*;
public class MyPlant {

	public static void main(String args[])
	{
		Frame f = new Frame();
		f.setBounds(0, 0, 1280, 600);
        f.setLayout(new BorderLayout());
       
		
		Panel p1 = new Panel();
		p1.setBounds(0, 0, 800,400);
		p1.setBackground(Color.GREEN);
		Panel p2 = new Panel();
		p2.setBounds(800, 200, 100, 100);
		p2.setBackground(Color.BLUE);
		Button b1 = new Button("Press");
		b1.setVisible(true);
		b1.setEnabled(true);
		p2.add(b1);
		p2.setVisible(true);
		f.add(p1);
		f.add(p2);
		 f.setVisible(true);
	}
	
}
