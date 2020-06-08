package book;
	import java.lang.String;

	public class Book {


		private char[] charArray ;
		private static int size;
		private static int total;
		private static char[] temp;
		private static int strlen;


		public Book(){

			size = 1000; 

		}

		public void toCharArray(String str) {


			strlen = str.length();

			this.charArray = new char[10];//sadece aktar
			for(int i = 0; i<str.length(); i++) {
				this.charArray[i] = str.charAt(i);// why I cannot reach the same 'this.charArray' in resize method?

			}	


		}
		public char[] append(char[] charArray) {

			total = strlen + charArray.length;
			temp = new char[size];

			if(size <total) {
				resize();
			}

			for(int i = 0; i<charArray.length; i++) { // yeniyi eskiye aktar
				temp[strlen+ i] = charArray[i]; //I am getting index out of bonds error here
			}

			return temp;
		}

		public void resize () {

			size = (total)*2 +2 ; 


			for(int i = 0; i<strlen; i++) { 
				temp[i] = this.charArray[i] ;//why is this charArray is different than the one in toCharmethod
			}

		}
		public static void main(String[] args) {


			char[] a =  {'a','b','c','d'};
			char[] b =  {'m','e','t','e'};
			MutableString stringb = new MutableString(b);
			MutableString string = new MutableString(a);
			string.append(stringb);
			
			
			for(int i = 0; i<string.append(stringb).getLength(); i++) { 

				


			}

		}
	}