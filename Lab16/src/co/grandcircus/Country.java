package co.grandcircus;

public class Country {
	private String newCountry;
	// private double price;
	// private boolean isRed;

	public Country(String newCountry /* , double price, boolean isRed */ ) {
		this.newCountry = newCountry;
		// this.price = price;
		// this.isRed = isRed;
	}

	public String getType() {
		return newCountry;
	}

	public void setType(String newCountry) {
		this.newCountry = newCountry;
	}

	// public double getPrice() {
	// return price;
	// }
	// public void setPrice(double price) {
	// this.price = price;
	// }
	// public boolean isRed() {
	// return isRed;
	// }
	// public void setRed(boolean isRed) {
	// this.isRed = isRed;
	// }
	@Override
	public String toString() {
		return newCountry;
	}

}