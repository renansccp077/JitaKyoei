package br.ufpi.pdsi2.test;

import static org.junit.Assert.assertEquals;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.facade.AppFacadeImpl;
import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.view.AppView;
import org.fpij.jitakyoei.view.MainAppView;
import org.junit.Test;

public class testesPdsi2 {
	AppView view = new MainAppView();
	AppFacade facade = new AppFacadeImpl(view);

	@Test (expected=Exception.class)
	public void testeCPFInvalido() throws Exception{
		Filiado filiado = new Filiado();
		filiado.setCpf("12345678910");
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	@Test (expected=Exception.class)
	public void testeLetraCPF() throws Exception{
		Filiado filiado = new Filiado();
		filiado.setCpf("12sdfsdf910");
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	@Test 
	public void testeCPFValido() throws Exception {
		String cpf = "04516322307";
		Filiado filiado = new Filiado();
		filiado.setCpf(cpf);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		String cpfCadastrado = facade.searchAluno(aluno).get(0).getFiliado().getCpf();
		assertEquals("Não são iguais", cpf, cpfCadastrado);
		
	}
	
	@Test (expected=Exception.class)
	public void verificarNumeroCampoNome() throws Exception {
		String nome = "Ren4n";
		Filiado filiado = new Filiado();
		filiado.setNome(nome);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		String nomeCadastrado = facade.searchAluno(aluno).get(0).getFiliado().getNome();
		assertEquals("Não são iguais", nome, nomeCadastrado);
	}
	
	@Test (expected=Exception.class)
	public void verificarEmailInvalido() throws Exception{
		String email = "renangmailcom";
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		String emailCadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEmail();
		assertEquals("Não são iguais", email, emailCadastrado);
	}
	
	@Test (expected=Exception.class)
	public void verificarInconsistenciaRegistro() throws Exception{
		
		Filiado filiado1 = new Filiado();
		Filiado filiado2 = new Filiado();
		
		filiado1.setRegistroCbj("123");
		filiado2.setRegistroCbj("123");
		
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		aluno1.setFiliado(filiado1);
		aluno2.setFiliado(filiado2);
	}
	
	@Test (expected=Exception.class)
	public void verificarEstadoInvalido() throws Exception{
		String estado = "EstadoInvalido";
		Endereco end = new Endereco();
		end.setEstado(estado);
		Filiado filiado = new Filiado();
		filiado.setEndereco(end);
	}
	
	@Test (expected=Exception.class)
	public void verificarLetraCEP() throws Exception{
		String cep = "12d2";
		Endereco end = new Endereco();
		end.setCep(cep);
		Filiado filiado = new Filiado();
		filiado.setEndereco(end);
		
	}
}
