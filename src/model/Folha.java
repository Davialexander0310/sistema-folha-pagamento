package model;

public class Folha {

            private int idFolha;
            private Funcionario funcionario;
            private double salarioBase;
            private double proventos;
            private double descontos;
            private double salarioLiquido;
            private String mesReferencia;

    public int getIdFolha() {
        return idFolha;
    }

    public void setIdFolha(int idFolha) {
        this.idFolha = idFolha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getProventos() {
        return proventos;
    }

    public void setProventos(double proventos) {
        this.proventos = proventos;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }          
}
