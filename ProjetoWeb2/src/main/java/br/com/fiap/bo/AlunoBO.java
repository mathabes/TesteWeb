package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

public class AlunoBO {
	
	AlunoDAO alunoDao;		
	
	
	public ArrayList<Aluno> secionarBo() throws SQLException, ClassNotFoundException{
		alunoDao = new AlunoDAO();
		return  (ArrayList<Aluno>) alunoDao.selecionar();
	}
	
	public void inserirBo(Aluno aluno) throws ClassNotFoundException, SQLException  {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.inserir(aluno);
	}
	
	public void atualizarBo(Aluno aluno) throws ClassNotFoundException, SQLException  {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.atualizar(aluno);
	}
	
	public void deletarBo(int rm) throws ClassNotFoundException, SQLException {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.deletar(rm);
	}	

}
