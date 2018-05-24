package com.yosael.service;

import java.util.List;

import com.yosael.model.Persona;

public interface IPersonaService {//extends IService<Persona>{
	//si generas con el generico sale conflicto de namespace
	void registrar(Persona t) throws Exception;	
	void modificar(Persona t) throws Exception;
	List<Persona> listar() throws Exception;
	Persona listarPorId(Persona t) throws Exception;
}
