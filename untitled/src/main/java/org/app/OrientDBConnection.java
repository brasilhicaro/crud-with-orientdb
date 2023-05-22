package org.app;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;

public class OrientDBConnection {
    private final OrientDB orientDB;
    private final ODatabaseSession db;

    public OrientDBConnection() {
        orientDB = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        db = orientDB.open("orientdb", "bd2", "bd2");
    }

    public ODatabaseSession getDb() {
        return db;
    }

    public void close() {
        db.close();
        orientDB.close();
    }
}