package modelagem.monopoly.gui;

import java.awt.Graphics2D;
import java.awt.Image;

import modelagem.monopoly.enums.PieceType;
import modelagem.monopoly.model.ImageFactory;
import modelagem.monopoly.model.Monopoly;
import modelagem.monopoly.model.Piece;
import modelagem.monopoly.model.Spot;


public class Pawn extends Piece{
	
	private Spot spot;
	private int balance;
	private Image img;
	private Image flag;
	
	public Pawn(PieceType t){
		switch(t){
		case PEAO1:
			this.img = ImageFactory.getImage("azul.png");
			this.flag = ImageFactory.getImage("bandeira_azul.png");
//			this.setY(10);
			break;
		case PEAO2:
			this.img = ImageFactory.getImage("vermelho.png");
			this.flag = ImageFactory.getImage("bandeira_vermelha.png");
			this.setX(20);
//			this.setY(10);
			break;
		case PEAO3:
			this.img = ImageFactory.getImage("verde.png");
			this.flag = ImageFactory.getImage("bandeira_verde.png");
			this.setY(10);
			break;
		case PEAO4:
			this.img = ImageFactory.getImage("amarelo.png");
			this.flag = ImageFactory.getImage("bandeira_amarela.png");
			this.setX(20);
			this.setY(10);
			break;
		case PEAO5:
			this.img = ImageFactory.getImage("branco.png");
			this.flag = ImageFactory.getImage("bandeira_branca.png");
			this.setY(20);
			break;
		case PEAO6:
			this.img = ImageFactory.getImage("preto.png");
			this.flag = ImageFactory.getImage("bandeira_preta.png");
			this.setX(20);
			this.setY(20);
			break;
		}
		this.setSpot(Monopoly.course.getFirst());
		this.setType(t);
		this.setBalance(2485);
	}
	
	public void drawPiece(Graphics2D g){
//		switch(this.getType()){
//		case PEAO1:
//			g.setColor(Color.BLUE);
//			break;
//		case PEAO2:
//			g.setColor(Color.RED);
//			break;
//		case PEAO3:
//			g.setColor(Color.GREEN);
//			break;
//		case PEAO4:
//			g.setColor(Color.ORANGE);
//			break;
//		case PEAO5:
//			g.setColor(Color.WHITE);
//			break;
//		case PEAO6:
//			g.setColor(Color.BLACK);
//			break;
//		}
//		g.fillOval(this.getX()+spot.getX(), this.getY()+spot.getY(), 20, 20);
		g.drawImage(this.img,this.getX()+spot.getX(),this.getY()+spot.getY(),null);
	}
	
	public void moveNSpots(int n){
		if(n+this.spot.getIndex() >= Monopoly.course.size()){
			int index = (n+this.spot.getIndex())-Monopoly.course.size();
			this.setSpot(Monopoly.course.get(index));
			//Aplica a regra de Honorarios se passar direto pelo ponto de partida
			if(index!=0){
				int[] nada = new int[2];
				nada[0] = 0;
				nada[1] = 0;
				Monopoly.judge.applyRule(this, Monopoly.course.get(0) ,nada);
			}
		}else{
			this.setSpot(Monopoly.course.get(n+this.spot.getIndex()));
		}
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setFlag(Image flag) {
		this.flag = flag;
	}
	
	public Image getFlag() {
		return this.flag;
	}

}
