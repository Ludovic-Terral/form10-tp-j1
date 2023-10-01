package TP3;

public class Case {

	public enum ContentCase{	
		VIDE,
		VAISSEAU,	
	};
	
	private ContentCase _contentCase;
	private Boolean _isReveal;
	
	public Case(){
		 _contentCase = ContentCase.VIDE;
		_isReveal = false;	
	}
	
	public ContentCase getContentCase() {
		return _contentCase;
	}
	
	public void setContentCase(ContentCase content) {
		_contentCase = content;
	}
	
}
