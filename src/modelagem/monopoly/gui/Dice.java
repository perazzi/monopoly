package modelagem.monopoly.gui;

import java.awt.Graphics2D;
import java.awt.Image;

import modelagem.monopoly.enums.PieceType;
import modelagem.monopoly.model.ImageFactory;
import modelagem.monopoly.model.Piece;

public class Dice extends Piece{
	
	private int value;
	private Image img;

	public Dice(PieceType t){
		switch(t){
		case DADO1:
			this.setX(180);
			this.setY(200);
			break;
		case DADO2:
			this.setX(250);
			this.setY(200);
			break;
		}
		this.setType(t);
		this.value = roll();
	}
	
	public void drawPiece(Graphics2D g){
//		System.out.println("desenhando dado "+this.getType().toString());
		g.drawImage(this.img,this.getX(),this.getY(),50,50,null);
	}
	
	public int roll(){
		this.value = (int) (1 + (Math.random() * (6)));
		this.img = ImageFactory.getImage(String.valueOf(this.value));
		return this.value;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
