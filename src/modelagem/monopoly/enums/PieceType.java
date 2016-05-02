package modelagem.monopoly.enums;

public enum PieceType {
	 PEAO1, 
	 PEAO2, 
	 PEAO3, 
	 PEAO4, 
	 PEAO5, 
	 PEAO6,
	 CASA,
	 HOTEL,
	 DADO1,
	 DADO2;


	public String toString(){
		switch(this.ordinal()){
		case 0:
			return "PEAO1 - Azul";
		case 1:
			return "PEAO2 - Vermelho";
		case 2:
			return "PEAO3 - Verde";
		case 3:
			return "PEAO4 - Amarelo";
		case 4:
			return "PEAO5 - Branco";
		case 5:
			return "PEAO6 - Preto";
		default: return this.name();
		}
	}
}
