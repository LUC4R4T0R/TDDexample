public class ttd implements ttdInterface{
    String[][] rules;
    public ttd(String[][] rules){
        this.rules = rules;
    }
    @Override
    public boolean isWellSorted(String[] sequence) {
        if(sequence.length <= 1){
            return true;
        }
        return true;
    }
}
