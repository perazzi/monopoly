package modelagem.monopoly.gui;

import java.awt.Graphics2D;
import java.awt.Image;

import modelagem.monopoly.model.ImageFactory;
import modelagem.monopoly.model.Piece;

public class Chance extends Piece{
	
	private int number;
	private String chanceType;
	private String descript;
	private int value;
	
	public Chance(int no,char chanceType,String descript,int value){
		this.setX(506);
		this.setY(506);
		if(chanceType == 'R'){
			this.setChanceType("reves");
		}else{
			this.setChanceType("sorte");
		}
		this.setDescript(descript);
		this.setValue(value);
		this.setNumber(no);
	}

	public void drawPiece(Graphics2D g) {
		
	}

	public Image getImage(){
		return ImageFactory.getImage(this.getChanceType()+this.getNumber()+".PNG");
	}
	
	public String getChanceType() {
		return chanceType;
	}

	public void setChanceType(String chanceType) {
		this.chanceType = chanceType;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
