package day20;
import java.util.*;

public class BE8Tree {
	Integer value;
	ArrayList<BE8Tree> children;
	
	
	public BE8Tree() {
		children = new ArrayList<BE8Tree>();
	}
	public BE8Tree(Integer value) {
		this.value = value;
		children = new ArrayList<BE8Tree>();
	}
}
