package controller;

import model.Folha;
import model.Funcionario;
import dao.FolhaDAO;
import java.util.List;
import service.FolhaService;
import service.FinanceiroService;

public class FolhaController {
    
    private FolhaService folhaService = new FolhaService();
    private FolhaDAO folhaDao = new FolhaDAO();
    private FinanceiroService financeiroService = new FinanceiroService();
    
    public Folha gerarFolha(Funcionario funcionario, double proventos, String mesReferencia){
        Folha folha = folhaService.calcular(funcionario, proventos, mesReferencia);      
        folhaDao.salvar(folha);
        financeiroService.gerarLancamentoCAP(folha);
        return folha;
    }
    
    public List<Folha> listarTodos(){
        return folhaDao.listarTodos();
    }
}
