import java.util.HashSet;

interface Visitable
{
    void accept(Visitor visitor);
    boolean getNullable ();
    <Intager> HashSet getFirstpos();
    <Intager> HashSet getLastpos();

}
