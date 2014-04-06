package orgamanager.model.development.ftpupdate.ehcserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FtpUpdateEhcServer { // TODO did not work yet!!!
	
	// from php
//	public function testFtpConnection(){
//	// Verbindung aufbauen
//	echo "* Anmeldeversuch als $this->ftpUser@$this->ftpHost\n";
//	$conn_id = ftp_connect($this->ftpHost) or die("Couldn't connect to $this->ftpHost");
//	if (@ftp_login($conn_id, $this->ftpUser, $this->ftpPass)) {
//		echo "* Angemeldet als $this->ftpUser@$this->ftpHost\n";
//		echo "* Aktuelles Verzeichnis: " . ftp_pwd($conn_id) . "\n";
//	} else {
//		echo "* Anmeldung als $this->ftpUser nicht möglich\n";
//	}
//	ftp_close($conn_id);
//}

//private function copyProjectToServer(){
//	$conn_id = ftp_connect($this->ftpHost);
//	if (@ftp_login($conn_id, $this->ftpUser, $this->ftpPass)) {
//		echo "* Kopiere Projekt auf den Server ... \n";
//		$this->copyFilesToServer($conn_id);
//	} else {
//		die("* Kopieren des Projekts auf den Server nicht möglich.\n");
//	}
//	ftp_close($conn_id);
//}

//private function copyFilesToServer($conn_id){
//	
//	// Verzeichniswechsel in ServerRoot 
//	ftp_chdir($conn_id, $this->pathToServerRoot);
//	
//	// Passivmodus erzwingen, hinter einer Firewall oft notwendig
//	ftp_pasv($conn_id, true);
//	
//	// ---------------------------------------------------------------------
//	// ROOT, delete former files in root
////		$rootFiles = array(
////				"composer.json",
////				"composer.lock",
////				"composer.phar",
////				"init_autoloader.php",
////				"LICENSE.txt",
////				"README.md",
////				"composer.lock",
////		);
////		foreach($rootFiles as $file){
////			// Loeschen
////			if (ftp_delete($conn_id, $file)) {
////				echo "* $file erfolgreich geloescht.\n";
////			} else {
////				echo "* Ein Fehler trat beim Loeschen von $file auf.\n";
////			}
//		
////			// Hochladen
////			if (ftp_put($conn_id, $file, ($this->pathToLocalRoot . $file), FTP_ASCII)) {
////				echo "* $file erfolgreich hochgeladen (von " . ($this->pathToLocalRoot . $file) . " nach " . $file . ");\n";
////			} else {
////				echo "* Ein Fehler trat beim Hochladen von $file auf (von " . ($this->pathToLocalRoot . $file) . " nach " . $file . ");\n";
////			}
////		}
//	
//	// ---------------------------------------------------------------------
//	// config, autoload ordner 
////		$configFiles = array(
////				"config/autoload/global.php",
////				"config/autoload/local.php.dist",
////				"config/autoload/zfcuser.global.php",
////				"config/application.config.php",
////		);
////		foreach($configFiles as $file){
////			// Loeschen
////			if (ftp_delete($conn_id, $file)) {
////				echo "* $file erfolgreich geloescht.\n";
////			} else {
////				echo "* Ein Fehler trat beim Loeschen von $file auf.\n";
////			}
//
////			// Hochladen
////			if (ftp_put($conn_id, $file, ($this->pathToLocalRoot . $file), FTP_ASCII)) {
////				echo "* $file erfolgreich hochgeladen.\n";
////			} else {
////				echo "* Ein Fehler trat beim Hochladen von $file auf.\n";
////			}
////		}
//	
//	// ---------------------------------------------------------------------
//	// data ordner
////		$dataFiles = array(
////				"data/db/db.sqlite"
////		);
////		foreach($dataFiles as $file){
////			// Loeschen
////			if (ftp_delete($conn_id, $file)) {
////				echo "* $file erfolgreich geloescht.\n";
////			} else {
////				echo "* Ein Fehler trat beim Loeschen von $file auf.\n";
////			}
//	
////			// Hochladen
////			if (ftp_put($conn_id, $file, ($this->pathToLocalRoot . $file), FTP_ASCII)) {
////				echo "* $file erfolgreich hochgeladen.\n";
////			} else {
////				echo "* Ein Fehler trat beim Hochladen von $file auf.\n";
////			}
////		}
//	
//	// ---------------------------------------------------------------------
//	// module, Application, config
//	$moduleFiles = array(
//			"module/Application/config/module.config.php",
//			//"module/Application/language/de.php",
//			//"module/Application/language/en.php",
//			//"module/Application/src/Application/Controller/IndexController.php",
//			"module/Ehome/config/module.config.php",
//			"module/Ehome/src/Ehome/Controller/IndexController.php",
//			"module/Ehome/src/Ehome/Controller/JobaUserController.php",
//			"module/Ehome/src/Ehome/Controller/JsonController.php",
//			"module/Ehome/src/Ehome/Entity/JobaEvent.php",
//			"module/Ehome/src/Ehome/Entity/JobaEventTable.php",
//			"module/Ehome/src/Ehome/Filter/JobaEventFilter.php",
//			"module/Ehome/src/Ehome/Form/JobaEventForm.php",
//			"module/Ehome/src/Ehome/Entity/Room.php",
//			"module/Ehome/src/Ehome/Entity/RoomTable.php",
//			"module/Ehome/src/Ehome/Filter/RoomFilter.php",
//			"module/Ehome/src/Ehome/Form/RoomForm.php",
//			"module/Ehome/view/ehome/index/editjobaevent.phtml",
//			"module/Ehome/view/ehome/index/editroom.phtml",
//			"module/Ehome/view/ehome/index/ehometest.phtml",
//			"module/Ehome/view/ehome/index/index.phtml",
//			"module/Ehome/view/ehome/index/indexfunctional.phtml",
//			"module/Ehome/view/ehome/index/indexroom.phtml",
//			"module/Ehome/view/ehome/index/temp.phtml",
//			"module/Ehome/view/ehome/joba-user/login.phtml",
//			"module/Ehome/view/zfc-user/user/login.phtml",
//			"module/Ehome/autoload_classmap.php",
//			"module/Ehome/Module.php",
//	);
//	foreach($moduleFiles as $file){
//		// Loeschen
//		if (ftp_delete($conn_id, $file)) {
//			echo "* $file erfolgreich geloescht.\n";
//		} else {
//			echo "* Ein Fehler trat beim Loeschen von $file auf.\n";
//		}
//		// Hochladen
//		if (ftp_put($conn_id, $file, ($this->pathToLocalRoot . $file), FTP_ASCII)) {
//			echo "* $file erfolgreich hochgeladen.\n";
//		} else {
//			echo "* Ein Fehler trat beim Hochladen von $file auf.\n";
//		}
//	}
//	
//	// ---------------------------------------------------------------------
//	// public
//	$publicFiles = array(
//			"public/index.php",
//			"public/css/style.css",
//			"public/js/script.js",
//			//"public/devscripts/ftpbuild.php",
//			//"public/devscripts/ftpconfig.php",
//			"public/devscripts/ftpupdate.php",
//	);
//	foreach($publicFiles as $file){
//		// Loeschen
//		if (ftp_delete($conn_id, $file)) {
//			echo "* $file erfolgreich geloescht.\n";
//		} else {
//			echo "* Ein Fehler trat beim Loeschen von $file auf.\n";
//		}
//			
//		// Hochladen
//		if (ftp_put($conn_id, $file, ($this->pathToLocalRoot . $file), FTP_ASCII)) {
//			echo "* $file erfolgreich hochgeladen.\n";
//		} else {
//			echo "* Ein Fehler trat beim Hochladen von $file auf.\n";
//		}
//	}
//}
//
//
//// Accessors 
//public function getVersion(){
//	return $this->version;
//}
//
//public function getDate(){
//	return $this->date;
//}
//}
//
//// Start der Prozedur
//echo "\n";
//echo "************************************************************************\n";
//echo "* \n";
//$obj = new FtpUpdate();
//echo "* Update Skript Version " .  $obj->getVersion() . ", " . $obj->getDate() . ";\n";
//echo "* \n";
//$obj->update();
//echo "************************************************************************\n";
//
//?>
	
	private FtpConfigEhcServer config;
	private String pathToServerRoot;
	private String pathToLocalRoot;
	private String ftpHost;
	private String ftpPort;
	private String ftpUser;
	private String ftpPass;

	public FtpUpdateEhcServer() {
		this.config = new FtpConfigEhcServer();
		this.pathToServerRoot = config.getPathToServerRoot();
		this.pathToLocalRoot = config.getPathToLocalRoot();
		this.ftpHost = config.getFtpHost();
		this.ftpPort = config.getFtpPort();
		this.ftpUser = config.getFtpUser();
		this.ftpPass = config.getFtpPass();
	}

	public void update() {
		testFtpConnection();
		copyProjectToServer();
	}

	public void testFtpConnection() {
		// TODO
	}

	public void copyProjectToServer() {
		// FTP usage see
		// codejava.net/java-se/networking/ftp/java-ftp-file-upload-tutorial-and-example
		int port = (int) Integer.parseInt(ftpPort);
		String user = ftpUser;
		String pass = ftpPass;
		String server = ftpHost;
		String localFilePath = "D:/Test/Projects.zip";
		String remoteFileName = "Projects.zip";
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// APPROACH #1: uploads first file using an InputStream
			File firstLocalFile = new File(localFilePath);
			String firstRemoteFile = remoteFileName;
			InputStream inputStream = new FileInputStream(firstLocalFile);
			System.out.println("Start uploading first file");
			boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
			inputStream.close();
			if (done) {
				System.out.println("The first file is uploaded successfully.");
			}
			
			boolean completed = ftpClient.completePendingCommand();
			if (completed) {
				System.out.println("The second file is uploaded successfully.");
			}
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}

