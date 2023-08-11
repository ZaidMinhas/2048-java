import java.util.ArrayList;
import java.util.Random;

public class Grid {

	ArrayList<TileRow> rows;
	ArrayList<Tile> tiles;
	Random random = new Random();
	
	
	int row, col;
	public Grid(int row, int col) {
		this.row = row;
		this.col = col;
		rows = new ArrayList<TileRow>(row);
		for (int y = 0; y < row; y++) {
			TileRow boardRow =  new TileRow(col);
			for (int x = 0; x < col; x++) {
				boardRow.tiles.add(new Tile(x, y));
			}
			rows.add(boardRow);
		}
	}
	
	
	public Tile get(int x, int y) {
		if (x >= 0 && x < col && y >= 0 && y < row)
			return rows.get(y).get(x);
		else{
			return null;
		}
	}
	
	public Tile getNext(Tile currTile, int dirX, int dirY) {
		return get(currTile.x + dirX, currTile.y + dirY);
		
	}
	
	
	public Tile getEmptyTile() {
		ArrayList<Tile> emptyTiles = new ArrayList<Tile>();
		boolean full = true;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++ ) {
				Tile tile = get(i, j);
				if (tile.number == 0) {
					emptyTiles.add(tile);
					full = false;
				}
			}
		}
		if (!full) {
			int index = random.nextInt(0, emptyTiles.size());
			return emptyTiles.get(index);
		}
		else
			return null;
	}
}
