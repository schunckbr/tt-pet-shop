package br.com.tt.web.pet.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.web.pet.dao.Dao;
import br.com.tt.web.pet.model.Proprietario;

@ManagedBean
@SessionScoped
public class ProprietarioBean {

	private Proprietario proprietario = new Proprietario();
	private Dao dao = new Dao();
	private List<Proprietario> lista = dao.buscarTodos(proprietario);

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public void salvar() {
		System.out.println("Salvando com sucesso!");
		System.out.println(proprietario.getCpf());
		dao.salvar(proprietario);
		proprietario = new Proprietario();
	}

}
