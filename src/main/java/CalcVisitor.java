import org.apache.calcite.sql.*;
import org.apache.calcite.sql.util.SqlBasicVisitor;

public class CalcVisitor extends SqlBasicVisitor<String> {

    @Override
    public String visit(SqlCall call){
      //  visit()
       // call.accept(this) ;
        //factory
        for(SqlNode node : call.getOperandList()){
            if(node instanceof SqlBasicCall || node instanceof SqlNodeList)
                node.accept(this) ;
        }
        System.out.println(call.toString());
        return call.toString() ;
    }
}
