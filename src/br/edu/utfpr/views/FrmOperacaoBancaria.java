package br.edu.utfpr.views;

import br.edu.utfpr.cliente.Cliente;
import br.edu.utfpr.conta.Conta;
import br.edu.utfpr.operacao.Deposito;
import br.edu.utfpr.operacao.Saque;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FrmOperacaoBancaria extends JFrame{
    private JPanel pnDadosConta;
    private JPanel pnDadosCliente1;
    private JPanel pnDadosCliente2;
    private JPanel pnBotoes;
    private JPanel pnPrincipal;
    private JScrollPane spDadosOperacao;
    private JTextField tfNumeroConta;
    private JTextField tfSaldoInicial;
    private JTextField tfNomeCliente1;
    private JTextField tfValorCliente1;
    private JTextField tfNomeCliente2;
    private JTextField tfValorCliente2;
    private JButton btRealizarOperacao;
    private JRadioButton rbSaqueCliente1;
    private JRadioButton rbDepositoCliente1;
    private JRadioButton rbSaqueCliente2;
    private JRadioButton rbDepositoCliente2;
    private JLabel lbNumeroConta;
    private JLabel lbSaldoInicial;
    private JLabel lbNomeCliente1;
    private JLabel lbValorCliente1;
    private JLabel lbNomeCliente2;
    private JLabel lbValorCliente2;
    private JTextArea taOperacao;
    private TitledBorder tbDadosConta;
    private TitledBorder tbDadosCliente1;
    private TitledBorder tbDadosCliente2;
    private ButtonGroup bgDepositoSaqueCliente1;
    private ButtonGroup bgDepositoSaqueCliente2;
    
    public FrmOperacaoBancaria (){
        pnDadosConta = new JPanel(new GridLayout(4,1));
        pnDadosCliente1 = new JPanel(new GridLayout(6,1));
        pnDadosCliente2 = new JPanel(new GridLayout(6,1));
        pnBotoes = new JPanel(new GridLayout(1,1));       
        pnPrincipal = new JPanel(new GridLayout(3,1));
        tfNumeroConta  = new JTextField();
        tfSaldoInicial = new JTextField();
        tfNomeCliente1 = new JTextField();
        tfValorCliente1 = new JTextField();
        tfNomeCliente2 = new JTextField();
        tfValorCliente2 = new JTextField();
        btRealizarOperacao = new JButton("Realizar operação");
        rbSaqueCliente1 = new JRadioButton("Saque");
        rbDepositoCliente1 = new JRadioButton("Depósito");
        rbSaqueCliente2 = new JRadioButton("Saque");             
        rbDepositoCliente2 = new JRadioButton("Depósito");
        lbNumeroConta = new JLabel("Número da conta");
        lbSaldoInicial = new JLabel("Saldo inicial");
        lbNomeCliente1 = new JLabel("Nome");
        lbValorCliente1 = new JLabel("Valor");
        lbNomeCliente2 = new JLabel("Nome");
        lbValorCliente2 = new JLabel("Valor");
        taOperacao = new JTextArea();
        spDadosOperacao = new JScrollPane(taOperacao);
        tbDadosConta = BorderFactory.createTitledBorder("Dados da conta");
        tbDadosConta.setTitleJustification(TitledBorder.CENTER);
        tbDadosCliente1 = BorderFactory.createTitledBorder("Dados do cliente 1");
        tbDadosCliente1.setTitleJustification(TitledBorder.CENTER);
        tbDadosCliente2 = BorderFactory.createTitledBorder("Dados do cliente 2");
        tbDadosCliente2.setTitleJustification(TitledBorder.CENTER);
        bgDepositoSaqueCliente1 = new ButtonGroup();
        bgDepositoSaqueCliente2 = new ButtonGroup();
        
        pnDadosConta.setBorder(tbDadosConta);
        pnDadosConta.add(lbNumeroConta);
        pnDadosConta.add(tfNumeroConta);
        pnDadosConta.add(lbSaldoInicial);
        pnDadosConta.add(tfSaldoInicial);
        
        bgDepositoSaqueCliente1.add(rbSaqueCliente1);
        bgDepositoSaqueCliente1.add(rbDepositoCliente1);
        pnDadosCliente1.setBorder(tbDadosCliente1);
        pnDadosCliente1.add(lbNomeCliente1);
        pnDadosCliente1.add(tfNomeCliente1);
        pnDadosCliente1.add(lbValorCliente1);
        pnDadosCliente1.add(tfValorCliente1);
        pnDadosCliente1.add(rbSaqueCliente1);
        pnDadosCliente1.add(rbDepositoCliente1);
        rbSaqueCliente1.setSelected(true);
        
        bgDepositoSaqueCliente2.add(rbSaqueCliente2);
        bgDepositoSaqueCliente2.add(rbDepositoCliente2);
        pnDadosCliente2.setBorder(tbDadosCliente2);
        pnDadosCliente2.add(lbNomeCliente2);
        pnDadosCliente2.add(tfNomeCliente2);
        pnDadosCliente2.add(lbValorCliente2);
        pnDadosCliente2.add(tfValorCliente2);       
        pnDadosCliente2.add(rbSaqueCliente2);
        pnDadosCliente2.add(rbDepositoCliente2);  
        rbSaqueCliente2.setSelected(true);       
        
        pnBotoes.add(btRealizarOperacao);
        
        pnPrincipal.add(pnDadosConta);
        pnPrincipal.add(pnDadosCliente1);
        pnPrincipal.add(pnDadosCliente2);
        this.add(pnPrincipal, BorderLayout.NORTH);  
        this.add(spDadosOperacao, BorderLayout.CENTER);
        this.add(pnBotoes, BorderLayout.SOUTH);
        
        btRealizarOperacao.addActionListener((e) -> {
            Thread threadCliente1;
            Thread threadCliente2;
            Cliente cliente1 = new Cliente(tfNomeCliente1.getText(), tfNumeroConta.getText());
            Cliente cliente2 = new Cliente(tfNomeCliente2.getText(), tfNumeroConta.getText());
            Conta conta = new Conta(tfNumeroConta.getText(), Double.parseDouble(tfSaldoInicial.getText()));
            if (rbSaqueCliente1.isSelected()){
                Saque saqueCliente1 = new Saque(cliente1, conta, Double.parseDouble(tfValorCliente1.getText()), taOperacao, tfSaldoInicial);
                threadCliente1 = new Thread(saqueCliente1);
            }else{
                Deposito depositoCliente1 = new Deposito(cliente1, conta, Double.parseDouble(tfValorCliente1.getText()), taOperacao, tfSaldoInicial);
                threadCliente1 = new Thread(depositoCliente1);
            };           

            if (rbSaqueCliente2.isSelected()){
                Saque saqueCliente2 = new Saque(cliente2, conta, Double.parseDouble(tfValorCliente2.getText()), taOperacao, tfSaldoInicial);
                threadCliente2 = new Thread(saqueCliente2);
            }else{
                Deposito depositoCliente2 = new Deposito(cliente2, conta, Double.parseDouble(tfValorCliente2.getText()), taOperacao, tfSaldoInicial);
                threadCliente2 = new Thread(depositoCliente2);
            };
            threadCliente1.start();
            threadCliente2.start();
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 720); 
        this.setTitle("Operação bancária - saque ou depósito");
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FrmOperacaoBancaria();
    }
}
