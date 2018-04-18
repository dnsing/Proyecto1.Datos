package Principal;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Invaders{
	double X;
	double Y;
	Rectangle2D invader;
	Invaders next;

	public Invaders(Rectangle2D rect){
		this.invader = rect;
		this.next = null;
	}
	
	public Rectangle2D getRec() {
		return invader;
	}
	
	public void setNext(Invaders next) {
		this.next = next;
	}
	
	public Invaders getNext() {
		return next;
	}
	
}
