package br.com.tt.web.pet.controller.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.tt.web.pet.dao.Dao;
import br.com.tt.web.pet.model.Pet;

@ManagedBean
@SessionScoped
public class PetBean {

	private Pet pet = new Pet();
	private Dao petDao = new Dao();
	private List<Pet> lista = petDao.buscarTodos(pet);

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public void salvar() {
		petDao.salvar(pet);
		lista = petDao.buscarTodos(pet);
		pet = new Pet();
	}

	public List<Pet> getLista() {
		return lista;
	}

	public void setLista(List<Pet> lista) {
		this.lista = lista;
	}

}
