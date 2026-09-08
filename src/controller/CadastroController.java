package controller;

import model.Funcionario;
import dao.FuncionarioDAO;
import java.util.List;

public class CadastroController {
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public void cadastrar(Funcionario funcionario){
        funcionarioDAO.cadastrar(funcionario);
    }
    
    public List<Funcionario> listarTodos(){
        return funcionarioDAO.listarTodos();
    }
}
