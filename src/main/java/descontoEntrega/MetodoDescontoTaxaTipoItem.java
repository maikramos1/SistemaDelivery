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
public class MetodoDescontoTaxaTipoItem implements IMetodoDescontoTaxaEntrega{
    private Map<String,Double> descontoPorTipoItem;
    
    public MetodoDescontoTaxaTipoItem(){
        descontoPorTipoItem = new HashMap<>();
        descontoPorTipoItem.put("Alimentação",0.05);
        descontoPorTipoItem.put("Educação",0.2);
        descontoPorTipoItem.put("Lazer",0.15);
    }
    
    @Override
    public void calcularTaxaDesconto(Pedido pedido){
        if(seAplica(pedido)){
            double soma = 0.0;
            for (Item item : pedido.getItens()) {
                if(descontoPorTipoItem.containsKey(item.getTipo())){
                    soma += descontoPorTipoItem.get(item.getTipo());
                    descontoPorTipoItem.remove(item.getTipo());
                }
            }
            pedido.aplicarDescontoEntrega(new CupomDescontoEntrega("Desconto na entrega por Tipo de Item",soma));
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido){
        for (Item item: pedido.getItens()){
            if(descontoPorTipoItem.containsKey(item.getTipo())) return true;
        }
        return false;
    }
}
