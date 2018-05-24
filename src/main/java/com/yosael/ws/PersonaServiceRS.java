package com.yosael.ws;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.yosael.model.Persona;
import com.yosael.service.IPersonaService;
import com.yosael.service.impl.PersonaServiceImpl;

@Path("/personas")
public class PersonaServiceRS {
	
	private IPersonaService personaService;
	
	public PersonaServiceRS() {
		personaService = new PersonaServiceImpl();
	}
	
	@POST
	@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response agregarPersona(Persona persona) {
		try {
			return Response.ok().entity(persona).build();
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Consumes(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{id}")
	public Response modificarPersona(@PathParam("id") int id, Persona personaModificada) {
		try {
			//Persona persona = personaService.modificar(personaModificada);
			//if(persona!=null) {
				personaService.modificar(personaModificada);
				return Response.ok().entity(personaModificada).build();
			/*}
			else {
				return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			}*/
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	/*
	@DELETE
	@Path("{id}")
	public Response eliminarPersona(@PathParam("id") int id) {
		try {
			personaService.(new Persona(id));
			return Response.ok().build();
		} catch (Exception e) {
			return Response.status(404).build();
		}
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")// hace referencia a /personas/{id}
	public Persona buscarPersonaPorId(@PathParam("id") int id) {
		System.out.println("Entro a buscar personas por ID");
		try {
			Persona per = new Persona();
			per.setIdPersona(2);
			per.setNombres("Edwin");
			per.setApellidos("Gutierrez");
			per.setDireccion("direccion01");
			per.setFechaNac(new Date());
			//per.getFoto();
			per.setSexo("M");
			
			//return personaService.listarPorId(new Persona(id));
			return per;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> listarPersonas(){
		try {
			return personaService.listar();
		} catch (Exception e) {
			return null;
		}
		
	}

}
