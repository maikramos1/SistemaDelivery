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
public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega{
    private String bairroCliente;
    
    @Override
    public void calcularTaxaDesconto(Pedido pedido){
        if(seAplica(pedido)){
            if(pedido.getCliente().getBairro().equals("Centro")) pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por Bairro", 0.2));
            if(pedido.getCliente().getBairro().equals("Bela Vista")) pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por Bairro", 0.3));
            if(pedido.getCliente().getBairro().equals("Cidade Maravilhosa")) pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por Bairro", 0.15));
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        return pedido.getCliente().getBairro().equals("Centro") || pedido.getCliente().getBairro().equals("Bela Vista")|| pedido.getCliente().getBairro().equals("Cidade Maravilhosa");
    }
}
