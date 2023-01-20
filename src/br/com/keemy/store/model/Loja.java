package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;

public class Loja {

    private static Loja instance;

    private BigDecimal caixa = Global.caixaInicial;

    private Loja(){

    }

    public static synchronized Loja getInstance(){
        if (instance == null)
            instance = new Loja();
        return instance;
    }

    public BigDecimal getCaixa() {
        return caixa;
    }

    public void setCaixa(BigDecimal caixa) {
        this.caixa = caixa;
    }
}
