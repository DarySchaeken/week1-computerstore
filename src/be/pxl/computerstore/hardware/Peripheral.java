package be.pxl.computerstore.hardware;

public abstract class Peripheral extends ComputerComponent {

	public Peripheral(String vendor, String name, double price) {
		super(vendor, name, price);
	}

	@Override
	public String getShortDescription() {
		StringBuilder shortDescription = new StringBuilder(super.getShortDescription());
		shortDescription.insert(shortDescription.indexOf("*") + 2, this.getClass().getSimpleName() + " * ");
		return shortDescription.toString();
	}

}
