package Maze1;



public class ArrayStack implements Stack {
	
	private StackNode top;

	public ArrayStack() {
		top = null;
	}
	

	@Override
	public boolean isEmpty() {
		return (top == null);
	}

	
	@Override
	public void push(Element item) {
		StackNode newNode = new StackNode();
		newNode.item = item;
		newNode.link = top;
		top = newNode;
	}

	
	@Override
	public Element pop() {
		if (isEmpty()) {
			System.out.println("");
			return null;
		} else {
			Element item = top.item;
			top = top.link;
			return item;
		}
	}

	
	@Override
	public Element peek() {
		if (isEmpty()) {
			System.out.println("");
			return null;
		} else
			return top.item;
	}

	//πÊ«‚
	public void Direction(int x, int y) { 
		if (x < 0 || y < 0 || x >= Maze.ROW || y >= Maze.COL)
			return;
		if (Maze.maze[x][y] != '1' && Maze.maze[x][y] != '*') {
			Element temp = new Element(x, y);
			push(temp);
		}

	}
}
