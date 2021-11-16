package com.gugawag.pdist.ejbs;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.gugawag.pdist.model.Mensagem;

@Stateless
public class MensagemDAO {
	@PersistenceContext(unitName="default")
    private EntityManager em;

    public void inserir(Mensagem novoMensagem){
        em.persist(novoMensagem);
    }

    public List<Mensagem> listar() {
        return em.createQuery("FROM Mensagem").getResultList();
    }
    
    public Mensagem pesquisarPorId(long id) {
        return (Mensagem) em.createQuery("FROM Mensagem m WHERE m.id= "+ id).getSingleResult();
    }
}
