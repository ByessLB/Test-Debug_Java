# Le Débogage et les Tests Unitaires en Java

## Introduction

### Présentation

- **Objectifs** : Comprendre l'importance du débogage et des tests unitaire dans le développement logiciel. Apprendre à utiliser les outils et techniques de débogage et à écrire des tests unitaires en Java.
- **Importance du débogage et des tests unitaires** : Assurer la qualité et la fiabilité du logiciel en détectant et corrigeant les erreurs tôt dans le cycle de développement.

### Concepts de base

- **Qu'est-ce que le débogage ?** : Le débogage est le processus de recherche et de correction des erreurs dans un programme.
- **Qu'est-ce que les tests unitaires ?** : Les tests unitaires sont des tests qui vérifient le bon fonctionnement d'une unité de code (méthode, classe).
- **Pourquoi sont-ils importants ?** : Ils permettent de détecter les erreurs tôt, de garantir la qualité du code et de faciliter la maintenance.

## Partie 1: Débogage

### Introduction au débogage

- **Définition et importance** : Le débogage est essentiel pour identifier et corriger les erreurs dans le code. Il permet de garantir que le programme fonctionne comme prévu.
- **Outils de débogage en Java** : IDE (InteliJ IDEA, Eclipse, VsCode), logs, points d'arrêt, etc.

### Technique de débogage

- **Utilisation de `System.out.println`** : Afficher des message dans la console pour suivre l'exécution du programme.
```java
System.out.println("La valeur de x est : " + x);
```
- **Points d'arrêt (breakpoints)** : Suspendre l'exécution du programme à des points spécifiques pour inspecter les variables et l'état du programme.
- **Inspection des variables** : Voir les valeurs des variables à un point donné.
- **Evaluation des expression** : Tester des expressions pendant l'exécution.

### Exemple pratique de débogage

- **Présentation de la classe `AgeCalculator`** :
```java
package test.debug;

import java.time.LocalDate;

public class AgeCalculator {

    /**
     * Simple method to get age from birthdate with format YYY-MM-DD
     * @param birthdate date of birth
     *  @return age if the year is correct and -1 if exception occurred while casting
     */

    public int getAge(String birthdate) {
        String[] parts = birthdate.split("-");
        if (parts.length > 0) {
            try {
                int year = Integer.valueOf(parts[0]);
                int now = LocalDate.now().getYear();

                return now - year;
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return -1;
    }
}
```
- **Identification des erreurs potentielles** :
    - Format de date incorrect.
    - Année de naissance future.
- **Utilisation des outils de débogage pour résoudre les problèmes** :
    - Ajouter des points d'arrêt pour inspecter les valeurs des variables.
    - Utiliser `System.out.println` pour afficher les valeurs intermédiaires.

## Partie 2: Tests unitaires

### Introduction aux tests unitaires

- **Définition et importance** : Les tests unitaires permettent de vérifier le bon fonctionnemant d'une unité de code. Ils sont essentiels pour détecter les erreurs tôt et garantir la qualité du coede.
- **Outils de test unitaire en Java** : JUnit, TestNG, etc.

### Ecriture de tests unitaires

- **Structure d'un test unitaire** :
    - **Arrange** : Préparer les données nécessaires pour le test.
    - **Act** : Exécuter la méthode à tester.
    - **Assert** : Vérifier que le résultat est correct.
- **Annotations JUnit** :
    - **`@Test`** : Marquer une méthode comme test.
    - **`@BeforeEach`** : Initialiser avant chaque test.
    - **`@AfterEach`** : Nettoyer après chaque test.
- **Assertions** :
    - **`assertEquals`** : Vérifier l'égalité.
    - **`assertTrue`** : Vérifier une condition.
    - **`assertThrows`** : Vérifier qu'une exception est levée.

### Exemple pratique de tests unitaires

- **Présentation de la classe `Square` et de l'interface `Shape`** :
```java
package test.debug;

public interface Shape {
    double calculateArea();
}
```
```java
package test.debug;

public record Square(double side) implements Shape {
    @Override
    public double calculateArea() { return side * side; }
}
```
- **Ecriture de tests unitaires pour `Shape`** :
```java
package test.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SquareTest {

    @Test
    void shouldReturnSquareArea() {
        // Given - Arrange
        Square square = new Square(3);

        // When - Act
        double result = square.calculateArea();

        // Then - Assert
        assertEquals(9, result);
    }
}
```
- **Exécution et analyse des résultats des tests** :
    - Exécuter les tests avec un IDDE ou un outil de buils comme Maven ou Gradle.
    - Analyser les résultats pour vérifier que les tests passent ou échouent.

## Partie 3: Etude de cas

#### Etude de cas: `AgeCalculator`

- **Présentation de la classe `AgeCalculator`** :
```java
package test.debug;

import java.time.LocalDate;

public class AgeCalculator {

    /**
     * Simple method to get age from birthdate with format YYY-MM-DD
     * @param birthdate date of birth
     *  @return age if the year is correct and -1 if exception occurred while casting
     */

    public int getAge(String birthdate) {
        String[] parts = birthdate.split("-");
        if (parts.length > 0) {
            try {
                int year = Integer.valueOf(parts[0]);
                int now = LocalDate.now().getYear();

                return now - year;
            } catch (NumberFormatException e) {
                throw e;
            }
        }
        return -1;
    }
}
```
- **Identification des scénarios de test** :
    - Date de naissance valide.
    - Date de naissance Invalide (format incorrect).
    - Date de naissance futur.
- **Ecriture de tests unitaires pour `AgeCalculator`** :
```java
package test.debug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class AgeCalculatorTest {

    @Test
    void shouldReturnAge() {
        // Given - Arrange
        AgeCalculator ageCalculator = new AgeCalculator();

        // When - Act
        int age = ageCalculator.getAge("2000-06-23");

        // Then - Assert
        assertEquals(24, age);
    }

    @Test
    void shouldThrowException() {
        // Arrange
        AgeCalculator ageCalculator = new AgeCalculator();

        // Act & Assert
        assertThrows(NumberFormatException.class, () -> ageCalculator.getAge("200O-06-23"));
    }
}
```
#### Analyse des résultats des tests

- **Interprétation des résultats** :
    - Tests réussis : Le code fonctionne comme prévu.
    - Tests échoués : Identification des erreurs et des améliorations possibles.

## Conclusion

### Résumé des points clés

- **Importance du débogage et des tests unitaires** : Assurer la qualité et la fiabilité& du logiciel.
- **Techniques et outils présentés** : `System.out.println`, points d'arrêt, assertions JUnit, etc.

### Ressources supplémentaires

- **Documentation officielle de JUnit** : [JUnit Documentation](https://junit.org/junit5/docs/current/user-guide/)
