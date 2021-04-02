import org.apache.calcite.avatica.util.Quoting;
import org.apache.calcite.config.Lex;
import org.apache.calcite.rel.RelRoot;
import org.apache.calcite.sql.*;
import org.apache.calcite.sql.parser.SqlParser;
import org.apache.calcite.sql.parser.ddl.SqlDdlParserImpl;
import org.apache.calcite.sql.util.SqlBasicVisitor;
import org.apache.calcite.sql.util.SqlString;
import org.apache.calcite.sql.validate.SqlConformanceEnum;
import org.apache.calcite.tools.FrameworkConfig;
import org.apache.calcite.tools.Frameworks;
import org.apache.calcite.tools.Planner;

import java.sql.DatabaseMetaData;

public class CalciteMain {

    public static void main(String[] args) {
        try {
//           // String query1 = "select e.first_name as FirstName e.salary as Salary from from table2,employee e";
//           // String query = "select e.first_name AS FirstName, e.salary AS Salary in table2 from employee e";
//            String q2 = "Select * into SQLShackDemo.HumanResources.Department from AdventureWorks2018.HumanResources.Department" ;
////            Frameworks.ConfigBuilder configBuilder = Frameworks.newConfigBuilder();
////            //configBuilder.defaultSchema(`my SchemaPlus here`);
////            FrameworkConfig frameworkConfig = configBuilder.build();
////            Planner planner = Frameworks.getPlanner(frameworkConfig);
////
////            SqlNode sqlNode = planner.parse(query);
////            planner.validate(sqlNode);
////            RelRoot relRoot = planner.rel(sqlNode);
////            String query = "select e.first_name AS FirstName, e.salary AS Salary into table2 from employee e";
//           // SqlDialect dialect = SqlDialect.DatabaseProduct.SQL.getDialect();
//            //SqlParser.ConfigBuilder;
//            SqlParser.Config config = SqlParser.configBuilder().setLex(Lex.SQL_SERVER).setConformance(SqlConformanceEnum.SQL_SERVER_2008).setParserFactory(SqlDdlParserImpl.FACTORY).setCaseSensitive(false).build() ;
//           // SqlParser.ConfigBuilder configBuilder =  SqlParser.configBuilder().setConfig()     ;
//            SqlParser parser = SqlParser.create(q2,config);
//            SqlNode node = parser.parseQuery();
//            node.getKind();

//            String q2 = "fns" +
//                    "join (" +
//                    "select f.EmployeeNumber as CallCenterEmployeeID, cast((trim(isnull(f.FirstName,'X')) || ' ' || trim(isnull(f.LastName,'X'))) as varchar(50)) as EmployeeName " +
//                    "from p.pii_Fact_SalesForce_User f " +
//                    "join (" +
//                    " select f.EmployeeNumber, f.LastModifiedDate, max(CreatedDate) as MaxCreatedDate " +
//                    " from p.pii_Fact_SalesForce_User f " +
//                    " join (" +
//                    " select EmployeeNumber, max(LastModifiedDate) as MaxLastModifiedDate" +
//                    " from p.pii_Fact_SalesForce_User " +
//                    " where EmployeeNumber is not null " +
//                    "  group by EmployeeNumber " +
//                    " ) x on f.EmployeeNumber = x.EmployeeNumber and f.LastModifiedDate = x.MaxLastModifiedDate " +
//                    " group by f.EmployeeNumber, f.LastModifiedDate " +
//                    " ) y on f.EmployeeNumber = y.EmployeeNumber and f.LastModifiedDate = y.LastModifiedDate and f.CreatedDate = y.MaxCreatedDate " +
//                    ") cce on fns.CallCenterEmployeeID = cce.CallCenterEmployeeID " +
//                    "left join p.Dim_Promotion promo on (case when fns.InternalPromotionID = 26177 then fns.PromotionID else fns.InternalPromotionID end) = promo.PromotionID " +
//                    "left join p.Dim_Product dp on fns.ProductID = dp.ProductID " +
//                    "left join p.Dim_ProductDNAReporting dna on dp.SKU = dna.SKU " +
//                    "left join p.Dim_ProductCategory dpc on dp.ProductCategoryID = dpc.ProductCategoryID " +
//                    "left join p.Dim_ProgramIn prog on fns.ProgramInID = prog.ProgramInID " +
//                    "where fns.DWUpdateDate >= ? " +
//                    "and fns.CallCenterEmployeeID <> 0" ;
            //String q2 = "select CallCenterEmployeeID,InternalPromotionID,PromotionID,InternalPromotionID,ProgramInID,CallCenterEmployeeID,DWUpdateDate from FT as fns inner join (select f.EmployeeNumber as CallCenterEmployeeID, cast((trim(isnull(f.FirstName,'X')) || ' ' || trim(isnull(f.LastName,'X'))) as varchar(50)) as EmployeeName from p.pii_Fact_SalesForce_User f join ( select f.EmployeeNumber, f.LastModifiedDate, max(CreatedDate) as MaxCreatedDate  from p.pii_Fact_SalesForce_User f  join ( select EmployeeNumber, max(LastModifiedDate) as MaxLastModifiedDate from p.pii_Fact_SalesForce_User  where EmployeeNumber is not null   group by EmployeeNumber  ) x on f.EmployeeNumber = x.EmployeeNumber and f.LastModifiedDate = x.MaxLastModifiedDate  group by f.EmployeeNumber, f.LastModifiedDate  ) y on f.EmployeeNumber = y.EmployeeNumber and f.LastModifiedDate = y.LastModifiedDate and f.CreatedDate = y.MaxCreatedDate ) cce on fns.CallCenterEmployeeID = cce.CallCenterEmployeeID left join p.Dim_Promotion promo on (case when fns.InternalPromotionID = 26177 then fns.PromotionID else fns.InternalPromotionID end) = promo.PromotionID left join p.Dim_Product dp on fns.ProductID = dp.ProductID left join p.Dim_ProductDNAReporting dna on dp.SKU = dna.SKU left join p.Dim_ProductCategory dpc on dp.ProductCategoryID = dpc.ProductCategoryID left join p.Dim_ProgramIn prog on fns.ProgramInID = prog.ProgramInID where fns.DWUpdateDate >= ? and fns.CallCenterEmployeeID <> 0" ;
            String updateq = "update cs " +
                    "set `cs.OrderCreateDate` = `app.OrderCreateDate`," +
                    "`cs.XID` = `app.XID`," +
                    "`cs.IID` = `app.IID`," +
                    "`cs.GrossQuantity` = `app.GrossQuantity`," +
                    "`cs.GrossAmount` = `app.GrossAmount`," +
                    "`cs.GrossAmountUSD` = `app.GrossAmountUSD`," +
                    "`cs.CallCenterEmployeeID` = `app.CallCenterEmployeeID`," +
                    "`cs.EmployeeName` = app.EmployeeName," +
                    "`cs.SourceIDDesc` = `app.SourceIDDesc`," +
                    "`cs.ProductDesc` = `app.ProductDesc`," +
                    "`cs.DWUpdateDate` = getdate()" +
                    " from CommerceSales cs " +
                    " join tmp_CommerceSalesAppend app on `cs.OrderNumber` = `app.OrderNumber` and `cs.LineItemID` = `app.LineItemID` and `cs.SKU` = `app.SKU`" +
                    " where `cs.OrderCreateDate` <> `app.OrderCreateDate`" +
                    " or `cs.XID` <> `app.XID`" +
                    " or `cs.IID` <> `app.IID`" +
                    " or `cs.GrossQuantity` <> `app.GrossQuantity`" +
                    " or `cs.GrossAmount` <> `app.GrossAmount`" +
                    " or isnull(`cs.GrossAmountUSD`,-1) <> isnull(`app.GrossAmountUSD`,-1)" +
                    " or `cs.CallCenterEmployeeID` <> `app.CallCenterEmployeeID`" +
                    " or `cs.EmployeeName` <> `app.EmployeeName`" +
                    " or isnull(`cs.SourceIDDesc`,'') <> isnull(`app.SourceIDDesc`,'')" +
                    " or `cs.ProductDesc` <> `app.ProductDesc`" ;
            //String updateq = "update cs set `cs.OrderCreateDate` = `app.OrderCreateDate`,`cs.XID` = `app.XID`,`cs.IID` = `app.IID`,`cs.GrossQuantity` = `app.GrossQuantity`,`cs.GrossAmount` = `app.GrossAmount`,`cs.GrossAmountUSD` = `app.GrossAmountUSD`,`cs.CallCenterEmployeeID` = `app.CallCenterEmployeeID`,`cs.EmployeeName` = app.EmployeeName,`cs.SourceIDDesc` = `app.SourceIDDesc`,`cs.ProductDesc` = `app.ProductDesc`,`cs.DWUpdateDate` = '11' where from CommerceSales cs  join tmp_CommerceSalesAppend app on `cs.OrderNumber` = `app.OrderNumber` and `cs.LineItemID` = `app.LineItemID` and `cs.SKU` = `app.SKU` where `cs.OrderCreateDate` <> `app.OrderCreateDate` or `cs.XID` <> `app.XID` or `cs.IID` <> `app.IID` or `cs.GrossQuantity` <> `app.GrossQuantity` or `cs.GrossAmount` <> `app.GrossAmount` or isnull(`cs.GrossAmountUSD`,-1) <> isnull(`app.GrossAmountUSD`,-1) or `cs.CallCenterEmployeeID` <> `app.CallCenterEmployeeID` or `cs.EmployeeName` <> `app.EmployeeName` or isnull(`cs.SourceIDDesc`,'') <> isnull(`app.SourceIDDesc`,'') or `cs.ProductDesc` <> `app.ProductDesc`" ;

//            String sampleUpdateQ = "UPDATE `ONE`\n" +
//                    "    SET crawler_status_code = -1\n" +
//                    "    FROM ONE t1 JOIN\n" +
//                    "         TWO t2\n" +
//                    "         ON `t1.domain` = `t2.domain`\n" +
//                    "    WHERE `t2.id` = 88 AND `t2.level` = 0 AND code in (403, 404));" ;
            String query = "select a as aa,trunc(b) as bb,c from tt where a>10" ;
            String query1 ="UPDATE `hr.depts` SET `depts.department_name`='New Name' WHERE `depts.deptno` = 666";
            SqlString sql = new SqlString(SqlDialect.DatabaseProduct.MSSQL.getDialect(),updateq) ;
            //Quoting qq = new Quoting("")
            SqlParser.Config config = SqlParser.configBuilder().setLex(Lex.ORACLE).setConformance(SqlConformanceEnum.ORACLE_10).setParserFactory(SqlDdlParserImpl.FACTORY).setCaseSensitive(false).setQuoting(Quoting.BACK_TICK).build() ;
            Frameworks.ConfigBuilder configBuilder = Frameworks.newConfigBuilder().parserConfig(config);
            FrameworkConfig frameworkConfig = configBuilder.build();
            Planner planner = Frameworks.getPlanner(frameworkConfig);
            //SqlParser parser = SqlParser.create(sql.getSql(),config) ;

            SqlNode node = planner.parse(sql.getSql());
            node.accept(new CalcVisitor()) ;
            //String sql = node.toSqlString(SqlDialect.DatabaseProduct.MSSQL.getDialect()).getSql();
            //node.accept(new SqlBasicVisitor<String>) ;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
