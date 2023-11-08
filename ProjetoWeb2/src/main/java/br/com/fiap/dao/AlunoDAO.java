package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Aluno;
import br.com.fiap.conexoes.ConexaoFactory;

public class AlunoDAO {
	
	public Connection minhaConexao;
	
	public AlunoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Insert 
	public String inserir (Aluno aluno) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Insert into T_FIAP_ALUNO values (?, ?, ?, ?)");
			stmt.setInt(1, aluno.getRm());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getTurma());
			stmt.setDouble(4, aluno.getNota());
			stmt.execute();
			stmt.close();			
		return "Cadastrado com Sucesso!";
	}
	
	// Delete
	public String deletar(int rm) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				("Delete from T_FIAP_ALUNO where RM = ?");
			stmt.setInt(1, rm);
			stmt.execute();
			stmt.close();		
		return "Deletado com Sucesso!";
	}
	// UpDate 
	public String atualizar(Aluno aluno) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement
				(" Update T_FIAP_ALUNO set NOME = ?, TURMA = ?, "
						+ "  NOTA = ? where RM = ?");
				stmt.setString(1, aluno.getNome());
				stmt.setString(2, aluno.getTurma());
				stmt.setDouble(3, aluno.getNota());
				stmt.setInt(4, aluno.getRm());
				stmt.executeUpdate();
				stmt.close();	
		return "Atualizado com Sucesso!";
	}
	// Select 
	public List<Aluno> selecionar() throws SQLException{
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		PreparedStatement stmt = minhaConexao.prepareStatement
				("SELECT * FROM T_FIAP_ALUNO");
		
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setRm(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setTurma(rs.getString(3));
				aluno.setNota(rs.getDouble(4));
				listaAluno.add(aluno);
			}		
		return listaAluno;		
	}
	

}
