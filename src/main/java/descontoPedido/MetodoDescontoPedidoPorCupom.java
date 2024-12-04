/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoPedido;

import java.util.HashMap;
import java.util.Map;
import model.CupomDescontoPedido;
import model.Pedido;

/**
 *
 * @author maikr
 */
public class MetodoDescontoPedidoPorCupom implements IMetodoDescontoPedido{
    
    private final Map<String, Double> codigosDeDesconto;
    private String codigoDeCupom;
    
    public MetodoDescontoPedidoPorCupom() {
        this.codigosDeDesconto = new HashMap<>();
        this.codigosDeDesconto.put("DESC10", 0.10); // 10%
        this.codigosDeDesconto.put("DESC20", 0.20); // 20%
        this.codigosDeDesconto.put("DESC30", 0.30); // 30%
    }

    @Override
    public void calcularDescontoPedido(Pedido pedido) {
        if(seAplica(pedido)){
            codigoDeCupom = pedido.getCodigoDeCupom();
            if (codigoDeCupom != null && codigosDeDesconto.containsKey(codigoDeCupom)) {
                pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido por Código de cupom",codigosDeDesconto.get(codigoDeCupom)));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        for (CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()) {
            if (cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido por tipo de item")) return false;
        }
        return true;
    }
    
    
}
