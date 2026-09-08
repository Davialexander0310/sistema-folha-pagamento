package dao;

import config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.Funcionario;
import javax.swing.JOptionPane;
import model.Folha;

public class FolhaDAO {
    public void salvar(Folha folha){
        
        String sql = "INSERT INTO FOLHAS (id_funcionario, salario_base, proventos, descontos, salario_liquido, mes_referencia) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = ConexaoBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, folha.getFuncionario().getIdFuncionario());
            stmt.setDouble(2, folha.getSalarioBase());
            stmt.setDouble(3, folha.getProventos());
            stmt.setDouble(4, folha.getDescontos());
            stmt.setDouble(5, folha.getSalarioLiquido());
            stmt.setString(6, folha.getMesReferencia());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Folha gerada com sucesso!");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar no banco: "+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
    
    public List<Folha> listarTodos(){
        
        String sql = "SELECT f.id_folha, f.salario_base, f.proventos, f.descontos, f.salario_liquido, f.mes_referencia, " + "fu.id_funcionario, fu.nome_funcionario, fu.cargo_funcionario, fu.salario_bruto " + "FROM FOLHAS f " + "JOIN FUNCIONARIOS fu ON f.id_funcionario = fu.id_funcionario";
    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Folha> folhas = new ArrayList<>();
        
        try{
            conn = ConexaoBD.conectar();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            funcionario.setNomeFuncionario(rs.getString("nome_funcionario"));
            funcionario.setCargoFuncionario(rs.getString("cargo_funcionario"));
            funcionario.setSalarioBruto(rs.getDouble("salario_bruto"));
            
            Folha folha = new Folha();
            folha.setFuncionario(funcionario);
            folha.setSalarioBase(rs.getDouble("salario_base"));
            folha.setProventos(rs.getDouble("proventos"));
            folha.setDescontos(rs.getDouble("descontos"));
            folha.setSalarioLiquido(rs.getDouble("salario_liquido"));
            folha.setMesReferencia(rs.getString("mes_referencia"));
            
            folhas.add(folha);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao listar folhas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        finally {
                try {
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (conn != null) conn.close();
                } 
                catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
         }
        return folhas;
    }
}
