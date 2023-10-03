package fr.lixtec.form10.j1.tp.tp2;

import java.util.ArrayList;
import java.util.List;

public class AlgoFrancois {
	public class Message {
		
		private String decrypted;
		private String encrypted;
		
		public Message(String decrypted, String encrypted) {
			this.decrypted = decrypted;
			this.encrypted = encrypted;
		}
		
		public void verifyEncryption() {
			System.out.println("""
				Expected: %s
				Found: %s
				Passed: %s 
			""".formatted(
				this.encrypted,
				encrypt(this.decrypted),
				this.encrypted.equals(encrypt(this.decrypted))
			));
		}
		
		public void verifyDecryption() {
			System.out.println("""
				Expected: %s
				Found: %s
				Passed: %s 
			""".formatted(
				this.decrypted,
				decrypt(this.encrypted),
				this.decrypted.equals(decrypt(this.encrypted))
			));
		}
		
	}
	
	public static final int DEFAULT_SHIFT = 0;
	public static final int N_ALPHA = 26; // number of character in the Latin alphabet
	
	private int shift;
	
	public AlgoFrancois(int shift) {
		this.shift = shift;
	}
	
	public AlgoFrancois() {
		this(DEFAULT_SHIFT);
	}
	
	public int getShift() {
		return this.shift;
	}
	
	public void setShift(int shift) {
		this.shift = shift;
	}
	
	public String encrypt(String message) {
		String ret = "";
		for (char l : message.toCharArray()) {
			char toZero = Character.isLowerCase(l) ? 'a' : 'A';
			ret += Character.isLetter(l)
				? Character.toString((l - toZero + this.shift) % N_ALPHA + toZero)
				: l
			;
		}
		return ret;
	}
	
	public String decrypt(String message) {
		String ret = "";
		for (char l : message.toCharArray()) {
			char toZero = Character.isLowerCase(l) ? 'a' : 'A';
			ret += Character.isLetter(l)
				? Character.toString((l - toZero - this.shift + N_ALPHA) % N_ALPHA + toZero)
				: l
			;
		}
		return ret;
	}

	public static void main(String args[]) {
		final int shift = 23;
		AlgoFrancois algoFrancois = new AlgoFrancois(shift);
		
		List<Message> encryptionTests = new ArrayList<>();
		encryptionTests.add(algoFrancois.new Message("", ""));
		encryptionTests.add(algoFrancois.new Message("az", "xw"));
		encryptionTests.add(algoFrancois.new Message("1,000.00", "1,000.00"));
		encryptionTests.add(algoFrancois.new Message("""
			In cryptography, this cipher is one \
			of the simplest and most widely known \
			encryption techniques.""","""
			Fk zovmqldoxmev, qefp zfmebo fp lkb \
			lc qeb pfjmibpq xka jlpq tfabiv hkltk \
			bkzovmqflk qbzekfnrbp."""));
		
		List<Message> decryptionTests = new ArrayList<>();
		decryptionTests.add(algoFrancois.new Message("az", "xw"));
		decryptionTests.add(algoFrancois.new Message("AZ", "XW"));
		
		for (Message test : encryptionTests)
			test.verifyEncryption();
		for (Message test : decryptionTests)
			test.verifyDecryption();
		
		System.out.println(algoFrancois.decrypt("Gb prfp xr ylrq ab jbp mbfkbp xsbz zbq xidl."));
	}
	
}