package TP3;

import java.awt.Font;

import TP3.Vaiseau.Vaisseau;

public class Case {

	public enum ContentCase{	
		VIDE,
		VAISSEAU,	
	};
	
	
	public enum Color{	
		RESET("\u001B[0m"),
		VERT("\u001B[32m"),
		ROUGE("\u001B[31m");
		
		private String _code;
		
	    Color(String code) {
	        _code = code;
	    }
	
	    public String getCode() {
	    	return _code; 
	    }
	   }
	
	
	private ContentCase _contentCase;
	//private TypeVaisseau _typeVaisseau;
	private Boolean _isReveal;
	private Vaisseau _v;
	
	public Case(){
		 _contentCase = ContentCase.VIDE;
	//	 _typeVaisseau = TypeVaisseau.VIDE;
		_isReveal = true;
		_v = new Vaisseau();
	}
	
	public ContentCase getContentCase() {
		return _contentCase;
	}
	public Boolean getIsReveal() {
		return _isReveal;
	}
	public Vaisseau getVaisseau() {
		return _v;
	}
	//public TypeVaisseau getTypeVaisseau() {
	//	return _typeVaisseau;
	//}
	
	public void setContentCase(ContentCase content) {
		_contentCase = content;
	}
	public void setIsReveal(Boolean bool) {
		_isReveal = bool;
	}
	public void setVaisseau(Vaisseau v) {
		_v = v;
	}
	
	
	
	public void afficheCaractereCase(char c, Color color) {
		String reset = "\u001B[0m";
		System.out.print( color.getCode() + c + reset); //
	}
	
	/*
	public void afficheCaseViergeVerte() {
		
		//Font policeMonospace = new Font("Monospaced", Font.PLAIN, 12);
		String greenColor = "\u001B[32m";
		String pion = "\u26C2";
		String reset = "\u001B[0m";
		System.out.print( greenColor + pion + reset); //
	}
	
	public void afficheCaseVaisseau() {
		
		//Font policeMonospace = new Font("Monospaced", Font.PLAIN, 12);
		String redColor = "\u001B[31m";
		String reset = "\u001B[0m";
		System.out.print( redColor + "#" + reset); //
	}
	*/
	
	//public void setTypeVaisseau(TypeVaisseau typeVaisseau){
	//	_typeVaisseau = typeVaisseau;
	//}
	
}
