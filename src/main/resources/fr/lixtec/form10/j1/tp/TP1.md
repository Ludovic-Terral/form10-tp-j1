# TP 1

## Exercice 1

On représente un ascenseur dans un système à l'aide d'une classe. La classe Ascenseur doit disposer de la méthode publique getEtage() qui retourne le numéro de l'étage auquel se trouve l'ascenseur. Si l'ascenseur est au rez-de-chaussée, la méthode retourne 0.

La classe Ascenseur a également la méthode appelerDepuis(int etage) qui sert à appeler l'ascenseur à un étage donné. Cette méthode a pour conséquence d'amener l'ascenseur à l'étage donné.

**La sortie standard affiche les mouvements de l'ascenceur**

Implémentez la classe Ascenseur. Ajoutez dans la classe une méthode :

    public static void main(String[] args) {
    }

Dans la méthode main, créez un objet de type Ascenseur et appelez ses méthodes. Après chaque appel, affichez l'évolution de l'ascenseur. 


## Exercice 2

On souhaite créer une classe BoiteDeVitesses pour représenter une boite de vitesses. Cette classe contient les méthodes :

**changerVitesse()**
Pour changer de vitesse

**retrograder()**
Pour passer à la vitesse inférieure

**getVitesse()**
Pour donner la vitesse courante (0 représente le point mort)

Implémentez la classe BoiteDeVitesses. Ajoutez dans la classe une méthode :

    public static void main(String[] args) {
    }
    
Dans la méthode main, vous allez simuler une voiture qui fait un run sur 400m départ arrêté. Pour cela, créez une instance de type BoiteDeVitesses et simuler l'accélaration jusqu'en 6e avant de revenir au point mort. 
Après chaque changement de vitesse, affichez sur la sortie standard le numéro de la vitesse courante.