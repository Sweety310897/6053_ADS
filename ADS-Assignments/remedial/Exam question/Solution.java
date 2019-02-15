import java.util.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		WordSyn wpg = new WordSyn("Files");
		wpg.reader();
		wpg.presenter();
	}
}

class WordSyn {
	File folder;
	Insertion insert;
	File[] listoffiles;
	LinkedHashMap<String,ArrayList<Object>> lhm;
	
	WordSyn(String path_directory) {
		this.folder= new File(path_directory);
		this.listoffiles = folder.listFiles();
		this.lhm = new LinkedHashMap<String,ArrayList<Object>>();
		insert = new Insertion();
	}

	void reader() throws Exception {
		for (int i = 0; i < listoffiles.length; i++) {		
			FileReader in = new FileReader(listoffiles[i].getAbsolutePath());
		    BufferedReader br = new BufferedReader(in);
		    String line;
		    while ((line = br.readLine()) != null) {
		    	this.parser(line, i);
		    }
		    in.close();		
		}
	}

	void parser(String data, int indexoffile) {
		String[] dt = data.split(" ");
		for (int i = 0 ; i < dt.length; i++) {
			if (!this.lhm.containsKey(dt[i])) {			
				ArrayList<Object> sal = new ArrayList<Object>(); 
				ArrayList<Integer> ssal = new ArrayList<Integer>(); 
				ssal.add(i);
				sal.add(1);
				sal.add(ssal);
				LinkedHashMap<Integer,ArrayList<Object>> slhm = new LinkedHashMap<Integer,ArrayList<Object>>();  
				slhm.put(indexoffile, sal);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(1);
				al.add(slhm);
				this.lhm.put(dt[i], al);
			} else {
				Integer total_frequency = (Integer) this.lhm.get(dt[i]).get(0);
				total_frequency += 1;
				this.lhm.get(dt[i]).set(0, total_frequency);
				LinkedHashMap<Integer, ArrayList<Object>> tmp_slhm = (LinkedHashMap<Integer, ArrayList<Object>>) this.lhm.get(dt[i]).get(1);
				if (tmp_slhm.containsKey(indexoffile)) {
					Integer sfreq = (Integer) tmp_slhm.get(indexoffile).get(0);
					sfreq += 1;
					tmp_slhm.get(indexoffile).set(0,sfreq);
					ArrayList<Integer> tmp_ssal =  (ArrayList<Integer>) tmp_slhm.get(indexoffile).get(1);
					tmp_ssal.add(i);		
				} else {
					ArrayList<Object> tmp_sal = new ArrayList<Object>(); 
					ArrayList<Integer> tmp_ssal = new ArrayList<Integer>(); 
					tmp_ssal.add(i);
					tmp_sal.add(1);
					tmp_sal.add(tmp_ssal);
					tmp_slhm.put(indexoffile,tmp_sal);		
				}
			}
		}
	}

	void presenter() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		// System.out.println(lhm);
		if (lhm.get(line) != null) {
		int totalfreq = (int) lhm.get(line).get(0);
		ArrayList<WordProfileGeneratorr> comp = new ArrayList<WordProfileGeneratorr>();
		LinkedHashMap<Integer, ArrayList<Object>> lkm = (LinkedHashMap<Integer, ArrayList<Object>>) this.lhm.get(line).get(1);
		System.out.println(line + ":" + totalfreq);
		Map<String, ArrayList<Object>> test1 = new LinkedHashMap<String, ArrayList<Object>>();
		lkm.forEach((key,value) -> {
		ArrayList<Object> obj = new ArrayList<Object>();
		ArrayList<Object> obj2 = new ArrayList<Object>();
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		al1 = (ArrayList) value.get(1);
		int doc = (int) key;
		int subfreq = (int) value.get(0);
		obj.add(doc);
		obj.add(subfreq);
		obj.add(al1);
		obj2.add(obj);
		WordProfileGeneratorr wpgg = new WordProfileGeneratorr(doc, subfreq, al1, obj2);
		insert.add(wpgg);
		});

		insert.insertion();

	} else {
			System.out.println("word is not present in any file");
		}
	}
}