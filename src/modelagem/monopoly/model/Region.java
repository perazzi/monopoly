package modelagem.monopoly.model;

import java.util.ArrayList;
import java.util.List;

import modelagem.monopoly.gui.Pawn;

public class Region {

	private List<Spot> spots;
	private String name;
	private int maxNumber = 1;
	
	public Region(String name){
		this.name = name;
		spots = new ArrayList<Spot>();
	}
	
	public void addSpot(Spot s){
		this.spots.add(s);
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean ownsRegion(Pawn p){
		boolean b = true;
		for(Spot s:spots)
			b=ownsSpot(p,s) && b;
		return b;
	}
	
	public int getmaxNumber(){
		if(maxNumber<=4)
			return maxNumber;
		else
			return 4;
	}
	
	public boolean ownsSpot(Pawn p, Spot s){
		return p.getType() == s.getOwner().getType();
	}
	
	 public void update() {
		boolean b = true;
		int num = spots.get(0).getNumberOfHouses();
		for(Spot s:spots){
			b = s.getNumberOfHouses() == num;
			num = s.getNumberOfHouses();
		}
		if(b && num == maxNumber && maxNumber <= 4){
			maxNumber++;
			System.out.println("Liberando compra de mais uma casa em cada territorio "+name);
		}
			
	 }
}
