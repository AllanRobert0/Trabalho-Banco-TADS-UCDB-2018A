public class Agencia {
	
	public int numAgencia;
	public String endeAgencia;
	
	
	public Agencia() {
	}
	
	public int getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia() {
		this.numAgencia = Input.readInt("Digite Numero da Agencia: ");
	}

	public String getEndeAgencia() {
		return endeAgencia;
	}

	public void setEndeAgencia() {
		this.endeAgencia = Input.readString("Digite Endereco da Agencia: ");
	}
		
}
