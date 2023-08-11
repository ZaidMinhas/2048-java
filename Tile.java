
public class Tile {
	
	int x;
	int y;
	boolean locked = false;
	int number = 0;
	public Tile(int x, int y) {
		this.x = x; 
		this.y = y;
	}
	
	public String toString() {
		return "" + number;
	}
}
