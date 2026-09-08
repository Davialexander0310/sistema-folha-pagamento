package model;

import model.enums.StatusConta;

public class ContaPagar {
    private int idConta;
    private String descricao;
    private String vencimento;
    private double valor;
    private StatusConta status;
    
    public StatusConta getStatus(){
        return status;
    }
    
    public void setStatus(StatusConta status){
        this.status = status;
    }
    
    public int getIdConta() {
        return idConta;
    }
    
    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getVencimento() {
        return vencimento;
    }
    
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
}
