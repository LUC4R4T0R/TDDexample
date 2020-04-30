import java.util.Arrays;

public class ttd implements ttdInterface{
    String[][] rules;
    public ttd(String[][] rules){
        this.rules = rules;
    }
    @Override
    public boolean isWellSorted(String[] sequence) {
        if(sequence != null) {
            for (String[] rule : rules) {
                if (Arrays.asList(sequence).lastIndexOf(rule[0]) != -1 && Arrays.asList(sequence).indexOf(rule[1]) != -1) {
                    if (Arrays.asList(sequence).lastIndexOf(rule[0]) > Arrays.asList(sequence).indexOf(rule[1])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
