package fr.lixtec.form10.j1.tp.tp3;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;

public final class Utils {
	
	private Utils() {}
	
	private static boolean ANSI_ENABLED = false;
	
	public static void enableAnsi() {
		if (!ANSI_ENABLED) {
			AnsiConsole.systemInstall();
			ANSI_ENABLED = true;
		}
	}
	
	public static void disableAnsi() {
		//cls();
		System.out.print(ansi().reset());
		AnsiConsole.systemUninstall();
	}
	
	public static void cls() {
		System.out.print(ansi().eraseScreen().cursor(1, 1));
	}
	
	public static void print(String msg) {
		System.out.print(msg);
	}
	
	public static void print(char c) {
		System.out.print(c);
	}
	
	public static void print(int i) {
		System.out.println(i);
	}
	
	public static void print(Ansi a) {
		System.out.print(a);
	}
	
	public static void println(String msg) {
		System.out.println(msg);
	}
	
	public static void println(int n) {
		System.out.println(n);
	}
	
}
