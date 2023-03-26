package Model;

import java.util.ArrayList;

public class Calcul {

    private ArrayList<Integer> Resultat;

    public ArrayList<Integer> getResultat(){
        return this.Resultat;
    }

    public void setResultat(ArrayList<Integer> resultat){
        this.Resultat = resultat;
    }

    /* Fonction de test si les valeurs en paramètres sont bien exploitable (A < B)*/
    public boolean testValeur(String A, String B) throws Exception {
        boolean result = false;
        int Aint;
        int Bint;
        try {
            Aint = Integer.parseInt(A);
            Bint = Integer.parseInt(B);
        } catch (Exception e){
            throw new Exception("Nombre entier attendu");
        }
        if(Aint < 0){
            throw new Exception("Il faut que le nombre soit positif : "+A);
        } else if(Bint < 0){
            throw new Exception("Il faut que le nombre soit positif : "+B);
        }
        else if(Aint < Bint){
            result = true;
        } else{
            throw new Exception("Il faut que le premier nombre soit strictement supérieur au second");
        }
        return result;
    }

    /**
     * Fonction publique qui retourne un ArrayList d'entier correspondant aux nombres parfaits
     * avec en paramètre un nombre de départ et un d'arriver
     *
     * @return
     */
    public void calculNombreParfait(String A, String B) throws Exception {
        int Aint;
        int Bint;
        ArrayList<Integer>  result = new ArrayList<Integer>();
        if(testValeur(A,B)){//vérification que le nombre A est plus petit que B
            Aint = Integer.parseInt(A);
            Bint = Integer.parseInt(B);
            int intervalle = Bint - Aint;
            for(int i = 0; i < intervalle; i++){//Boucle pour vérifier chaque valeur dans l'intervalle entre A et B
                int chiffre = Bint - i + 1;
                String number = String.valueOf(chiffre);
                char[] digit = number.toCharArray();
                int sum = 0;
                for(int j = 0; j < digit.length;j++){//Boucle pour séparer et calculer chaque digit pour chacun des nombres de l'intervalle
                    int valeur = Integer.parseInt(Character.toString(digit[j]));//transformation d'un type char en string puis en int
                    sum += valeur*valeur;
                }
                if(sum == 1){
                    result.add(chiffre);
                }
            }
        }
        this.Resultat = result;
    }
}