package flybird;

import java.io.IOException;

import javax.swing.JFrame;

public class Game {
	public static void main(String[] ags) throws IOException, InterruptedException {
		JFrame jframe=new JFrame();
		BirdGame birdGame=new BirdGame();
		System.out.println();
		jframe.add(birdGame);
		jframe.setSize(440, 670);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setVisible(true);
		birdGame.birdAction();
	}
}
