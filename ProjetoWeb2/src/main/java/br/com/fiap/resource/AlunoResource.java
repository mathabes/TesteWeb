package br.com.fiap.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.beans.Aluno;
import br.com.fiap.bo.AlunoBO;



@Path("/aluno")
public class AlunoResource {
	

	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar() {
		return "Teste Novo Yeah!";	}*/
		
	
	private AlunoBO alunoBO = new AlunoBO();	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Aluno> buscar() throws SQLException, ClassNotFoundException {
		return (ArrayList<Aluno>) alunoBO.secionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs (Aluno aluno, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		alunoBO.inserirBo(aluno);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(aluno.getRm()));
		return Response.created(builder.build()).build();		
	}
	
	@PUT
	@Path("/{rm}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizaRs (Aluno aluno, @PathParam("rm") int rm) throws SQLException, ClassNotFoundException {
		alunoBO.atualizarBo(aluno);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{rm}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteRs (@PathParam("rm") int rm) throws ClassNotFoundException, SQLException {
		alunoBO.deletarBo(rm);
		return Response.ok().build();
	}
}
