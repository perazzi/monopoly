package modelagem.monopoly.facade;

import java.util.Collections;
import java.util.LinkedList;

import modelagem.monopoly.enums.PieceType;
import modelagem.monopoly.enums.RuleType;
import modelagem.monopoly.gui.Chance;
import modelagem.monopoly.gui.Dice;
import modelagem.monopoly.gui.Pawn;
import modelagem.monopoly.model.Monopoly;
import modelagem.monopoly.model.Region;
import modelagem.monopoly.model.Rent;
import modelagem.monopoly.model.Spot;

public class MonopolyFacade {

	
	public static Dice[] createDiceSet(){
		Dice[] dices = new Dice[2];
		dices[0] = new Dice(PieceType.DADO1);
		dices[1] = new Dice(PieceType.DADO2);
		return dices;
	}
	
	public static LinkedList<Spot> getCourseSpots(){
		Region wine = new Region("wine");
		Region blue = new Region("blue");
		Region purple = new Region("purple");
		Region red = new Region("red");
		Region yellow = new Region("yellow");
		Region green = new Region("green");
		Region marine = new Region("marine");
		
		LinkedList<Spot> course = new LinkedList<Spot>();
		
		course.add(new Spot(0,"Ponto de Partida",null,200,RuleType.HONORARIOS,675,20));
		course.add(new Spot(1,"Leblon",new Rent(6,30,90,270,400,500),50,100,RuleType.ALUGUEL,675,106,wine));
		course.add(new Spot(2,"Sorte-Rev�s",null,0,RuleType.SORTE_OU_REVES,675,169));
		course.add(new Spot(3,"Av. Presidente Vargas",new Rent(2,10,30,90,160,250),50,60,RuleType.ALUGUEL,675,231,wine));
		course.add(new Spot(4,"Av. Nossa S. de Copacabana",new Rent(4,20,60,180,320,450),50,60,RuleType.ALUGUEL,675,295,wine));
		course.add(new Spot(5,"Companhia Ferroviaria",new Rent(50),200,RuleType.PASSAGEM,675,358));
		course.add(new Spot(6,"Av. Brigadeiro Faria Lima",new Rent(20,100,300,750,925,1100),150,240,RuleType.ALUGUEL,675,422,blue));
		course.add(new Spot(7,"Companhia de Via��o",new Rent(50),200,RuleType.PASSAGEM,675,485));
		course.add(new Spot(8,"Av. Rebou�as",new Rent(18,90,250,700,875,1050),150,220,RuleType.ALUGUEL,675,547,blue));
		course.add(new Spot(9,"Av. 9 de Julho",new Rent(18,90,250,700,875,1050),150,220,RuleType.ALUGUEL,675,609,blue));
		course.add(new Spot(10,"Pris�o",null,0,RuleType.PARADA_LIVRE,694,677));
		course.add(new Spot(11,"Av. Europa",new Rent(16,80,220,600,800,1000),100,200,RuleType.ALUGUEL,602,670,purple));
		course.add(new Spot(12,"Sorte-Rev�s",null,0,RuleType.SORTE_OU_REVES,540,670));
		course.add(new Spot(13,"Rua Augusta",new Rent(14,70,200,550,750,950),100,180,RuleType.ALUGUEL,479,670,purple));
		course.add(new Spot(14,"Av. Pacaemb�",new Rent(14,70,200,550,750,950),100,180,RuleType.ALUGUEL,415,670,purple));
		course.add(new Spot(15,"Companhia de Taxi",new Rent(40),150,RuleType.PASSAGEM,354,670));
		course.add(new Spot(16,"Sorte-Rev�s",null,0,RuleType.SORTE_OU_REVES,292,670));
		course.add(new Spot(17,"Interlagos",new Rent(35,175,500,1100,1300,1500),200,350,RuleType.ALUGUEL,230,670,red));
		course.add(new Spot(18,"Lucros ou Dividendos",null,200,RuleType.HONORARIOS,167,670));
		course.add(new Spot(19,"Morumbi",new Rent(50,200,600,1400,1700,2000),200,400,RuleType.ALUGUEL,106,670,red));
		course.add(new Spot(20,"Parada Livre",null,0,RuleType.PARADA_LIVRE,28,670));
		course.add(new Spot(21,"Flamengo",new Rent(8,40,100,300,450,600),50,120,RuleType.ALUGUEL,30,607,red));
		course.add(new Spot(22,"Sorte-Rev�s",null,0,RuleType.SORTE_OU_REVES,30,547));
		course.add(new Spot(23,"Botafogo",new Rent(6,30,90,270,400,500),50,100,RuleType.ALUGUEL,30,483,red));
		course.add(new Spot(24,"Imposto de Renda",null,200,RuleType.PAGAMENTO_OBRIGATORIO,30,421));
		course.add(new Spot(25,"Companhia de Navega��o",new Rent(40),150,RuleType.PASSAGEM,30,358));
		course.add(new Spot(26,"Av. Brasil",new Rent(12,60,180,500,700,900),100,160,RuleType.ALUGUEL,30,295,yellow));
		course.add(new Spot(27,"Sorte-Rev�s",null,140,RuleType.SORTE_OU_REVES,30,232));
		course.add(new Spot(28,"Av. Paulista",new Rent(10,50,150,450,625,750),100,140,RuleType.ALUGUEL,30,168,yellow));
		course.add(new Spot(29,"Jardim Europa",new Rent(10,50,150,450,625,750),100,140,RuleType.ALUGUEL,30,105,yellow));
		course.add(new Spot(30,"V� para a Pris�o",null,0,RuleType.VA_PARA_A_PRISAO,30,20));
		course.add(new Spot(31,"Copacabana",new Rent(6,30,90,270,400,500),150,260,RuleType.ALUGUEL,103,20,green));
		course.add(new Spot(32,"Companhia de Avia��o",new Rent(50),200,RuleType.PASSAGEM,166,20));
		course.add(new Spot(33,"Av. Vieira Souto",new Rent(28,150,450,1000,1200,1400),200,320,RuleType.ALUGUEL,230,20,green));
		course.add(new Spot(34,"Av. Atl�ntica",new Rent(26,130,390,900,1100,1275),200,300,RuleType.ALUGUEL,293,20,green));
		course.add(new Spot(35,"Companhia de t�xi aereo",new Rent(50),200,RuleType.PASSAGEM,356,20));
		course.add(new Spot(36,"Ipanema",new Rent(26,130,390,900,1100,1275),200,300,RuleType.ALUGUEL,420,20,green));
		course.add(new Spot(37,"Sorte-Rev�s",null,0,RuleType.SORTE_OU_REVES,484,20));
		course.add(new Spot(38,"Jardim Paulista",new Rent(24,120,360,850,1025,1150),150,260,RuleType.ALUGUEL,547,20,marine));
		course.add(new Spot(39,"Brooklin",new Rent(22,110,330,800,975,1150),150,260,RuleType.ALUGUEL,610,20,marine));
		return course;
	}
	
