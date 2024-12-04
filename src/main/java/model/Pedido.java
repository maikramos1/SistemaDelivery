/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author maikr
 */
public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private String codigoDeCupom;
    private final List<Item> itens;
    private List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private List<CupomDescontoPedido> cuponsDescontoPedido;

    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente){
        if (taxaEntrega < 0 || dataPedido == null || cliente == null) {
            throw new IllegalArgumentException("Valores inválidos para criar o pedido.");
        }
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        itens = new ArrayList<>();
        cuponsDescontoEntrega = new ArrayList<>();
        cuponsDescontoPedido = new ArrayList<>();
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public double getValorPedido(){
        double soma = 0.0;
        for(Item item: itens){
            soma += item.getValorTotal();
        }
        return soma + taxaEntrega;
    }
    
    public void setCodigoDeCupom(String codigoDeCupom) {
        this.codigoDeCupom = codigoDeCupom;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Item> getItens(){
        return Collections.unmodifiableList(itens);
    }
    
    public double getTaxaEntrega(){
        return taxaEntrega;
    }
    
    public String getCodigoDeCupom() {
        return codigoDeCupom;
    }
        
    public void aplicarDescontoEntrega(CupomDescontoEntrega cupomDescontoEntrega){
        if(cupomDescontoEntrega == null) throw new IllegalArgumentException("Cupom não pode ser nulo.");
        cuponsDescontoEntrega.add(cupomDescontoEntrega);
    }
    
    public void aplicarDescontoPedido(CupomDescontoPedido cupomDescontoPedido){
        if(cupomDescontoPedido == null) throw new IllegalArgumentException("Cupom não pode ser nulo.");
        cuponsDescontoPedido.add(cupomDescontoPedido);
    }
    
    public double getDescontoConcedidoEntrega(){
        double soma = 0.0;
        for (CupomDescontoEntrega cupom : cuponsDescontoEntrega){
            soma += cupom.getValorDesconto();
        }
        return soma * taxaEntrega;
    }
    
    public double getDescontoConcedidoPedido(){
        double soma = 0.0;
        for (CupomDescontoPedido cupom : cuponsDescontoPedido){
            soma += cupom.getValorDesconto();
        }
        return soma * getValorPedido();
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return Collections.unmodifiableList(cuponsDescontoEntrega);
    }
    
    public List<CupomDescontoPedido> getCuponsDescontoPedido(){
        return Collections.unmodifiableList(cuponsDescontoPedido);
    }
    
    public double calcularValorTotal(){
        double total = 0.0;
        
        total += (getValorPedido() - getDescontoConcedidoEntrega() - getDescontoConcedidoPedido());
        
        return total;
    }
    
    @Override
    public String toString() {
        
        return "Pedido{\n" +
                "Taxa de Entrega: " + taxaEntrega +
                "\nItens: " + itens +
                "\nCliente: " + cliente +
                "\nCupons Entrega: " + cuponsDescontoEntrega +
                "\nCupons Pedido: " + cuponsDescontoPedido+ "}";
    }

}
