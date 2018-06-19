public class Conta {

	public int numConta;
	public int agencAssociada;
	public String cpfConta;
	
	public Conta() {

	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int auxInteiro) {
		this.numConta = auxInteiro; 
	}

	public int getAgencAssociada() {
		return agencAssociada;
	}

	public void setAgencAssociada(int numAgencAssoc) {
		this.agencAssociada = numAgencAssoc;
	}

	public String getCpfConta() {
		return cpfConta;
	}

	public void setCpfConta(String auxCpfConta) {
		this.cpfConta = auxCpfConta; //Input.readString("Digite CPF: ");
	}
	
}
