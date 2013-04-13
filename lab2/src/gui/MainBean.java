package gui;

import gui.util.Messages;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import recombinador.Recombinador;
import recombinador.Texto;
import recombinador.TipoRecombinacao;

@ManagedBean
@RequestScoped
public class MainBean {

	private static final String SELECIONE_UM_TEXTO_PARA_RECOMBINAR = "Selecione um texto para recombinar.";
	private static final String TEXTO_CADASTRADO_COM_SUCESSO = "Texto cadastrado com sucesso.";
	private static final String DIGITE_UM_TEXTO_PARA_SER_CADASTRADO = "Digite um texto para ser cadastrado.";
	private static final String DIGITE_SEU_TEXTO = "Digite seu texto.";
	
	private String texto = DIGITE_SEU_TEXTO;
	private Texto textoSelecionado;
	private String textoRecombinado;
	private TipoRecombinacao tipoRecombinacao;

	/**
	 * Cadastra novo texto no sistema.
	 */
	public String cadastraTexto() {
		if (!validarTexto(texto)) {
			return "";
		}
		Recombinador rec = Recombinador.getInstance();
		rec.novoTexto(texto);
		Messages.addMsgSucesso(TEXTO_CADASTRADO_COM_SUCESSO);
		texto = DIGITE_SEU_TEXTO;
		return "";
	}

	private boolean validarTexto(String texto2) {
		if (texto == null || texto.equals(DIGITE_SEU_TEXTO)) {
			Messages.addMsgErro(DIGITE_UM_TEXTO_PARA_SER_CADASTRADO);
			return false;
		}
		return true;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Mostra a página dos textos cadastrados.
	 */
	public String listarTextos() {
		return "textos_cadastrados.xhtml";
	}

	/**
	 * Mostra os textos cadastrados no Recombinador.
	 * 
	 * @return lista de Textos
	 */
	public List<Texto> getTextosCadastrados() {
		return Recombinador.getInstance().getTextos();
	}

	public Texto getTextoSelecionado() {
		return textoSelecionado;
	}

	public void setTextoSelecionado(Texto textoSelecionado) {
		this.textoSelecionado = textoSelecionado;
	}
	
	/**
	 * Iniciar a página de recombinação.
	 */
	public String recombinar() {
		if (texto == null) {
			Messages.addMsgErro(SELECIONE_UM_TEXTO_PARA_RECOMBINAR);
			return "";
		}
		setTextoRecombinado("");
		return "recombinador.xhtml";
	}
	
	public String cancelaRecombinacao() {
		setTextoRecombinado("");
		return "index.xhtml";
	}
	
	public String cadastraRecombinacao() {
		Recombinador.getInstance().novoTexto(getTextoRecombinado());
		Messages.addMsgSucesso(TEXTO_CADASTRADO_COM_SUCESSO);
		return "textos_cadastrados.xhtml";
	}

	public String getTextoRecombinado() {
		return textoRecombinado;
	}

	public void setTextoRecombinado(String textoRecombinado) {
		this.textoRecombinado = textoRecombinado;
	}

	public TipoRecombinacao getTipoRecombinacao() {
		return tipoRecombinacao;
	}

	public void setTipoRecombinacao(TipoRecombinacao tipoRecombinacao) {
		this.tipoRecombinacao = tipoRecombinacao;
	}
	
	public TipoRecombinacao[] getTiposRecombinacao() {
		return TipoRecombinacao.values();
	}
	
	public void adicionarLinha() {
		textoRecombinado += Recombinador.getInstance().getLinha(textoSelecionado, tipoRecombinacao);
	}
}