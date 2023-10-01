package TP3;

public class Vaisseau {
	
	protected String _name;
	
	protected int _cote1;
	protected int _cote2;
	protected static int _pv;
	
	protected int _longueurVerticale;
	protected int _longueurHorizontale;
	
	public Vaisseau(int cote1, int cote2) {
		_cote1 = cote1;
		_cote2 = cote2;
		_pv = _cote1 * _cote2;
		
		positionHorizontale();

	}
	
	public void positionHorizontale() {
		
		if (_cote1 < _cote2) {
			_longueurVerticale = _cote1;
			_longueurHorizontale = _cote2;
		}			
		else {
			_longueurVerticale = _cote2;
			_longueurHorizontale = _cote1;
		}
	};
		
	public void positionVerticale() {
		if (_cote1 < _cote2) {
			_longueurVerticale = _cote2;
			_longueurHorizontale = _cote1;
		}			
		else {
			_longueurVerticale = _cote1;
			_longueurHorizontale = _cote2;
		}
		
	};
	
	public int getLongueurVerticale() {
		return _longueurVerticale;
	}
	public int getLongueurHorizontale() {
		return _longueurHorizontale;
	}
	
	public int getPercentLife() {
		return ( _pv*100/(_cote1*_cote2) ) ;
	};
	
	public void damage() {
		_pv--;
	}
	
	public String getName() {
		return _name;
	}
	
	public String getStatsVaisseu() {
		String txt;
		txt = "Vaisseau de la classe " + getName() + " ";
		
		if (_pv == 0)
			txt += "désintégré";
		else {
			txt += "opérationnel à " + getPercentLife() + "%";
		}
		
		return txt;
	}
}
