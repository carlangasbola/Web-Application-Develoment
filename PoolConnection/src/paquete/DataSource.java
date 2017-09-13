package paquete;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;

public class DataSource {

    private static DataSource datasource;
    private BasicDataSource ds;

    private DataSource() throws IOException, SQLException, PropertyVetoException {
        
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // El driver
        ds.setUsername("root"); // Tu usuario
        ds.setPassword("hola"); // TU password
        ds.setUrl("jdbc:mysql://localhost/Base"); //URL de la base de datos
       
     // settings
        ds.setMinIdle(5);  // Establece el minimo de conexiones
        ds.setMaxIdle(20); // Establece el maximo de conexiones
        ds.setMaxOpenPreparedStatements(180); //precompila las consultas y evita la inyeccion

    }
 
    // Patron de diseño SINGLENTON
    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) { // Solamente existe una instacia del objeto
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

}