package dao;

import model.ContaPagar;
import model.enums.StatusConta;
import config.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ContaPagarDAO {

    public void salvar(ContaPagar conta){
        String sql = "INSERT INTO CONTAS_PAGAR (descricao, vencimento, valor, status) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = ConexaoBD.conectar();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, conta.getDescricao());
            stmt.setString(2, conta.getVencimento());
            stmt.setDouble(3, conta.getValor());
            stmt.setString(4, conta.getStatus().name());
            stmt.execute();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar conta a pagar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        public List<ContaPagar> listarTodos(){
            
            String sql = "SELECT * FROM CONTAS_PAGAR";
            
            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            List<ContaPagar> contasPagar = new ArrayList<>();
            
            try{
                conn = ConexaoBD.conectar();
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while(rs.next()){
                    ContaPagar c = new ContaPagar();
                    c.setIdConta(rs.getInt("id_conta"));
                    c.setDescricao(rs.getString("descricao"));
                    c.setVencimento(rs.getString("vencimento"));
                    c.setValor(rs.getDouble("valor"));
                    c.setStatus(StatusConta.valueOf(rs.getString("status")));
                    contasPagar.add(c);
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao listar contas: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
        return contasPagar;  
        }
        
        public void atualizarStatus(int idConta, StatusConta novoStatus){
            
            String sql = "UPDATE CONTAS_PAGAR SET status = ? WHERE id_conta = ?";
            
            Connection conn = null;
            PreparedStatement stmt = null;
            
            try{
                conn = ConexaoBD.conectar();
                stmt = conn.prepareStatement(sql);
                
                stmt.setString(1, novoStatus.name());
                stmt.setInt(2, idConta);
                stmt.execute();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao atualizar status: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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
}  