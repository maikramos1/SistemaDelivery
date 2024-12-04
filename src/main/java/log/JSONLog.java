/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

//biblioteca pro json
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author maikr
 */
public class JSONLog implements ILog {

    @Override
    public void escrever(String mensagem) {
        try (FileWriter file = new FileWriter("logPedido.json", true)) {
            // Escreve a mensagem no arquivo, adicionando uma quebra de linha para cada nova mensagem
            file.write(mensagem + "\n");
            //System.out.println("Mensagem registrada no JSON." + mensagem);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
