package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SrtParser {

	public Map<Long, Subtitle> parse(File file) throws FileNotFoundException,Exception {
		FileReader scannr = new FileReader(file);
		BufferedReader scanner =new BufferedReader(scannr);
		String s=scanner.readLine();
		Map<Long, Subtitle> map = new HashMap<Long, Subtitle>();
		for (int i = 1; s!=null; i++) {
//			scanner.nextLine().trim();
			String time = scanner.readLine();
			String sub = "";
			String line = scanner.readLine().trim();
			while (line!=null&&!line.isEmpty()) {
				sub += line + "<br>";
				line = scanner.readLine();
			}
			String a[] = time.split("-->");
			String t1[] = a[0].trim().split(":");
			String st1[] = t1[2].split(",");
			String t2[] = a[1].trim().split(":");

			String st2[] = t2[2].split(",");
			long begin = getTime(t1[0], t1[1], st1[0], st1[1]);
			long end = getTime(t2[0], t2[1], st2[0], st2[1]);

			map.put(begin, new Subtitle(i, begin, end, sub));
			s=scanner.readLine();
		}
		
		scanner.close();
		return map;
	}

	private long getTime(String hh, String mm, String ss, String ms) {
		int h = Integer.parseInt(hh);
		int m = Integer.parseInt(mm);
		int s = Integer.parseInt(ss);
		int z = Integer.parseInt(ms);
		return (h * 60 * 60 + m * 60 + s);
	}
	public static String secondsToTime(long seconds) {
		int m=(int) (seconds/60);
		int s=(int) (seconds%60);
		int h=(int) (m/60);
		m=(m%60);
		return h+":"+m+":"+s;
	}
}
