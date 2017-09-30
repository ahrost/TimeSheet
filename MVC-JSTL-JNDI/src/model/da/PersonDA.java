package model.da;


import model.to.PersonTo;
import model.util.DataSourceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDA {
    private Connection connection;
    private PreparedStatement statement;
    public PersonDA() throws Exception
    {
        connection= DataSourceProvider.getDataSource().getConnection();
        connection.setAutoCommit(false);
    }
public void insert(PersonTo personTo) throws Exception{
    statement=connection.prepareStatement("SELECT SEQ_PERSON.NEXTVAL  NID FROM DUAL");
   ResultSet resultSet= statement.executeQuery();
    resultSet.next();
    personTo.setId(resultSet.getLong("NID"));
    statement=connection.prepareStatement("INSERT INTO PERSON (ID,NAME) VALUES(?,?)");
    statement.setLong(1,personTo.getId());
    statement.setString(2, personTo.getName());
    statement.executeUpdate();
    connection.commit();
}
    public ArrayList<PersonTo> select()throws Exception
    {
        statement=connection.prepareStatement("SELECT * FROM PERSON");
        ResultSet resultSet=statement.executeQuery();
        ArrayList<PersonTo> personTos=new ArrayList<PersonTo>() ;
        while (resultSet.next()){
            PersonTo personTo=new PersonTo(resultSet.getLong("ID"),resultSet.getString("NAME"));
            personTos.add(personTo);
        }
        connection.commit();
        return  personTos;
    }
      public void close() throws SQLException {
          statement.close();
          connection.close();
      }


}


