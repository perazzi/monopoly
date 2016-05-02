package modelagem.monopoly.model;

import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelagem.monopoly.gui.Chance;
import modelagem.monopoly.gui.Pawn;

/*Observacoes
 * Códigos valores especiais para Cartas de Sorte ou Revés
 * -1 : va para a prisao
 * -2 : pague a todos  // parece q nao existe
 * -4 : receba de todos
 * -5 : passe livre
 * */
public class Judge implements Observer{
	
	private static StringBuffer sb;
	
	public Judge(){
		
	}
	
	public void applyRule(Pawn p,Spot s,int[] valoresDados){
		int sumDices = valoresDados[0] + valoresDados[1];
		switch(s.getRule()){
		case PASSAGEM:
			if(s.hasOwner()){
				if(s.getOwner() == p){// Se o player cair na propria casa, faz nada
					//nada ne
				}else{// se nao for player, faz a transacao e pergunta pro dono se deseja trocar
					int val = sumDices * s.getRent().getDefaultValue();
					Monopoly.dealer.debit(p, val);
					Monopoly.dealer.credit(s.getOwner(), val);
					askTrocaSpot(p, s);
				}
			}else{
				if(p.getBalance()>=s.getPrice())
					askCompraSpot(p,s);
			}
			break;
		case  ALUGUEL:
			if(s.hasOwner()){
				if(s.getOwner() == p){
					if(s.ownsRegion(p)){
						askCompraCasa(p,s);
					}
				}else{
					Monopoly.dealer.debit(p, s.howMuch());//Debita do jogador
					Monopoly.dealer.credit(s.getOwner(), s.howMuch());//Credita no dono
					askTrocaSpot(p, s);
				}
			}else{
				if(p.getBalance()>=s.getPrice())
					askCompraSpot(p,s);
				else
					System.out.println("Saldo insuficiente para compra"); //falencia
			}
			break;
		case HONORARIOS:
			Monopoly.dealer.credit(p, s.getPrice());
			break;
		case SORTE_OU_REVES:
			Chance card = Monopoly.chances.getFirst();
			JOptionPane.showConfirmDialog(null,null,card.getChanceType(),JOptionPane.OK_CANCEL_OPTION,JOptionPane.OK_CANCEL_OPTION,new ImageIcon(card.getImage()));
			if(card.getChanceType() == "sorte"){
				switch(card.getValue()){
				case -4:
					Monopoly.dealer.credit(p, 50*(Monopoly.jogadores.size()-1));
					for(Pawn player:Monopoly.jogadores){ //tira o valor de todo mundo menos ele
						if(player!=p){
							Monopoly.dealer.debit(player,50);
						}
					}
					break;
				case -5:
					//Tratar caso da carta passe livre
					break;
				default:
					Monopoly.dealer.credit(p, card.getValue());
					break;
				}
			}else{
				switch(card.getValue()){
				case -1:
					p.setSpot(Monopoly.course.get(10));
					sb = new StringBuffer();
					sb.append("Jogador ").append(p.getType().toString()).append(" foi para a prisão");
					System.out.println(sb.toString());
					Monopoly.tabuleiro.repaint();
					break;
//				case -2:
//					if(p.getBalance()>card.getValue()){
//						p.setBalance(p.getBalance()-card.getValue()*(Monopoly.jogadores.size()-1));//tira dele
//						Monopoly.dealer.printDebit(card.getValue()*(Monopoly.jogadores.size()-1), p);
//						for(Pawn player:Monopoly.jogadores){ //deposita o valor em todos menos ele
//							if(player!=p){
//								player.setBalance(player.getBalance()+card.getValue());
//								Monopoly.dealer.printCredit(card.getValue(), player);
//							}
//						}
//					}else{
//						//vai a falencia
//					}
//					break;
				default:
					if(p.getBalance()>=card.getValue()){
						Monopoly.dealer.debit(p, card.getValue());
					}else{
						//vai a falencia
					}
					break;
				}
			}
			card.drawPiece(Monopoly.tabuleiro.getGraphics2D());
			Monopoly.chances.remove(card);
			Monopoly.chances.addLast(card);
			break;
		case PAGAMENTO_OBRIGATORIO:
			Monopoly.dealer.debit(p, s.getPrice());
			break;
		case PARADA_LIVRE:
			break;
		case VA_PARA_A_PRISAO:
			p.setSpot(Monopoly.course.get(10));
			System.out.println("Jogador " + p.getType().toString() + " foi para a prisão");
			break;
		}
		Monopoly.dealer.printBalance(p);
	}
	
