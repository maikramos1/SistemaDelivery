/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descontoPedido;

import java.util.ArrayList;
import java.util.List;
import model.Pedido;

/**
 *
 * @author maikr
 */
public class CalculadoraDescontoPedidoService {
   private List<IMetodoDescontoPedido> metodosDesconto;
   
   public CalculadoraDescontoPedidoService(){
       metodosDesconto = new ArrayList<>();
       metodosDesconto.add(new MetodoDescontoPedidoPorTipoCliente());
       metodosDesconto.add(new MetodoDescontoPedidoPorCupom());
       metodosDesconto.add(new MetodoDescontoPedidoTipoItem());
   }
   
   public void calcularDescontoPedido(Pedido pedido){
       for (IMetodoDescontoPedido metodos : metodosDesconto){
           metodos.calcularDescontoPedido(pedido);
       }
   }
   
   public void addMetodoDescontoPedido(IMetodoDescontoPedido novoMetodo){
       metodosDesconto.add(novoMetodo);
   }
}
