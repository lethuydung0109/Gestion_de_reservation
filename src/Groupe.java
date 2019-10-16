import javafx.util.Pair;

import java.util.ArrayList;

public class Groupe  {
    int id;
    int nbPersonnes;
    //ajouter un tableau pour la gestion de reservation
    ArrayList<Pair<Integer, Integer>> listReserve;

    public Groupe(int id, int nbPersonnes){
        this.id = id;
        this.nbPersonnes = nbPersonnes;
        this.listReserve = new ArrayList<Pair<Integer, Integer>>();
    }

    public void reserveSalle(Salle salle){
        if(salle.reserver(this.nbPersonnes) == true){
            System.out.println("Groupe "+ this.id + " a reserve avec succes");
        }else{
            System.out.println("Groupe "+ this.id + " n'arrive pas a reserver");
        }
    }

    public void reserveSalle2(Salle salle){
        this.listReserve = salle.reserver2(this.nbPersonnes);
        if(this.listReserve != null){
            System.out.println("Groupe "+ this.id + " a reserve avec succes");
        }else{
            System.out.println("Groupe "+ this.id + " n'arrive pas a reserver");
        }
    }

    public void annulerReservation(Salle salle){
        if(salle.annuler(this.listReserve) == true){
            this.listReserve.clear();
            System.out.println("Votre reservation a ete annule");
        }else{
            System.out.println("Votre reservation ne peut pas etre annulee");
        }
    }

    public ArrayList<Pair<Integer, Integer>> getListReserve(){
        return this.listReserve;
    }

    public int getId(){
        return id;
    }



}
