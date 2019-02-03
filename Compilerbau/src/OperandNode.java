public class OperandNode extends SyntaxNode implements Visitable
{
    public int position;
    public String symbol;
    public OperandNode(String symbol)
    {
        position = -1; // bedeutet: noch nicht initialisiert
        this.symbol = symbol;
    }
    @Override
    public void accept(Visitor vistor)
    {
        visitor.visit(this);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getSymbol() {
        return symbol;
    }
}