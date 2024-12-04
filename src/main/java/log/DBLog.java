/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package log;

//bibliocas pro sql
import java.sql.*;

/**
 *
 * @author maikr
 */

//está apenas criando o db, a tabela e inserindo os dados .. mais nada
public class DBLog implements ILog {
    
    //a DATABASE_URL vai criar o db se não existir
    private static final String DATABASE_URL = "jdbc:sqlite:logPedido.db";
    private static final String CREATE_TABLE_SQL = 
            "CREATE TABLE IF NOT EXISTS logPedido (" +
            "   id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "   mensagem TEXT NOT NULL" +
            ");";
    
    public DBLog(){
        //cria a tabela se não existir 
        createTableIfNotExists();
    }
    
    private void createTableIfNotExists() {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
                Statement stmt = conn.createStatement()) {

            // Executa o SQL de criação da tabela
            stmt.execute(CREATE_TABLE_SQL);
            //System.out.println("Tabela criada ou já existente.");

        } catch (SQLException e) {
            e.getMessage();
            //System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
    
    @Override
    public void escrever(String mensagem) {
    
        // SQL statement for creating a new table
        var sql = "INSERT INTO logPedido(mensagem) VALUES(?)";
        
        try (Connection conn = DriverManager.getConnection(DATABASE_URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Define o valor do parâmetro da query
            stmt.setString(1, mensagem);

            // Executa a query
            stmt.executeUpdate();
            //System.out.println("Mensagem registrada no banco de dados.");
        } catch (SQLException e) {
            e.getMessage();
            //System.out.println(e.getMessage());
        }
    }
}
