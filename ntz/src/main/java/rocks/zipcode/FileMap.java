package rocks.zipcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileMap implements Serializable, Map<String,NoteList> {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static final String DBNAME = "ntz.db";

    private Map<String, NoteList> hashmap = new HashMap<String, NoteList>();

    public FileMap() {
        super();
    }

    public boolean load() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DBNAME));
            Map<String, NoteList> tmap = (Map<String, NoteList>) ois.readObject();
            if (tmap != null) {
                this.hashmap = tmap;
            }
            ois.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DBNAME));
            oos.writeObject(this.hashmap);
            oos.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Set<String> ks = this.keySet();
        for (String k : ks) {
            NoteList nl = this.get(k);
            s.append(k);
            s.append("\n");
            s.append(nl.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public int size() {
        return hashmap.size();
    }

    public boolean isEmpty() {
        return hashmap.isEmpty();
    }

    public boolean containsKey(Object key) {
        return hashmap.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return hashmap.containsValue(value);
    }

    public NoteList get(String key) {
        return hashmap.get(key);
    }

    @Override
    public NoteList get(Object key) {
        return hashmap.get(key);
    }

    public NoteList put(String key, NoteList value) {
        return hashmap.put((String) key, (NoteList) value);
    }

    public NoteList remove(Object key) {
        return hashmap.remove(key);
    }

    public void putAll(Map m) {
        hashmap.putAll(m);
    }

    public void clear() {
        hashmap.clear();
    }

    public Set<String> keySet() {
        return hashmap.keySet();
    }

    public Collection values() {
        return hashmap.values();
    }

    public Set entrySet() {
        return hashmap.entrySet();
    }

 
}
