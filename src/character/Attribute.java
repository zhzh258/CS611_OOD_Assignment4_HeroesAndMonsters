package character;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;

/*
* This class manages attributes of a character.
* A character has 2 kinds of attributes: const (base) and mutable (buff).
* For example, T can be EnumerateHeroAttribute
* */
public class Attribute<T extends Enum<T>> {
    final private HashMap<T, Integer> base; // base cannot be modified (after initialization in the constructor)
    final private HashMap<T, Integer> buff; // buff can be modified
    final private T[] enumConstants;
    public Attribute (Class<T> enumType, List<Integer> values){
        T[] enumConstants = enumType.getEnumConstants();
        this.enumConstants = enumConstants;
        if (enumConstants.length != values.size()) {
            throw new IllegalArgumentException("The number of values must match the number of enum constants!");
        }
        this.base = new HashMap<>();
        this.buff = new HashMap<>();

        for (int i = 0; i < enumConstants.length; i++) {
            this.base.put(enumConstants[i], values.get(i));
        }
    }

    // update HashMap buff
    public void setBuff(T key, int value){
        buff.put(key, value);
    }
    public void addBuff(T key, int dValue){
        buff.put(key, buff.get(key) + dValue);
    }

    // get result based on base and buff
    public int valueOf(T key){
        assert base.containsKey(key);
        int res = base.get(key);
        if(buff.containsKey(key)){
            res += buff.get(key); // currently I use "+". But it can be changed for future extensibility.
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("<Attribute>\n");
        for(T enumConstant : enumConstants){
            res.append("\t");
            res.append(enumConstant.toString()).append("==");
            int val = 0;
            if(base.get(enumConstant) != null){
                res.append(base.get(enumConstant));
            }
            if(buff.get(enumConstant) != null){
                res.append(buff.get(enumConstant));
            }
            res.append("\n");
        }
        res.append("</Attribute>\n");
        return res.toString();
    }
}
