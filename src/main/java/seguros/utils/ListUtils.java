package seguros.utils;

import java.util.LinkedList;
import java.util.List;

public class ListUtils {

    public static List convertToList(Iterable i){
        List l = new LinkedList();
        i.forEach(l::add);
        return l;
    }
}
