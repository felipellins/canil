/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model.dao;

import java.util.List;

/**
 *
 * @author Felipe
 */
public interface AnimalDAO <Animal> extends InterfaceDao<Animal> {
    public List<Animal> animaisOrfao();
    public Animal adotar(Animal animal);

    
}
