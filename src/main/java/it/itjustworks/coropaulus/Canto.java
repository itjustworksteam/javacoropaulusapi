package it.itjustworks.coropaulus;

public class Canto {

	private String nome;
	private String url;
	
	Canto(String nome, String url) {
		this.nome = nome;
		this.url = url;
	}

	public String nome() {
		return this.nome;
	}

	public String url() {
		return this.url;
	}
	
	@Override
	public String toString() {
		String response = "";
		response += "Canto{nome="+ this.nome + ", url="+this.url+"}";
		return response;
	}

	public String prettyToString() {
		return this.nome + " --> https://docs.google.com/viewerng/viewer?url=" + this.url + "\n";
	}

}
