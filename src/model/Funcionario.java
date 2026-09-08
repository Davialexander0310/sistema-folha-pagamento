package model;

public class Funcionario {
    
    private int idFuncionario;
    private String nomeFuncionario;
    private String cargoFuncionario;
    private double salarioBruto;
    
    public Funcionario(){    
    }
    
    public int getIdFuncionario(){
        return idFuncionario;
    }
    
    public void setIdFuncionario(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    
    public void setNomeFuncionario(String nomeFuncionario){
        this.nomeFuncionario = nomeFuncionario;
    }
    
    public String getCargoFuncionario(){
        return cargoFuncionario;
    }
    
    public void setCargoFuncionario(String cargoFuncionario){
        this.cargoFuncionario = cargoFuncionario;
    }
    
    public double getSalarioBruto(){
        return salarioBruto;
    }
    
    public void setSalarioBruto(double salarioBruto){
        this.salarioBruto = salarioBruto;
    }
    
    @Override
    public String toString(){
        return nomeFuncionario;
    }
}