	public static void initialize(){
		Pawn p1 = new Pawn(PieceType.PEAO1);
		Pawn p2 = new Pawn(PieceType.PEAO2);
//		Pawn p3 = new Pawn(PieceType.PEAO3);
//		Pawn p4 = new Pawn(PieceType.PEAO4);
//		Pawn p5 = new Pawn(PieceType.PEAO5);
//		Pawn p6 = new Pawn(PieceType.PEAO6);
		p1.setSpot(Monopoly.course.get(0));
		p2.setSpot(Monopoly.course.get(0));
//		p3.setSpot(Monopoly.course.get(0));
//		p4.setSpot(Monopoly.course.get(0));
//		p5.setSpot(Monopoly.course.get(0));
//		p6.setSpot(Monopoly.course.get(0));
		Monopoly.jogadores.add(p1);
		Monopoly.jogadores.add(p2);
//		Monopoly.jogadores.add(p3);
//		Monopoly.jogadores.add(p4);
//		Monopoly.jogadores.add(p5);
//		Monopoly.jogadores.add(p6);
		Monopoly.tabuleiro.addPiece(p1);
		Monopoly.tabuleiro.addPiece(p2);
//		Monopoly.tabuleiro.addPiece(p3);
//		Monopoly.tabuleiro.addPiece(p4);
//		Monopoly.tabuleiro.addPiece(p5);
//		Monopoly.tabuleiro.addPiece(p6);
		Monopoly.tabuleiro.addPiece(Monopoly.dados[0]);
		Monopoly.tabuleiro.addPiece(Monopoly.dados[1]);
	}
	
