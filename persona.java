/** 
 * @javadoc
 * classe Personagem e seus atributos
 */
public class persona {
    private String nomepers;
    private int energiapers;
  
    persona(String nome, int energia) {
      this.nomepers = nome;
      this.energiapers = 100;
    }
   
  public void setEnergia(int energia) {
    if (energia <= 0) {
        energia = 0;
        System.out.println(this.nomepers + " foi derrotado.");
    } else if (energia > 100) {
        energia = 100;
    }
  
    this.energiapers = energia;
  }
  
    void alterarEnergia(int alteracao) {
      this.energiapers = this.energiapers + alteracao;
  
      if (alteracao > 0) {
        System.out.println("Este movimento, impactou no personagem " + this.nomepers + " restaurando " + alteracao
            + " Pontos de Energia. ");
      } else {
        System.out.println("Este movimento, impactou no personagem " + this.nomepers + " consumindo " + alteracao
            + " Pontos de Energia. ");
      }
      this.setEnergia(this.energiapers + alteracao);
    
  
   
    }
  
  }
