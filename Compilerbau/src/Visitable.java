import java.util.HashSet;

interface Visitable
{
    void accept(Visitor visitor);
    boolean getNullable ();
    HashSet<Integer> getFirstpos();
    HashSet<Integer> getLastpos();

}
