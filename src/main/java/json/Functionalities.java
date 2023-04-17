package json;

import com.google.gson.*;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Functionalities {

    private static final Logger logger= Logger.getLogger(Functionalities.class.getName());

    public void csvToJson() throws IOException {
        try {

            Scanner scanner1 = new Scanner(System.in);
            logger.log(Level.INFO, "Por favor indique o PATH do ficheiro que pretende converter para JSON: ");
            String filePath = scanner1.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Ler a primeira linha e definir os nomes das colunas
            String primeiraLinha = reader.readLine();
            String[] nomesColunas = primeiraLinha.split(";");

            List<String[]> aulas = new ArrayList<String[]>();
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                aulas.add(campos);
            }
            reader.close();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Criar um objeto JsonObject para adicionar os nomes das colunas ao JSON
            JSONObject jsonObject = new JSONObject();
            JsonArray jsonArray = new JsonArray();
            for (String[] campos : aulas) {
                JsonObject linhaObjeto = new JsonObject();
                for (int i = 0; i < campos.length; i++) {
                    linhaObjeto.addProperty(nomesColunas[i], campos[i]);
                }
                jsonArray.add(linhaObjeto);
            }
            jsonObject.put("aulas", jsonArray);

            Scanner scanner2 = new Scanner(System.in);
            logger.log(Level.INFO, "Por favor indique o PATH onde pretende guardar o ficheiro JSON: ");
            String path = scanner2.nextLine();

            FileWriter writer = new FileWriter(path);
            gson.toJson(jsonObject.toMap(), writer);
            writer.close();

            logger.log(Level.INFO, "Ficheiro JSON criado com sucesso");
        } catch (IOException e){
            logger.log(Level.INFO, "Não foi possível criar ficheiro JSON");
        }
    }

    public void jsonToCsv() {
        // Class data members
        String jsonString;
        JSONObject jsonObject;

        // Try block to check for exceptions
        try {
            Scanner scanner1 = new Scanner(System.in);
            logger.log(Level.INFO, "Por favor indique o PATH do ficheiro que pretende converter para CSV: ");
            String filePath = scanner1.nextLine();

            // Step 1: Reading the contents of the JSON file using readAllBytes() method and storing the result in a string
            jsonString = new String(Files.readAllBytes(Paths.get(filePath)));

            // Step 2: Construct a JSONObject using above string
            jsonObject = new JSONObject(jsonString);

            // Step 3: Fetching the JSON Array test from the JSON Object
            JSONArray docs = jsonObject.getJSONArray("aulas");

            // Step 4: Create a new CSV file using the package java.io.File
            Scanner scanner2 = new Scanner(System.in);
            logger.log(Level.INFO, "Por favor indique o PATH onde pretende guardar o ficheiro CSV: ");
            String path = scanner2.nextLine();
            File file = new File(path);


            // Step 5: Produce a comma delimited text from the JSONArray of JSONObjects and write the string to the newly created CSV file
            String csvString = CDL.toString(docs);
            FileUtils.writeStringToFile(file, csvString);

            logger.log(Level.INFO, "Ficheiro CSV criado com sucesso");
        } catch (IOException e) {
            logger.log(Level.INFO, "Não foi possível criar ficheiro CSV");
        }
    }
}
