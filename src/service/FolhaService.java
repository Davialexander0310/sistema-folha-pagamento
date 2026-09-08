package service;

import model.Folha;
import model.Funcionario;

public class FolhaService {
    
    public Folha calcular(Funcionario funcionario, double proventos, String mesReferencia) {
        
        double salarioBruto = funcionario.getSalarioBruto();
        double inss = calcularINSS(salarioBruto);
        double baseIRRF = salarioBruto - inss;
        double irrf = calcularIRRF(baseIRRF);
        double descontos = inss + irrf;
        double salarioliquido = salarioBruto + proventos - descontos;
        
        Folha folha = new Folha();
        folha.setFuncionario(funcionario);
        folha.setSalarioBase(funcionario.getSalarioBruto());
        folha.setProventos(proventos);
        folha.setDescontos(descontos);
        folha.setMesReferencia(mesReferencia);
        folha.setSalarioLiquido(salarioliquido);
        
        return folha;
    }
    
    private double calcularINSS(double salarioBase){
        if(salarioBase<=1412.00){
            return salarioBase * 0.075; 
        }
        else if(salarioBase<=2666.68){
            return salarioBase * 0.09;
        }
        else if(salarioBase<=4000.03){
            return salarioBase * 0.12;
        }
        else{
            return salarioBase * 0.14;
        }
    }
    
    private double calcularIRRF(double baseDeCalculo){
        if (baseDeCalculo<=2259.20){
            return 0;
        }
        else if(baseDeCalculo<=2826.65){
            return (baseDeCalculo * 0.075) - 169.44;
        }
        else if(baseDeCalculo<=3751.05){
            return (baseDeCalculo * 0.15) - 381.44;
        }
        else if(baseDeCalculo<=4664.68){
            return (baseDeCalculo * 0.225) - 662.77;
        }
        else{
            return (baseDeCalculo * 0.275) - 896.00;
        }
    }
    
}
