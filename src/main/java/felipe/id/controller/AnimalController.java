/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.controller;

import felipe.id.model.Animal;
import felipe.id.model.AnimalModel;
import felipe.id.model.Canil;
import felipe.id.model.CanilModel;
import felipe.id.model.Cliente;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Felipe
 */
@RequestScoped
@ManagedBean 
public class AnimalController {
	private AnimalModel animalModel;
	private Animal animal;
	private Animal selectedAnimal;
        private Canil canil;
        private List<Animal>animais;
        private List<Canil> canis;
	private Cliente cliennte;
        
        public AnimalController() {
              
               
		this.animalModel = new AnimalModel();
		this.animal = new Animal();
                this.canil= new Canil();
                this.canis = new CanilModel().RecuperarTodos();
	}

    public AnimalController(AnimalModel animalModel, Animal animal, Animal selectedAnimal, Canil canil, List<Animal> animais, List<Canil> canis, Cliente cliennte) {
        this.animalModel = animalModel;
        this.animal = animal;
        this.selectedAnimal = selectedAnimal;
        this.canil = canil;
        this.animais = animais;
        this.canis = canis;
        this.cliennte = cliennte;
    }

        
        
        
	public void registrarAnimal() {
                
                this.animal.setCanil(canil);
		this.animalModel.cadastrarAnimal(this.animal);
		this.animal = new Animal();

		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Animal cadastrado com sucesso!"));
		 
	}

     public void removerAnimal(Integer idAnimal) {
		this.animalModel.removerAnimal(idAnimal);
	}

	public void alterarAnimal(ActionEvent evento) {
                
                try{
                    animal=(Animal) evento.getComponent().getAttributes().get("animalSelecionado");
                   AnimalModel animalModel = new AnimalModel();
                   animais=animalModel.RecuperarTodos();
                
                 }catch(RuntimeException erro){
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("erro ao alterar o animal"));
               erro.printStackTrace();
           }
            
	}

	public Animal recuperarID(String codAnimal) {
		return animalModel.recuperar(codAnimal);
	}
         @PostConstruct
	public void recuperarTodos() {   
        
        try{
               AnimalModel animalModel = new AnimalModel();
               animais = animalModel.RecuperarTodos();

           }catch(RuntimeException erro){
               FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("erro ao listar animais"));
               erro.printStackTrace();
           }
        
    } 

    public Cliente getCliennte() {
        return cliennte;
    }

    public void setCliennte(Cliente cliennte) {
        this.cliennte = cliennte;
    }

    
        
    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public AnimalModel getAnimalModel() {
        return animalModel;
    }

    public void setAnimalModel(AnimalModel animalModel) {
        this.animalModel = animalModel;
    }

    public Animal getSelectedAnimal() {
        return selectedAnimal;
    }

    public void setSelectedAnimal(Animal selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }

    public Canil getCanil() {
        return canil;
    }

    public void setCanil(Canil canil) {
        this.canil = canil;
    }

    public List<Canil> getCanis() {
        return canis;
    }

    public void setCanis(List<Canil> canis) {
        this.canis = canis;
    }

	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

}
