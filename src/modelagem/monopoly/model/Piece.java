package modelagem.monopoly.model;

import modelagem.monopoly.enums.PieceType;
import modelagem.monopoly.gui.MonopolyPiece;

public abstract class Piece implements MonopolyPiece {

	private int x = 0;
	private int y = 0;
	private PieceType type;
	

	//Getters & Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public PieceType getType() {
		return type;
	}

	protected void setType(PieceType type) {
		this.type = type;
	}
	
}
