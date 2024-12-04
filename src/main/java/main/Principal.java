/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import descontoEntrega.*;
import descontoPedido.*;
import log.*;
import model.*;
import java.time.LocalDate;
import service.*;

/**
 *
 * @author maikr
 */
public class Principal {
    public static void main(String[] args){
        Cliente cliente1 = new Cliente("MaikLindo", "Ouro", 10, "Rua TalTalTal", "Cidade Maravilhosa", "Alegre");
        Pedido pedido1 = new Pedido(10.0,LocalDate.now(), cliente1);
        Item item1 = new Item("Arroz", 2, 10.0, "Alimentação");
        Item item2 = new Item("Caneta", 3, 3.0, "Educação");
        
        pedido1.adicionarItem(item1);
        pedido1.adicionarItem(item2);
        
        CalculadoraDescontoTaxaEntregaService calculadora = new CalculadoraDescontoTaxaEntregaService();
        calculadora.calcularDescontoTaxa(pedido1);
        
        CalculadoraDescontoPedidoService calculadora2 = new CalculadoraDescontoPedidoService();
        calculadora2.calcularDescontoPedido(pedido1);
        
        System.out.println(pedido1.getValorPedido());
        //pedido1.setCodigoDeCupom("DESC10");
        //pedido1.setCodigoDeCupom("DESC20");
        //pedido1.setCodigoDeCupom("DESC30");
        System.out.println(pedido1.toString());
        /*
        System.out.println(pedido1.getTaxaEntrega());
        System.out.println(pedido1.getDescontoConcedidoEntrega());
        System.out.println(pedido1.getDescontoConcedidoPedido());
        */
        
        System.out.println(pedido1.calcularValorTotal());
        LogValorTotalPedidoService log = new LogValorTotalPedidoService();
        //pelo DB
        log.registra(pedido1,new DBLog());
        //pelo JSON
        log.registra(pedido1,new JSONLog());
        //pelo XML
        log.registra(pedido1,new XMLLog());
        
        System.out.println("Valor total do pedido: " + pedido1.calcularValorTotal());
    }
}
