/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoEntrega;

import model.*;

/**
 *
 * @author maikr
 */
public class MetodoDescontoTaxaValorPedido implements IMetodoDescontoTaxaEntrega{
    private double limiteValorPedido;
    private static double VALOR_DESCONTO = 0.15;
    
    public MetodoDescontoTaxaValorPedido(double limiteValorPedido){
        this.limiteValorPedido = limiteValorPedido;
    }
    
    @Override
    public void calcularTaxaDesconto(Pedido pedido){
        if(seAplica(pedido)){
            pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por valor do pedido",VALOR_DESCONTO)); 
        }
        
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        return pedido.getValorPedido() >= limiteValorPedido;
    }
}
