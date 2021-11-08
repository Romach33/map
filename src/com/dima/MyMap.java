package com.dima;

class Entry {
    String key;
    Double value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        if (key != null) {
            return prime * mul + key.hashCode();
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !this.getClass().getName().equals(o.getClass().getName())) {
            return false;
        }
        Entry element = (Entry) o;
        return this.key.equals(element.key);
    }
}

public class MyMap {
    private final int capacity = 100;
    private int size = 0;
    private final Entry[] table = new Entry[capacity];

    private int Hashing(int hashCode) {
        //System.out.println("Location:"+location);
        return hashCode % capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean containsKey(Object key) {
        if(key == null) {
            if(table[0].getKey() == null) {
                return true;
            }
        }
        assert key != null;
        int location = Hashing(key.hashCode());
        Entry e = null;
        try {
            e = table[location];
        }catch(NullPointerException ignored) {

        }
        return e != null && e.getKey() == key;
    }

    public boolean containsValue(Double value) {
        for (Entry entry : table) {
            if (entry != null && entry.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public Double get(String key) {
        Double returnable = null;
        if(key == null) {
            Entry element = null;
            try{
                element = table[0];
            }catch(NullPointerException ignored) {

            }
            if(element != null) {
                return element.getValue();
            }
        } else {
            int location = Hashing(key.hashCode());
            Entry element = null;
            try{
                element = table[location];
            }catch(NullPointerException ignored) {

            }
            if(element!= null && element.getKey().equals(key)) {
                return element.getValue();
            }
        }
        return returnable;
    }

    public Double put(String key, Double value) {
        Double returnable = null;
        if (key == null) {
            returnable = putForNullKey(value);
            return returnable;
        } else {
            int location = Hashing(key.hashCode());
            if(location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry e = null;
            try{
                e = table[location];
            }catch(NullPointerException ignored) {

            }
            if (e!= null && e.getKey().equals(key)) {
                returnable = e.getValue();
            } else {
                Entry eNew = new Entry();
                eNew.setKey(key);
                eNew.setValue(value);
                table[location] = eNew;
                size++;
            }
        }
        return returnable;
    }

    private Double putForNullKey(Double value) {
        Entry e = null;
        try {
            e = table[0];
        }catch(NullPointerException ignored) {

        }
        Double returnable = null;
        if (e != null && e.getKey() == null) {
            returnable = e.getValue();
            e.setValue(value);
            return returnable;
        } else {
            Entry eNew = new Entry();
            eNew.setKey(null);
            eNew.setValue(value);
            table[0] = eNew;
            size++;
        }
        return returnable;
    }

    public Double remove(String key) {
        int location = Hashing(key.hashCode());
        Double ret = null;
        if(table[location]!=null)
        if(table[location].getKey().equals(key)) {
            if (table.length - 1 - location >= 0)
                System.arraycopy(table, location + 1, table, location, table.length - 1 - location);
        }
        size--;
        return ret;
    }


}
