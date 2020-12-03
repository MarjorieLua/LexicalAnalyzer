public class dfaStates {
    /**
     * type: GPR, FPR, KEYWORD, ERROR
     */
    public static class Tokens{
        String token, type;

        public Tokens(String token, String type){
            this.token = token;
            this.type = type;
        }
    }

    /**
     * the possible transitions a state could do that is present in the DFA
     * qDead is the dead state (default)
     */
    public static String dfa(String index, String nxtIndex) {
        switch (index) {
            case "qStart":
                return switch (nxtIndex) {
                    case "D" -> "q2";
                    case "R" -> "q11";
                    case "$" -> "q12";
                    case "F" -> "q15";
                    default -> "qDead";
                };
            case "q2":
                return switch (nxtIndex) {
                    case "A" -> "q3";
                    case "M" -> "q7";
                    default -> "qDead";
                };
            case "q3":
                return switch (nxtIndex) {
                    case "D" -> "q4";
                    default -> "qDead";
                };
            case "q4":
                return switch (nxtIndex) {
                    case "D" -> "q5";
                    default -> "qDead";
                };
            case "q5":
                return switch (nxtIndex) {
                    case "I" -> "q6";
                    case "U" -> "q18";
                    default -> "qDead";
                };
            case "q6":
                return switch (nxtIndex) {
                    case "U" -> "q18";
                    default -> "qDead";
                };
            case "q7":
                return switch (nxtIndex) {
                    case "U" -> "q8";
                    default -> "qDead";
                };
            case "q8":
                return switch (nxtIndex) {
                    case "L" -> "q9";
                    default -> "qDead";
                };
            case "q9":
                return switch (nxtIndex) {
                    case "T" -> "q10";
                    default -> "qDead";
                };
            case "q10":
                return switch (nxtIndex) {
                    case "U" -> "q18";
                    default -> "qDead";
                };
            case "q11":
                return switch (nxtIndex) {
                    case "0", "4", "5", "6", "7", "8", "9" -> "q19";
                    case "1", "2" -> "q13";
                    case "3" -> "q14";
                    default -> "qDead";
                };
            case "q12":
                return switch (nxtIndex) {
                    case "0", "4", "5", "6", "7", "8", "9" -> "q19";
                    case "1", "2" -> "q13";
                    case "3" -> "q14";
                    case "F" -> "q15";
                    default -> "qDead";
                };
            case "q13":
                return switch (nxtIndex) {
                    case "0", "1", "2", "4", "3", "5", "7", "6", "8", "9" -> "q20";
                    default -> "qDead";
                };
            case "q14":
                return switch (nxtIndex) {
                    case "0", "1" -> "q21";
                    default -> "qDead";
                };
            case "q15":
                return switch (nxtIndex) {
                    case "0", "4", "5", "6", "8", "7", "9" -> "q22";
                    case "1", "2" -> "q16";
                    case "3" -> "q17";
                    default -> "qDead";
                };
            case "q16":
                return switch (nxtIndex) {
                    case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> "q23";
                    default -> "qDead";
                };
            case "q17":
                return switch (nxtIndex) {
                    case "0", "1" -> "q24";
                    default -> "qDead";
                };
            case "q18":
            case "q19":
            case "q20":
            case "q21":
            case "q22":
            case "q23":
            case "q24":
                return switch (nxtIndex) {
                    default -> "qDead";
                };
            default:
                return "qDead";
        }
    }
}