/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;
//biblioteca pro XML
import java.io.FileWriter;

/**
 *
 * @author maikr
 */
public class XMLLog implements ILog {
    @Override
    public void escrever(String mensagem) {
        
        try (FileWriter writer = new FileWriter("logPedido.xml", true)) {
            //padrão de xml do stackoverflow
            
            writer.write("<logEntry>\n");
            writer.write("  <mensagem>" + mensagem + "</mensagem>\n");
            writer.write("</logEntry>\n");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
