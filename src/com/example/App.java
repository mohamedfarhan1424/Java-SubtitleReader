package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String pathname = "D:\\Entertainment\\Series\\Flash Season-2\\Flash Season-2 Ep-11\\the.flash.2014.211 YSTV - intermedia™.srt";
		File file = new File(pathname);
		try {
			new SubtitleProcessor(new SrtParser().parse(file)).process();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}