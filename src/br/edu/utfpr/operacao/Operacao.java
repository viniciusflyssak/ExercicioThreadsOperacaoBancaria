package br.edu.utfpr.operacao;

import br.edu.utfpr.cliente.Cliente;
import br.edu.utfpr.conta.Conta;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Operacao implements Runnable{
    private Cliente cliente;
    private Conta conta;
    private double valor;
    private JTextArea taOperacao;
    private JTextField tfSaldo;

    public Operacao(Cliente cliente, Conta conta, double valor, JTextArea taOperacao, JTextField tfSaldo) {
        this.cliente = cliente;
        this.conta = conta;
        this.valor = valor;
        this.taOperacao = taOperacao;
        this.tfSaldo = tfSaldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }    

    
    public JTextArea getTaOperacao() {
        return taOperacao;
    }

    public void setTaOperacao(JTextArea taOperacao) {
        this.taOperacao = taOperacao;
    }    
    
    public JTextField getTfSaldo() {
        return tfSaldo;
    }

    public void setTfSaldo(JTextField tfSaldo) {
        this.tfSaldo = tfSaldo;
    }

    @Override
    public void run() {      
    }
}
