import java.util.ArrayList;

public class ArrayStack implements IStackable{
	private ArrayList<Integer> linkyArray = new ArrayList<Integer>();
	
	@Override
	public int size() {
		return linkyArray.size();
	}

	@Override
	public void push(int v) {
		linkyArray.add(v);
	}

	@Override
	public int pop() {
		return (int) linkyArray.remove(linkArray.size()-1);
	}

}
