/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package aksdfpak;

 /**
  *
  * @author david
  */
 public class UPX2 {
 
     public static void main(String[] args) {
         DatabaseConnection upx = new DatabaseConnection();
         DatabaseConnection.getConnection();
         
         ProfissionalDAO as = new ProfissionalDAO();
         
         System.out.println(as.buscar());
         
     }
 }
 