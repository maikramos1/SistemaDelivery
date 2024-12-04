/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import log.*;
import model.Pedido;
import util.UsuarioLogadoService;

/**
 *
 * @author maikr
 */
public class EstruturaLogService {
    //Estrutura da mensagem a ser gravada
    //Cada linha ou registro do log deve conter as seguintes informações:
    private String nomeUsuario = UsuarioLogadoService.getNomeUsuario();
    private LocalDateTime dataComHora = LocalDateTime.now();
    private String data = dataComHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String hora = dataComHora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    private int codigo_pedido;
    private String nomeMetodo = "(calcularValorTotal)";
    private String nomeCliente;

    
    public EstruturaLogService(Pedido pedido, int codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
        nomeCliente = pedido.getCliente().getNome();
    }
    
    @Override
    public String toString(){
        return "NOME_USUARIO: " + nomeUsuario + " "
                + "Data (DD/MM/YYYY): " + data + " "
                + "Hora (HH:MM:SS): " + hora + " "
                + "codigo_pedido: " + codigo_pedido + " "
                + "Nome de Operação: Calculo do valor total do pedido " + nomeMetodo + " "
                + "Nome_Cliente: " + nomeCliente;
    }
    
}
