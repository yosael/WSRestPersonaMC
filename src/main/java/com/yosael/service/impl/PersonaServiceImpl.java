package com.yosael.service.impl;

import java.util.List;

import com.yosael.dao.IPersonaDAO;
import com.yosael.dao.impl.PersonaDAOImpl;
import com.yosael.model.Persona;
import com.yosael.service.IPersonaService;

public class PersonaServiceImpl implements IPersonaService{

	private IPersonaDAO dao;
	
	public PersonaServiceImpl(){
		dao = new PersonaDAOImpl();
	}
	
	@Override
	public void registrar(Persona per) throws Exception {
		dao.registrar(per);
	}
		
	@Override
	public void modificar(Persona per) throws Exception {
		dao.modificar(per);		
	}

	@Override
	public List<Persona> listar() throws Exception {
		return dao.listar();
	}
	
	@Override
	public Persona listarPorId(Persona per) throws Exception {
		return dao.listarPorId(per);
	}

}
