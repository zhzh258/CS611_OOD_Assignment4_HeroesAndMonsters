package grid;

import character.EnumerateHeroAttribute;
import character.Hero;
import character.Team;
import event.FactoryEventBattle;
import event.FactoryEventMarket;
import utility.Color;
import utility.Rand;

import java.util.ArrayList;
import java.util.Random;

/*
* This class is the Grid of my game.
* It has a GridTile[][] that stores either a block, a border, a common, or a market
* */
public class Grid {
    final private ArrayList<ArrayList<Tile>> tiles;
    private final Team team;
    private FactoryEventMarket mf;
    private FactoryEventBattle bf;
    final private int R; // number of rows in the grid (excluding border)
    final private int C; // number of columns in the grid (excluding border)
    final private int H; // number of rows in the grid (including border)
    final private int W; // number of rows in the grid (including border)
    public int getR() {
        return R;
    }
    public int getC() {
        return C;
    }
    public int getH() {
        return H;
    }
    public int getW() {
        return W;
    }
    public ArrayList<ArrayList<Tile>> getTiles() {
        return tiles;
    }
    public Tile getTile(int i, int j){
        if(-1 < i && i < H && -1 < j && j < W) {
            return tiles.get(i).get(j);
        } else {
            return new TileBorder(-1, -1);
        }
    }
    public void setTile(int i, int j, Tile tile){
        if(-1 < i && i < H && -1 < j && j < W) {
            this.tiles.get(i).set(j, tile);
        }
    }
    public Tile getCurrentTile(){
        int r = team.get_r();
        int c = team.get_c();
        return getTile(r, c);
    }
    public Grid(int H, int W, int heroes_count){
        this.R = H - 2;
        this.C = W - 2;
        this.H = H;
        this.W = W;
        this.tiles = new ArrayList<ArrayList<Tile>>();
        for(int r = 0; r < H; r++){
            tiles.add(new ArrayList<Tile>());
        }

        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(i == 0 || i == R+1 || j == 0 || j == C+1){
                    tiles.get(i).add(new TileBorder(i, j));
                    continue;
                }
                Random rand = new Random();
                int randomNumber = rand.nextInt(100-1) + 1;
                if(randomNumber <= 20){
                    tiles.get(i).add(new TileBlock(i, j));
                } else if(randomNumber <= 55){
                    tiles.get(i).add(new TileMarket(i, j));
                } else {
                    tiles.get(i).add(new TileCommon(i, j));
                }
            }
        }
        int rand_r = Rand.randomInt(1, H-1);
        int rand_c = Rand.randomInt(1, W-1);
        // create the team
        this.team = new Team(heroes_count);
        this.team.set_r(rand_r);
        this.team.set_c(rand_c);
        // create the factories
        this.mf = new FactoryEventMarket(this.team); // bind this.team to mf
        this.bf = new FactoryEventBattle(this.team); // bind this.team to bf
    }

    public void display() {
        for (int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print("+");
                // top
                if(getTile(i, j) != null) {
                    Color.print(getTile(i, j).getTypeColor(), "--");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.print("+");
            System.out.println();
            for (int j = 0; j < W; j++) {
                // left for each grid
                if(getTile(i, j) != null) {
                    Color.print(getTile(i, j).getTypeColor(), "|");
                }else {
                    System.out.print(" ");
                }
                Tile tile = tiles.get(i).get(j);
                // center
                if (i == team.get_r() && j == team.get_c()){
                    Color.print("BLUE", "%-2s", "H");
                } else if (tile != null) {
                    Color.print(tile.getTypeColor(), "%-2s", tile.getTypeSymbol());
                } else {
                    System.out.print("??");
                }
            }
            // right edge for last grid of each row
            if(getTile(i, W - 1) != null) {
                Color.print(getTile(i, W - 1).getTypeColor(), "|");
            }else {
                System.out.print(" ");
            }
            System.out.println();
        }
        for(int j = 0; j < W; j++) {
            System.out.print("+");
            // bottom
            if(getTile(H - 1, j) != null) {
                Color.print(getTile(H - 1, j).getTypeColor(), "--");
            }else {
                System.out.print("  ");
            }
        }
        System.out.print("+");
        System.out.println();
    }
    public void displayHint() {
        System.out.println("Detailed View:");
        if(this.team == null){
            return;
        }
        int r = this.team.get_r();
        int c = this.team.get_c();
        Grid sub = new Grid(3,3, 0);
        int[] d = new int[]{-1, 0, 1};
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sub.setTile(i, j, getTile(r+d[i], c+d[j]));
            }
        }
        sub.display();
    }

    public void onUserInput(String s){
        int r = team.get_r();
        int c = team.get_c();
        // TODO
        if(s.equals("w")){ // move up
            tryUpdatePosition(r-1, c);
            return;
        }else if(s.equals("a")){ // move left
            tryUpdatePosition(r, c-1);
            return;
        }else if(s.equals("s")){ // move down
            tryUpdatePosition(r+1, c);
            return;
        }else if(s.equals("d")){ // move right
            tryUpdatePosition(r, c+1);
            return;
        }else if(s.equals("i")){ // show inventory
            team.showInventory();
        }else if(s.equals("m")){ // show map
            this.display();
        }else if(s.equals("h")){ // show hero status
            team.showHeroStatus();
        }else if(s.equals("t")){ // trade
            if(getCurrentTile() instanceof TileMarket){
                ((TileMarket) getCurrentTile()).market.start();
            } else{
                System.out.println("You can only enter the market in a 'M' tile!");
            }
        }else if(s.equals("c")){ // cast potions
            //
        }else if(s.equals("p")){ // change inventory to the next hero's
            team.changeInventory();
        }else if(s.equals("q")){ // back to menu
            return;
        }
    }

    private void tryUpdatePosition(int rr, int cc){
        boolean out_of_bound = !(0 < rr && rr < H-1 && 0 < cc && cc < W-1);
        boolean is_block = out_of_bound || getTile(rr, cc).getType() == EnumTile.Block;
        if(out_of_bound || is_block){ // invalid move
            System.out.println("Invalid choice: The team can't move to a block or a border.");
            return;
        } else{ // valid move
            // update team.r and team.c
            team.set_r(rr);
            team.set_c(cc);
            Tile next_tile = getTile(rr, cc);
            if(next_tile.getType() == EnumTile.Market){
                next_tile.generate(mf);
            } else if(next_tile.getType() == EnumTile.Common){
                int randomNumber = Rand.randomInt(0, 2);
                if(randomNumber == 0){ // lucky
                    return;
                } else if(randomNumber == 1){ // unlucky. Generate the battle event in this tile and start
                    next_tile.generate(bf);
                }
            }
        }
    }

    public boolean isGameOver(){
        for(Hero h : this.team.getHeroes()){
            if(h.getAttributeAt(EnumerateHeroAttribute.Health) > 0){
                return false;
            }
        }
        return true;
    }
    // testing
    public static void main(String[] a)  {
        Grid g_testing = new Grid(7, 7, 0);
        g_testing.display();
        g_testing.displayHint();
    }
}
