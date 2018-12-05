/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package felipe.id.model.dao;

/**
 *
 * @author Felipe
 */
public interface ColaboradorDAO <Colaborador> extends InterfaceDao <Colaborador> {
    public void alterarSenha(Colaborador colaborador);
}
