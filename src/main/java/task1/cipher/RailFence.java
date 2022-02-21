package task1.cipher;

public class RailFence {
	
	public String encode(String message, int key) {
		if (key <= 0) {
			throw new RuntimeException("Key can`t be less then 1");
		}
		
		if (message.equals("")) {
			return "";
		}
		
		StringBuilder encodedMessage = new StringBuilder();
		
		for (int i = 0; i < key; i++) {
			int iterator = 0;
			for (int j = i; j < message.length(); j += getSpace(iterator++, i, key)) {
				encodedMessage.append(message.charAt(j));
			}
		}
		return encodedMessage.toString();
	}

	public String decode(String message, int key) {
		if (key <= 0) {
			throw new RuntimeException("Key can`t be less then 1");
		}
		
		if (message.equals("")) {
			return "";
		}
		
		StringBuilder decodedMessage = new StringBuilder(message);
		int currentPosition = 0;
		for (int i = 0; i < key; i++) {
			int iterator = 0;
			for (int j = i; j < message.length(); j += getSpace(iterator++, i, key)) {
				decodedMessage.setCharAt(j, message.charAt(currentPosition++));
			}
		}
		return decodedMessage.toString();
	}
	
	private int getSpace(int iteration, int row, int size) {
		if (size == 0 || size == 1) {
			return 1;
		}
		if (row == 0 || row == size - 1) {
			return (size - 1) * 2;
		}
		
		if (iteration % 2 == 0) {
			return (size - row - 1) * 2;
		}
		return 2 * row;
	}
}
