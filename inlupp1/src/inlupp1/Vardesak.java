package inlupp1;

import java.util.Comparator;

abstract class Vardesak {

	private String name;
	private double value;

	public Vardesak(String name) {
		this.name = name;

	}

	// GETTERS & SETTERS
	public String getName() {
		return name;
	}

	public String toString() {
		String str = name + " value: " + getValueWithTax();
		return str;
	}

	abstract public double getValue();

	public double getValueWithTax() {
		return (double) (getValue() * 1.25);
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void addValue(double value) {
		this.value += value;
	}

}

/// SORT
class SortByName implements Comparator<Vardesak> {
	@Override
	public int compare(Vardesak a, Vardesak b) {
		return a.getName().compareTo(b.getName());
	}
}

class SortByValue implements Comparator<Vardesak> {
	@Override
	public int compare(Vardesak a, Vardesak b) {
		return (int) (a.getValue() - b.getValue());
	}
}

/// SUBCLASSES ******************
class Stocks extends Vardesak { // done
	private int quantity;
	private double quotation;

	public Stocks(String name, int quantity, double quotation) {
		super(name);
		this.quantity = quantity;
		this.quotation = quotation;

	}

	// GETTERS & SETTERS
	public int getQuantity() {
		return quantity;
	}

	public double getQuotation() {
		return quotation;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setQuotation(double quotation) {
		this.quotation = quotation;
		
	}

	@Override
	public double getValue() {
		return quantity * quotation;
	}

	public String toString() {
		return super.toString() + "  quotation: " + quotation + " quantity: " + quantity;
	}

}

class Jewelry extends Vardesak { // done

	private int gemstone;
	private int gemNumber;
	private int tempValue;
	private boolean isGold;

	public Jewelry(String name, int gemstone, boolean gold) {
		super(name);

		gemNumber = gemstone;
		isGold = gold;
		if (gold)
			tempValue = 2000;
		else
			tempValue = 700;

	}

	public int getGemNumber() {
		return gemstone;
	}

	public String toString() {
		return super.toString() + "  gemstone: " + gemstone;
	}

	public boolean getIsGold() {
		return isGold;
	}

	@Override
	public double getValue() {
		return tempValue + (gemNumber * 500);

	}
}

class Gadget extends Vardesak {
	private double purchasePrice;
	private int wear;

	public Gadget(String name, double purchasePrice, int wear) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.wear = wear;
		
	}

	// GETTERS & SETTERS
	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getWear() {
		return wear;
	}

	public void setWear(int wear) {
		this.wear = wear;
	}
	@Override
	public double getValue() {
		return purchasePrice *(wear *0.1);

	}

	public String toString() {
		return super.toString()+" price: "+ purchasePrice +" wear: "+ wear;
	}

}