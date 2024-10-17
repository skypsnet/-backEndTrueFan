package org.trueFanBoutique.dto;

public class Token {
	private final String accessToken;
	private Long Id;

	public Token(String accessToken, Long Id) {
		this.accessToken = accessToken;
		this.Id = Id;
	}//constructor Token

	
	public String getAccessToken() {
		return accessToken;
	}//getAccessToken


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}
}//class Token 
