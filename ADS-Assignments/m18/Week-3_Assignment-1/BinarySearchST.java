import java.util.Scanner;
import java.util.ArrayList;
class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n;
    public BinarySearchST() {
        //this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) { 
        keys = (Key[]) new Comparable[capacity]; 
        vals = (Value[]) new Object[capacity]; 
    }   
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = vals[i];
        }
        vals = tempv;
        keys = tempk;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        //if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to get() is null"); 
        }
        if (isEmpty()) {
        	return null;
        } 
        	
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) {
        	return vals[i];
        }
        return null;
    } 

    public int rank(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to rank() is null"); 
        }
        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 
    public void put(Key key, Value val)  {
        if (key == null) {
        	//throw new IllegalArgumentException("first argument to put() is null"); 
        	System.out.println("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        // insert new key-value pair
        if (n == keys.length) resize(2*keys.length);

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

        assert check();
    } 
    public void delete(Key key) {
        if (key == null) {
        	throw new IllegalArgumentException("argument to delete() is null"); 
        }
        if (isEmpty()) {
        	return;
        }
        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) resize(keys.length/2);

        assert check();
    } 
    public void deleteMin() {
        if (isEmpty()) {
        	System.out.println("Symbol table underflow error");
        	//throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    public void deleteMax() {
        if (isEmpty()) {
        	System.out.println("Symbol table underflow error");
        	//throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(max());
    }
    public Key min() {
        if (isEmpty()) {
        	//throw new NoSuchElementException("called min() with empty symbol table");
        	System.out.println("called min() with empty symbol table");
        }
        return keys[0]; 
    }
    public Key max() {
        if (isEmpty()) {
        	//throw new Exception("called max() with empty symbol table");
        	System.out.println("called max() with empty symbol table");
        }
        return keys[n-1];
    }
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            //throw new IllegalArgumentException("called select() with invalid argument: " + k);
            System.out.println("called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    public Key floor(Key key) {
        if (key == null) {
        	//throw new IllegalArgumentException("argument to floor() is null"); 
        	System.out.println("argument to floor() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }
    public Key ceiling(Key key) {
        if (key == null) {
        	//throw new IllegalArgumentException("argument to ceiling() is null"); 
        	System.out.println("argument to ceiling() is null");
        }
        int i = rank(key);
        if (i == n) return null; 
        else return keys[i];
    }
    public ArrayList<String> keys() {
        return keys(min(), max());
    }
public ArrayList<String> keys(Key low, Key high) {
        if (low == null) {
            throw new IllegalArgumentException("first argument to keys() is null"); 
        }

        if (high == null) {
            throw new IllegalArgumentException("last argument to keys() is null"); 
        }

        ArrayList<String> limit = new ArrayList<>();
        if (low.compareTo(high) > 0) {
            return limit;
        }

        for (int i = rank(low); i < rank(high); i++) {
            limit.add((String)keys[i]);
        }

        if (contains(high)) {
            limit.add((String)keys[rank(high)]);
        }

        return limit;
    }
    private boolean check() {
        return isSorted() && rankCheck();
    }
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }
}