import java.util.*;
class WordProfileGeneratorr {
	int docid;
	int subfreq;
	ArrayList<Integer> al1;
	ArrayList<Object> al2;
	WordProfileGeneratorr(int docid, int subfreq, ArrayList<Integer> al1, ArrayList<Object> al2) {
		this.docid = docid;
		this.subfreq = subfreq;
		this.al1 = al1;
		this.al2 = al2;
	}
	int compareTo(WordProfileGeneratorr that) {
		if (this.al1.size() > that.al1.size()) {
			return 1;
		} if (this.al1.size() < that.al1.size()) {
			return -1;
		} if (this.docid < that.docid) {
			return 1;
		} if (this.docid > that.docid) {
			return -1;
		} 
		return 0;
	}
	ArrayList<Object> getalobj() {
		return this.al2;
	}

}