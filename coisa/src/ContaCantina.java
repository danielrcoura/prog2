package coisa.src;

/**
* Representacao da conta de uma cantina que sera 
* atribuida a um estudante.
*
* @author Daniel Coura
*/
public class ContaCantina {
	private String nomeCantina;
	private int debito;
	private int qtdItens;
	private String[] detalhes = new String[5];
	private int qtdDetalhes;
	
	/**
     * Constroi uma conta de cantina.
     * Toda conta de cantina começa com debito, quantidade de itens
     * e detalhes vazios.
     * 
     * @param o nome da cantina
     */
	public ContaCantina(String nomeCantina) {
		this.nomeCantina = nomeCantina;
	}
	
	/**
	 * Retorna o nome da cantina.
	 *  
	 * @return o nome da cantina
	 */
	public String getNomeCantina() {
		return this.nomeCantina;
	}
	
	/**
	 * Cadastra lanche comprado atraves da quantidade de itens,
	 * valor total em centavos e detalhe do lanche.
	 * 
	 * @param qtdItens a quantidade de itens consumidos
	 * @param valorCentavos o valor total do lanche em centavos
	 * @param detalhe uma observacao sobre o lanche consumido 
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhe) {
		  this.qtdItens += qtdItens;
		  this.debito += valorCentavos;
		  if (detalhe != null) {
			  this.adicionaDetalhe(detalhe);
		  }
	}
	
	/**
	 * Cadastra lanche comprado atraves da quantidade de itens e 
	 * do valor total em centavos.
	 * 
	 * @param qtdItens a quantidade de itens consumidos
	 * @param valorCentavos o valor total do lanche em centavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		  this.cadastraLanche(qtdItens, valorCentavos, null);
	}
	
	/**
	 * Adiciona detalhe do lanche no array detalhes.
	 * Se o tamanho do array passar de 5, remove-se
	 * o primeiro detalhe passado e adiciona o novo.
	 * 
	 * @param detalhe uma observacao do lanche consumido
	 */
	private void adicionaDetalhe(String detalhe) {
		if (this.qtdDetalhes == 5) {
			String[] arrayTmp = new String[5];
			for (int i = 1; i < 5; i++) {
				arrayTmp[i-1] = this.detalhes[i];
			}
			arrayTmp[4] = detalhe;
			this.qtdDetalhes = 4;
			this.detalhes = arrayTmp;
		}
		this.qtdDetalhes += 1;
		this.detalhes[this.qtdDetalhes - 1] = detalhe;
	}
	
	/**
	 * Lista os detalhes dos ultimos 5 lanches consumidos.
	 * 
	 * @return a lista de detalhes dos lanches
	 */
	public String listarDetalhes() {
		String var = "";
		for (int i = 0; i < 5; i++) {
			var += this.detalhes[i] + ", ";
		}
		return var;
	}
	
	/**
	 * Desconta o valor em centavos do débito da conta da cantina.
	 * 
	 * @param valorCentavos o valor em centavos a ser descontado.
	 */
	public void pagaConta(int valorCentavos) {
		this.debito -= valorCentavos;
	}
	
	/**
	 * Retorna a String que representa a conta da cantina. A representacao
	 * segue o formato: "NOME_CANTINA - QUANTIDADE_ITENS - DEBITO"
	 * 
	 * @return a representacao em String da cantina
	 */
	public String toString() {
		return this.nomeCantina + " - " + this.qtdItens + " - " + this.debito;
	}
}
