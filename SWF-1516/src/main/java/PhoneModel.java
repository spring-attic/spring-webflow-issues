import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.ScriptAssert;


@ScriptAssert(lang = "javascript", script = "_this.phone1.equals(_this.phone2)", message="Phone numbers must match")
public class PhoneModel implements Serializable {
	
	
	@NotBlank
	private String phone1;
	
	@NotBlank
	private String phone2;

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	

}
