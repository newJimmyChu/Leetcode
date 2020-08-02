class MyHashMap {

    private Entry[] entryArray;
    private int size = 65536;

    /** Initialize your data structure here. */
    public MyHashMap() {
        entryArray = new Entry[size];

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        if (entryArray[h] != null) {
            if (entryArray[h].key == key) {
                entryArray[h].value = value;
                return;
            }

            Entry temp = entryArray[h].next;
            if (temp == null) {
                entryArray[h].next = new Entry(key, value);
                return;
            }
            while (temp.next != null) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
            }
            if (temp.key == key) {
                temp.value = value;
                return;
            }
            temp.next = new Entry(key, value);
        } else {
            entryArray[h] = new Entry(key, value);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        if (entryArray[h] == null)
            return -1;
        if (entryArray[h].key == key)
            return entryArray[h].value;

        Entry temp = entryArray[h].next;
        while (temp != null) {
            if (temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        if (entryArray[h] == null)
            return;
        if (entryArray[h].key == key) {
            entryArray[h] = entryArray[h].next;
            return;
        }

        Entry prev = entryArray[h];
        Entry temp = entryArray[h].next;
        while (temp != null) {
            if (temp.key == key) {
                prev.next = temp.next;
                return;
            }
            temp = temp.next;
            prev = prev.next;
        }
    }

    private int hash(int key) {
        return key & (size - 1);
    }
}

class Entry {

    public final int key;
    public int value;
    public Entry next;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    Entry(int key, int value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
