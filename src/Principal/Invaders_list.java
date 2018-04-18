package Principal;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Invaders_list {
	Invaders head;
	Invaders temp;
	int size;

	public Invaders_list() {
		head = null;
		temp = null;
		size = 0;
	}

	public void add(Rectangle2D rect) {
		if (head == null) {
			head = new Invaders(rect);
			head.next = null;
			temp = head;
		} else {
			Invaders temp1 = this.head;
			while (temp1.getNext() != null) {
				temp1 = temp1.getNext();
			}
			temp1.setNext((new Invaders(rect)));
		}
		size++;
	}

	public void deleteF() {
		head = head.getNext();
		size--;
	}

	public void dele(int i) {
		if (i > size) {
			throw new IndexOutOfBoundsException("indice no valido");
		} else if (i == 0) {
			this.deleteF();
			return;
		} else {
			int cont = 0;
			Invaders temporal = head;
			while (cont < i - 1) {
				temporal = temporal.getNext();
				cont++;
			}
			temporal.setNext(temporal.getNext().getNext());
		}
		size--;
	}

	public int getPos() {
		return size - 1;
	}

	public void getRect() {
		Invaders temp1 = head;
		while(temp1 != null) {
			System.out.println(temp1);
			temp1 = temp1.next;
		}
	}
	public Rectangle2D obtener(int indice) {
		Invaders temporal = head;
		for(int i=0;i<indice;i++) {
			temporal = temporal.getNext();
		}
		return temporal.getRec();
	}
	public RectangularShape getRect(int i) {
		int c = 1;
		Invaders temporal = head;
		while (i <= size) {
			if (i != c) {
				temporal = temporal.getNext();
				c += 1;
			}
			break;
		}
		return temporal.getRec();
	}
	
	public int getSize(){
		return size;
	}
	

}
