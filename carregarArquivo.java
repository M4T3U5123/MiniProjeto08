/** 
 * @javadoc
 * classe CarregaArquivo que tem a função de criar hashmap, ou seja, um dicionário através
 * de um conjunto de pares de chave-valor, para cada elemento, que será lido nos arquivos txt,
 * que tem o objetivo de capturar as escolhas, personagens e capitulos da história, estabelecendo
 * assim conexão entre os objetos.
 */ 
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class CarregarArquivo {
    HashMap<String, persona> lerpersonas(String caminhoArquivoPersonagens)
    {
        HashMap<String, persona> personagens= new HashMap<String, persona>();
        File arquivoPersonagens = new File(caminhoArquivoPersonagens);

    try
    {
     Scanner escaneadorArquivoPersonagens = new Scanner(arquivoPersonagens, "UTF-8");

     
     String nomePersonagem = "";
     String linhaEscaneada = "";
     int energiaPersonagem = 0;
     while (escaneadorArquivoPersonagens.hasNextLine()) 
     {
       while (!linhaEscaneada.equals("<PERSONAGEM>")) 
       {
         linhaEscaneada = escaneadorArquivoPersonagens.nextLine(); 
       }
       linhaEscaneada = escaneadorArquivoPersonagens.nextLine();
       nomePersonagem = escaneadorArquivoPersonagens.nextLine(); 
       linhaEscaneada = escaneadorArquivoPersonagens.nextLine();
       energiaPersonagem = Integer.parseInt(escaneadorArquivoPersonagens.nextLine()); 
       personagens.put(nomePersonagem, new persona(nomePersonagem,
           energiaPersonagem));
    }

    escaneadorArquivoPersonagens.close();
    } 
   catch (FileNotFoundException exception) 
   {
     exception.printStackTrace();
   }
   return personagens;
 }

 HashMap<String, capitulo> lerCaps(String caminhoArquivoCapitulos,
 HashMap<String, persona> personagens,
 Scanner escaneadorConsole)
{
        HashMap<String, capitulo> capitulos = new HashMap<String, capitulo>();
        File arquivoCapitulos = new File(caminhoArquivoCapitulos);
    
        try 
        {
          Scanner escaneadorArquivoCapitulos = new Scanner(arquivoCapitulos, "UTF-8");

          String linhaEscaneada = "";

         while (escaneadorArquivoCapitulos.hasNextLine()) 
    {
           while (!linhaEscaneada.equals("<CAPITULO>") && 
                  !linhaEscaneada.equals("<ESCOLHA>")) 
           {
             linhaEscaneada = escaneadorArquivoCapitulos.nextLine(); 
           }
           
             if (linhaEscaneada.equals("<CAPITULO>")) 
        {
            lerCap(personagens,
                escaneadorConsole,
                capitulos,
                escaneadorArquivoCapitulos);

                linhaEscaneada = "";
        }
        else if (linhaEscaneada.equals("<ESCOLHA>"))
        {
            lerEsco(capitulos, 
                       escaneadorArquivoCapitulos);
            linhaEscaneada = "";
        }   
}
        escaneadorArquivoCapitulos.close();
    }
        catch (FileNotFoundException exception) 
        {
          exception.printStackTrace();
        }
        return capitulos;
}

private void lerCap(HashMap<String, persona> personagens,
      Scanner escaneadorConsole,
      HashMap<String, capitulo> capitulos,
      Scanner escaneadorArquivoCapitulos) 
      {
    String nomeCapitulo;
    String textoCapitulo;
    String nomePersonagem;
    int variacaoEnergia = 0;
    String LinhaEscaneada;
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomeCapitulo = escaneadorArquivoCapitulos.nextLine(); 
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    textoCapitulo = escaneadorArquivoCapitulos.nextLine();
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomePersonagem = escaneadorArquivoCapitulos.nextLine();
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    variacaoEnergia = Integer.parseInt(escaneadorArquivoCapitulos.nextLine()); 
    capitulos.put(nomeCapitulo, new capitulo(nomeCapitulo,
        textoCapitulo,
        personagens.get(nomePersonagem),
        variacaoEnergia,
        escaneadorConsole));
  }

  private void lerEsco(HashMap<String, capitulo> capitulos,
      Scanner escaneadorArquivoCapitulos) 
      {
    String nomeCapituloOrigem;
    String textoDigitado;
    String textoMostrado;
    String nomeCapituloDestino;
    String LinhaEscaneada;
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomeCapituloOrigem = escaneadorArquivoCapitulos.nextLine(); 
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    textoDigitado = escaneadorArquivoCapitulos.nextLine(); 
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    textoMostrado = escaneadorArquivoCapitulos.nextLine(); 
    LinhaEscaneada = escaneadorArquivoCapitulos.nextLine();
    nomeCapituloDestino = escaneadorArquivoCapitulos.nextLine();
    
    capitulos.get(nomeCapituloOrigem).adicioneEscolha(
    new escolha(textoDigitado, capitulos.get(nomeCapituloDestino), textoMostrado));
  }
}
