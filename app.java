/**  
 *@version Mini-Projeto-08
 * @author Mateus Omar
 */
/**
 * @javadoc 
 * Método main do meu código que executa a interação com os objetos das outras classes, sendo assim,
 * as chamadas é o ponto de entrada do meu executável.
*/
import java.util.Scanner;
import java.util.HashMap;

class App {
  public static void main(String[] argas) {
    Scanner escaneador = new Scanner(System.in);
    CarregarArquivo ler = new CarregarArquivo();
    HashMap<String, persona> persona = ler.lerpersonas("rsc/persona.txt");
    HashMap<String, capitulo> capitulos = ler.lerCaps("rsc/capitulo.txt", persona, 
                                                                                   escaneador);   

    capitulo raiz = capitulos.get("cap1");

    raiz.mostrarinfo();
    escaneador.close();
  }

}