	private void askCompraCasa(Pawn p, Spot s){
		if(s.canBuyHouse(p) && p.getBalance() >= s.getEachHouse()){
			sb = new StringBuffer();
			sb.append("Deseja comprar uma casa no terreno \n");
			sb.append(s.getName());
			sb.append("\nPor R$");
			sb.append(s.getEachHouse());
			sb.append("?");
			if(JOptionPane.showConfirmDialog(null,sb.toString(),p.getType().toString(),JOptionPane.YES_NO_OPTION,JOptionPane.YES_NO_OPTION,new ImageIcon(ImageFactory.getImage("s"+String.valueOf(s.getIndex())+".png"))) == JOptionPane.YES_OPTION){
				s.addNumberOfHouses();
				Monopoly.dealer.debit(p, s.getEachHouse());
			}
		}else if(s.canBuyHotel(p)  && p.getBalance() >= s.getEachHouse()){
			sb = new StringBuffer();
			sb.append("Deseja comprar um Hotel no terreno \n");
			sb.append(s.getName());
			sb.append("\nPor R$");
			sb.append(s.getEachHouse());
			sb.append("?");
			if(JOptionPane.showConfirmDialog(null,sb.toString(),p.getType().toString(),JOptionPane.YES_NO_OPTION) == 0){
				s.setHasHotel(true);
				Monopoly.dealer.debit(p, s.getEachHouse());
			}
		}
	}
	
	private void askTrocaSpot(Pawn p, Spot s){
		sb = new StringBuffer();
		sb.append("Jogador ");
		sb.append(s.getOwner().getType().toString());
		sb.append("deseja vender seu terreno para o jogador ");
		sb.append(p.getType().toString());
		sb.append("\n Por R$");
		sb.append(s.getPrice()*s.getNumberOfHouses());
		sb.append("?");
		if(JOptionPane.showConfirmDialog(null,sb.toString(),p.getType().toString(),JOptionPane.YES_NO_OPTION) == 0){
			Monopoly.dealer.credit(s.getOwner(), s.getPrice());
			Monopoly.dealer.debit(p, s.getPrice());
			s.setOwner(p);
		}
	}
	
	private void askCompraSpot(Pawn p,Spot s){
		sb = new StringBuffer();
		sb.append("Deseja comprar o terreno \n");
		sb.append(s.getName());
		sb.append("\nPor R$");
		sb.append(s.getPrice());
		sb.append("?");
		//Quer comprar? //1 no 0 yes
		if(JOptionPane.showConfirmDialog(null,sb.toString(),p.getType().toString(),JOptionPane.YES_NO_OPTION,JOptionPane.YES_NO_OPTION,new ImageIcon(ImageFactory.getImage("s"+String.valueOf(s.getIndex())+".png"))) == JOptionPane.YES_OPTION){
			s.setOwner(p);
			Monopoly.dealer.debit(p, s.getPrice());
			sb = new StringBuffer();
			sb.append("Jogador ").append(p.getType().toString()).append(" comprou ").append(p.getSpot().getName());
			sb.append("\nForam debitados ").append("R$").append(s.getPrice()).append(" de seu balanço.");
			System.out.println(sb.toString());
		}
	}

	@SuppressWarnings("static-access")
	@Override
	public void update(Observable o, Object arg) {
		Pawn p = (Pawn) arg;
		System.out.println(p.getType().toString() + " Foi a falencia");
		Monopoly.jogadores.remove(p); // Tira ele do tabuleiro
		Monopoly.tabuleiro.pieces.remove(p); // Remove a peça
		for(Spot s:Monopoly.course){ // Deseta as casas q ele é dono
			if(s.getOwner() == p){
				s.setOwner(null);
			}
		}
	}
	
}
