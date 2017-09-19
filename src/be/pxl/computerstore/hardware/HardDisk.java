package be.pxl.computerstore.hardware;

public class HardDisk extends Peripheral {
	public int storageSize;
	
	public HardDisk(String vendor, String name, double price, int storageSize) {
		super(vendor, name, price);
		this.storageSize = storageSize;
	}

}
