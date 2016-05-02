package modelagem.monopoly.model;

public class Rent {

	private int defaultValue = 0;
	private int housex1 = 0;
	private int housex2 = 0;
	private int housex3 = 0;
	private int housex4 = 0;
	private int hotel = 0;

	public Rent(int def) {
		this.setDefaultValue(def);
	}

	public Rent(int def, int one, int two, int three, int four, int hotel) {
		this.setDefaultValue(def);
		this.setHousex1(one);
		this.setHousex2(two);
		this.setHousex3(three);
		this.setHousex4(four);
		this.setHotel(hotel);
	}
	
	
	public int getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}

	public int getHousex1() {
		return housex1;
	}

	public void setHousex1(int housex1) {
		this.housex1 = housex1;
	}

	public int getHousex2() {
		return housex2;
	}

	public void setHousex2(int housex2) {
		this.housex2 = housex2;
	}

	public int getHousex3() {
		return housex3;
	}

	public void setHousex3(int housex3) {
		this.housex3 = housex3;
	}

	public int getHousex4() {
		return housex4;
	}

	public void setHousex4(int housex4) {
		this.housex4 = housex4;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}



}
