package br.com.agenda.teste;

import java.sql.SQLException;
import br.com.agenda.dao.ListaTarefasDAO;

public class ListaTarefasTeste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		LocalDAO local = new LocalDAO();
		System.out.println(local.listarTudo());
		
		UsuarioDAO usuario = new UsuarioDAO();
		System.out.println(usuario.listarTudo());
		*/
		
		ListaTarefasDAO dao = new ListaTarefasDAO();
		dao.insert("Ir a barbearia", "Arrumar o cabelo e a barba", 2, 1);
	}
}