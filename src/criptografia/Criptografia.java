/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package criptografia;
import java.util.*;
public class Criptografia {

    public static void main(String[] args) {
        // TODO code application logic here
        String key;
        do{
            Scanner chave = new Scanner (System.in);
            System.out.println("Digite sua chave numerica:");
            key = chave.nextLine();
        }while(key.matches("[0-9]*") == false);   
        
        Scanner texto = new Scanner (System.in);
        System.out.println("\nDigite seu texto:");
        String text = texto.nextLine();
        
        Scanner resposta = new Scanner (System.in);
        System.out.println("\nDigite 1 para criptografar ou 2 para descriptografar");
        String res = resposta.nextLine();
            
        int crypNum[];
        char crypChar[];
        String crypStr[];
        crypNum = new int[text.length()]; //instanciamento
        crypChar = new char[text.length()];
        crypStr = new String[text.length()];
        int key1 = Integer.parseInt(key); //chave de string para int
        if(key1>26){
            key1%=26;
            if (key1==0){
                key1++;
            }
        }
        int key2 = key1;
        if(key2>10){
            key2%=10;
            if (key2==0){
                key2++;
            }
        }
        switch(Integer.parseInt(res)){
                case 1 -> {
                    for(int i = 0; i < text.length(); ++i){
                        
                        
                        char letra = text.charAt(i); //chars[i] em arrays
                        String letraStr = Character.toString(letra);
                        int letraASCII = (int)letra; //para o calculo em if
                        
                        if(Character.isLetter(letra)){
                            if(letraStr.matches("[A-Z]*")){
                                crypNum[i] = ((letraASCII - 65 + key1)%26)+65;
                                crypChar[i] = (char)crypNum[i];
                                crypStr[i] = Character.toString(crypChar[i]);
                            } 
                            if (letraStr.matches("[a-z]*")){
                                crypNum[i] = ((letraASCII - 97 + key1)%26)+97;
                                crypChar[i] = (char)crypNum[i];
                                crypStr[i] = Character.toString(crypChar[i]);
                            }
                        }else{
                            if(letraStr.matches("[0-9]*")){
                                crypNum[i] = ((letraASCII - 48 + key2)%10)+48;
                                crypChar[i] = (char)crypNum[i];
                                crypStr[i] = Character.toString(crypChar[i]);
                            } else{
                                crypStr[i] = Character.toString(letra);
                            }
                        }
                    }
                    System.out.println("\nSeu texto criptografado:");
                    for (String a : crypStr){
                        System.out.print(a);
                    }
                    System.out.println("");
                }
                case 2 -> {  
                    for(int j = 0; j < text.length(); ++j){
                                            
                        char letra = text.charAt(j); //chars[i] em arrays
                        String letraStr = Character.toString(letra);
                        int letraASCII = (int)letra; //para o calculo em if
                                                
                        if(Character.isLetter(letra)){
                            if(letraStr.matches("[A-Z]*")){
                                crypNum[j] = ((letraASCII - 65 + (26-key1))%26)+65;
                                crypChar[j] = (char)crypNum[j];
                                crypStr[j] = Character.toString(crypChar[j]);
                            } 
                            if (letraStr.matches("[a-z]*")){
                                crypNum[j] = ((letraASCII - 97 + (26-key1))%26)+97;
                                crypChar[j] = (char)crypNum[j];
                                crypStr[j] = Character.toString(crypChar[j]);
                            }
                        }else{
                            if(letraStr.matches("[0-9]*")){
                                crypNum[j] = ((letraASCII - 48 + (10-key2))%10)+48;
                                crypChar[j] = (char)crypNum[j];
                                crypStr[j] = Character.toString(crypChar[j]);
                            } else{
                                crypStr[j] = Character.toString(letra);
                            }
                        }
                    }
                    System.out.println("\nSeu texto descriptografado:");
                    for (String b : crypStr){
                        System.out.print(b);
                    }
                    System.out.println("");
                }
        }
        

    }
    
}
