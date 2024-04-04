package event;

import character.Monster;
import character.EnumerateMonster;
import character.Team;
import utility.InputHandler;
import utility.Rand;

import java.util.*;

/*
 * This class uses Factory Pattern.
 * A FactoryEventBattle bf is stored in Team.java.
 * Whenever user enters a TileEvent for the first time, it creates an event for the tile.
 * */
public class FactoryEventBattle extends FactoryEvent {
    private List<Monster> monsters;
    final private Team team;
    public FactoryEventBattle(Team team){
        monsters = new ArrayList<>();
        this.team = team;

        List<String> filenames = Arrays.asList("Dragons", "Exoskeletons", "Spirits");

        for(String filename: filenames){
            InputHandler in = InputHandler.getInstance();
            List<List<String>> values = in.loadFileContents(in.toPath(filename));
            for(int i=1; i<values.size(); i++){
                if(filename.equals("Dragons")){
                    List<String> monster = values.get(i);
                    String name = monster.get(0);
                    int level = Integer.parseInt(monster.get(1));
                    int damage = Integer.parseInt(monster.get(2));
                    int defense = Integer.parseInt(monster.get(3));
                    int dodge_chance = Integer.parseInt(monster.get(4));
                    monsters.add(new Monster(name, level, damage, defense, dodge_chance, EnumerateMonster.Dragon));
                }
                else if(filename.equals("Exoskeletons")){
                    List<String> monster = values.get(i);
                    String name = monster.get(0);
                    int level = Integer.parseInt(monster.get(1));
                    int damage = Integer.parseInt(monster.get(2));
                    int defense = Integer.parseInt(monster.get(3));
                    int dodge_chance = Integer.parseInt(monster.get(4));
                    monsters.add(new Monster(name, level, damage, defense, dodge_chance, EnumerateMonster.Exoskeletons));
                }
                else if(filename.equals("Spirits")){
                    List<String> monster = values.get(i);
                    String name = monster.get(0);
                    int level = Integer.parseInt(monster.get(1));
                    int damage = Integer.parseInt(monster.get(2));
                    int defense = Integer.parseInt(monster.get(3));
                    int dodge_chance = Integer.parseInt(monster.get(4));
                    monsters.add(new Monster(name, level, damage, defense, dodge_chance, EnumerateMonster.Spirits));
                }
            }
        }
    }
    @Override
    public EventBattle createInstance() {
        int n = team.getSize();
        List<Monster> selectedMonsters = Rand.selectRandomElements(monsters, n);
        return new EventBattle(selectedMonsters, team);
    }
}
