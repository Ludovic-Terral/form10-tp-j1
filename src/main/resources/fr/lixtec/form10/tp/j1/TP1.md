# TP 1

## Exercice 1

On repr�sente un ascenseur dans un syst�me � l�aide d�une classe. La classe Ascenseur doit disposer de la m�thode publique getEtage() qui retourne le num�ro de l��tage auquel se trouve l�ascenseur. Si l�ascenseur est au rez-de-chauss�e, la m�thode retourne 0.

La classe Ascenseur a �galement la m�thode appeler(int etage) qui sert � appeler l�ascenseur � un �tage donn�. Cette m�thode a pour cons�quence d�amener l�ascenseur � l��tage donn�.

**La sortie standard affiche les mouvements de l'ascenceur**

Impl�mentez la classe Ascenseur. Ajoutez dans la classe une m�thode :

    public static void main(String[] args) {
    }

Dans la m�thode main, cr�ez un objet de type Ascenseur et appelez ses m�thodes. Apr�s chaque appel, affichez l'�volution de l�ascenseur. 


## Exercice 2

On souhaite cr�er une classe BoiteDeVitesses pour repr�senter une boite de vitesses. Cette classe contient les m�thodes :

**monterRapport()**
Pour passer � la vitesse sup�rieure

**retrograder()**
Pour passer � la vitesse inf�rieure

**getVitesse()**
Pour donner la vitesse courante (null repr�sente le point mort)

Impl�mentez la classe BoiteDeVitesses. Ajoutez dans la classe une m�thode :

    public static void main(String[] args) {
    }
    
Dans la m�thode main, vous allez simuler une voiture qui fait un run sur 400m d�part arr�t�. Pour cela, cr�ez une instance de type BoiteDeVitesses et simuler l'acc�laration jusqu'en 6e avant de revenir au point mort. 
Apr�s chaque changement de vitesse, affichez sur la sortie standard le num�ro de la vitesse courante.