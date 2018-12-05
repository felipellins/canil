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
public interface ClienteDAO <Cliente> extends InterfaceDao<Cliente>  {
    public void alterarSenha(Cliente cliente);
}
