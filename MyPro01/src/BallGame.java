
import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image dest = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100;	//С��ĺ�����
	double y = 100; //С���������
	
	double degree = Math.PI/3; //���ȣ� �˴�Ϊ60��
	
//	boolean right = true; //����
	
	//�����ڵķ���
	public void paint(Graphics g) {
		System.out.println("���ڱ�����һ�Σ�");
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
	
	//���ڼ���
	void launchFrame() {
		setSize(856,500);
		setLocation(50, 50);
		setVisible(true);
		
		//�ػ�����,ÿ�뻭25��
		while (true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//main�����ǳ���ִ�е����
	public static void main(String[] args) {
		System.out.println("������ѧ�ø�俣������Ϸ�ô�������ɵĿ�У�Ԣ�����֣�");
		BallGame game = new BallGame();
		game.launchFrame();
		
	}

}
