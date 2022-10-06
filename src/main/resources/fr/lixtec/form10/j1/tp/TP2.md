# TP 2

## Exercice 1
On souhaite implémenter une classe DetecteurTemperature. Cette classe recevra des informations sur la température et sera capable de déduire si le niveau de température est normal, élevé ou critique :

| Température | Niveau |
| --- | --- |
| t < 30 | normal |
| 30 < t < 38 | élevé |
| t > 38 | critique |

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

## Exercice 2
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
