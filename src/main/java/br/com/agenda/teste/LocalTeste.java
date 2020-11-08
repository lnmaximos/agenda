package br.com.agenda.teste;

import java.sql.SQLException;
import br.com.agenda.dao.LocalDAO;

public class LocalTeste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/*
		LocalDAO dao = new LocalDAO();
		
		dao.inserir("Cooper");
	    
		
		LocalDAO dao = new LocalDAO();
		System.out.println("Lista antes de atualizar");
		System.out.println(dao.listarTudo());
		
		LocalDAO daoUpdate = new LocalDAO();
		daoUpdate.alterar("Centrais Elétricas de SC", 2L);
		
		System.out.println("Lista atualizada:");
		LocalDAO pesq = new LocalDAO();
		System.out.println(pesq.listarTudo());
	   */
		
		LocalDAO dao = new LocalDAO();
		System.out.println("Lista antes de atualizar");
		System.out.println(dao.listarTudo());
		
		LocalDAO del = new LocalDAO();
		del.excluir(3L);
		
		System.out.println("Lista atualizada:");
		LocalDAO pesq = new LocalDAO();
		System.out.println(pesq.listarTudo());
		
		
	}
}