public class Groupe  {
    int id;
    int nbPersonnes;
    //ajouter un tableau pour la gestion de reservation


    public Groupe(int id, int nbPersonnes){
        this.id = id;
        this.nbPersonnes = nbPersonnes;
    }

    public void reserveSalle(Salle salle){
        if(salle.reserver(this.nbPersonnes) == true){
            System.out.println("Groupe "+ this.id + " a reserve avec succes");
        }else{
            System.out.println("Groupe "+ this.id + " n'arrive pas a reserver");
        }
    }


}
