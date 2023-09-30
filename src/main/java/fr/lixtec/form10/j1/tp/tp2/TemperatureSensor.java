package fr.lixtec.form10.j1.tp.tp2;

public class TemperatureSensor {
	
	public enum LEVEL {
		NORMAL(Float.MIN_VALUE, 30.0f),
		HIGH(NORMAL.limit, 38.0f),
		CRITICAL(HIGH.limit, Float.MAX_VALUE);
		
		private Float limit;
		private Float floor;
		public Float limit() { return this.limit; }
		public Float floor() { return this.floor; }
		
		LEVEL(Float floor, Float limit) {
			this.floor = floor;
			this.limit = limit;
		}
	}

	private float temperature;
	private LEVEL level;
	
	public TemperatureSensor() {
		this.setTemperature(0.0f);
	}
	
	public void setTemperature(float temperature) {
		this.temperature = temperature;
		this.setLevel();
	}
	
	private void setLevel() {
		for (LEVEL level : LEVEL.values()) {
			this.level = temperature > level.floor() ? level : this.level;
		}
	}
	
	public LEVEL getLevel() {
		return this.level;
	}
	
	public boolean isLevel(LEVEL level) {
		return this.level.compareTo(level) >= 0;
	}
	
	public static void main(String[] args) {
		
		TemperatureSensor temperatureSensor = new TemperatureSensor();
		
		for (float temperature = 25.0f; temperature < 45.0f; temperature += 2.0f) {
			
			temperatureSensor.setTemperature(temperature);
			
			System.out.print("""
				Temperature: %.2f°C
				LEVEL: %s
			""".formatted(
				temperature,
				temperatureSensor.getLevel()
			));
			
			for (LEVEL level : LEVEL.values())
				System.out.print("\t" + level + ": " + temperatureSensor.isLevel(level));
			System.out.println("\n");
			
		}
	}

}
