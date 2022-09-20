# TP 2

## Exercice 1

On souhaite créer une classe BoiteDeVitesses pour représenter une boite de vitesses. Cette classe contient les méthodes :

**changerVitesse()**
Pour passer une vitesse donnée. Il n’est pas possible d’aller au delà de la cinquième vitesse (dans ce cas, un appel a la méthode doit être sans effet).

**retrograder()**
Pour passer a la vitesse inférieure. Il n’est pas possible de rétrograder en dessous de la premiere (dans ce cas, un appel a la méthode doit être sans effet).

**setPointMort()**
Pour aller au point mort.

**getVitesse()**
Pour donner la vitesse courante (null représente le point mort)

**toString()**
Pour retourner une chaîne de caracteres (String). Si la vitesse vaut null, la méthode retourne « point mort ». Pour les autres vitesses, la méthode retourne respectivement : « premiere », « seconde », « troisieme », « quatrieme », « cinquieme ».

Implémentez la classe BoiteDeVitesses. Ajoutez dans la classe une méthode main dans laquelle vous allez simuler une voiture qui fait un run sur 400m départ arreté. Pour cela, créez une instance de type BoiteDeVitesses et simuler l'accélaration jusqu'en 5e avant de revenir au point mort. 
Apres chaque changement de vitesse, affichez sur une meme ligne de la sortie standard le numéro de la vitesse courante, '-' et la représentation de la boite a vitesse.



## Exercice 2

On souhaite créer les classes MoteurEssence et MoteurDiesel pour représenter les moteurs à explosion. Ces classes contiennent les méthodes :

**accelerer()**
Pour augmenter le régime

**decelerer()**
Pour baisser le régime

**demarrer()**
Pour démarrer le moteur

**getRegime()**
Pour donner le régime moteur

**getConsommation()**
Pour donner la consommation, génération aléatoire dans la plage.

La plage de régime du moteur essence est de 900 a 14000 trs/min. Le rupteur s'active 13500 trs/min et fait descendre le régime a 13000trs/min.
La plage de consommation du moteur essence est de 4 a 14l/100.
La plage de régime du moteur diesel est de 750 a 6500 trs/min. Le rupteur s'active 6000 trs/min et fait descendre le régime a 5500trs/min.
La plage de consommation du moteur essence est de 2 a 9l/100.

Nous allons créer un banc de test qui peut tester les moteurs a explosion. Pour cela, le garagiste demande un contrat commun entre tous les moteurs.
Le plan de test consiste:
* a accélérer progressivement jusqu'a la limite de chaque moteur, 
* de vérifier que le rupteur s'enclenche
Pour etre réussi, le test doit etre reproduit 10 fois. 


**Implémentez la classe BancTest et les différentes classes de MoteurExplosion. Par ailleurs, il arrive que ce plan de test provoque la rupture du moteur. Trouver le moyen de matérialiser cet évenement. La sortie standard affichera le régime moteur et la consommation.**


## Exercice 3
On souhaite implémenter une classe DetecteurTemperature. Cette classe recevra des informations sur la température et sera capable de déduire si le niveau de température est normal, élevé ou critique :

| Température | Niveau |
| --- | --- |
| t ? 30 | normal |
| 30 < t < 38 | élevé |
| t ? 38 | critique |

La classe DetecteurTemperature possede les méthodes suivantes :

**setTemperature(float t)**
Pour positionner la température actuelle.

**getNiveau()**
Qui retourne le niveau de la température actuelle sous la forme d’une chaîne de caracteres : « normal », « élevé », « critique »

**isNiveauAtteint(String niveau)**
Qui retourne true ou false si le niveau courant est au moins le niveau donné en parametre.

Ajouter la méthode main suivante pour tester votre classe :

    public static void main(String[] args) {
      DetecteurTemperature detecteurTemperature = new DetecteurTemperature();
    
      for(float temperature = 25; temperature < 45; temperature += 2) {
        detecteurTemperature.setTemperature(temperature);
        System.out.println("Température actuelle    = " + temperature);
        System.out.println("Niveau actuel           = " + detecteurTemperature.getNiveau());
        System.out.println("Niveau normal atteint   = " + detecteurTemperature.isNiveauAtteint("normal"));
        System.out.println("Niveau élevé atteint    = " + detecteurTemperature.isNiveauAtteint("élevé"));
        System.out.println("Niveau critique atteint = " + detecteurTemperature.isNiveauAtteint("critique"));
        System.out.println("###################################");
      }
    }

## Exercice 4
On souhaite implémenter le code de Francois 1er en utilisant le code ci-dessous. Cet algorithme de chiffrement classique, utilisé par Francois 1er dans ses correspondances secrètes, se base sur le principe du décalage. Une lettre est remplacée par son équivalent dans l’alphabet en effectuant un décalage. Le programme ci-dessous utilise un décalage. Cela donne comme équivalence :

<table class="hlist"><tbody><tr><td><ul class="simple">
<li><p>a → x</p></li>
<li><p>b → y</p></li>
<li><p>c → z</p></li>
<li><p>d → a</p></li>
<li><p>e → b</p></li>
<li><p>f → c</p></li>
<li><p>g → d</p></li>
<li><p>h → e</p></li>
<li><p>i → f</p></li>
</ul>
</td><td><ul class="simple">
<li><p>j → g</p></li>
<li><p>k → h</p></li>
<li><p>l → i</p></li>
<li><p>m → j</p></li>
<li><p>n → k</p></li>
<li><p>o → l</p></li>
<li><p>p → m</p></li>
<li><p>q → n</p></li>
<li><p>r → o</p></li>
</ul>
</td><td><ul class="simple">
<li><p>s → p</p></li>
<li><p>t → q</p></li>
<li><p>u → r</p></li>
<li><p>v → s</p></li>
<li><p>w → t</p></li>
<li><p>x → u</p></li>
<li><p>y → v</p></li>
<li><p>z → w</p></li>
</ul>
</td></tr></tbody></table>

Ainsi la phrase :

> In cryptography, a cipher is one of the simplest and most widely known encryption techniques.

sera encodée avec un décalage de 23 comme ceci :

> Fk zovmqldoxmev, x zfmebo fp lkb lc qeb pfjmibpq xka jlpq tfabiv hkltk bkzovmqflk qbzekfnrbp.

Compléter la classe AlgoFrancois et vérifier que les 8 étapes sont atteintes. Il ne vous reste plus qu'à décoder la phrase codée.

### Quelques indications
On peut obtenir un tableau de caractères à partir d’une chaîne avec la méthode toCharArray. S’il n’est pas possible de parcourir les éléments d’une chaîne de caractères avec un for amélioré, on peut facilement parcourir le tableau de caractères :

    String helloWorld = "Hello world!";
    for (char c : helloWorld.toCharArray()) {
      // ...
    }
    
Il est possible de créer une nouvelle chaîne de caractères à partir d’un tableau :

    char[] tableau = "Hello".toCharArray();
    String chaine = new String(tableau);
