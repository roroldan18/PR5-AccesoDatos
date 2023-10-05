package Controller;

import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private String path;

    private Reader reader;

    private Writer writer;

    public FileManager(String path) {
        this.path = "src/" + path;
    }

    public void readFile(){
        try{
            this.reader = new FileReader(this.path);
            int character = this.reader.read();
            while (character != -1){
                System.out.print((char)character);
                character = this.reader.read();
            }
            this.reader.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void writeFile(String text){
        try{
            this.writer = new FileWriter(this.path, true);
            this.writer.write(text);
            this.writer.write("\n");
            this.writer.close();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeLine(String dni){
        // Array temporal
        ArrayList<String> lines = new ArrayList<>();

        try {
            // Leer el archivo línea por línea
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String lineRead;
            while ((lineRead = bufferedReader.readLine()) != null) {
                // Si la línea no coincide con el DNI, añadirla a la lista temporal
                if (!lineRead.contains(dni)) {
                    lines.add(lineRead);
                }
            }

            // Cerrar el archivo
            bufferedReader.close();
            reader.close();

            // Reescribir el archivo con las líneas de la lista temporal
            FileWriter writer = new FileWriter(path);

            for (String line : lines) {
                writer.write(line + "\n");
            }

            // Cerrar el archivo
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
