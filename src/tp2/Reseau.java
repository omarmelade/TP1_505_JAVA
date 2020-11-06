package tp2;

import java.util.ArrayList;

public class Reseau {

    int nbVilles;

    private ArrayList<Ville> villes;
    private ArrayList<Arete> distanceVilles;

    public Reseau(int nbVilles){
        this.nbVilles = nbVilles;
        initReseau();
    }

    public void initReseau(){
        villes = new ArrayList<>(nbVilles);
        distanceVilles = new ArrayList<>();
        // cree les villes
        creeVilles(nbVilles);
        // cree les routes entre les villes
        creeRoutes(villes);
    }

    // cree une ville
    public Ville creeVille(int id){
        return new Ville(id);
    }

    // cree le tableau de villes
    private void creeVilles(int nbVilles) {

        for(int i = 0; i < nbVilles; i++){
            villes.add(creeVille(i));
        }

    }

    // cree le tableau des liens entres les villes
    private void creeRoutes(ArrayList<Ville> villes) {

        for ( Ville v1: villes) {
            for(Ville v2: villes) {
                Arete d = new Arete(v1, v2);
                distanceVilles.add(d);
            }
        }

    }



}
