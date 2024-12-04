/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package descontoEntrega;

import model.Pedido;

/**
 *
 * @author maikr
 */
public interface IMetodoDescontoTaxaEntrega {
    public void calcularTaxaDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
