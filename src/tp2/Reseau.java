package tp2;

import java.util.ArrayList;

public class Reseau {

    int nbVilles;
    int nbArete;
    private ArrayList<Ville> villes;
    private ArrayList<Arete> distanceVilles;

    /**
     * Crée un reseau de villes avec :
     * @param nbVilles le nombre de villes du reseau
     */
    public Reseau(int nbVilles){

        this.nbVilles = nbVilles;
        initReseau();
        this.nbArete = distanceVilles.size();
    }

    /**
     * Initialise le reseau avec :
     * Une liste de Villes
     * Une liste d'Aretes
     */
    public void initReseau(){
        villes = new ArrayList<>();
        distanceVilles = new ArrayList<>();
        // cree les villes
        creeVilles(nbVilles);
        // cree les routes entre les villes
        initDistanceVilles(villes);
    }

    // cree une ville
    public Ville creeVille(int id){
        return new Ville(id);
    }

    /**
     * cree le tableau de Villes
     * @param nbVilles le nombre de villes du reseau
     */
    private void creeVilles(int nbVilles) {

        for(int i = 0; i < nbVilles; i++){
            villes.add(creeVille(i));
        }
    }

    /**
     * Cree le tableau des Aretes
     * @param villes le tableau des villes a parcourire pour crée les Aretes
     */
    private void initDistanceVilles(ArrayList<Ville> villes) {

        for ( Ville v1: villes) {
            for(Ville v2: villes) {
                Arete d = new Arete(v1, v2);
                distanceVilles.add(d);
            }
        }
    }


    
    public ArrayList<Ville> getVilles(){
    	return villes;
    }
    public ArrayList<Arete> getAretes(){
    	return distanceVilles;
    }

    public int getNbVilles() {
        return nbVilles;
    }

    public int getNbArete() {
        return distanceVilles.size();
    }

    @Override
    public String toString() {
        return "Reseau{" +
                "nbVilles=" + nbVilles +
                ", villes=" + villes +
                ", distanceVilles=" + distanceVilles +
                '}';
    }
}
