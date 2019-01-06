package advancedproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HuntForGold {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String size = scanner.nextLine();
        int row = Integer.parseInt(size.split("\\s+")[0]);
        int col = Integer.parseInt(size.split("\\s+")[1]);
        // build the maze
        Maze maze = new Maze(row, col);
        for (int i = 0; i < row; i++) {
            maze.build(scanner.nextLine().trim());
        }
        // create player
        int playNum = Integer.parseInt(scanner.nextLine());
        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < playNum; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            Player player = new Player(
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2])
            );
            playerList.add(player);
        }
        // players keep hunting gold
        boolean somePlayerWin = false;
        Player win = null;
        while (!somePlayerWin) {
            for (Player player : playerList) {
                if (player.hunt(maze)) {
                    somePlayerWin = true;
                    win = player;
                    break;
                }
            }
        }
        // reaches here means one of player win the game
        System.out.println(win.id);
    }
}

class Maze {

    char[][] maze;
    Map map;
    private int curRow;
    private int curCol;

    public Maze(int x, int y) {
        maze = new char[x][y];
        map = new Map();
        curRow = 0;
        curCol = 0;
    }

    public void build(String l) {
        String[] lines = l.split("\\s+");
        curCol = 0;
        int idx = 0;
        // handle a line data, map the maze
        while (idx < lines.length) {
            if ("D".equals(lines[idx])) {
                int x = Integer.parseInt(lines[++idx]);
                int y = Integer.parseInt(lines[++idx]);
                maze[curRow][curCol] = 'D';
                map.put(new Pair(curRow, curCol), new Pair(x, y));
            } else if ("T".equals(lines[idx])) {
                maze[curRow][curCol] = 'T';
            } else if ("G".equals(lines[idx])) {
                maze[curRow][curCol] = 'G';
            }
            idx++;
            curCol++;
        }
        curRow++;
    }
}

class Player {

    int id;
    private int x;
    private int y;
    private boolean isTraped;

    public Player(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.isTraped = false;
    }

    public boolean hunt(Maze m) {
        if (!this.isTraped) {
            int row = m.maze.length;
            int col = m.maze[0].length;
            char ch = m.maze[x][y];
            if (ch == 'D') {
                Pair p = m.map.get(x, y);
                x = Math.abs(x + p.x) % row;
                y = Math.abs(y + p.y) % col;
            } else if (ch == 'T') {
                this.isTraped = true;
            } else if (ch == 'G') {
                return true;
            }
        }
        return false;
    }
}

class Map {

    HashMap<Pair, Pair> map = new HashMap<>();

    public void put(Pair pair1, Pair pair2) {
        map.put(pair1, pair2);
    }

    public Pair get(int x, int y) {
        for (Pair p : map.keySet()) {
            if (p.x == x && p.y == y) return map.get(p);
        }
        return null;
    }

}

class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
