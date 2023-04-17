package json;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        Functionalities func = new Functionalities();
        func.csvToJson();
        func.jsonToCsv();
        CsvDownloader csvd = new CsvDownloader();
        csvd.copyURLToFile("https://raw.githubusercontent.com/anamoreira-iscte/ES-2023-LEI-GrupoE-Terca/main/horario_exemplo.csv");

    }
}
