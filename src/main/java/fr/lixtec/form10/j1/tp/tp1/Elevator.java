package fr.lixtec.form10.j1.tp.tp1;

public class Elevator {
	private int floor = 0;
	
	public int getFloor() {
		return this.floor;
	}
	
	public void callFrom(int floor) {
		this.floor = floor;
	}
	
	public static void main(String args[]){
		Elevator elevator = new Elevator();
		System.out.println(elevator.getFloor());
		elevator.callFrom(4);
		System.out.println(elevator.getFloor());
	}
}
