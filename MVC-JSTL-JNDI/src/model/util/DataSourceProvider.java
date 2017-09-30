package model.util;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceProvider {
   private static Context context;
   private static   DataSource dataSource;
    static {
        try {
            context=new InitialContext();
            dataSource=(DataSource)context
                    .lookup("java:comp/env/jdbc/havij");
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
     public static  DataSource getDataSource() throws Exception
     {

         return dataSource;
     }
}
