import java.util.Iterator;
import java.util.LinkedList;

public class TopSortIterator implements Iterator<String> {

    LinkedList<String> orderedItems;
    int index = 0;

    public TopSortIterator(String[][] order) {
        orderedItems = new LinkedList<>();
        for(int i = 0; i < order.length; i++){
            for(int j = 0; j < order[i].length; j++){
                if(!orderedItems.contains(order[i][j])){
                    orderedItems.add(order[i][j]);
                }
            }
        }
        for(int j = 0; j < order.length; j++){
            for(int i = 0; i < order.length; i++){
                int a = orderedItems.indexOf(order[i][0]);
                int b = orderedItems.indexOf(order[i][1]);
                if (a > b) { // falls die Reihenfolge nicht passt
                    orderedItems.add(b, order[i][0]);
                    orderedItems.remove(a+1);
                }
            }
            j++;
        }
        ttdInterface sortChecker = new ttd(order);
        if(!sortChecker.isWellSorted(orderedItems.toArray(new String[orderedItems.size()]))) throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return index < orderedItems.size();
    }

    @Override
    public String next() {
        return orderedItems.get(index++);
    }
}
