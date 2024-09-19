package encryption;

import org.testng.annotations.Test;

public class AESEncrypTest {

	@Test
	public void sampleTest() throws Throwable {
		String privateKey="Ac03tEam@j!tu_#1";
		String data="{\"name\" : \"gopika\", \"id\" : \"typ-244\"}";
		
		EncryptandDecryptUtility ed= new EncryptandDecryptUtility();
		System.out.println(ed.encrypt(data, privateKey));
		
		System.out.println(ed.decrypt("FqF9K/29A2zzXTuAPjUC7mD2d4B18qqoschpzVv5Ru+D5WHie+5036NOm6kiGZIL", privateKey));
	}
	
}
