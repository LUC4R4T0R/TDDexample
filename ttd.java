import java.util.Arrays;
import java.util.List;
public class ttd implements ttdInterface{
    String[][] rules;
    public ttd(String[][] rules){
        this.rules = rules;
    }
    @Override
    public boolean isWellSorted(String[] sequence) {
        if(sequence != null && rules != null) {
            for (String[] rule : rules) {
                List<String> temp = Arrays.asList(sequence);
                if (temp.lastIndexOf(rule[0]) != -1 && temp.indexOf(rule[1]) != -1) {
                    if (temp.lastIndexOf(rule[0]) > temp.indexOf(rule[1])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
