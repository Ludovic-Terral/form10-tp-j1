package TP3;

class Case {
	
	private int positionRow;
	private int positionColumn;
	private char content;
	
	public char getContent() {
		return this.content;
	}
	
	Case(int positionRow, int positionColumn) {
		this.positionColumn = positionColumn;
		this.positionRow = positionRow;
		this.content = 'X';
		
		if(this.positionColumn == 0) {
			this.content = '[';
		}
		if(this.positionColumn == 22) {
			this.content = ']';
		}
		if(this.positionColumn%2 == 0 && this.positionColumn%2 != 0 ) {
			this.content = ',';
		}
		if(this.positionColumn%2 == 1 && this.positionColumn%2 != 0) {
			this.content = ',';
		}
		
	}
	
	public void setCase() {
		
	}
}

