
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
            if (node.left.getNullable() == true || node.right.getNullable() == true){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //firstpos eintragen
            for (int firstposleft: node.left.getFirstpos()) {
                node.addFirstpos(firstposleft);
            }
            for (int firstposright: node.right.getFirstpos()) {
                node.addFirstpos(firstposright);
            }

            //lastpos eintrangen
            for (int lastposleft: node.left.getLastpos()) {
                node.addFirstpos(lastposleft);
            }
            for (int lastposright: node.right.getLastpos()) {
                node.addFirstpos(lastposright);
            }
        }

        //for Konkatination nodes
        if (node.operator.equals("*")){
            //nullable
            if (node.left.getNullable() == true && node.right.getNullable() == true){
                node.setNullable(true);
            }
            else {
                node.setNullable(false);
            }

            //firstpos
            if (node.left.getNullable() == true){
                //add firstpos right
                for (int firstposright: node.right.getFirstpos()) {
                    node.addFirstpos(firstposright);
                }
            }
            //add firstpos left
            for (int firstposleft: node.left.getFirstpos()) {
                node.addFirstpos(firstposleft);
            }

            //lastpos
            if (node.right.getNullable() == true){
                //add lastpos left
                for (int lastposleft: node.left.getLastpos()) {
                    node.addFirstpos(lastposleft);
                }
            }
            //add lastpos right
            for (int lastposright: node.right.getLastpos()) {
                node.addFirstpos(lastposright);
            }
        }
    }

    @Override
    public void visit(UnaryOpNode node) {
        //nullable eintragen
        if (node.operator.equals("*") || node.operator.equals("?")){
            node.setNullable(true);
        }
        else {
            node.setNullable(node.left.getNullable());
        }

        //firstpos eintragen
        for (int firstposleft: node.left.getFirstpos()) {
            node.addFirstpos(firstposleft);
        }

        //lastpos eintrangen
        for (int lastposright: node.right.getLastpos()) {
            node.addFirstpos(lastposright);
        }
    }
}
