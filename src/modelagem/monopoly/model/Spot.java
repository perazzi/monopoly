package modelagem.monopoly.model;

import java.awt.Color;
import java.awt.Graphics2D;

import modelagem.monopoly.enums.RuleType;
import modelagem.monopoly.gui.Pawn;

public class Spot{
	
	private Region region;
	private int index;
	private int price;
	private String name;
	private Color color;
	private int x;
	private int y;
	private RuleType rule;
	private Pawn owner;
	private Rent rent;
	private int numberOfHouses = 0;
	private boolean hasHotel = false;
	private int eachHouse = 0;
	
	public Spot(int index,String name,Rent rnt, int price,RuleType rule,int x, int y){
		this.setIndex(index);
		this.setName(name);
		this.setRule(rule);
		this.setPrice(price);
		this.setX(x);
		this.setY(y);
		this.setRent(rnt);
	}
	
	public Spot(int index,String name, Rent rnt, int eachBuilding,int price,RuleType rule,int x, int y, Region r){
		this.setIndex(index);
		this.setName(name);
		this.setRule(rule);
		this.setPrice(price);
		this.setX(x);
		this.setY(y);
		this.setEachHouse(eachBuilding);
		this.setRent(rnt);
		this.region = r;
		region.addSpot(this);
	}
	
	public int howMuch(){
		if(!hasHotel){
			switch(this.numberOfHouses){
			case 1:
				return rent.getHousex1();
			case 2:
				return rent.getHousex2();
			case 3:
				return rent.getHousex3();
			case 4:
				return rent.getHousex4();
			default:
				return rent.getDefaultValue();
			}
		}else{
			return rent.getHotel();
		}
	}
	
	public boolean canBuyHouse(Pawn p){
		if(ownsRegion(p) && this.numberOfHouses < region.getmaxNumber()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean canBuyHotel(Pawn p){
		return (this.numberOfHouses == 4 && this.hasHotel == false);
	}
	
	public boolean ownsRegion(Pawn p){
		return this.region.ownsRegion(p);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public RuleType getRule() {
		return rule;
	}

	public void setRule(RuleType rule) {
		this.rule = rule;
	}

	public Pawn getOwner() {
		return owner;
	}

	public void setOwner(Pawn owner) {
		this.owner = owner;
	}
	
	public boolean hasOwner(){
		return !(this.owner == null);
	}
	
	public void printFlag(Graphics2D g){
		g.drawImage(this.owner.getFlag(),this.x,this.y,null);
		Monopoly.tabuleiro.repaint();
	}
	
	public void printElements(Graphics2D g){
		for(int i=0;i<numberOfHouses;i++){
			switch(i){
			case 0:
				g.drawImage(ImageFactory.getImage("house.png"),this.x+20,this.y+20,20,20,null);
				break;
			case 1:
				g.drawImage(ImageFactory.getImage("house.png"),this.x+40,this.y+40,20,20,null);
				break;
			case 2:
				g.drawImage(ImageFactory.getImage("house.png"),this.x+20,this.y+40,20,20,null);
				break;
			case 3:
				g.drawImage(ImageFactory.getImage("house.png"),this.x+40,this.y+20,20,20,null);
				break;
			}
			if(this.hasHotel){
				g.drawImage(ImageFactory.getImage("hotel.png"),this.x+20,this.y+20,40,40,null);
			}
			
		}
		Monopoly.tabuleiro.repaint();
	}
	
	
	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public int getNumberOfHouses() {
		return numberOfHouses;
	}

	public void addNumberOfHouses() {
		this.numberOfHouses++;
		this.region.update();
	}

	public boolean isHasHotel() {
		return hasHotel;
	}

	public void setHasHotel(boolean hasHotel) {
		this.hasHotel = hasHotel;
	}

	public int getEachHouse() {
		return eachHouse;
	}
	
	public Region getRegion(){
		return this.region;
	}

	public void setEachHouse(int eachHouse) {
		this.eachHouse = eachHouse;
	}
}
