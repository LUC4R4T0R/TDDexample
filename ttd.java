public class ttd implements ttdInterface{

    @Override
    public boolean isWellSorted(String[] sequence) {
        if(sequence.length <= 1){
            return true;
        }
        return false;
    }
}
