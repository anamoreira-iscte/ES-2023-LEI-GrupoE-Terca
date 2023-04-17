package json;

import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.net.URLEncoder;
import java.io.FileWriter;

            public class CsvDownloader {

                public static void copyURLToFile(String urls) throws IOException {

                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Qual é o Path do ficheiro csv onde pretende guardar?");
                    String path = scanner.nextLine();

                    FileWriter writer = new FileWriter(path);

                    try {
                        URL url = new URL(urls);
                        InputStream input = url.openStream();

                        char[] buffer = new char[4096];
                        int n = 0;
                        while (-1 != (n = new InputStreamReader(input).read(buffer))) {
                            writer.write(buffer, 0, n);
                        }

                        input.close();
                        writer.close();

                        System.out.println("File downloaded successfully!");
                    } catch (IOException ioEx) {
                        ioEx.printStackTrace();
                    }
                }


                public static void main(String[] args) throws Exception {

                    copyURLToFile("https://raw.githubusercontent.com/anamoreira-iscte/ES-2023-LEI-GrupoE-Terca/main/horario_exemplo.csv");
                }
            }