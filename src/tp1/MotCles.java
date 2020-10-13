package tp1;


public class MotCles {

    public MotCles() {

    }

    public boolean keyword(String word, String sentence) {

        boolean found = false;
        int n = sentence.length(); //Taille de la phrase
        int m = word.length();	//Taille du mot 
        for (int i = 0; i < n; i++) {	//On parcours 
            if(sentence.charAt(i) == word.charAt(0) && !found) {
                found = true;
                for (int j = 1; j < m; j++) {
                        if ((i+j >= n)||(word.charAt(j) != sentence.charAt(i + j) && found)) {
                            found = false;
                        }  
                	
                	}
                }
                }
        return found;
    }
}
