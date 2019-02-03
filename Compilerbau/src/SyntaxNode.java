import java.util.HashSet;
import java.util.Set;

public abstract class SyntaxNode
{
    public Boolean nullable;
    public final Set<Integer> firstpos = new HashSet<>();
    public final Set<Integer> lastpos = new HashSet<>();

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public void addFirstpos (Integer newFirstpos){
        firstpos.add(newFirstpos);
    }

    public void addLastpos (Integer newLastpos){
        lastpos.add(newLastpos);
    }
}