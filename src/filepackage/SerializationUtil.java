package filepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil 
{
	// load from file
	public static Object deserialize(String fileName) throws IOException,
			ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(fileName);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		Object object = objectIn.readObject();
		objectIn.close();
		return object;
	}

	// save into file
	public static void serialize(Object object, String fileName)
			throws IOException {
		FileOutputStream fileOut = new FileOutputStream(fileName);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(object);

		fileOut.close();
	}
}
