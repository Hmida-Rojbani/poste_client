package tn.poste.client.data.dto;

import java.lang.reflect.Field;

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

	public boolean checkAllNotNull() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields())
	        if (!f.getName().equals("id") && ( f.get(this) == null || ((String)f.get(this)).isEmpty()))
	            return false;
	    return true;            
	}
}
