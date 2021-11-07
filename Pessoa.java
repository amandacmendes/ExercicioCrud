package exercicioCrud.ExercicioCrud;

public class Pessoa {

	private String nome;
	private String cpf;
	private String dataNasc;
	private String email;
	private String telefone;
	
	public Pessoa(){ 
	}
	
	public Pessoa(String nome, String cpf, String dataNasc, String email, String telefone){
		this.nome = nome;
		this.cpf = cpf;		
		this.dataNasc = dataNasc;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
