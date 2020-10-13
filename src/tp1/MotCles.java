package tp1;


public class MotCles {

    public MotCles() {

    }

    public boolean keyword(String word, String sentence) {

        boolean found = false;
        int n = sentence.length();
        int m = word.length();

        for (int i = 0; i < n; i++) {
            if(sentence.charAt(i) == word.charAt(0) && !found) {
                found = true;
                for (int j = 1; j < m; j++) {
                    if(i+j < m) {
                        if (word.charAt(j) != sentence.charAt(i + j) && found) {
                            found = false;
                        }
                    }else{
                        found = false;
                    }
                }
            }
        }
        return found;
    }
}