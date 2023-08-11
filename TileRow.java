
import java.util.ArrayList;

public class TileRow {
	
	ArrayList<Tile> tiles;
	
	public TileRow(int cols) {
		tiles = new  ArrayList<Tile>(cols);
	}
	
	public Tile get(int index) {
		return tiles.get(index);
	}
}
