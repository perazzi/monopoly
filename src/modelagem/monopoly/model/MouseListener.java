package modelagem.monopoly.model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import modelagem.monopoly.gui.Pawn;
public class MouseListener extends MouseAdapter{

	public MouseListener(Object o){

	}
	
	public void mouseClicked(MouseEvent e) { //Eventos e ações do click do Mouse
		try{
		//AREA DE CLIQUE DO DADO
			if (e.getX() > 180 && e.getX() < 300 && e.getY() > 200  && e.getY() < 250) {
				int[] dados = new int[2];
				if(Monopoly.campo.getText().length() > 0){
					dados[1] = Integer.valueOf(Monopoly.campo.getText());
					dados[0] = 0;
				}else{
					dados = Monopoly.rowDices();
				}
		       	
		       	Pawn currentPlayer = Monopoly.jogadores.get(Monopoly.currPlayer);
	//		       	curre ntPlayer.moveNSpots(sumDices);
				if(currentPlayer.getSpot().getIndex() == 10){ //Se o camarada está na prisão
					if(dados[0] == dados[1]){  //Se tiver e lançar dados iguais, anda sem pagar
						System.out.println("Dados iguais! Jogador sai sem pagar!");
						currentPlayer.moveNSpots(dados[1]+dados[0]);
				       	Monopoly.tabuleiro.repaint();
				       	Monopoly.judge.applyRule(currentPlayer, currentPlayer.getSpot(),dados);
					}else{ //Senão, anda, mas paga
						System.out.println("Jogador "+currentPlayer.getType().toString()+" pagou 200 para sair da prisão");
						Monopoly.dealer.debit(currentPlayer, 200);//Debita do jogador
						currentPlayer.moveNSpots(dados[1]+dados[0]);
						Monopoly.tabuleiro.repaint();
				       	Monopoly.judge.applyRule(currentPlayer, currentPlayer.getSpot(),dados);
					}
				}else{
					currentPlayer.moveNSpots(dados[1]+dados[0]);
			       	Monopoly.tabuleiro.repaint();
			       	Monopoly.judge.applyRule(currentPlayer, currentPlayer.getSpot(),dados);
				}
		       	Monopoly.changePlayer();
		       	Monopoly.printCurrentPlayer();
		       	Monopoly.tabuleiro.repaint();
			       
			}
		//IDENTIFICA A POSICAO DO CLIQUE
//		System.out.println("X = "+e.getX());
//		System.out.println("Y = "+e.getY());
		}catch(Exception evt){
		}
	}
	 
	 
}
