package fr.lixtec.form10.j1.tp.tp3;

public class Board {
	
	public static final int DEFAULT_WIDTH = 10;
	public static final int DEFAULT_HEIGHT = 8; // A-H
	public static final int MIN_WIDTH = 3; // Universe ship: 3*2
	public static final int MAX_WIDTH = 20; // Default ratio for area
	public static final int MIN_HEIGHT = 2;
	public static final int MAX_HEIGHT = 26; // A-Z
	public static final int DEFAULT_AREA = DEFAULT_WIDTH * DEFAULT_HEIGHT;
	public static final int MIN_AREA = 18; // Space occupied by all ships
	public static final int MAX_AREA = MAX_WIDTH * MAX_HEIGHT;	
	
	private int w;
	private int h;
	
	public Board() {
		this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	public Board(int w, int h) throws IllegalArgumentException {
		int area = w * h;
		
		boolean is_dimension_valid = true;
		is_dimension_valid = is_dimension_valid && (area >= MIN_AREA && area <= MAX_AREA);
		is_dimension_valid = is_dimension_valid && (w >= MIN_WIDTH && w <= MAX_WIDTH);
		is_dimension_valid = is_dimension_valid && (h >= MIN_HEIGHT && h <= MAX_HEIGHT);
		if (!is_dimension_valid)
			throw new IllegalArgumentException("Board dimension is not valid");
		
		this.w = w;
		this.h = h;
	}
	
	public int getWidth() {
		return this.w;
	}
	
	public int getHeight() {
		return this.h;
	}
	
}
