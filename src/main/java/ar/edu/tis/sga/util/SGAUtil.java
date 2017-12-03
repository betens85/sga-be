package ar.edu.tis.sga.util;

import java.security.SecureRandom;

public class SGAUtil {

	public static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	private static SecureRandom rnd = new SecureRandom();

	public static String generarLegajo(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString().toUpperCase();
	}
}
