public class Main {
    public static void main(String args[]) throws InterruptedException {
        Salle salle = new Salle(5, 10);

        Groupe g1 = new Groupe(1, 4);
//        g1.reserveSalle(salle);
        Groupe g2 = new Groupe(2, 8);
//        g2.reserveSalle(salle);
        Groupe g3 = new Groupe(3, 6);


        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                g1.reserveSalle(salle);
                System.out.println(salle);
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                g2.reserveSalle(salle);
                System.out.println(salle);
            }
        });
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                g3.reserveSalle(salle);
                System.out.println(salle);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();


    }

}
