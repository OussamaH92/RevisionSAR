public class Tampon {

    private int nombrePlace;
    private int tailleMax;
    private int free,next;
    private String[] produit;

    public Tampon(int taille){
        this.free = 0;
        this.next = 0;
        this.tailleMax = taille;
        this.nombrePlace = taille;
        produit = new String[tailleMax];
    }

    public synchronized void deposerProduit(String p) throws InterruptedException {

        if(nombrePlace == 0)wait(); //while si n>1 producteurs
        produit[free] = p;
        nombrePlace--;
        free = (free++)%tailleMax;
        notify(); //notifyAll() si n>1 consommateurs

    }

    public synchronized String consommerProduit() throws InterruptedException {

        if(nombrePlace == tailleMax)wait();

        String temp = produit[next];
        produit[next] = null;
        nombrePlace++;
        next = (next++)%tailleMax;
        notify();

        return temp;
    }

}
