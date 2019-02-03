
public class Visitor1 implements Visitor{

    private int positioncounter = 1;

    @Override
    public void visit(OperandNode node) {

        //position eintragen
        node.setPosition(positioncounter);
        positioncounter ++;

        //nullable eintragen
        if (node.getSymbol().equals("epsilon")){
            node.setNullable(true);
        }
        else {
            node.setNullable(false);
        }

        //firstpos und Lastpos eintragen
        if (node.nullable == false){
            node.addFirstpos((Integer) node.getPosition());
            node.addLastpos((Integer) node.getPosition());
        }

    }

    @Override
    public void visit(BinOpNode node) {
        //for or nodes:
        if (node.operator.equals("or")) {
            //nullable eintragen
            if (node.left.)
            //firstpos eintragen
            //lastpos eintrangen
        }
        if (node.operator.equals("*")){

        }
    }

    @Override
    public void visit(UnaryOpNode node) {
        //nullable eintragen
        //firstpos eintragen
        //lastpos eintrangen
    }
}
