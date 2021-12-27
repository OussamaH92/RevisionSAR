public class Entree extends Port{

    private Call cm; //

    public Object demandeRDV(Object requete) throws InterruptedException {
        Canal c = new Canal();
        this.envoyer(new Call(c,requete));
        return c.lireMessage();
    }

    public Object lireRequete(){
        this.cm = (Call) lireRequete();
        return cm.getRequete();
    }

    public void repondre(Object reponse) throws InterruptedException {
        this.cm.getCanal().deposerMessage(reponse);
    }
    public class Call{
        public Canal cnl;
        public Object requete;

        public Call(Canal canal, Object requete){
            this.cnl = canal;
            this.requete = requete;
        }

        public Canal getCanal(){return this.cnl;}
        public Object getRequete(){return this.requete;}
    }
}
