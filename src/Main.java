public class Main {
    public static void main(String args[]){
        Salle salle = new Salle(5, 10);

        salle.toString();

        salle.reserver(8);
        System.out.println(salle);
//        System.out.println(salle.nContiguesAuRangI(3, 0));
        salle.reserver(4);
        System.out.println(salle);
        salle.reserver(10);
        System.out.println(salle);
        salle.reserver(23);
        System.out.println(salle);


    }

}
