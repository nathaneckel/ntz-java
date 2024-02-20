package rocks.zipcode;

import java.util.ArrayList;

public class NoteList extends ArrayList<String> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // yes, really, it's just a no-additional functionality subclass.
    public NoteList(String s) {
        super();
        this.add(s);
    }
}
