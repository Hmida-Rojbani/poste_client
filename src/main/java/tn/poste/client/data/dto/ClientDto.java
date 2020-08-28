package tn.poste.client.data.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
	
	private long id;
	@NotBlank(message ="Name must exist")
	private String name;
	private String number;

}
