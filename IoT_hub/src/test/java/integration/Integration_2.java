package integration;

import java.util.Arrays;

import org.apache.http.client.fluent.Request;

import iot_sim.SimConfig;
import iot_sim.Main;

public class Integration_2 {
	private static final String broker = "tcp://brokergrupo6.ddns.net:1883";
	private static final String topicPrefix = System.currentTimeMillis()+"/integration_2/iot_hub";

	public static void main(String[] args) throws Exception {
		SimConfig config = new SimConfig(
			8080, Arrays.asList("xxxx", "yyyy", "zzzz.789"), broker, "testee/iot_sim", topicPrefix);

		try (Main m = new Main(config))
		{
			Integration.run(new Integration_2(), 10);
		}
	}

	private String get(String pathParams) throws Exception {
		return Request.Get("http://127.0.0.1:8080"+pathParams)
			.userAgent("Mozilla/5.0")
			.connectTimeout(1000)
			.socketTimeout(1000)
			.execute().returnContent().asString();
	}

	public boolean testCase00() throws Exception {
		String ret = get("/xxxx");
		return (ret.indexOf("xxxx is off") != -1)
			&& (ret.indexOf("xxxx is on") == -1)
			&& (ret.indexOf("Power reading is 0.000") != -1);
	}

	public boolean testCase01() throws Exception {
		String ret = get("/xxxx?action=on");
		return (ret.indexOf("xxxx is on") != -1)
			&& (ret.indexOf("xxxx is off") == -1);
	}

	public boolean testCase02() throws Exception {
		String ret = get("/xxxx?action=off");
		return (ret.indexOf("xxxx is off") != -1)
			&& (ret.indexOf("xxxx is on") == -1);
	}

	public boolean testCase03() throws Exception {
		String ret = get("/xxxx?action=on");
		return (ret.indexOf("xxxx is on") != -1)
			&& (ret.indexOf("xxxx is off") == -1);
	}

	public boolean testCase04() throws Exception {
		String ret = get("/xxxx?action=toggle");
		return (ret.indexOf("xxxx is off") != -1)
			&& (ret.indexOf("xxxx is on") == -1);
	}

	public boolean testCase05() throws Exception {
		String ret = get("/xxxx?action=toggle");
		return (ret.indexOf("xxxx is on") != -1)
			&& (ret.indexOf("xxxx is off") == -1);
	}

	public boolean testCase06() throws Exception {
		String ret = get("/yyyy");
		return (ret.indexOf("yyyy is off") != -1)
			&& (ret.indexOf("yyyy is on") == -1);
	}

	public boolean testCase07() throws Exception {
		String ret = get("/xxxx");
		return (ret.indexOf("xxxx is on") != -1)
			&& (ret.indexOf("xxxx is off") == -1);
	}

	public boolean testCase08() throws Exception {
		String ret = get("/zzzz.789");
		return (ret.indexOf("Power reading is 0.000") != -1);
	}

	public boolean testCase09() throws Exception {
		get("/zzzz.789?action=on");
		Thread.sleep(1500);
		String ret = get("/zzzz.789");
		return (ret.indexOf("Power reading is 789.000") != -1);
	}
}
