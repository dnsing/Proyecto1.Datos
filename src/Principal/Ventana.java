package Principal;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.RectangularShape;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame{
	static int puntaje=0;

	public static void main(String[] args) {

		JFrame frame = new JFrame("Space Invaders");
		frame.setSize(800, 800);
		frame.setBackground(Color.BLACK);
		
		Label label = new Label();
		label.setText("Puntaje: "+ puntaje);
		label.setBounds(50, 50, 100, 100);
		frame.add(label);

		Enemigos enemigos = new Enemigos();
		frame.add(enemigos);
		frame.requestFocus();
		
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code==KeyEvent.VK_UP) {
					int cont=0;
					lista(cont);
					cont++;
				}
			}

			private void lista(int cont) {
				Invaders_list lista= enemigos.getLista();
				
				Random random = new Random();
				if(lista.getSize()<=0) {
					System.out.println("Lista Vacia");
					
				}else {
					int intR=random.nextInt(lista.getSize());
					lista.dele(cont);
					puntaje+=100;
					label.setText("Puntaje: "+ puntaje);
					System.out.println(lista.getSize());
				}
			}
		
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		

	}


}
