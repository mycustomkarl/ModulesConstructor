package Grafiche;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class GraficaLinguaInglese {
	@Id @OneToOne(fetch = FetchType.LAZY) @MapsId
	private long id;
	private String nome;
	private String nomeRidotto;
	private String keyWord;
	
	
	//private Grafica graficaMadre;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeRidotto() {
		return nomeRidotto;
	}

	public void setNomeRidotto(String nomeRidotto) {
		this.nomeRidotto = nomeRidotto;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	/*
	public Grafica graficaMadre() {
		return graficaMadre;
	}
	
	public void addGraficaMadre(Grafica grafica) {
		this.graficaMadre = grafica;
	}
	*/
	public void setPrimaryKey(long key) {
		this.id = key;
	}
}
