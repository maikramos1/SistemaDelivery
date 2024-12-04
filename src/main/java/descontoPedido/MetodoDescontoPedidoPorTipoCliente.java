/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoPedido;

import java.util.HashMap;
import java.util.Map;

import model.*;

/**
 *
 * @author maikr
 */
public class MetodoDescontoPedidoPorTipoCliente implements IMetodoDescontoPedido{
    private Map<String,Double> descontosPorTipoCliente;
    private String tipoCliente;
    
    public MetodoDescontoPedidoPorTipoCliente(){
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 0.3);
        descontosPorTipoCliente.put("Prata", 0.2);
        descontosPorTipoCliente.put("Bronze", 0.1);
    }
    
    @Override
    public void calcularDescontoPedido(Pedido pedido){
        if(seAplica(pedido)){
           pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido por Tipo de Cliente",descontosPorTipoCliente.get(pedido.getCliente().getTipo()))); 
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        tipoCliente = pedido.getCliente().getTipo();
        if(tipoCliente.equals("Ouro") || tipoCliente.equals("Prata") || tipoCliente.equals("Bronze")){
            for (CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()) {
                if (cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido por tipo de item")) return false;
            }
            return true;
        }
        return false;
    }
}
