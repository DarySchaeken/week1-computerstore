package be.pxl.computerstore.hardware;

import java.util.Random;

public abstract class ComputerComponent {
	private String vendor;
	private String name;
	private double price;
	private String articleNumber;

	private static int baseArticleNumber = 0;
	private static Random ramdomArticleNumberGenerator = new Random();

	public ComputerComponent(String vendor, String name, double price) {
		this.vendor = vendor;
		this.name = name;
		this.price = price;

		articleNumber = generateArticleNumber();
		baseArticleNumber++;

	}

	private String generateArticleNumber() {
		StringBuilder articleNumber = new StringBuilder(13);
		StringBuilder vendor = new StringBuilder(this.vendor.toUpperCase());
		while (vendor.length() < 3) {
			vendor.append('X');
		}
		articleNumber.append(vendor.substring(0, 3));
		articleNumber.append('-');
		StringBuilder baseArticleNumber = new StringBuilder(Integer.toString(ComputerComponent.baseArticleNumber));
		while (baseArticleNumber.length() < 5) {
			baseArticleNumber.insert(0, '0');
		}
		articleNumber.append(baseArticleNumber);
		articleNumber.append('-');
		for (int i = 0; i < 3; i++) {
			articleNumber.append(ramdomArticleNumberGenerator.nextInt(9) + 1);
		}

		return articleNumber.toString();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	@Override
	public String toString() {
		return "ArticleNumber = " + articleNumber + "\nVendor = " + vendor + "\nName = " + name + "\nPrice = " + price;
	}
	
	public String getShortDescription(){
		return articleNumber + " * " + name + " * " + price + "€";
	}
}
