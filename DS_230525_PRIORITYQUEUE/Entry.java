package DS_230525_PRIORITYQUEUE;

public class Entry <Key extends Comparable<Key>, Value>
{
    private Key key;
    private Value value;
    public Entry(Key newKey, Value newValue){
        key = newKey;
        value = newValue;
    }


    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value val) {
        this.value = val;
    }
}
