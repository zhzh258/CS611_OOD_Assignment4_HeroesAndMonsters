package character;

import item.Item;

import java.util.List;

/*
 * This class is the team in the grid. A Team contains 1-3 heroes.
 * */
public class Team {
    final private List<Hero> heroes;

    public int get_r() {
        return r;
    }

    public void set_r(int r) {
        this.r = r;
    }

    public int get_c() {
        return c;
    }

    public void set_c(int c) {
        this.c = c;
    }

    public Hero getHero(){
        return heroes.get(current);
    }
    public List<Hero> getHeroes(){
        return heroes;
    }
    public int getSize(){
        return heroes.size();
    }

    private int r; // current location
    private int c; // current location
    private int current; // current focused hero

    public Team(int heroes_count){
        FactoryHero hf = new FactoryHero();
        this.heroes = hf.createInstance(heroes_count);
        for(Hero h : heroes){
            System.out.println(h.toString());
        }
        this.current = 0;
        this.r = -1;
        this.c = -1;
    }

    public void addHero(Hero h){
        heroes.add(h);
    }

    public void showInventory(){
        System.out.println("Now showing inventory of hero " + (current+1));
        this.getHero().getInventory().display();
    }
    public void changeInventory(){
        current = (current + 1) % getSize();
        System.out.println("You successfully switch to the inventory of hero " + (current + 1));
    }

    public void showHeroStatus(){
        for(int i = 0; i < getSize(); i++){
            System.out.println("Status of hero No." + (i+1));
            this.getHeroes().get(i).display();
        }
    }

}
