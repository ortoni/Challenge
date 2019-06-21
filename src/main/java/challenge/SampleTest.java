package challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SampleTest {
	private static final String IP = "192.168.1.3";
	private static final int PORT = 4451;

	private RemoteWebDriver driver;
	private ActiveNodeDeterminer determiner = new ActiveNodeDeterminer(IP, PORT);
	ChromeOptions options;
	Capabilities caps;
	DesiredCapabilities dc;
	HashMap<String, Object> prefs;

	@BeforeClass
	public void setup() throws Exception {
		URL url = new URL("http://" + IP + ":" + PORT + "/wd/hub");
		/*
		 * HashMap<String, Object> setPath = new HashMap<String, Object>(); //
		 * setPath.put("download.default_directory", file.getAbsolutePath()); // To set
		 * // path setPath.put("safebrowsing.enabled", "false"); // To disable security
		 * check
		 * 
		 * HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		 * options = new ChromeOptions(); options.setExperimentalOption("prefs",
		 * setPath); options.addArguments("--disable-extensions"); FirefoxOptions op =
		 * new FirefoxOptions(); op.setCapability("version", "67.0");
		 * op.setCapability("platform", "WIN10"); // dc = DesiredCapabilities.firefox();
		 * // Adding capabilities
		 * 
		 * dc.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		 * dc.setCapability(ChromeOptions.CAPABILITY, options);
		 * 
		 * 
		 * dc.setVersion("67.0"); dc.setPlatform(Platform.WIN10);
		 * 
		 * 
		 * driver = new RemoteWebDriver(url, op);
		 */
		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.dir", "K:\\");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.skipWinSecurityPolicyChecks", false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.hide_plugins_without_extensions", true);
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("pdfjs.enableWebGL", false);
		profile.setPreference("pdfjs.enabIedCache.initialized", true);
		profile.setPreference("pdfjs.enabIedCache.state", false);
		profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", true);
		profile.setPreference("pdfjs.renderer", false);
		profile.setPreference("pdfjs.enabledCache.initialized", true);
		profile.setPreference("pdfjs.enabledCache.state", false);
		profile.setPreference("browser.download.useToolkitUI", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.helperApps.neverAsk.openFile",
				"text/plain,application/octet-stream,application/pdf,application/x-pdf,application/vnd.pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/x-excel, application/x-msexcel, application/excel, application/vnd.ms-excel");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
//		options.setCapability("marionette", false);
		DesiredCapabilities dc = new DesiredCapabilities();
//		DesiredCapabilities.firefox();
		dc.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		dc.setCapability(FirefoxProfile.ALLOWED_HOSTS_PREFERENCE, profile);
//		dc.setCapability("marionette", false);

		/*
		 * dc.setBrowserName("firefox"); dc.setVersion("67.0");
		 * dc.setPlatform(Platform.WIN10); options.se
		 */

		driver = new RemoteWebDriver(url, dc);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {
		System.out.println("Node : " + determiner.getNodeInfoForSession(driver.getSessionId()));
		driver.get("http://leafground.com/pages/download.html");
		driver.findElementByLinkText("Download xls").click();
		Thread.sleep(10000);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

class ActiveNodeDeterminer {
	private String gridHostName;
	private int gridPort;

	private static final Logger LOGGER = Logger.getLogger(ActiveNodeDeterminer.class.getCanonicalName());

	/**
	 *
	 * @param gridHostName - The host where the Grid Hub is running.
	 * @param gridPort     - The port on which the Grid port is listening to.
	 */
	public ActiveNodeDeterminer(String gridHostName, int gridPort) {
		this.gridHostName = gridHostName;
		this.gridPort = gridPort;
	}

	/**
	 * @param sessionId - A {@link SessionId} object that represents a valid
	 *                  session.
	 * @return - A {@link GridNode} object that represents the node to which the
	 *         session was routed to.
	 */
	public GridNode getNodeInfoForSession(SessionId sessionId) {
		GridNode node = null;
		CloseableHttpClient client = HttpClientBuilder.create().build();
		CloseableHttpResponse response = null;
		try {
			URL url = new URL("http://" + gridHostName + ":" + gridPort + "/grid/api/testsession?session=" + sessionId);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("GET", url.toExternalForm());
			response = client.execute(new HttpHost(gridHostName, gridPort), r);
			JsonObject object = extractJson(response.getEntity());
			URL tempUrl = new URL(object.get("proxyId").getAsString());
			node = new GridNode(tempUrl.getHost(), tempUrl.getPort());
		} catch (Exception e) {
			String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: " + e.getMessage();
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new RuntimeException(errorMsg, e);
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		LOGGER.info("Session " + sessionId + " was routed to " + node.toString());
		return node;
	}

	private JsonObject extractJson(HttpEntity entity) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()))) {
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			return new JsonParser().parse(builder.toString()).getAsJsonObject();
		}
	}

	/**
	 * A simple POJO (Plain Old Java Object) class that represents a Node in the
	 * Selenium Grid environment.
	 */
	public static class GridNode {
		private String nodeIp;
		private int nodePort;

		public GridNode(String nodeIp, int nodePort) {
			this.nodeIp = nodeIp;
			this.nodePort = nodePort;
		}

		/**
		 * @return - A String that represents the IP Address of the node.
		 */
		public String getNodeIp() {
			return this.nodeIp;
		}

		/**
		 * @return - An int that represents the port number of the node.
		 */
		public int getNodePort() {
			return this.nodePort;
		}

		@Override
		public String toString() {
			return "GridNode [IP='" + nodeIp + "', Port=" + nodePort + "]";
		}
	}
}