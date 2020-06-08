package validater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
public static void main(String[] args) {
	
	String text="05382930951 111ssfadfdsffsfsf541293 0951 mgelgi17@ku.edu.tr mgelgi17@gmail.com51gkglskflsfkdgsşk 541 2930951";
	String numbers = "";
	String mail=null;
	Pattern mailPat=Pattern.compile("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])\n");
	
	Pattern phoneNumberPattern=Pattern.compile("\\d{10}|[90]\\d{10}|[90]\\s\\d{10}| [0]\\s\\d{10}| \\d{3}\\s\\d{7}");
	Pattern phoneNumberPattern2=Pattern.compile("(0|0\\s)?5[0-9]{2}\\s{0,1}[0-9]{3}\\s?[0-9]{4}");
	Matcher matchernumber = phoneNumberPattern2.matcher(text);
	while(matchernumber.find()) {
		numbers += matchernumber.group()+" ";
		System.out.println("yaptım");}
	
	System.err.println(numbers);
	
	Pattern MailPattern=Pattern.compile("([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?");
	Pattern MailPattern2=Pattern.compile("\\s+[a-zA-Z][a-zA-Z0-9]*_?[a-zA-Z0-9]*@([A-Za-z0-9]+\\.)+[A-Za-z]{2,3}");
	
	Matcher matchermail = MailPattern2.matcher(text);
	while (matchermail.find()) {
		mail += matchermail.group()+"\n";
		System.out.println("yaptım2");}
	
	System.err.println(mail);
	
}




//patterns
//webSite:
////(?i)\b((?:[a-z][\w-]+:(?:/{1,3}|[a-z0-9%])|www\d{0,3}[.]|[a-z0-9.\-]+[.][a-z]{2,4}/)(?:[^\s()<>]+|\(([^\s()<>]+|(\([^\s()<>]+\)))*\))+(?:\(([^\s()<>]+|(\([^\s()<>]+\)))*\)|[^\s`!()\[\]{};:'".,<>?«»“”‘’]))
//telephoneNumber:
////(?:(?:\+?([1-9]|[0-9][0-9]|[0-9][0-9][0-9])\s*(?:[.-]\s*)?)?(?:\(\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\s*\)|([0-9][1-9]|[0-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\s*(?:[.-]\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\s*(?:[.-]\s*)?([0-9]{4})(?:\s*(?:#|x\.?|ext\.?|extension)\s*(\d+))?
//mail:
////(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
////"([a-z\\d\\.-]+)@([a-z\\d-]+)\\.([a-z]{2,8})(\\.[a-z]{2,8})?"
}
