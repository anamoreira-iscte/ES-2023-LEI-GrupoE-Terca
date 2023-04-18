/*
import json.Functionalities;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void CsvtoJsonLocal(){
        Functionalities func = new Functionalities();

        String input1 = "\"C:\\Users\\inesc\\OneDrive - ISCTE-IUL\\Documentos\\Iscte\\3º Ano\\2º Semestre\\ES\\ES-2023-LEI-GrupoE-Terca\\exemplo.csv\"";
        String input2 = "\"C:\\Users\\inesc\\OneDrive - ISCTE-IUL\\Documentos\\Iscte\\3º Ano\\2º Semestre\\ES\\TestsCsvToJson.json\"";

        // Create a ByteArrayInputStream to simulate user input
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        System.setIn(new ByteArrayInputStream(input2.getBytes()));

        // Create a Scanner to read input from the ByteArrayInputStream
        Scanner scanner = new Scanner(System.in);

        // Call the method you want to test, passing in the Scanner
        int result = func.csvToJson(scanner);
        File json = new File()
        assertEquals(result; "bla");
    }
}
*/