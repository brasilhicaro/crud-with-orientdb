package org.app;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.OElement;
import com.orientechnologies.orient.core.record.OVertex;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

    public class CRUDPerson {
    private ODatabaseSession db;

    public CRUDPerson(ODatabaseSession db) {
        this.db = db;
    }

    public void create(String name, int age) {
        OVertex person = db.newVertex("Person");
        person.setProperty("name", name);
        person.setProperty("age", age);
        person.save();
    }

    public void readAll() {
        String query = "SELECT FROM Person";
        OResultSet result = db.query(query);
        while (result.hasNext()) {
            OResult item = result.next();
            System.out.println("person: " + item.getProperty("name"));
        }
        result.close();
    }

    public OElement readById(ORID rid) {
        return db.load(rid);
    }

    public void update(ORID rid, String name, int age) {
        OVertex person = db.load(rid);
        person.setProperty("name", name);
        person.setProperty("age", age);
        person.save();
    }

    public void delete(ORID rid) {
        db.delete(rid);
    }
}