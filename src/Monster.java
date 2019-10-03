import java.util.HashMap;
import java.util.Objects;

abstract class Monster {
    Integer hp;
    private Integer xp;
    private Integer maxHP;
    HashMap<String,Integer> items;

    public Monster(int xp, int maxHP, HashMap<String, Integer> items) {
        this.xp = xp;
        this.maxHP = maxHP;
        hp = maxHP;
        this.items = items;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return getHp() == monster.getHp() &&
                getXp() == monster.getXp() &&
                getMaxHP() == monster.getMaxHP() &&
                getItems().equals(monster.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHp(), getXp(), getMaxHP(), getItems());
    }

    @Override
    public String toString() {
        return "Monster{" +
                "hp=" + hp +
                ", xp=" + xp +
                ", maxHP=" + maxHP +
                ", items=" + items +
                '}';
    }
}
