package modelagem.monopoly.model;

import java.util.Observable;

import modelagem.monopoly.gui.Pawn;

public class Dealer extends Observable {
	
	public Dealer(){
		
	}

	private static StringBuffer sb;
	
	public void printDebit(int value, Pawn p){
		sb = new StringBuffer();
		sb.append("Debitado R$" ).append(value).append(" do jogador ").append(p.getType().toString());
		System.out.println(sb.toString());
	}
	
	public void printCredit(int value, Pawn p){
		sb = new StringBuffer();
		sb.append("Creditado  R$" ).append(value).append(" ao jogador ").append(p.getType().toString());
		System.out.println(sb.toString());
	}
	
	public void printBalance(Pawn p){
		sb = new StringBuffer();
		sb.append("Balanço atual do jogador ").append(p.getType().toString()).append(" R$").append(p.getBalance());
		System.out.println(sb.toString());
	}
	
	public void credit(Pawn p, int value){
		p.setBalance(p.getBalance()+value);
		printCredit(value, p);
	}
	
	public void debit(Pawn p, int value){
		if(p.getBalance() < value){ // O camarada faliu, Avisa ao juiz
			System.out.println("notificando");
			notifyObservers(p);
		}else{
			p.setBalance(p.getBalance()-value);
			printDebit(value, p);
		}
		if(p.getBalance() < value){
			Monopoly.judge.update(this, p);
		}
	}
}
