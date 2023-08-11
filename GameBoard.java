import java.util.Random;

public class GameBoard {
	
	/* Set a board of n x m
	 * A board has tiles
	 * The tiles are in a 2D array
	 * 
	 */
	int score = 0;
	int row = 4;
	int col = 4;
	Random random = new Random();
	Grid grid;
	
	public GameBoard() {
		
		grid = new Grid(row, col);
		SpawnTile();
		SpawnTile();
	}
	
	
	public void SpawnTile() {
		Tile tile =  grid.getEmptyTile();
		tile.number = random.nextFloat() <= 0.1 ? 4 : 2;
		
	}
	
	
	public void move(int dirX, int dirY, int startX, int startY, int incrX, int incrY) {
		boolean checkLocks = false;
		for (int y = startY; y < row && y >= 0; y+= incrY) {
			for (int x = startX; x < col && x >= 0; x+= incrX) {
				Tile tile = grid.get(x, y);
				if (tile.number != 0) {
					Tile nextTile = tile;
					while (true) {
						nextTile = grid.getNext(tile, dirX, dirY);
						if (nextTile == null) {
							break;
						}
						
						if (nextTile.number == 0) {
							nextTile.number = tile.number;
							tile.number = 0;
							tile = nextTile;
						}
						else {
							if (nextTile.number == tile.number && !nextTile.locked) {
								score += tile.number;
								nextTile.number = tile.number*2;
								tile.number = 0;
								tile = nextTile;
								tile.locked = true;
								checkLocks = true;
								
							}
							else {
								
								break;
							}
						}
						
					}
				}
			}
		}
		if (checkLocks)
			unlock();
		SpawnTile();
	}

	public void unlock() {
		for (int y = 0; y < row;y++) {
			for (int x = 0; x < col; x++) {
				grid.get(x, y).locked = false;
			}
		}
	}
	
	public void moveRequest(String input) {
		//Down
		if (input.compareToIgnoreCase("s") == 0)
			move(0,1,  0,  row - 2,  1,  -1);
		
		//Up
		if (input.compareToIgnoreCase("w") == 0)
			move(0,-1, 0,  1,  1,  1);
		
		//Right
		if (input.compareToIgnoreCase("d") == 0)
			move(1,0 , col-2, 0, -1, 1);
		
		//Left
		if (input.compareToIgnoreCase("a") == 0)
			move(-1, 0, 1, 0, 1, 1);
	}
	
	public String toString() {
		String output = "";
		for (int y = 0; y < row; y++) {
			for (int x = 0; x < col; x++) {
				Tile tile = grid.get(x, y);
				if (tile.number == 0) {
					output += "-\t";
				}
				else {
					output += tile.number + "\t";
				}
				 
			}
			output += "\n";
		}
		
		return output;
	}
}
