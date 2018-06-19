								//CONFORME VAI ACESSANDO O MENU VAI CADASTRANDO
public class Classe_Principal { //VERIFICAR EXISTENCIA DE AGENCIA AO CRIAR CONTA 
								//1 - AGENCIA   , 2 - CLIENTE , 
	public static void CadastraAgencia(Agencia vetAgencia[],int indAgencia){
		
		System.out.println("\nCadstrando Agencia Numero  "+(indAgencia+1)+" de "+vetAgencia.length);
		
		vetAgencia[indAgencia] = new Agencia();
		vetAgencia[indAgencia].setNumAgencia();
		vetAgencia[indAgencia].setEndeAgencia();
		
	}
	
	public static void CadastraCliente(Cliente vetCliente[],int indCliente){
		
		System.out.println("\nCadstrando Cliente Numero  "+(indCliente+1)+" de "+vetCliente.length);
		
		vetCliente[indCliente] = new Cliente();
		
		vetCliente[indCliente].setNomeCliente();
		vetCliente[indCliente].setCpfCliente();
		vetCliente[indCliente].setTelefCliente();
		vetCliente[indCliente].setCpfIndicou();
		
	}
	
	public static void CadastrarConta(int indAgencia, int indCliente, int indConta, Agencia[] vetAgencia,
			Cliente[] vetCliente, Conta[] vetConta) {
		
		System.out.println("\nCriando Conta Numero  "+(indConta+1)+" de "+vetConta.length);
		
		vetConta[indConta] = new Conta();
		
		int auxInteiro = Input.readInt("Digite Agencia Associada: ");
		
		while(verifAgencia(auxInteiro, indAgencia, vetAgencia) == false) {//PROCURA A EXISTENCIA
			auxInteiro = Input.readInt("Digite Agencia Associada: ");
		}
		
		vetConta[indConta].setAgencAssociada(auxInteiro);  
		
		String auxString = Input.readString("Digite o CPF: ");
		
		while(verifCpf(auxString, indCliente, vetCliente) == false) {//PROCURA A EXISTENCIA
			auxString = Input.readString("Digite CPF: ");
		}		
		vetConta[indConta].setCpfConta(auxString);
		
		auxInteiro = Input.readInt("Digite Numero da Conta: ");
		
		while(verifNUMconta(auxInteiro, indConta, vetConta) == true) {//PROCUARA A NAO EXISTENCIA
			auxInteiro = Input.readInt("Digite Numero da Conta: ");
		}
		
		vetConta[indConta].setNumConta(auxInteiro);
		System.out.println("FIM");
		
	}	
	
	public static boolean verifNUMconta(int auxInteiro, int indConta, Conta[] vetConta) {
		boolean auxExiste = false;

		for (int i = 0; i < indConta; i++) {
			
			if(vetConta[i].getNumConta() == auxInteiro) {
				System.out.println("\n    ! Conta Com Num ja Inexistente !    \nTente Novamente.\n");
				return true;
			}
		}
		return auxExiste;
	}

	public static boolean verifCpf(String auxCpfConta, int indCliente, Cliente[] vetCliente) {
		
		boolean auxExiste = false;
		
		for (int i = 0; i < indCliente; i++) {
			
			if((vetCliente[i].getCpfCliente()).equals(auxCpfConta))
				return true;
				
		}
		System.out.println("\n    ! Cliente Inexistente !    \nTente Novamente.\n");
		return auxExiste;
	}

	public static boolean verifAgencia(int auxAgenciaAssociada, int indAgencia, Agencia[] vetAgencia) {
		
		boolean auxExiste = false;
		
		for (int i = 0; i < indAgencia; i++) {
			if(vetAgencia[i].getNumAgencia() == auxAgenciaAssociada)
				return true;
		}
		System.out.println("\n    ! Agencia Inexistente !    \nTente Novamente.\n");
		return auxExiste;
	}

	public static void contaPorAgencia(int indConta, Conta[] vetConta, int indCliente, Cliente[] vetCliente) {
		
		boolean NENHUM = true;
		
		int NumAgenc = Input.readInt("Digite Num. Agencia Desejado: ");
		
		for (int i = 0; i < indCliente; i++) {
			if (NumAgenc == vetConta[i].agencAssociada) {
				NENHUM = false;
				System.out.println("");
				
				System.out.println("\nNumero da Conta: "+vetConta[i].getNumConta()+"\nNome: "+encontraNome(vetCliente,indCliente, vetConta[i].getCpfConta()));
				
			}
		}	
		if(NENHUM == true)
			System.out.println("\n   Nenhum Encontrado");
	}
	
	public static void contaPorCliente(int indConta, Conta[] vetConta) {
		
		boolean NENHUM = true;
		String auxString = Input.readString("\n Digite CPF desejado: ");
		
		for (int i = 0; i < indConta; i++) {
			
			if(auxString.equals(vetConta[i].getCpfConta())) {
				NENHUM = false;
				System.out.println("\n  Numero da Agencia: "+vetConta[i].getAgencAssociada()
						+ "\n  Numero Conta: "+vetConta[i].getNumConta());
			}
		}
		if(NENHUM == true)
			System.out.println("\n   Nenhum Encontrado");
	}	
	
	public static String encontraNome(Cliente[] vetCliente, int indCliente, String cpfConta) {
		
		for (int i = 0; i < indCliente; i++) {
			
			if(vetCliente[i].getCpfCliente().equals(cpfConta))
				return vetCliente[i].getNomeCliente();
		}
		return "oi";
	}
	
