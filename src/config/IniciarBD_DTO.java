package config;

import javax.swing.JOptionPane;

public class IniciarBD_DTO {
    
    public static  void carregarDriver(){
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
       } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Tentativa de conexão com o banco de dados mal sucedida", "Erro de conexão com o banco de dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}