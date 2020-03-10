
package myreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Myreport{
         public   static Connection conectar(){
          Connection con = null;
          try {
            String url= "jdbc:mysql://localhost:3306/registro?user=root&password=mysqladmin";
             con= DriverManager.getConnection(url);
              if (con != null) {
                  System.out.println("Conexion Satisfacion");
              }
              
          } catch (SQLException e) {
              System.out.println(e.getMessage());
          }
          return con;
      }    
         //private void btnregistar     
        
         
         
         
         
         
        public static void main(String[] args) {
        try {
            JasperReport jr= (JasperReport)
            JRLoader.loadObject
             (Myreport.class.getResource("./registro.jasper"));
            Map parametros = new HashMap<String, Object>();
            parametros.put("MONTO",1500);
           // parametros.put("Precio2",10);
            JasperPrint jp= JasperFillManager.fillReport(jr, parametros, (conectar()));
            JasperViewer jv= new  JasperViewer(jp);
            jv.show();
        } catch (Exception e) {
            System.err.println(e);   
    }
    }
  

}


