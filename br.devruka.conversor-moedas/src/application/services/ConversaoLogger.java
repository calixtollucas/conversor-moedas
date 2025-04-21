package services;

import java.io.FileWriter;
import java.io.IOException;

import domain.Conversao;

public class ConversaoLogger {

    public static void log(Conversao conversao){
        try(FileWriter fw = new FileWriter("conversoes_log.txt",true)){
            
            fw.write(String.format("[%s] %s %.2f para %s %.2f (Taxa: %f %%)\n",
                conversao.getTimestamp().toString(),
                conversao.getCurrency().getCode(),
                conversao.getCurrency().getValue(),
                conversao.getTargetCurrency().getCode(),
                conversao.getTargetCurrency().getValue(),
                conversao.getTax()));

        } catch (IOException e) {
            System.out.println("[ERROR] erro ao escrever o log");
            e.printStackTrace();
        }

    }
    
}
