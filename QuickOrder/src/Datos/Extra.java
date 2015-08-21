/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauro
 */
public class Extra {
    
    private final Estructura es = new Estructura();
    private final Statement st;

    public Extra() throws SQLException, ClassNotFoundException {
        this.st = es.generarSt();
    }
    
    public void restaurarSchema() throws IOException{
        Runtime r;
        Process p;
        //ProcessBuilder pb;
        r = Runtime.getRuntime(); 
        String[] cmd = {
            "C:\\Program Files\\PostgreSQL\\9.4\\bin\\pg_restore.exe",
            "--host", "localhost",
            "--port", "5433",
            "--username", "postgres",
            "--dbname", "quickorderDB",
            "--password","1234",
            "--verbose",
            "C:\\quickorderDB.backup"
        };
        p = r.exec(cmd);
    }
    
    public void cargarDatosDePrueba() throws IOException, SQLException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("c:\\datosPrueba.sql"), "UTF-8"))){
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null){
                if(line.startsWith("INSERT") || line.startsWith("TRUNCATE")){
                    sb.append(line);
                }
                line = br.readLine();
            }
            
            JOptionPane.showMessageDialog(null, sb.toString(), "A ver", JOptionPane.INFORMATION_MESSAGE);
            
            st.execute(sb.toString());
        }
    }
}