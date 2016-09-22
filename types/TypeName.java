package types;

/**
 * Created by marius on 22.09.2016.
 */
public class TypeName extends Type {


    @Override public String identify() {
        return "type name";
    }

    @Override public int size() {
        return 4;
    }
}
