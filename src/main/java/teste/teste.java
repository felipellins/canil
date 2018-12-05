package teste;



import felipe.id.model.Canil;
import felipe.id.model.CanilModel;
import felipe.id.model.Cliente;
import felipe.id.model.ClienteModel;
import felipe.id.model.Colaborador;

import felipe.id.model.Endereço;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Felipe
 */
public class teste {
 // public Animal(String id_animal, String nome_ani, int idade, String porte, String raça,
    //String tipo, String data_entrada, String data_adotado,Canil canil,Cliente cliente) {
   //public Canil(String id_canil,String nome,Endereço endereço){
   // public Endereço(String cidade,String rua,int numero,String estado)
    
    public static void main(String []args){
         
        ClienteModel cm= new ClienteModel();
        CanilModel cam= new CanilModel();  
           
           
            
                    
            // Endereço endi= new Endereço ( "palmeirina","rua joão", 5,"pernambuco");
            
          // Cliente client = new Cliente("225","novofe","@1gmail","s11nha",endi);
          // Cliente c2 = new Cliente("225","alt","@1gmail","s11nha",endi);
           
           //   client.setEndereço(endi);     
         
         //client.setIdCli(98);
         //cm.alterarCliente(client);
          
          // cm.cadastrarCliente(client);
          
          
          Cliente  c =cm.recuperar("123");
          
         
            
             System.out.println(c.getNome());
        
          
           
           
          // cm.removerCliente(64);
                                          // Banco se chama Novo
           
         // Canil can= new Canil("533","canil pe",endi,null);
          // can.setEndereço(endi);
             
                // can.setIdcanil();
               //  cam.alterarCanil(can);
                
               //  cam.removerCanil(84);
               //  cam.removerCanil(85);
               // cam.cadastrarCanil(can);
               
               
 
              // System.out.println(cm);
               
     // Colaborador col = new Colaborador("id_cpf", " nome_alterado",endi,"login"," senha");
       
        // col.setEndereço(endi);
         //colh.inserir(col);
        // colh.alterar(col);
        // colh.deletar("id_cpf");
              
           
          

            
            
        
                  
           
        
    }
    
    
    
}
