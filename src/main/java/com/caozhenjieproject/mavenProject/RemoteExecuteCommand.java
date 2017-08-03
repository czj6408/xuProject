package com.caozhenjieproject.mavenProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

class RemoteExecuteCommand {
	private static String DEFAULTCHART = "UTF-8";
	private Connection conn;
	private String ip;
	private String userName;
	private String userPwd;

	public RemoteExecuteCommand(String ip, String userName, String userPwd) {
		this.ip = ip;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public RemoteExecuteCommand() {

	}

	/**
	 *
	 * 
	 * @author Ickes
	 * @since V0.1
	 * @return ??????true,????false
	 */
	public Boolean login() {
		boolean flg = false;
		try {
			conn = new Connection(ip);
			conn.connect();// ??
			flg = conn.authenticateWithPassword(userName, userPwd);// ??
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flg;
	}

	/**
	 * @author Ickes ????shll??????
	 * @param cmd
	 *            ???????
	 * @return ????????????
	 * @since V0.1
	 */
	public String execute(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();
				session.execCommand(cmd);
				result = processStdout(session.getStdout(), DEFAULTCHART);
				if (StringUtils.isBlank(result)) {
					result = processStdout(session.getStderr(), DEFAULTCHART);
				}
				conn.close();
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @author Ickes ????shll??????
	 * @param cmd
	 *            ???????
	 * @return ?????????????,????????,??????,??null
	 * @since V0.1
	 */
	public String executeSuccess(String cmd) {
		String result = "";
		try {
			if (login()) {
				Session session = conn.openSession();// ??????
				session.execCommand(cmd);// ????
				result = processStdout(session.getStdout(), DEFAULTCHART);
				conn.close();
				session.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ????????????
	 * 
	 * @author Ickes
	 * @param in
	 *            ?????
	 * @param charset
	 *            ??
	 * @since V0.1
	 * @return ?????????
	 */
	private String processStdout(InputStream in, String charset) {
		InputStream stdout = new StreamGobbler(in);
		StringBuffer buffer = new StringBuffer();
		;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					stdout, charset));
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line + "\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public static void setCharset(String charset) {
		DEFAULTCHART = charset;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}
