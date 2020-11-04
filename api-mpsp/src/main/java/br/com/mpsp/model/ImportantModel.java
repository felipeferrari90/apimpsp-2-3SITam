package br.com.mpsp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_IMPORTANT")
public class ImportantModel {

	int id;
	String titulo;
	String mensagem;
	String url;
	
	
	
	public ImportantModel(int id, String titulo, String mensagem, String url) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.url = url;
	}
	
	@Id
	@Column(name = "ID_IMPORTANT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    @SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "TITULO")
	@NotNull
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name = "MENSAGEM", columnDefinition="CLOB")
	@NotBlank
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Column(name = "URLSITE", columnDefinition ="CLOB")
	@NotBlank
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
