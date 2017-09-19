package be.pxl.computerstore.hardware;

import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable {
	private Processor processor;
	private ComputerCase computerCase;
	private Peripheral[] peripherals = new Peripheral[MAX_PERIPHERAL];
	public static final int MAX_PERIPHERAL = 3;

	public ComputerSystem() {

	}

	public Processor getProcessor() {
		return processor;
	}

	public void setProcessor(Processor processor) {
		this.processor = processor;
	}

	public ComputerCase getComputerCase() {
		return computerCase;
	}

	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}

	public void addPeripheral(Peripheral peripheral) {
		for (int i = 0; i < peripherals.length; i++) {
			if (peripherals[i] == null) {
				peripherals[i] = peripheral;
				return;
			}
		}
		throw new TooManyPeripheralsException();
	}

	public void removePeripheral(String articleNumber) {
		for (int i = 0; i < peripherals.length; i++) {
			if (peripherals[i] != null && peripherals[i].getArticleNumber() == articleNumber) {
				peripherals[i] = null;
				break;
			}
		}
	}

	public int getNumberOfPeripherals() {
		int counter = 0;
		for (Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				counter++;
			}
		}
		return counter;
	}

	public Peripheral[] getPeripherals() {
		return peripherals;
	}

	@Override
	public double totalPriceExcl() {
		double totalPriceExclusive = processor.getPrice() + computerCase.getPrice();
		for (Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				totalPriceExclusive += peripheral.getPrice();
			}
		}
		return totalPriceExclusive;
	}

	@Override
	public String toString() {
		StringBuilder returnString  = new StringBuilder("Computercase:\n" + computerCase.toString() + "\nProcessor:\n" + processor.toString());
		int printedPeripheral = 1;
		for (Peripheral peripheral: peripherals) {
			if (peripheral != null) {
				returnString.append("\nRandapparaat " + printedPeripheral + ":\n" + peripheral.toString());
				printedPeripheral++;
			}
		}
		returnString.append("\nTOTAAL EXCL.:" + String.format("%.2f", totalPriceExcl()));
		returnString.append("\nTOTAAL INCL.:" + String.format("%.2f", totalPriceIncl()));
		return returnString.toString();
	}

}
