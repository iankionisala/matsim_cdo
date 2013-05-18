package tutorial;

import java.io.File;

public class xml_parser_txt {

	private static boolean is_file_exist(String filetostring){
		File file = new File( filetostring  );
		
		if( file.exists() ) {
		
			return true;
			
		}else{
			
			return false;
			
		}
	}
	
	public static void main(String[] args) {
		
		String filepath = "file_to_path.xml";

		if( is_file_exist(filepath) ){
			
		}else{
			
		}
			
	
	}
	
	
}
