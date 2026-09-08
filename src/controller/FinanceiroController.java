package controller;

import model.ContaPagar;
import dao.ContaPagarDAO;
import java.util.List;
import model.enums.StatusConta;

public class FinanceiroController {
    
    private ContaPagarDAO contaPagarDAO = new ContaPagarDAO();
    
    public List<ContaPagar> listarTodos(){
        return contaPagarDAO.listarTodos();
    }
    
    public void atualizarStatus(int idConta, StatusConta novoStatus) {
    contaPagarDAO.atualizarStatus(idConta, novoStatus);
    }
    
}