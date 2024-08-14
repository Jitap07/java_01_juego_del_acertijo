import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception
    {
        // DECLARACION DE VARIABLES:
        Scanner scanner = new Scanner(System.in);  // Captura Datos por Teclado
        String PalabraSecreta = "INTELIGENCIA";    // Palabra a adivinar
        int IntentosMaximos = 10;                  // Limite de Intentos
        int IntentosFallidos = 0;                  // Contabiliza intentos fallidos (aciertos NO).
        boolean AciertaLetra = false;              // ¿Acertó Letra Ingresada?
        boolean AciertaPalabra = false;            // ¿Acertó Palabra?
        char[] LetrasAdivinadas = new char[PalabraSecreta.length()];  //ARRAY de Letras acertadas por el usuario
        String PalabraFinal = "";                  // Palabra formada con las letras correctas ingresadas
        
        // INICIALIZACIÓN:
        for(int i = 0; i < LetrasAdivinadas.length; i++)
        {
            LetrasAdivinadas[i] = '_';
            // -----------------------------------------------------------------------------------------------------------------
            // Armando Palabra Final para mostrar en pantalla:
            if (i < (LetrasAdivinadas.length - 1))  // Si no es el ultimo caracter
                PalabraFinal = PalabraFinal + LetrasAdivinadas[i] + " / ";   // Concatena la letra adivinada más el " / "
            else   // Para el ultimo caracter
                PalabraFinal = PalabraFinal + LetrasAdivinadas[i];           // Solo Concatena la letra adivinada
            // -----------------------------------------------------------------------------------------------------------------
        }
        
        // INDICACIONES:
        System.out.println("\n-------------------------------------------------------");
        System.out.println("-------   BIENVENIDOS AL JUEGO DEL ACERTIJO :   -------");
        System.out.println("-------------------------------------------------------");
        System.out.println("El juego consiste en acertar una palabra Secreta");
        System.out.println("Ud. tendrá un tope máximo de 10 intentos");
        System.out.println("Se contarán solo los intentos fallidos");
        System.out.println("Cada letra ACERTADA, autocompletará los espacios en blanco");
        System.out.println("");
        System.out.println("BUENA SUERTE !!!");
        System.out.println("-------------------------------------------------------");
        
        // BUCLE WHILE:
        // MIENTRAS, NO ACIERTE la palabra y sus intentos no superen el límite:
        while((!AciertaPalabra) && (IntentosFallidos < IntentosMaximos))
        {
            AciertaLetra = false;   // Valor por defecto para cada recorrido while
            
            // Mostrando palabra formada con las letras que va adivinando
            System.out.println("\n\nLa palabra secreta contiene " + PalabraSecreta.length() + " Letras: ");
            System.out.println(PalabraFinal);
            
            // Captura Letra Ingresada, lo convierte en MAYÚSCULA, pero si ingresa una cadena, toma solo el de la posicion "0":
            System.out.println("Introduzca una letra: ");
            char letraingresada = Character.toUpperCase(scanner.next().charAt(0));
            
            // Recorre cada letra de la Palabra Secreta:
            for(int i = 0; i < PalabraSecreta.length(); i++)
            {
                // Compara, Si la letra ingresada es igual a la letra de la palabra secreta en la posicion "i":
                if (letraingresada == PalabraSecreta.charAt(i))
                {
                    // Actualizo el ARRAY de las letras que va adivinando
                    LetrasAdivinadas[i] = letraingresada;  // Deja el valor '_' ; para asignarle la letra ingresada
                    AciertaLetra = true;
                }
            }
            
            // -----------------------------------------------------------------------------------------------------------------
            // Armando nuevamente Palabra Final para mostrarlo en pantalla:
            PalabraFinal = "";     // Limpia Variable
            for(int i = 0; i < LetrasAdivinadas.length; i++)
            {
                if (i < (LetrasAdivinadas.length - 1))
                    PalabraFinal = PalabraFinal + LetrasAdivinadas[i] + " / ";
                else
                    PalabraFinal = PalabraFinal + LetrasAdivinadas[i];
            }
            // -----------------------------------------------------------------------------------------------------------------
            
            if (AciertaLetra)   // Si ACIERTA letra
                System.out.println("CORRECTO !!!, Letra adivinada . . . ");
            else
            {
                System.out.println("INCORRECTO !!!, Te quedan: " + (IntentosMaximos - IntentosFallidos) + " Intentos . . .");
                IntentosFallidos ++;      // Contabiliza intento
            }
            
            // Si al concatenar ARRAY de caracteres, se compara con la palabra Secreta y lo ACIERTA:
            if (String.valueOf(LetrasAdivinadas).equals(PalabraSecreta))
                AciertaPalabra = true;    // ACERTÓ la Palabra Completa
        }
        
        if (AciertaPalabra)
            System.out.println("\nFELICIDADES !!!, Adivinaste la Palabra Secreta: " + PalabraSecreta + ". \n");
        else
            System.out.println("\nQUE LÁSTIMA !!!, Te quedastes sin intentos.  \nGAME OVER . . . \n");
        
        scanner.close();
    }
}
