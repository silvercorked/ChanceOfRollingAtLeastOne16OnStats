import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThreeD6DropLowplus1net {

	private int[] statistics;
	private Random rand;
	
	public ThreeD6DropLowplus1net() {
		rand = new Random();
		statistics = stats();
		
	}
	
	public int[] stats() {
		int[] stats = {stat(),stat(),stat(),stat(),stat(),stat()};
		return stats;
	}
	
	public int stat() {
		int a = rand.nextInt(6) + 1;
		int b = rand.nextInt(6) + 1;
		int c = rand.nextInt(6) + 1;
		int d = rand.nextInt(6) + 1;
		ArrayList<Integer> all = new ArrayList<Integer>();
		all.add(a);all.add(b);all.add(c);all.add(d);
		int sum = 0; 
		for (int i = 0; i < 3; i++) {
			sum+= Collections.max(all);
			all.remove(Collections.max(all));
		}
		return sum;
	}
	
	public int[] getStats() {
		return statistics;
	}
}
