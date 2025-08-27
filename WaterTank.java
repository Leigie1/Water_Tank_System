package dsa;

//abstract class
abstract class WaterTank{
	int capacity;
	int waterLevel;
	
	WaterTank(int capacity){
		this.capacity = capacity;
		this.waterLevel = 0;
		
	}
	//abstract methods
	abstract void fillTank(int liters);
	abstract void useWater(int liters);
	abstract String checkStatus();
}