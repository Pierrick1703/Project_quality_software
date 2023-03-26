package test;

import Model.Calcul;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions.*;
import Model.Calcul;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.testng.AssertJUnit.assertEquals;

public class TestClass {

    static ArrayList<Integer> result;
    static ArrayList<Integer> result2;
    static Calcul c;
    static Error ex;
    static Error ex1;
    static Error ex2;
    static Error ex3;
    static Error ex4;
    static String valeur;
    static String valeur2;
    static String valeur3;
    static String valeur4;
    static String valeur5;
    static String valeur6;

    static String valeur7;

    static String valeur8;

    static String valeur9;

    static String valeur10;
    static String reponseTest;
    static String reponseTest2;


    @DisplayName("Jeu de données")
    @BeforeAll
    static void beforeAll() {
        c = new Calcul();
        result = new ArrayList<Integer>();
        result2 = new ArrayList<Integer>();
        valeur = "15";
        valeur2 = "2";
        valeur3 = "101";
        valeur4 = "1001";
        valeur5 = "-11";
        valeur6 = "-12";
        valeur7 = "A";
        valeur8 = "B";
        valeur9 = "1,5";
        valeur10 = "2,2";
        result.add(1000);
        result.add(100);
        result.add(10);
        result2.add(100);
        result2.add(10);
    }

        @Test
        @DisplayName("Test d'exception")
        public void testThrowError(){
            ex = assertThrows(Error.class,()-> c.calculNombreParfait(valeur,valeur2),"erreur exception");//Test du message d'erreur si le premier chiffre est plus grand que le second
            ex1 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur5,valeur),"erreur exception");//Test du message d'erreur si la valeur est négatif
            ex2 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur4,valeur6),"erreur exception");//Test du message pour les deux cas de figure des deux premier test
            ex3 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur7,valeur8), "erreur exception");//Test du message d'erreur si une valeur ou plus est une chaine de caractère
            ex4 = assertThrows(Error.class,()-> c.calculNombreParfait(valeur7,valeur8), "erreur exception");//Test du message d'erreur si une valeur est un chiffre à virgule
        }


        @Test
        @DisplayName("Test d'execution de calcul")
        public void testValeur() throws Exception {
            c.calculNombreParfait(valeur2,valeur4);
            assertEquals(result,c.getResultat());
            c.calculNombreParfait(valeur2,valeur3);
            assertEquals(result2,c.getResultat());
            reponseTest = "Test execution sur les valeurs : ["+valeur2+","+valeur4+"] et ["+valeur2+","+valeur3+"]";
        }

        @Test
        @DisplayName("Test de temps d'execution")
        public void testTime(){
            int time = 5;
            assertTimeout(
                    Duration.ofMillis(time),
                    () -> c.calculNombreParfait(valeur,valeur3),
                    "Erreur de temps d'exécution"
            );
            reponseTest2 = "Test de temps d'execution correcte en 5 millieme de seconde";
        }


        @AfterAll()
        @DisplayName("Affichage des résultat des test")
        static void afterAll(){
            System.out.println("Résultat du test de message d'erreur : "+ ex);
            System.out.println("Résultat du test de message d'erreur :" + ex1);
            System.out.println("Résultat du test de message d'erreur :" + ex2);
            System.out.println("Résultat du test de message d'erreur : "+ ex3);
            System.out.println("Résultat du test de message d'erreur :" + ex4);
            System.out.println(reponseTest);
            System.out.println(reponseTest2);
    }
}
