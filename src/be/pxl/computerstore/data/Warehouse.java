package be.pxl.computerstore.data;

import be.pxl.computerstore.hardware.ComputerCase;
import be.pxl.computerstore.hardware.ComputerComponent;
import be.pxl.computerstore.hardware.GamingController;
import be.pxl.computerstore.hardware.HardDisk;
import be.pxl.computerstore.hardware.Keyboard;
import be.pxl.computerstore.hardware.KeyboardLayout;
import be.pxl.computerstore.hardware.Monitor;
import be.pxl.computerstore.hardware.Mouse;
import be.pxl.computerstore.hardware.Peripheral;
import be.pxl.computerstore.hardware.Processor;
import be.pxl.computerstore.hardware.WebCam;
import be.pxl.computerstore.util.Dimension;

public class Warehouse {
	
	public static ComputerComponent[] computerComponents;
	
	static {
		ComputerCase computerCase1 = new ComputerCase("Aerocool", "CS-102 Midi-Toren zwart", 24.70);
		computerCase1.setDimension(new Dimension(170, 345, 325));
		computerCase1.setWeight(1.9);

		ComputerCase computerCase2 = new ComputerCase("Sharkoon", "VS4-V ATX", 30.63);
		computerCase2.setDimension(new Dimension(200, 430, 445));
		computerCase2.setWeight(3.5);

		ComputerCase computerCase3 = new ComputerCase("Chieftec", "CQ-01B-U3", 31.94);
		computerCase3.setDimension(new Dimension(160, 428, 410));
		computerCase3.setWeight(3.7);

		HardDisk hd1 = new HardDisk("WD", "WD5000LPCX", 46.48, 500);
		HardDisk hd2 = new HardDisk("Seagate", "BarraCuda ST500LM030", 42.51, 500);
		HardDisk hd3 = new HardDisk("Intenso", "SSD", 49.56, 128);

		Processor processor1 = new Processor("Intel", "Core i9 79000X", 813.14, 3.7);
		Processor processor2 = new Processor("AMD", "Ryzen 7 1800X", 400.27, 2.4);

		Keyboard azerty = new Keyboard("Trust", "eLight LED Illuminated", 8.14, KeyboardLayout.AZERTY);
		Keyboard azerty2 = new Keyboard("Kensington", "ValuKeyboard", 12.70, KeyboardLayout.AZERTY);
		Keyboard qwerty = new Keyboard("Logitech", "K120", 13.54, KeyboardLayout.QWERTY);

		Mouse mouse1 = new Mouse("HP", "X1000", 7.63);
		Mouse mouse2 = new Mouse("Conceptronic", "Lounge", 7.44);

		WebCam webcam1 = new WebCam("Trust", "Primo", 12.49);

		Monitor monitor = new Monitor("HP", "v197 18.5''", 89.15);
		Monitor monitor2 = new Monitor("Philips", "V-line", 93.21);

		GamingController controller1 = new GamingController("Logitech", "F310 Gamepad", 29.40);
		GamingController controller2 = new GamingController("Thrustmaster", "Ferrari 458 Italia", 77.55);

		computerComponents = new ComputerComponent[] { computerCase1, computerCase2, computerCase3, hd1, hd2, hd3, processor1,
				processor2, azerty, azerty2, qwerty, mouse1, mouse2, webcam1, monitor, monitor2, controller1,
				controller2 };
	}
	
	public void displayProcessors() {
		for(ComputerComponent component: computerComponents){
			if(component instanceof Processor){
				System.out.println(component.getShortDescription());
			}
		}
	}
	
	public void displayComputerCases() {
		for(ComputerComponent component: computerComponents){
			if(component instanceof ComputerCase){
				System.out.println(component.getShortDescription());
			}
		}
	}
	
	public void displayPeripherals() {
		for(ComputerComponent component: computerComponents){
			if(component instanceof Peripheral){
				System.out.println(component.getShortDescription());
			}
		}
	}
}
