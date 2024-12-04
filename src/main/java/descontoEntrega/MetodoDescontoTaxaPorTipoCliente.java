/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoEntrega;

import java.util.HashMap;
import java.util.Map;

import model.*;

/**
 *
 * @author maikr
 */
public class MetodoDescontoTaxaPorTipoCliente implements IMetodoDescontoTaxaEntrega{
    private Map<String,Double> descontosPorTipoCliente;
    private String tipoCliente;
    
    public MetodoDescontoTaxaPorTipoCliente(){
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 0.3);
        descontosPorTipoCliente.put("Prata", 0.2);
        descontosPorTipoCliente.put("Bronze", 0.1);
    }
    
    @Override
    public void calcularTaxaDesconto(Pedido pedido){
        if(seAplica(pedido)){
           pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por Tipo de Cliente",descontosPorTipoCliente.get(pedido.getCliente().getTipo()))); 
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        return descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
}
