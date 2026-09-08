package service;

import model.Folha;
import model.ContaPagar;
import model.enums.StatusConta;
import dao.ContaPagarDAO;

public class FinanceiroService {
    
    private ContaPagarDAO contapagarDAO = new ContaPagarDAO();
    
    public void gerarLancamentoCAP(Folha folha){
        String descricao = "Salário - " + folha.getFuncionario().getNomeFuncionario() + " - " + folha.getMesReferencia();
        String vencimento = calcularVencimento(folha.getMesReferencia());
        ContaPagar conta = new ContaPagar();
        conta.setDescricao(descricao);
        conta.setValor(folha.getSalarioLiquido());
        conta.setStatus(StatusConta.PENDENTE);
        conta.setVencimento(vencimento);
        contapagarDAO.salvar(conta);
    }
    
    private String calcularVencimento(String mesReferencia) {
    String[] partes = mesReferencia.split("/");
    int mes = Integer.parseInt(partes[0]);
    int ano = Integer.parseInt(partes[1]);
    
    if (mes == 12) {
        mes = 1;
        ano = ano + 1;
    } else {
        mes = mes + 1;
    }
    
    String mesTexto;
    if (mes < 10) {
    mesTexto = "0" + mes;
    } else {
    mesTexto = "" + mes;
    }

    String data = "05" + "/" + mesTexto + "/" + ano;
    return data;
    }
}
