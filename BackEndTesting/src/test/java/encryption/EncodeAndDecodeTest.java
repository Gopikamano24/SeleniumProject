package encryption;

import org.testng.annotations.Test;

import java.util.Base64;

public class EncodeAndDecodeTest {

	
	@Test
	public void encodingAndDecodingData() {
		String str=new String(Base64.getEncoder().encode("gopika:kandhasamy35".getBytes()));
		System.out.println(str);
		
		String str1=new String(Base64.getDecoder().decode("cm1neWFudHJhOnJtZ3lAOTk5OQ==".getBytes()));
		System.out.println(str1);
		
	}
}
