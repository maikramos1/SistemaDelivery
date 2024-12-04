/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package descontoPedido;

import model.Pedido;

/**
 *
 * @author maikr
 */
public interface IMetodoDescontoPedido {
    public void calcularDescontoPedido(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
