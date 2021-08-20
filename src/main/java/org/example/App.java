package org.example;

public class App {
    // #1 A senha deve ter pelo menos oito caracteres.
    // #2 A senha consiste apenas em letras e dígitos.
    // #3 A senha deve conter pelo menos dois dígitos.
    public static void main(String[] args) {

        String[] senhaEscolhida = new String[8];
        senhaEscolhida[0] = "abc123";       //menos de 8        quebrou regra 1
        senhaEscolhida[1] = "abcdef12@";    //tem símbolo       quebrou regra 2
        senhaEscolhida[2] = "abcdef 12";    //tem espaço        quebrou regra 2
        senhaEscolhida[3] = "1234!6789";    //tem símbolo       quebrou regra 2
        senhaEscolhida[4] = "abcdefXX";     //sem digito        quebrou regra 3
        senhaEscolhida[5] = "abcdefX1";     //apenas 1 digito   quebrou regra 3
        senhaEscolhida[6] = "abcdef12";     //senha             ok
        senhaEscolhida[7] = "123456789";    //senha             ok

        for (int i = 0; i < senhaEscolhida.length; i++) {
            System.out.print("Senha "+i+" = ");
            System.out.println("["+senhaEscolhida[i]+"]");
            System.out.println("Jr. -> Sua senha é " + validaJunior(senhaEscolhida[i]));
            System.out.println("Pl. -> Sua senha é " + validaPleno(senhaEscolhida[i]));
            System.out.println("Sr. -> Sua senha é " + validaSenior(senhaEscolhida[i]));
            System.out.println("--------------------------");
        }

    }

    public static boolean validaJunior(String p){
        int achouDigito = 0;
        int achouSimbolo = 0;

        //# 1
        if (p.length() < 8)
            return false;

        for (char c : p.toCharArray()) {
            if (c >= '0' && c <= '9') {
                achouDigito++;
            } else if ((c < 'A' || c > 'Z') && (c < 'a' || c >= 'z')) {
                achouSimbolo++;
            }
        }
        //# 2
        if(achouSimbolo>0)
            return false;

        //# 3
        if(achouDigito<2)
            return false;

        return true;
    }

    public static boolean validaPleno(String senha){
        //#1 8 char                 (?=.{8,})
        //#2 somente letras e num	([a-zA-Z]{0,})
        //#3 min 2 digitos			(\\d{2,}) ou ([0-9]{2,})
        String padrao = "(?=.{8,})([a-zA-Z]{0,})(\\d{2,})";
        if(senha.matches(padrao))
            return true;
        return false;
    }

    public static boolean validaSenior(String senha){
        //#1
        if(senha.length()<8)
            return false;

        //#2
        if(senha.length()!=(contaDigitos(senha)+contaLetras(senha)))
            return false;

        // #3
        if(contaDigitos(senha)<2)
            return false;

        return true;
    }

    public static int contaLetras(String senha){
        int total=0;
        String alfabeto="";
        for (int i = 65; i <= 90; i++) {
            alfabeto+=(char)i;
        }
        for (int i = 97; i <= 122; i++) {
            alfabeto+=(char)i;
        }
        alfabeto+="*";
        for (int i = 0; i < senha.length(); i++) {
            if(alfabeto.contains(senha.substring(i, i+1))){
                total++;
            }
        }
        return total;
    }

    public static int contaDigitos(String senha){
        int total=0;
        String digitos="";
        for (int i = 0; i < 10; i++) {
            digitos+=i;
        }
        for (int i = 0; i < senha.length(); i++) {
            if(digitos.contains(senha.substring(i, i+1))){
                total++;
            }
        }
        return total;
    }

}