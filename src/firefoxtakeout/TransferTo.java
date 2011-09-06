/*
 */

package firefoxtakeout;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JOptionPane;

/**
 * @author hp
 */
public class TransferTo {

	public TransferTo() {
	}

	public static void copyFileTo() throws IOException {
		String appdata = System.getenv("APPDATA");
		File srcFile = new File(System.getProperty("user.home") + "\\Desktop\\FireFoxTakeout\\places.sqlite");
		File destFile = new File(appdata + "\\Mozilla\\Firefox\\Profiles");

		if (!srcFile.exists()) {
			JOptionPane.showMessageDialog(null, "Firefox Transfor Directory not found on Desktop!", "Transfer Failed", JOptionPane.PLAIN_MESSAGE);
			throw new IOException("copyFiles: Can not find source: " + srcFile.getAbsolutePath() + ".");
		} else {
			File[] profileDir = destFile.listFiles();
			File dest = new File(profileDir[0].toString() + "\\places.sqlite");

			InputStream oInStream = new FileInputStream(srcFile);
			OutputStream oOutStream = new FileOutputStream(dest);

			byte[] oBytes = new byte[1024];
			int nLength;
			BufferedInputStream oBuffInputStream = new BufferedInputStream(oInStream);
			while ((nLength = oBuffInputStream.read(oBytes)) > 0) {
				oOutStream.write(oBytes, 0, nLength);
			}

			oInStream.close();
			oOutStream.close();

			JOptionPane.showMessageDialog(null, "Inpainting is completed.", "Inpainting", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
