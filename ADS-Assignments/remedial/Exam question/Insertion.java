class Insertion {
    // Team teams;
    WordProfileGeneratorr[] obj;
    int size;
    Insertion() {
        obj = new WordProfileGeneratorr[2000];
        this.size = 0;
    }
    public void add(WordProfileGeneratorr f) {
        obj[size++] = f;
    }
    public int size() {
        return size;
    }
// time complexity for this method is O(N^2).
// In first for loop and second loop it iterates through the size of array
    public void insertion() {
        for (int i = 0;i < size; i++) {
            for (int j = i; j > 0 && obj[j].compareTo(obj[j-1]) == 1; j--) {
                swap(obj, j, j-1);
            }
        }
        print();
    }
// time complexity of this method is O(1). It swaps the elements only once.
    public void swap(WordProfileGeneratorr[] obj, int j, int min) {
        WordProfileGeneratorr temp = obj[min];
        obj[min] = obj[j];
        obj[j] = temp;
    }
// time complexity of this method is O(N). It iterates through
// the array to print all the objects in array.
    public void print() {
        String str = "";
        for (int i = 0; i < size; i++) {
            String s = "";
            s += obj[i].getalobj();
            str += s.substring(2,s.length() - 2).trim();
            str += "\n";
        }
        str += "\n";
        System.out.println(str);
    }
}
