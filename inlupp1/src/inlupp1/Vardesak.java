package inlupp1;

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
	

/// SUBCLASSES ******************
	class Stocks extends Vardesak{
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

	}
	
	class Jewelry extends Vardesak{
		private int gemstone;
		private boolean gold;
		private boolean silver;
		
		public Jewelry(String name, int gemstone, boolean gold, boolean silver) {
			super(name);
			this.gemstone = gemstone;
			this.gold = gold;
			this.silver = silver;

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
		public boolean isSilver() {
			return silver;
		}
		public void setSilver(boolean silver) {
			this.silver = silver;
		}
	}
	
	class Gadget extends Vardesak{
		private double purchasePrice;
		private int wear;
		
		public Gadget(String name, double purchasePrise, int wear) {
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
	}