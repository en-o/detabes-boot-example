package com.detabes.cloud.doc.swagger.config;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 控制台输出
 *
 * @author tn
 * @version 1
 * @ClassName ServerConfig
 * @description
 * @date 2020/6/18 16:24
 */
@Component
public class ConsoleConfig implements ApplicationRunner {

	private final static Logger log = LoggerFactory.getLogger(ConsoleConfig.class);

	public static String SPIRIT = "/";


	@Value("${server.port:8080}")
	private int serverPort;

	@Value("${server.servlet.context-path:/}")
	private String serverName;



	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			if (SPIRIT.equals(serverName)) {
				serverName = "";
			}
			log.warn("\n----------------------------------------------------------\n\t" +
					" swagger 启动. Access URLs:\n\t" +
					"swagger 启动成功！聚合接口文档地址-HTML: http://" + getRealIp() + ":" + serverPort + serverName + "/doc.html" + "\n\t" +
					"----------------------------------------------------------");
		} catch (Exception ignored) {
		}
	}

	/**
	 * 获取本地真正的IP地址，即获得有线或者无线WiFi地址。
	 *
	 * @return java.lang.String
	 * @author tn
	 * @date 2020/4/21 23:44
	 * @description 过滤虚拟机、蓝牙等地址
	 */

	private static String getRealIp() {
		try {
			Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();

				// 去除回环接口，子接口，未运行和接口
				if (netInterface.isLoopback() || netInterface.isVirtual()
						|| !netInterface.isUp()) {
					continue;
				}

				if (!netInterface.getDisplayName().contains("Intel")
						&& !netInterface.getDisplayName().contains("Realtek")) {
					continue;
				}
				Enumeration<InetAddress> addresses = netInterface
						.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress ip = addresses.nextElement();
					if (ip != null) {
						// ipv4
						if (ip instanceof Inet4Address) {
							return ip.getHostAddress();
						}
					}
				}
				break;
			}
		} catch (SocketException e) {
			log.error("获取主机ip地址时出错"
					+ e.getMessage());
		}
		return "127.0.0.1";
	}


}