	public static LinkedList<Chance> getChanceSet(){
		LinkedList<Chance> chanceSet = new LinkedList<Chance>();
		chanceSet.add(new Chance(1,'R',"Um amigo pediu-lhe um empr�stimo.\nVoc� nao pode recusar.",15));
		chanceSet.add(new Chance(2,'R',"Voc� vai casar e est� comprando \num apartamento novo.",25));
		chanceSet.add(new Chance(3,'R',"O m�dico lhe recomendou repouso num\n bom hotel de montanha",45));
		chanceSet.add(new Chance(4,'R',"Voc� achou interessante assistir �\n estr�ia da temporada de ballet.\nCompre os ingressos.",30));
		chanceSet.add(new Chance(5,'R',"V� para a pris�o sem receber nada.\n(talvez eu lhe fa�a uma visita...)",-1));
		chanceSet.add(new Chance(6,'R',"Voc� estacionou seu carro em lugar\nproibido e entrou na contra m�o.",30));
		chanceSet.add(new Chance(7,'R',"Papai, os livros do ano passado n�o\nservem mais, preciso de livros novos",40));
		chanceSet.add(new Chance(8,'R',"V� para a pris�o sem receber nada.\n(talvez eu lhe fa�a uma visita...)",-1));
		chanceSet.add(new Chance(9,'R',"Voc� estacionou seu carro em lugar\nproibido e entrou na contra m�o.",30));
		chanceSet.add(new Chance(10,'R',"Voc� acaba de receber a comunica��o\ndo imposto de Renda",50));
		chanceSet.add(new Chance(11,'R',"Seu clube est� ampliando as piscinas.\nOs s�cios devem contribuir",25));
		chanceSet.add(new Chance(12,'R',"Renove a tempo a licen�a do seu autom�vel",30));
		chanceSet.add(new Chance(13,'R',"Seus parentes do interior vieram\npassar umas f�rias na sua casa",45));
		chanceSet.add(new Chance(14,'R',"Seus filhos j� v�o para a escola.\nPague a primeira mensalidade",50));
		chanceSet.add(new Chance(15,'R',"A geada prejudicou a sua safra de caf�",50));
		chanceSet.add(new Chance(1,'S',"A prefeitura mandou abrir uma nova\navenida, para o que desapropriou v�rios pr�dios.\nEm consequencia seu terreno valorizou",25));
		chanceSet.add(new Chance(2,'S',"Houve um assalto � sua loja, mas voc�\nestava segurado.",150));
		chanceSet.add(new Chance(3,'S',"Um amigo tinha lhe pedido um empr�stimo\ne se esqueceu de devolver. Ele acaba de se lembrar.",80));
		chanceSet.add(new Chance(4,'S',"Voc� est� com sorte. Suas a��es na Bolsa\nest�o em alta.",200));
		chanceSet.add(new Chance(5,'S',"Voc� trocou seu carro usado com um amigo\ne ainda saiu lucrando.",50));
		chanceSet.add(new Chance(6,'S',"Voc� acaba de receber uma parcela do seu\n13 sal�rio",50));
		chanceSet.add(new Chance(7,'S',"Voc� tirou o primeiro lugar no torneio de\nt�nis do seu clube, parab�ns.",150));
		chanceSet.add(new Chance(8,'S',"O seu cachorro policial tirou o 1 pr�mio\nna exposi��o do Kennel Club",100));
		chanceSet.add(new Chance(9,'S',"Sa�da livre da pris�o.\n(Conserve este cart�o para quando lhe for preciso ou\nnegocie-o em qualquer ocasi�o, por pre�o a combinar)",-5));
		chanceSet.add(new Chance(10,'S',"Avance at� o ponto de partida e...",200));
		chanceSet.add(new Chance(11,'S',"Voc� apostou com os parceirosdeste jogo e ganhou. (Receba 50 de cada um)",-4));
		chanceSet.add(new Chance(12,'S',"Voc� saiu de f�rias e se hospedou na casa de um amigo.\nVoc� economizou o hotel.",45));
		chanceSet.add(new Chance(13,'S',"Inesperadamente voc� recebeu uma heran�a\nque j� estava esquecida.",100));
		chanceSet.add(new Chance(14,'S',"Voc� foi promovido a diretor da sua empresa.",100));
		chanceSet.add(new Chance(15,'S',"Voc� jogou na Loteria Esportiva\ne ganhou com um grupo de amigos.",150));
		Collections.shuffle(chanceSet);
		return chanceSet;
	}
	
	
	
}
