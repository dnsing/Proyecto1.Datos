package Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Enemigos_A extends JPanel implements ActionListener{
	Timer t = new Timer(5,this);
	double x=1.0;
	double y=0;
	double VelX =2.0;
	double VelY= 2.0;
	Invaders_list listaEnemigos = new Invaders_list();
	int invasores;
	int espacio=60;
	Rectangle2D rect,rect1,rect2,rect3,rect4,rect5;
	int cont=0;
	
	HileraA listaA = new HileraA();
	public Enemigos_A() {
		t.start();
		anadisLista();
	}
	
	public void paintComponent1(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		
		rect = new Rectangle2D.Double(x,y,30,30);
		rect1 = new Rectangle2D.Double(x+espacio, y, 50, 30);
		rect2 = new Rectangle2D.Double(x+espacio*2, y, 30, 30);
		rect3 = new Rectangle2D.Double(x+espacio*3, y, 30, 30);
		rect4 = new Rectangle2D.Double(x+espacio*4, y, 30, 30);
		rect5 = new Rectangle2D.Double(x+espacio*5, y, 30, 30);
		
		switch(listaEnemigos.getSize()) {
		case(6):
			g2.setColor(Color.BLUE);

			g2.fill(rect);
			g2.fill(rect1);
			g2.fill(rect2);
			g2.fill(rect3);
			g2.fill(rect4);
			g2.fill(rect5);
			break;
		case(5):
			x=rect.getX();
			
			rect.setFrame(x+espacio*1, y, 30, 30);
			rect1.setFrame(x+espacio*2, y, 30, 30);
			rect2.setFrame(x+espacio*3, y, 30, 30);
			rect4.setFrame(x+espacio*4, y, 30, 30);
			rect5.setFrame(x+espacio*5, y, 30, 30);
			
			g2.fill(rect);
			g2.fill(rect1);
			g2.fill(rect2);
			g2.fill(rect4);
			g2.fill(rect5);
			break;
		case(4):
			x=rect.getX();
		
			rect.setFrame(x+espacio*1, y, 30, 30);
			rect1.setFrame(x+espacio*2, y, 30, 30);
			rect4.setFrame(x+espacio*3, y, 30, 30);
			rect5.setFrame(x+espacio*4, y, 30, 30);
			
			g2.fill(rect);
			g2.fill(rect1);
			g2.fill(rect4);
			g2.fill(rect5);
			break;
		case(3):
			x=rect.getX();
		
			rect.setFrame(x+espacio*1, y, 30, 30);
			rect1.setFrame(x+espacio*2, y, 30, 30);
			rect4.setFrame(x+espacio*3, y, 30, 30);
			
			g2.fill(rect);
			g2.fill(rect1);
			g2.fill(rect4);
			break;
		case(2):
			x=rect.getX();
		
			rect1.setFrame(x+espacio*1, y, 30, 30);
			rect4.setFrame(x+espacio*2, y, 30, 30);
			
			g2.fill(rect1);
			g2.fill(rect4);
			break;
		case(1):
			x=rect.getX();
			rect4.setFrame(x+espacio*1, y, 30, 30);
			g2.fill(rect4);
			break;
		case(0):
			HileraA hileraA = new HileraA();
			
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(x<800-espacio*listaEnemigos.getSize() && y==0+cont) {
			VelX =1.0;
			x+=VelX;
		}
		if(x>=750-espacio*listaEnemigos.getSize()) {
			if(y!=100) {
				y+=VelY;
			}
		}
		if(x<=750-espacio*listaEnemigos.getSize() && y>=100+cont && x!=0) {
			VelX=-1.0;
			x+=VelX;
		}
		if(x==0) {
			if(y!=200+cont) {
				y+=VelY;
				if(y==200+cont) {
					cont+=200;
				}
			}
		}
		repaint();
	}
	public void anadisLista() {
		listaA.add(rect);
		listaA.add(rect1);
		listaA.add(rect2);
		listaA.add(rect3);
		listaA.add(rect4);
		listaA.add(rect5);
	}
	
	public void addListaA() {
		
	}
	
	public RectangularShape getRect(JFrame frame) {
		return rect;
	}
	public void destruir() {
		listaA.deleteF();
		System.out.println(listaEnemigos.getSize());
	}
	public HileraA getListaA() {
		return listaA;
	}
}
