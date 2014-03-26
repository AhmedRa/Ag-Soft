package com.ag.clinic.DB;

import java.sql.Connection;

public class DB {
    
    public Connection getMySqlConn(){ 
        
        return new connections.DBConnection().getMysqlDriver("localhost", "clinic?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", "root", null) ;
      

    }
}
