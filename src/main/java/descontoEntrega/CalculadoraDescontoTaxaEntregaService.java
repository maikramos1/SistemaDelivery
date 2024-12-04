/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoEntrega;

import java.util.ArrayList;
import java.util.List;
import model.Pedido;

/**
 *
 * @author maikr
 */
public class CalculadoraDescontoTaxaEntregaService {
    private List<IMetodoDescontoTaxaEntrega> metodosDesconto;
   
    public CalculadoraDescontoTaxaEntregaService(){
        metodosDesconto = new ArrayList<>();
        metodosDesconto.add(new MetodoDescontoTaxaPorBairro());
        metodosDesconto.add(new MetodoDescontoTaxaPorTipoCliente());
        metodosDesconto.add(new MetodoDescontoTaxaTipoItem());
        metodosDesconto.add(new MetodoDescontoTaxaValorPedido(2000));
   }
   
    public void calcularDescontoTaxa(Pedido pedido){
        for (IMetodoDescontoTaxaEntrega metodos : metodosDesconto){
            metodos.calcularTaxaDesconto(pedido);
        }
   }
   
   public void addMetodoDescontoTaxa(IMetodoDescontoTaxaEntrega novoMetodo){
       metodosDesconto.add(novoMetodo);
   }
}
