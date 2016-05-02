package modelagem.monopoly.model;

import java.awt.BorderLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextField;

import modelagem.monopoly.facade.MonopolyFacade;
import modelagem.monopoly.gui.Chance;
import modelagem.monopoly.gui.Dice;
import modelagem.monopoly.gui.Frame;
import modelagem.monopoly.gui.Pawn;
import modelagem.monopoly.gui.Tabuleiro;

//Classe que representa o jogo em si
public class Monopoly {

	public static Tabuleiro tabuleiro;
	public static List<Pawn> jogadores;
	public static Dice[] dados;
	public static LinkedList<Spot> course;
	public static LinkedList<Chance> chances;
	public static int currPlayer = 0;
	public static JTextField campo = new JTextField();
	public static Dealer dealer;
	public static Judge judge;
	
	public Monopoly(){
		Frame frame = new Frame();
		tabuleiro = new Tabuleiro();
		jogadores = new LinkedList<Pawn>();
		course = MonopolyFacade.getCourseSpots();
		chances = MonopolyFacade.getChanceSet();
		dados = MonopolyFacade.createDiceSet();
		dealer = new Dealer();
		judge = new Judge();
		frame.getContentPane().add(tabuleiro,BorderLayout.CENTER);
		dealer.addObserver(judge);
		MonopolyFacade.initialize();
		frame.setVisible(true);
		printCurrentPlayer();
		Frame aux = new Frame(200,50);
		aux.add(campo);
		aux.setTitle("Mover n casas:");
		aux.setVisible(true);
//		tabuleiro.repaint();
		
	}
	
	public static int[] rowDices(){
		dados[0].roll();
		dados[1].roll();
		System.out.println(dados[0].getType()+" caiu em "+dados[0].getValue());
		System.out.println(dados[1].getType()+" caiu em "+dados[1].getValue());
		int[] valores = new int[2];
		valores[0] = dados[0].getValue();
		valores [1] = dados[1].getValue();
		return valores;
	}
	
	public static void changePlayer(){
		if(currPlayer < jogadores.size()-1){
			currPlayer++;
		}else{
			currPlayer = 0;
		}
	}
	
	public static Pawn getCurrentPlayer(){
		if(jogadores.size()>0){
			return jogadores.get(Monopoly.currPlayer);
		}else return null;
	}
	
	public static void printCurrentPlayer(){
		if(getCurrentPlayer()!=null){
			System.out.println("----------\nJogador da vez: "+getCurrentPlayer().getType());
			System.out.println("Saldo atual: R$"+getCurrentPlayer().getBalance());
		}
	}

	
}
