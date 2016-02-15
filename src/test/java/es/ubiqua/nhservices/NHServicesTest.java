package es.ubiqua.nhservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.log.SysoLogger;

import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

import java.text.DecimalFormat;

import junit.framework.TestCase;

public class NHServicesTest  extends TestCase{
	
	 public void testFunctions() throws Exception {
		//Utils.sendSMSWakeUpAlarm(new WakeUpAlarm());
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime() + " - "+c.getTimeInMillis());
		
		c.setTimeInMillis(1455548632490L);
		System.out.println("OJJ: "+c.getTime());
	 }
	 
	 
}
