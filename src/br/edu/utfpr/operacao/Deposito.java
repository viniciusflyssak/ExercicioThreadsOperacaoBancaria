package br.edu.utfpr.operacao;

import br.edu.utfpr.cliente.Cliente;
import br.edu.utfpr.conta.Conta;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Deposito extends Operacao{

    public Deposito(Cliente cliente, Conta conta, double valor, JTextArea taOperacao, JTextField tfSaldo) {
        super(cliente, conta, valor, taOperacao, tfSaldo);
    }    
    
    public void depositar(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            this.getTaOperacao().append("Erro: " + ex.getMessage());
        }
        synchronized(this.getConta()){          
            this.getConta().setSaldo(this.getConta().getSaldo() + this.getValor()); 
            this.getTaOperacao().append(this.getCliente().getNome() + " depositou " + this.getValor() + " da conta " + this.getConta().getNumero() + "\n");              
            this.getTaOperacao().append("Novo saldo: " + this.getConta().getSaldo());
        }          
        this.getTaOperacao().append("\n\n");
        this.getTfSaldo().setText(String.valueOf(this.getConta().getSaldo()));
    }
    
    @Override
    public void run() {
        depositar();
    }
    
}
