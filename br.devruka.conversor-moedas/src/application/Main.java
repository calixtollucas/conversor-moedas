import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

import domain.Conversao;
import domain.Currency;
import exceptions.ConversaoException;
import services.ExchangerAPI;

public class Main {

    private static final String API_KEY = "9b569aeb7a96e467339dcdb9";
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean sair = false;

        // MENU
        while(!sair){

            System.out.println("  CONVERSOR DE MOEDAS  ");
            System.out.println("=======================");
            System.out.println("1 - realizar conversão ");
            System.out.println("2 - mostrar logs       ");
            System.out.println("3 - moedas suportadas  ");
            System.out.println("4 - sair               ");
            System.out.println("=======================");
            System.out.println("Digite uma opção válida: ");

            String input = sc.nextLine();

            switch (Integer.parseInt(input)) {
                case 1:
                    converterMoeda();
                    break;
                case 2:
                    mostraLogs();
                    break;
                case 3:
                    mostrarMoedasSuportadas();
                    break;
                case 4:
                    sair = !sair;
                    sc.close();
                    break;
            
                default:
                    System.out.println("Valor inválido");
                    break;
            }
        }  
    }

    public static void converterMoeda(){
        try{
            System.out.println("  CONVERSOR DE MOEDAS  ");
            System.out.println("=======================");
            System.out.println("Digite o código da moeda que deseja converter: ");
            String currencyCode = sc.nextLine();

            System.out.println("Digite o valor que deseja converter: ");
            Double currencyValue = Double.parseDouble(sc.nextLine());

            System.out.println("Digite o código da moeda para qual deseja converter: ");
            String targetCurrencyCode = sc.nextLine();

            ExchangerAPI exchanger = new ExchangerAPI(API_KEY);

            Currency currency = new Currency(currencyCode, new BigDecimal(currencyValue));
            
            Conversao conversao = exchanger.fetch(currency, targetCurrencyCode);
            System.out.printf("%.2f de %s - convertido para -> %.2f de %s (Taxa de: %f)\n", 
                conversao.getCurrency().getValue().doubleValue(),
                conversao.getCurrency().getCode(),
                conversao.getTargetCurrency().getValue().doubleValue(),
                conversao.getTargetCurrency().getCode(),
                conversao.getTax());
        } catch(ConversaoException e){
            System.out.println(e.getMessage());
            return;
        } catch (NumberFormatException e){

            System.out.println("É necessário você inserir um valor numérico");
            return;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void mostrarMoedasSuportadas(){

        try (BufferedReader br = new BufferedReader(new FileReader("moedas_suportadas.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch(IOException e){
            System.out.println("erro ao fazer a leitura do arquivo moedas_suportadas.txt");
            e.printStackTrace();
        }

    }

    public static void mostraLogs(){
        System.out.println("        LOGS        ");
        System.out.println("====================");
        try (BufferedReader br = new BufferedReader(new FileReader("conversoes_log.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch(IOException e){
            System.out.println("erro ao fazer a leitura do arquivo moedas_suportadas.txt");
            e.printStackTrace();
        }
        System.out.println("===================");
    }
}
