package Grafiche;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Grafica {
	@Id
	private Long id;
	private String imageFilePath;
	private String nomeFile;

	public Grafica() {
		
	}
	
	public String getImageFilePath() {
		return this.imageFilePath;
	}
	
	public String getNomeFile() {
		return this.nomeFile;
	}
	
	public void setImageFilePath(String path) {
		this.imageFilePath = path;
	}
	
	public void setNomeFile(String nome) {
		this.nomeFile = nome;
	}
	
	@Override
	public String toString() {
		return ("Immagine con nome: " + nomeFile +", al percorso: " + imageFilePath);
	}
	
	public void setPrimaryKey(long key) {
		this.id = key;
	}
	
	public long getId() {
		return this.id;
	}

}
