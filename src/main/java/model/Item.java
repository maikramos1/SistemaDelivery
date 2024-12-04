/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author maikr
 */
public class Item {
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private String tipo;
    
    public Item(String nome, int quantidade, double valorUnitario, String tipo){
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }
    
    public double getValorTotal(){
        double aux;
        aux = valorUnitario * quantidade;
        return aux;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    @Override
    public String toString(){
        return nome + " x " + quantidade + " uni a R$ " +  valorUnitario + " -> " + tipo;
    }
}
