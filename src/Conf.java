import org.antlr.v4.runtime.tree.ParseTree;
import value.ExpValue;
import java.util.HashMap;
import java.util.Map;

public class Conf {

    private final Map<String, ExpValue<?>> map = new HashMap<>();

    private final Map<String, ParseTree> mapTree = new HashMap<>();

    private final Map<String, Map<String, ExpValue<?>>> mapMethodVar = new HashMap<>();

    private final Map<String, Map<String, ExpValue<?>>> mapMethodVar_copy = new HashMap<>();

    public boolean contains(String id) {
        return map.containsKey(id);
    }

    public ExpValue<?> get(String id) {
        return map.get(id);
    }

    public void update(String id, ExpValue<?> v) {
        map.put(id, v);
    }


    public boolean containsTree(String id) {
        return mapTree.containsKey(id);
    }

    public ParseTree getTree(String id) {
        return mapTree.get(id);
    }

    public void updateTree(String id, ParseTree v) {
        mapTree.put(id, v);
    }

    public boolean containsMVar(String id) {
        return mapMethodVar.containsKey(id);
    }

    public Map<String, ExpValue<?>> getMVar(String id) {
        return mapMethodVar.get(id);
    }

    public void updateMVar(String id, Map<String, ExpValue<?>> v) {
        mapMethodVar.put(id, v);
    }

    public Map<String, ExpValue<?>> getMVarCopy(String id) {
        return mapMethodVar_copy.get(id);
    }

    public void updateMVarcopy(String id, Map<String, ExpValue<?>> v) {
        mapMethodVar_copy.put(id, v);
    }


}