package inlupp1;

import java.util.Comparator;

public class Vardesak {
	
	
	private String name;
	private double value;
	


	public Vardesak(String name) {
		this.name = name;
		this.value = value;
	}
	// GETTERS & SETTERS
	public String getName() {
		return name;
	}
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	public void addValue(double value) {
		this.value += value;
	}

}


/// SORT 
class SortByName implements Comparator<Vardesak>{
	@Override
	public int compare(Vardesak a, Vardesak b) {
		return a.getName().compareTo(b.getName());
	}
}

class SortByValue implements Comparator<Vardesak>{
	@Override
	public int compare(Vardesak a, Vardesak b) {
		return (int) (a.getValue() - b.getValue());
	}
}

	

/// SUBCLASSES ******************
	class Stocks extends Vardesak{
		private int quantity;
		private double quotation;
		
		
		public Stocks(String name, int quantity, double quotation) {
			super(name);
			this.quantity = quantity;
			this.quotation = quotation;
			calculateValue();
		}
		
		public void calculateValue() {
			double tempValue = 0;
			tempValue = quantity*quotation;
			setValue(tempValue);
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
			calculateValue();
		}

	}
	
	class Jewelry extends Vardesak{
		private int gemstone;
		private boolean gold;
		
		public Jewelry(String name, int gemstone, boolean gold) {
			super(name);
			this.gemstone = gemstone;
			this.gold = gold;
			calculateValue();
		}
		
		public void calculateValue() {
			double tempValue = 0.0;
			if(gold) {
				tempValue += 2000.0; 
			}
			tempValue += gemstone*500.0;
			setValue(tempValue);
		}
		
		// GETTERS & SETTERS
		public int getGemstone() {
			return gemstone;
		}
		public void setGemstone(int gemstone) {
			this.gemstone = gemstone;
		}
		public boolean isGold() {
			return gold;
		}
		public void setGold(boolean gold) {
			this.gold = gold;
		}
	}
	
	class Gadget extends Vardesak{
		private double purchasePrice;
		private int wear;
		
		public Gadget(String name, double purchasePrice, int wear) {
			super(name);
			this.purchasePrice = purchasePrice;
			this.wear = wear;
			calculateValue();
		}
		
		public void calculateValue() {
			double tempValue = 0;
			tempValue += (wear/10)*purchasePrice;
			setValue(tempValue);
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
	}