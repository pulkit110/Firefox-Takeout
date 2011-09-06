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
public class TransferFrom {

	public TransferFrom() {

	}

	public static void copyFileFrom() throws IOException {
		String appdata = System.getenv("APPDATA");
		File srcFile = new File(appdata + "\\Mozilla\\Firefox\\Profiles");
		File destFile = new File(System.getProperty("user.home") + "\\Desktop\\FireFoxTransform\\places.sqlite");

		if (!srcFile.exists()) {
			throw new IOException("copyFiles: Can not find source: " + srcFile.getAbsolutePath() + ".");
			// System.out.println("Source File path not found!!");
			// System.exit(0);
		} else {
			if (!destFile.exists()) {
				File dir = new File(System.getProperty("user.home") + "\\Desktop\\FireFoxTakeout");
				dir.mkdir();
			} else {
				System.out.println("Floder not exists");
			}

			File[] profileDir = srcFile.listFiles();
			File toCopy = new File(profileDir[0].toString() + "\\places.sqlite");

			InputStream oInStream = new FileInputStream(toCopy);
			OutputStream oOutStream = new FileOutputStream(destFile);

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