	private static void ClientePorAgencia(int indAgencia, int indCliente, int indConta, Agencia[] vetAgencia,
			Cliente[] vetCliente, Conta[] vetConta) {
		
		boolean NENHUM = true;
		int auxInt = Input.readInt("\n Digite Num Agencia desejado: ");
		
		for (int i = 0; i < indConta; i++) {
			
			if(auxInt == vetConta[i].getAgencAssociada()) {
				NENHUM = false;
				String auxCPF = vetConta[i].getCpfConta();
				
				imprimeNomeCPF(auxCPF,indCliente, vetCliente);
				//ENCONTRAR PESSO C ESSE CPF : NOME E TELEFONE
				
			}
		}
		if(NENHUM == true)
			System.out.println("\n   Nenhum Encontrado");
	}

	public static void imprimeNomeCPF(String auxCPF, int indCliente, Cliente[] vetCliente) {
		
		for (int i = 0; i < indCliente; i++) {
			if(auxCPF.equals(vetCliente[i].getCpfCliente()))
				System.out.println("\n  Nome: "+vetCliente[i].getNomeCliente()
						+"\n  Telefone: "+vetCliente[i].getTelefCliente());
		}
		
	}	

	public static int SwCase(
			int indAgencia, int indCliente, int indConta, 
			Agencia[] vetAgencia, Cliente[] vetCliente, Conta[] vetConta
			){
		
		int retorno;
		//int OPC = printMenu();
		int OPC = Input.readInt(  
				"\nMenu Principal: \n   "
				+ "1.Cadastrar Agencia ("+(indAgencia)+"/"+vetAgencia.length+")\n   "
				+ "2.Cadastrar Cliente ("+(indCliente)+"/"+vetCliente.length+")\n   "
				+ "3.Cadastrar Conta   ("+(indConta)+"/"+vetConta.length+")\n   "
				+ "4.Contas Por Agencia\n   "
				+ "5.Contas Por Cliente\n   "
				+ "6.Clientes Por Agencia\n   "
				+ "0.SAIR \nEscolha Uma Opcao:"
				);
				
		switch(OPC) {
			
			case 1:
				retorno = 1;
				
				if((vetAgencia.length ) == indAgencia )
					retorno = 11;
				else	
				CadastraAgencia(vetAgencia, indAgencia);
				
				return retorno;
				
			case 2:
				retorno = 2;
				
				if((vetCliente.length ) == indCliente)
					retorno = 12;
				else
				CadastraCliente(vetCliente, indCliente);
				
				return retorno;
			case 3:
				retorno = 3;
				if(indCliente == 0)//VERIFICA EXISTENCIA DE CLIENTES
					retorno = 15;
				else if(indAgencia == 0 )//VERIFICA EXISTENCIA DE AGENCIAS
					retorno = 14;
				else if((vetConta.length ) == indConta) //VERIFICA SE LIMITE FOI ATINGIDO
					retorno = 13;
				else
					CadastrarConta( indAgencia,  indCliente,  indConta,  vetAgencia,  vetCliente, vetConta);
				return retorno;
				
			case 4:
				retorno = 4;
				if(indAgencia == 0 || indCliente == 0 || indConta == 0)
					retorno = 16;
				else
				contaPorAgencia(indConta,vetConta, indCliente, vetCliente);
				return retorno;
			case 5:
				retorno = 5;
				if(indAgencia == 0 || indCliente == 0 || indConta == 0)
					retorno = 16;
				else
				contaPorCliente(indConta,vetConta);
				return retorno;
			case 6:
				retorno = 6;
				if(indAgencia == 0 || indCliente == 0 || indConta == 0)
					retorno = 16;
				else
				ClientePorAgencia(indAgencia,indCliente,indConta,vetAgencia,vetCliente,vetConta);
				return retorno;
			case 0:
				System.out.println("\n     Finalizando Programa .. Allan Roberto @2018 TADS UCDB\n");
				return 0;
			default:
				//System.out.println("Opcao invalida. Tente novamente.");
				return 20;
		}
		//return 0;
	}

	public static void main(String[] args) {
		
		System.out.println("       Bem Vindo ao Sistema Bancario\n  Iniciando....\n");
		
		int indAgencia = 0;
		int indCliente = 0;
		int indConta = 0;
							//	numero MAX = vetor.length
		Agencia vetAgencia [] = new Agencia [Input.readInt("Digite Quantidade MAX de Agencias: ")];
		Cliente vetCliente [] = new Cliente [Input.readInt("Digite Quantidade MAX de Clientes: ")];
		Conta vetConta [] = new Conta [Input.readInt("Digite Quantidade MAX de Contas: ")];
		
		boolean ContinuaLoop = true;
		
		while( ContinuaLoop == true){
			
			switch(SwCase(indAgencia,indCliente,indConta,vetAgencia,vetCliente,vetConta)) {
		
				case 1:
					indAgencia++;
					break;
				case 2:
					indCliente++;
					break;
				case 3:
					indConta++;
					break;
				case 4:
					//OPERACAO 4,5 OU 6 CONCLUIDAS
					break;
				case 11:
					System.out.println("\n    ! Limite MAX de Agencias Atingido !");
					break;
				case 12:
					System.out.println("\n    ! Limite MAX de Clientes Atingido !");
					break;
				case 13:
					System.out.println("\n    ! Limite MAX de Contas Atingido !");
					break;
				case 14:
					System.out.println("\n    ! Operacao Invalida ! \n   Nao existem Agencias Cadastrados");
					break;
				case 15:
					System.out.println("\n    ! Operacao Invalida ! \n Nao existem Clientes Cadastrados");
					break;
				case 16:
					System.out.println("\n    ! Dados Cadastrados Insuficientes ! \n   Realize cadastros antes de prosseguir.");
					break;
				case 0: //FINALIZAR PROGRAMA
					ContinuaLoop = false;
					break;
				case 20:
					System.out.println("\nOpcao invalida. Tente novamente.");
					break;
			}
		}
	}
}
