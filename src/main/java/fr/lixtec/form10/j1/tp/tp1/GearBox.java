package fr.lixtec.form10.j1.tp.tp1;

public class GearBox {
	
	private int gear = 0;
	
	public int getGear() {
		return this.gear;
	}
	
	public void gearUp() {
		this.gear++;
	}
	
	public void gearDown() {
		this.gear--;
	}

	public static void main(String[] args) {
		
		GearBox gearbox = new GearBox();
		
		while (gearbox.getGear() < 6) {
			System.out.println(gearbox.getGear());
			gearbox.gearUp();
		}
		
		while (gearbox.getGear() > 0) {
			System.out.println(gearbox.getGear());
			gearbox.gearDown();
		}

		System.out.println(gearbox.getGear());
		
	}

}
