import java.util.Scanner;
import java.util.Arrays;
class CricketRanking {
	String teamname;
	int win;
	int loss;
	int draw;
	CricketRanking(String name,int winn, int lost, int draws) {
		this.teamname = name;
		this.win = winn;
		this.loss = lost;
		this.draw = draws;
	}
	public String getTeamName() {
		return this.teamname;
	}
	public int getwinn() {
		return this.win;
	}
	public int getLost() {
		return this.loss;
	}
	public int getDraw() {
		return this.draw;
	}
	public int compareTo(CricketRanking comp) {
		if(this.win > comp.win) {
			return 1;
		}
		if(this.win < comp.win) {
			return -1;
		}
		if(this.loss < comp.loss) {
			return 1;
		}
		if(this.loss > comp.loss) {
			return -1;
		}
		if(this.draw > comp.draw) {
			return 1;
		}
		if(this.draw < comp.draw) {
			return -1;
		}
		return 0;
	}
	
}
class Sorting {
	CricketRanking[] teams;
	int size;
	Sorting() {
		size = 0;
		teams = new CricketRanking[10];
	}
	//takes O(n) time complexity.
	void add(CricketRanking objcricket) {
		teams[size++] = objcricket;
		if(size > 10) {
			resize();
		}
	}
	//takes O(1) complexity.
	void resize() {
		teams = Arrays.copyOf(teams, size * 2);
	}
	//takes O(n) time complexity.
	void exchange(CricketRanking[] a, int i, int min) {
		CricketRanking temp = a[min];
		a[min] = a[i];
		a[i] = temp;
	}
	//takes O(n) time complexity.
	String display() {
		String s = "";
		for(int i = 0; i < size; i++) {
			s += teams[i].teamname + ",";

		}
		return s.substring(0, s.length() - 1);
	}
	//takes O(n^2) time complexity.
	void InsertionSort() {
		for(int i = 0; i < size-1; i++) {
			int min = i; 
			for(int j = i+1; j > 0; j--) {
				if(less(teams,j,j-1)) {
					exchange(teams,j,j-1);		
				}
			}
			
			
		}
	}
	//takes O(1) time complexity.
	boolean less(CricketRanking[] teams, int j, int min) {
		return teams[j].compareTo(teams[min]) > 0;
	}
}
