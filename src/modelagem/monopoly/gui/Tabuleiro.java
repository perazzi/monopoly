package modelagem.monopoly.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import modelagem.monopoly.model.Monopoly;
import modelagem.monopoly.model.MouseListener;
import modelagem.monopoly.model.Piece;
import modelagem.monopoly.model.Spot;


public class Tabuleiro extends JPanel{
	private static final long serialVersionUID = 8857604899088362464L;
	
	private Graphics2D g2d;
	public static List<Piece> pieces;
	Image img1 = Toolkit.getDefaultToolkit().getImage("tabuleiro.png");
	
	public Tabuleiro (){
		pieces = new ArrayList<Piece>();
		addMouseListener(new MouseListener(this));
	}
	
	public void paintComponent(Graphics g){//Desenha um novo Canvas
		super.paintComponent(g);
		g2d=(Graphics2D) g;  
		g2d.drawImage(img1,0, 0,this);
		for(Spot s:Monopoly.course){
			if(s.hasOwner()){
				s.printFlag(g2d);
				s.printElements(g2d);
			}
		}
		for(Piece p:pieces){
			p.drawPiece(g2d);
//			System.out.println(pieces.size());
		}
	}
	

	public Graphics2D getGraphics2D(){
		return g2d;
	}

	public List<Piece> getPieces() {
		return pieces;
	}
	
	public void addPiece(Piece p){
		pieces.add(p);
	}


}
