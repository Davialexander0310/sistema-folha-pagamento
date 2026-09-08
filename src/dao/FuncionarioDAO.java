package dao;

import config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

public class FuncionarioDAO {
    
    public void cadastrar(Funcionario funcionario){
        
        String sql = "INSERT INTO FUNCIONARIOS (nome_funcionario, cargo_funcionario, salario_bruto) VALUES (?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement stmt =  null;
        
        try{
            conn =  ConexaoBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCargoFuncionario());
            stmt.setDouble(3, funcionario.getSalarioBruto());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar no banco: "+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
    
    public List<Funcionario> listarTodos(){
        
        String sql = "SELECT * FROM FUNCIONARIOS";
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Funcionario> funcionarios = new ArrayList<>();
        try{
            conn = ConexaoBD.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setIdFuncionario(rs.getInt("id_funcionario"));
                f.setNomeFuncionario(rs.getString("nome_funcionario"));
                f.setCargoFuncionario(rs.getString("cargo_funcionario"));
                f.setSalarioBruto(rs.getDouble("salario_bruto"));
                funcionarios.add(f);
            }
        }
        catch(SQLException e){
              JOptionPane.showMessageDialog(null, "Erro ao listar funcionários: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);      
        }
    return funcionarios;
    }
}