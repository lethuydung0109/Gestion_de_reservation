import javafx.util.Pair;

import java.util.ArrayList;

public class Salle {
    int nbRangs;
    int nbPlacesParRang;
    boolean[][] placesLibres;

    public Salle(int nbRangs, int nbPlacesParRang) {
        this.nbRangs = nbRangs;
        this.nbPlacesParRang = nbPlacesParRang;
        this.placesLibres = new boolean[nbRangs][nbPlacesParRang];
        for (int i = 0; i < nbRangs; i++){
            for(int j = 0; j < nbPlacesParRang; ++j){
                placesLibres[i][j] = true;
            }
        }
    }

    public boolean capaciteOK(int n) {
        int count = 0;
        for (int i = 0; i < nbRangs; i++) {
            for (int j = 0; j < nbPlacesParRang; j++) {
                if (placesLibres[i][j] == true) count++;
                // optimize here
            }
        }
        if (count >= n) {
            return true;
        } else {
            return false;
        }
    }

    int nContiguesAuRangI(int n, int i) {
        int count = 0;
        for (int k = 0; k < nbPlacesParRang; k++) {
            if (placesLibres[i][k] == true) {
                count = count + 1;
//                System.out.println("i = " + i + " | k = "+k);
//                System.out.println("Count = "+count);
                if (count == n) return k - n + 1  ;

            } else count = 0;
        }
        return -1;
    }

    synchronized boolean reserverContigues(int n) {
        for (int i = 0; i < nbRangs; i++) {
//            System.out.println("nContinguesAuRang "+ nContiguesAuRangI(n,i));
            int nContinguesRangIIndex = nContiguesAuRangI(n, i);
            if ( nContinguesRangIIndex!= -1) {
                for (int k = nContinguesRangIIndex; k < nContinguesRangIIndex + n ; k++) {
                    placesLibres[i][k] = false;
                }
                return true;
            }
        }
        return false;
    }

    synchronized ArrayList<Pair<Integer, Integer>> reserverContigues2(int n){
        ArrayList<Pair<Integer, Integer>> listReserve = new ArrayList<Pair<Integer, Integer>>();

        for (int i = 0; i < nbRangs; i++) {
//            System.out.println("nContinguesAuRang "+ nContiguesAuRangI(n,i));
            int nContinguesRangIIndex = nContiguesAuRangI(n, i);
            if ( nContinguesRangIIndex!= -1) {
                for (int k = nContinguesRangIIndex; k < nContinguesRangIIndex + n ; k++) {
                    placesLibres[i][k] = false;
                    listReserve.add(new Pair<>(i, k));
                }
                return listReserve;
            }
        }
        return null;
    }

    synchronized boolean reserver(int n) {
        System.out.println("====== Reserver "+ n + " places===========" );
        if (capaciteOK(n) == false) {
            System.out.println("Not enough place");
            return false;
        } else {
            if (reserverContigues(n) == true){
//                reserverContigues(n);
                System.out.println("Reserve adjacent places");
                return true;
            } else{
                System.out.println("Reserve randomly");
                int count = 0;
                for (int i = 0; i < nbRangs; i++){
                    for (int j = 0; j < nbPlacesParRang; j++){
                        if (placesLibres[i][j] == true) {
                            placesLibres[i][j] = false;
                            count = count + 1;
                        }
                        if(count == n) return true;
                        }
                    }

                return true;
            }
        }
    }

    synchronized ArrayList<Pair<Integer, Integer>> reserver2(int n){
        ArrayList<Pair<Integer, Integer>> listReserve = new ArrayList<Pair<Integer, Integer>>();

        System.out.println("====== Reserver "+ n + " places===========" );
        if (capaciteOK(n) == false) {
            System.out.println("Not enough place");
            return null;
        } else {
            ArrayList<Pair<Integer, Integer>>  resConti = reserverContigues2(n);
            if (resConti != null){
                System.out.println("Reserve adjacent places");
                listReserve.addAll(resConti);
                return listReserve;
            } else{
                System.out.println("Reserve randomly");
                int count = 0;
                for (int i = 0; i < nbRangs; i++){
                    for (int j = 0; j < nbPlacesParRang; j++){
                        if (placesLibres[i][j] == true) {
                            placesLibres[i][j] = false;
                            listReserve.add(new Pair<>(i, j));
                            count = count + 1;
                        }
                        if(count == n) return listReserve;
                    }
                }

                return listReserve;
            }
        }
    }

    synchronized boolean annuler(ArrayList<Pair<Integer, Integer>> listReserve){
        for (Pair<Integer, Integer> place : listReserve) {
            placesLibres[place.getKey()][place.getValue()] = true;
        }
        return true;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nbRangs; ++i){
            for(int j = 0; j< nbPlacesParRang; ++j){
                sb.append(this.placesLibres[i][j] + "\t \t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}