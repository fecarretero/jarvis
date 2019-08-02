/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.jarvis;

import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

/**
 *
 * @author andyv
 */
public class Jarvis {

    public void saludar() {
        String saludo = "Hello! I'm Jarvis";
        decir(saludo);
    }
    public void escribir(String texto) {
        System.out.println(texto);
    }
    public void decir(String texto) {
        try {
            System.setProperty("freetts.voices",
                    "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText(texto, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            synthesizer.deallocate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void analizarc(){
        char c = 'A';
        boolean a;
        System.out.println("Analizando Caracter...");
        System.out.println("El caracter ingresado es " + c);
        a = Character.isAlphabetic(c);
        System.out.println("Es letra? "+ a ); 
        a = Character.isDigit(c);
        System.out.println("Es digito? "+ a );
        c = Character.toUpperCase(c);
        System.out.println("La mayuscula de A "+ c );
        c = Character.toLowerCase(c);
        System.out.println("La minuscula de A "+ c );
    }
    public void analizarf(){
        String a = "IronMan";
        int c = a.length();
        System.out.println("Cantidad de Caracteres: " + c);
        System.out.println(a.substring(0,c/2+1));
        System.out.println(a.substring(c/2+1,c));
        System.out.println(a.toUpperCase());
        System.out.println(a.toLowerCase());
        System.out.println(a.substring(0,1).toUpperCase()+a.substring(1,c).toLowerCase());
        
    }
    public void fecha(){
        String a = "01-10-1982";
        System.out.println("Informacion de Fecha: " + a);
        System.out.println("Dia: " + a.substring(0,2));
        System.out.println("Mes: " + a.substring(3,5));
        System.out.println("Año: " + a.substring(6,a.length()));
    }
    public void jeringozo(){
        String a = "hola";
        a = a.replace("a","apa");
        a = a.replace("e","epe");
        a = a.replace("i","ipi");
        a = a.replace("o","opo");
        a = a.replace("u","upu");
        System.out.println(a);
        decir(a);
    }
}
