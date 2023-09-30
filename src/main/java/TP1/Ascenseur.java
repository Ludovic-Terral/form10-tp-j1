package TP1;

public class Ascenseur {

	
	private int _etageCurrent;
	
	public void setEtageInit(int etage) {
		_etageCurrent = etage;
	}
	
	public int getEtage() {
		return _etageCurrent;
	}
	
	
	public void appelerDepuis(int etage) {
		
		System.out.print(">>Etage  ");
		System.out.print(etage);
		System.out.println("<<");
		
		System.out.print("Etage courant: ");
		System.out.println( getEtage());
		
		while(_etageCurrent != etage) {
		
			if ( _etageCurrent < etage) {
			_etageCurrent++;
			}
			else {
				_etageCurrent--;
			}
				
			 System.out.print("etage courant: ");
			 System.out.println( getEtage());
		}
	}
	
	
    public static void main(String[] args) {
    	
    	Ascenseur A = new Ascenseur();
    	A.setEtageInit(10);
    	A.appelerDepuis(5);
    	
    }
    
    
    
	
}
