import java.io.*;
import java.util.ArrayList;

public class LexicalAnalyzer {

    public static void main(String[] args) throws IOException {

        String index = "qStart";
        ArrayList<dfaStates.Tokens> tokens = new ArrayList<>();
        /**
         * to read input.txt embedded in main
         * to write output.txt embedded in main
         */
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String sep = System.lineSeparator();

        /**
         * creating of tokens
         */
        for (int a = 0; br.ready(); a++){
            String t = "";
            tokens.clear();
            String txt = br.readLine();

            for (int pos = 0; pos < txt.length(); pos++) {
                /**
                 * checks for comma, newline and whitespace by reading left to right from the input.txt
                 * token creation
                 * maximal munch implementation
                 * boolean returns true if the given string (x) is empty or blank, otherwise false.
                 */
                boolean current = false;
                if (txt.charAt(pos) != ',' && txt.charAt(pos) != '\n' && txt.charAt(pos) != ' ' ) {
                    t = t + txt.charAt(pos);
                    if (pos == txt.length() - 1) {
                        for (int position = 0; position < t.length(); position++) {
                            String str = String.valueOf(t.charAt(position));
                            index = dfaStates.dfa(index, str);
                            if (index.equals("qDead")) {
                                tokens.add(new dfaStates.Tokens("ERROR", "ERROR"));
                                current = true;
                                break;
                            }
                        }
                        /**
                         * possible final states are identified to know which type a token belongs too
                         */
                        if (index.equals("q19") || index.equals("q13") || index.equals("q20") || index.equals("q14") || index.equals("q21"))
                            tokens.add(new dfaStates.Tokens(t, "GPR"));
                        else if (index.equals("q22") || index.equals("q16") || index.equals("q23") || index.equals("q17") || index.equals("q24"))
                            tokens.add(new dfaStates.Tokens(t, "FPR"));
                        else if (index.equals("q10") || index.equals("q18"))
                            tokens.add(new dfaStates.Tokens(t, "KEYWORD"));
                        else if (!current)
                            tokens.add(new dfaStates.Tokens("ERROR", "ERROR"));

                        index = "qStart";
                        break;
                    }
                }
                /**
                 * reads/checks the text from left to right
                 * maximal munch implementation
                 */
                else {
                    for (int pos2 = 0; pos2 < t.length(); pos2++) {
                        char i = t.charAt(pos2);
                        index = dfaStates.dfa(index, String.valueOf(i));
                        if (index.equals("qDead")) {
                            tokens.add(new dfaStates.Tokens("ERROR", "ERROR"));
                            current = true;
                            break;
                        }
                    }
                    /**
                     * possible final states are identified to know which type a token belongs too
                     */
                    if (index.equals("q19") || index.equals("q13") || index.equals("q20") || index.equals("q14") || index.equals("q21"))
                        tokens.add(new dfaStates.Tokens(t, "GPR"));
                    else if (index.equals("q22") || index.equals("q16") || index.equals("q23") || index.equals("q17") || index.equals("q24"))
                        tokens.add(new dfaStates.Tokens(t, "FPR"));
                    else if (index.equals("q10") || index.equals("q18"))
                        tokens.add(new dfaStates.Tokens(t, "KEYWORD"));
                    else if (t.length() != 0 && !current)
                        tokens.add(new dfaStates.Tokens("ERROR", "ERROR"));

                    index = "qStart";
                    t = "";
                }
            }
            /**
             * goes through all the tokens that are stored in the array list
             * produces the output.txt
             */
            for (int output = 0; output < tokens.size(); output++) {
                if (output != tokens.size() - 1)
                    bw.write(tokens.get(output).type + " ");
                else {
                    bw.write(tokens.get(output).type);
                    bw.write(sep);
                }
                System.out.println(tokens.get(output).type);
            }
            if (tokens.size() == 0) {
                bw.write(sep);
            }
        }
        br.close();
        bw.close();
    }
}