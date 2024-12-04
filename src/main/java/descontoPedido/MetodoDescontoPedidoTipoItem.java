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
public class MetodoDescontoPedidoTipoItem implements IMetodoDescontoPedido{
    private Map<String,Double> descontoPorTipoItem;
    
    public MetodoDescontoPedidoTipoItem(){
        descontoPorTipoItem = new HashMap<>();
        descontoPorTipoItem.put("Alimentação",0.05);
        descontoPorTipoItem.put("Educação",0.2);
        descontoPorTipoItem.put("Lazer",0.15);
    }
    
    @Override
    public void calcularDescontoPedido(Pedido pedido){
        if(seAplica(pedido)){
            double soma = 0.0;
            for (Item item : pedido.getItens()) {
                if(descontoPorTipoItem.containsKey(item.getTipo())){
                    soma += descontoPorTipoItem.get(item.getTipo());
                    descontoPorTipoItem.remove(item.getTipo());
                }
            }
            if(soma > 0){
                pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido por tipo de item",soma));
            }
        }
    }
    
    @Override
    public boolean seAplica(Pedido pedido){        
            for (CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()) {
                if (cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido por tipo de cliente")) return false;
                if (cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido por Código de cupom")) return false;
            }
        return true;
    }
}
