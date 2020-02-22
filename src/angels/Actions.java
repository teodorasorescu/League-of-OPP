package angels;

import java.util.LinkedList;
import java.util.List;

public class Actions {
    //it sets the position
    public final void setUpRaw(final LinkedList<Angel> angels, final int[] raw,
                               final int[] column) {
        int i;
        for (i = 0; i < angels.size(); i++) {
            angels.get(i).setRawAngel(raw[i]);
            angels.get(i).setColumnAngel(column[i]);
        }
    }

    //it sets the type of the angel
    public final void setUpType(final LinkedList<Angel> angels, final List<String> type) {
        int i;
        for (i = 0; i < angels.size(); i++) {
            angels.get(i).setType(type.get(i));
        }
    }
}
