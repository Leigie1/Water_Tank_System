package dsa;

import javax.swing.JOptionPane;



//Home Tank Subclass
class HomeTank extends WaterTank{
	HomeTank() {
		super(200);
	}
	@Override
	public void fillTank(int liters) {
		if(waterLevel+liters>capacity) {
			waterLevel=capacity;
		}else {
			waterLevel+=liters;
		}
		JOptionPane.showMessageDialog(null, liters + " liter(s) added. Current Water level: " 
                + waterLevel + "/" + capacity);
	}

	@Override
	public void useWater(int liters) {
		if (waterLevel - liters < 0) {
            waterLevel = 0;
        } else {
            waterLevel -= liters;
        }
        JOptionPane.showMessageDialog(null, liters + " liters used. Current Water level: " 
                + waterLevel + "/" + capacity);
    }
		
	

	@Override
	public String checkStatus() {
		if (waterLevel == 0) return "Tank is Empty!";
        else if (waterLevel == capacity) return "Tank is Full!";
        else return "Tank is In Use.";
	}
	
}
// Building Tank Subclass
class BuildingTank extends WaterTank{

	BuildingTank() {
		super(1000);
	}
	@Override
	public void fillTank(int liters) {
		if(waterLevel+liters>capacity) {
			waterLevel=capacity;
		}else {
			waterLevel+=liters;
		}
		JOptionPane.showMessageDialog(null, liters + " liter(s) added. Current Water level: " 
                + waterLevel + "/" + capacity);
	}

	@Override
	public void useWater(int liters) {
		if (waterLevel - liters < 0) {
            waterLevel = 0;
        } else {
            waterLevel -= liters;
        }
        JOptionPane.showMessageDialog(null, liters + " liters used. Current Water level: " 
                + waterLevel + "/" + capacity);
    }
		
	

	@Override
	public String checkStatus() {
		if (waterLevel == 0) return "Tank is Empty!";
        else if (waterLevel == capacity) return "Tank is Full!";
        else return "Tank is In Use.";
	}
	
}
//Main class
public class WaterTankSystem {
	public static void main(String[] args) {
		String choice = JOptionPane.showInputDialog("Enter type of tank:\n(1) HomeTank (200L)\n(2) BuildingTank (1000L)");
        WaterTank tank;

        if ("1".equals(choice)) {
            tank = new HomeTank();
        } else {
            tank = new BuildingTank();
        }

        while (true) {
            String action = JOptionPane.showInputDialog("Choose action:\n(1) Fill Tank\n(2) Use Water\n(3) Check Status");
            if (action == null) break;

            switch (action) {
                case "1":
                    int fillLiters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                    tank.fillTank(fillLiters);
                    break;
                case "2":
                    int useLiters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                    tank.useWater(useLiters);
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, tank.checkStatus());
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice, Try again");
            }

            //END if full or empty
            String status = tank.checkStatus();
            if (status.equals("Tank is Empty!") || status.equals("Tank is Full!")) {
                JOptionPane.showMessageDialog(null, status + " Program ended.");
                break;
            }
        }
    }
}
	

