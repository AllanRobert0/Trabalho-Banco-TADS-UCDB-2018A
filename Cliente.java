public class Cliente {
	
	public String cpfCliente;
	public String nomeCliente;
	public int telefCliente;
	public String cpfIndicou;
	
	
	public Cliente() {
		
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente() {
		this.cpfCliente = Input.readString("Digite CPF do Cliente: ");
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente() {
		this.nomeCliente = Input.readString("Digite Nome do Cliente: ");
	}


	public int getTelefCliente() {
		return telefCliente;
	}


	public void setTelefCliente() {
		this.telefCliente = Input.readInt("Digite Telefone do Cliente: ");
	}


	public String getCpfIndicou() {
		return cpfIndicou;
	}


	public void setCpfIndicou() {
		this.cpfIndicou = Input.readString("Digite CPF de Quem Indicou \n   *Caso nao haja digite '0':  ");
	}
	
}
