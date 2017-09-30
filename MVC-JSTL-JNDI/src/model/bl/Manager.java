package model.bl;


import model.to.PersonTo;

import java.util.ArrayList;

public interface Manager {
    public long registerPerson(String name) throws Exception;
    public ArrayList<PersonTo> getPersonList () throws Exception;

}
