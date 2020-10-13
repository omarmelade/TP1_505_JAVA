package tp1;


public class MotCles {

    public MotCles() {

    }

    public boolean keyword(String word, String sentence) {
        boolean found = false;     // Boolean trouvé
        int n = sentence.length(); // Taille de la phrase
        int m = word.length();     // Taille du mot

        for (int i = 0; i < n; i++) {    //On parcours la phrase
            if (sentence.charAt(i) == word.charAt(0) && !found) {
                found = true;
                for (int j = 1; j < m; j++) { // on parcours le mot
                    if ((i + j >= n) || (word.charAt(j) != sentence.charAt(i + j) && found)) {
                        found = false;
                    }
                }
            }
        }
        return found;
    }

//    public void smartKeyWord(String[] keyWords, String sentence){
//
//        int lsize = sentence.length();
//        for (int i = 0; i < lsize; i++) {
//            for (String word: keyWords) {
//                if(word.charAt(i) == sentence.charAt(i)){
//
//                }
//            }
//        }
//    }
}
