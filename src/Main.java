import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        Salle salle = new Salle(5, 10);

        Groupe g1 = new Groupe(1, 4);
//        g1.reserveSalle(salle);
        Groupe g2 = new Groupe(2, 8);
//        g2.reserveSalle(salle);
        Groupe g3 = new Groupe(3, 5);


        /* Reservation sans annulation */
//        Thread t1 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                g1.reserveSalle(salle);
//                System.out.println(salle);
//            }
//        });
//        Thread t2 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                g2.reserveSalle(salle);
//                System.out.println(salle);
//            }
//        });
//        Thread t3 = new Thread(new Runnable(){
//            @Override
//            public void run() {
//                g3.reserveSalle(salle);
//                System.out.println(salle);
//            }
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();


        /* Reservation avec annulation */
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                g1.reserveSalle2(salle);
                System.out.println("GroupeID = " + g1.getId() + " - " + g1.getListReserve());
                System.out.println(salle);
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                g2.reserveSalle2(salle);
                System.out.println("GroupeID = " + g2.getId() + " - " + g2.getListReserve());
                System.out.println(salle);
            }
        });
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                g3.reserveSalle2(salle);
                System.out.println("GroupeID = " + g3.getId() + " - " + g3.getListReserve());
                g3.annulerReservation(salle);
                System.out.println(salle);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();



        // test arraylist of pair<Int, Int>
//        ArrayList<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
//        list.add(new Pair<>(1,1));
//        list.add(new Pair<>(1,2));
//        list.add(new Pair<>(1,10));
//
//
//        System.out.println(list);
//        System.out.println(list.get(2).getKey());


    }

}
