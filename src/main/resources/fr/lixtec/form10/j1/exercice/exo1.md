# Exercice 1: Premier projet Eclipse

## Création du projet & ajout d'une librairie
Pour cet exercice, nous allons créer un document PDF grâce à la bibliothèque [iText](https://itextpdf.com/en). Pour cela, téléchargez le fichier JAR suivant :

* [https://repo1.maven.org/maven2/com/itextpdf/itextpdf/5.5.13.3/itextpdf-5.5.13.3.jar](https://repo1.maven.org/maven2/com/itextpdf/itextpdf/5.5.13.3/itextpdf-5.5.13.3.jar)
    

Créez une projet Java dans Eclipse et copiez les fichiers JAR téléchargés dans un répertoire `lib` que vous créerez dans le projet Eclipse.

Ajoutez maintenant le fichier JAR comme bibliothèques du projet. Pour cela, faites une clic droit sur le nom du projet dans le _Package Explorer_  et choisissez Properties. 
Dans la boite de dialogue des propriétés du projet, choisissez Java Buid Path et enfin, cliquez sur l’onglet Libraries :

![eclipse_build_path.png](https://lixtec.fr/wp-content/uploads/2022/09/form10_eclipse_build_path.png)

Utilisez le bouton Add JARs… pour ajouter le fichier téléchargé comme une bibliothèque de votre projet.

## Ajout du code de test

Dans le _Package Explorer_, vous pouvez directement faire un clic droit sur chaque fichier JAR et choisir Build Path ‣ Add to Build Path.

Créer ensuite la classe _PremierPdf_ et ajoutez le code suivant :

    import java.io.FileOutputStream;
    
    import com.itextpdf.text.Document;
    import com.itextpdf.text.Paragraph;
    import com.itextpdf.text.pdf.PdfWriter;
    
    public class PremierPdf {
    
      public static void main(String\[\] args) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("premier-pdf.pdf"));
        document.open();
        document.addTitle("Mon premier PDF");
        document.add(new Paragraph("Hello the world en PDF grâce à iText"));
        document.close();
      }
    }

En exécutant cette classe, vous obtenez à la racine de votre projet le fichier _premier-pdf.pdf_ créé grâce à la bibliothèque [iText](https://itextpdf.com/en).


##Astuce##

Si vous ne voyez pas le fichier PDF apparaître dans le _Package Explorer_, faites un clic droit sur le nom du projet et choisissez Refresh.


##Note##

Pour cet exercice, le fichier JAR est téléchargé depuis le site [http://central.maven.org](http://central.maven.org) qui référence des milliers de bibliothèques Java. [Maven](http://maven.apache.org) est un outil de _build_ qui gére les étapes de construction de votre projet et notamment la déclaration des dépendances logicielles.