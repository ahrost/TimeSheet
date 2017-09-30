package model.bl;


import model.da.PersonDA;
import model.to.PersonTo;

import java.util.ArrayList;

public class ManagerImpl implements  Manager {
    @Override
    public long registerPerson(String name) throws Exception {
        PersonTo personTo=new PersonTo(0,name);
        PersonDA personDA=new PersonDA();
         personDA.insert(personTo);
        personDA.close();
        return  personTo.getId();
    }

    @Override
    public ArrayList<PersonTo> getPersonList() throws Exception {
       PersonDA personDA=new PersonDA();
    ArrayList<PersonTo> personTos=personDA.select();
        personDA.close();
        return personTos;


          //To change body of implemented methods use File | Settings | File Templates.
    }
}
