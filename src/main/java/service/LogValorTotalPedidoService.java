/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import log.*;
import model.Pedido;

/**
 *
 * @author maikr
 */

public class LogValorTotalPedidoService {
    private static int LOGS_FEITOS = 0;
    
    public void registra(Pedido pedido, ILog log){
        if (pedido == null) throw new IllegalArgumentException("Pedido inválido");
        if (log == null) throw new IllegalArgumentException("Log inválido");
        
        EstruturaLogService info = new EstruturaLogService(pedido, LOGS_FEITOS);
        info.toString();
        
        log.escrever(info.toString());
        
        LOGS_FEITOS++;
    }
}
