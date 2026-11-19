CREATE DATABASE PAGAMENTO;
USE PAGAMENTO;

CREATE TABLE FUNCIONARIOS(
	id_funcionario INTEGER AUTO_INCREMENT NOT NULL,
	nome_funcionario VARCHAR(50) NOT NULL,
	cargo_funcionario VARCHAR(20) NOT NULL,
	salario_bruto DECIMAL(8,2) NOT NULL,
	PRIMARY KEY (id_funcionario)
);

CREATE TABLE FOLHAS( 
id_folha INTEGER AUTO_INCREMENT PRIMARY KEY, 
id_funcionario INT NOT NULL, 
salario_base DECIMAL(8,2) NOT NULL, 
proventos DECIMAL(8,2) NOT NULL, 
descontos DECIMAL(8,2) NOT NULL, 
salario_liquido DECIMAL(8,2) NOT NULL, 
mes_referencia VARCHAR(20) NOT NULL, 
FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIOS(id_funcionario) 
); 

CREATE TABLE CONTAS_PAGAR(
id_conta INT AUTO_INCREMENT PRIMARY KEY,
descricao VARCHAR(100) NOT NULL,
vencimento VARCHAR(20),
valor DECIMAL(8,2) NOT NULL,
status VARCHAR(20) NOT NULL 
); 
