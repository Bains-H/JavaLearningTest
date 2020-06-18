
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image dest = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100;	//小球的横坐标
	double y = 100; //小球的纵坐标
	
	double degree = Math.PI/3; //弧度， 此处为60度
	
//	boolean right = true; //方向
	
	//画窗口的方法
	public void paint(Graphics g) {
		System.out.println("窗口被画了一次！");
		g.drawImage(dest, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x += 10 * Math.cos(degree);
		y += 10 * Math.sin(degree);
		
		if (y > 500-40-30 || y < 40+40) {
			degree = -degree;
		}
		if (x > 856-40-30 || x < 40) {
			degree = Math.PI - degree;
			
		}
		
//		if (right) {
//			x += 10;
//		}else {
//			x -= 10;
//		}
//		if (x > 856-40-30) {
//			right = false;
//		}
//		if (x < 40) {
//			right = true;
//		}
	}
	
	//窗口加载
	void launchFrame() {
		setSize(856,500);
		setLocation(50, 50);
		setVisible(true);
		
		//重画窗口,每秒画25次
		while (true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//main方法是程序执行的入口
	public static void main(String[] args) {
		System.out.println("我是尚学堂高淇，这个游戏让大家体验变成的快感，寓教于乐！");
		BallGame game = new BallGame();
		game.launchFrame();
		
	}

}
