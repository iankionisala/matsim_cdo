package xml_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class file_handler {
	
	private static String _mfile_name;
	private static String _mcur_dir;
	private File file;
	private FileReader fileReader;
	
	public String[] result;
	public String out = "";
	
	public file_handler(String file_path){
		_mfile_name = file_path;

		
	}
	
	private void read_dir(){
		String fpath_var = this.getClass().getClassLoader().getResource("").getPath();
		fpath_var = fpath_var.substring(0, fpath_var.length() - 4);
		fpath_var = fpath_var.replace("/", "//");
		_mcur_dir = fpath_var;
	}
	
	private boolean is_writable(){
		read_dir();
		file = new File("" + _mcur_dir + "input/" + ""); 
		
		if (file.canWrite() )
			return true;
		else
			return false;
		
	}
	
	private boolean is_readable(){
		read_dir();
		file = new File("" + _mcur_dir + _mfile_name + ""); 
		
		if ( !file.exists() ) 
            return false;
        if ( !file.canRead() )
            return false;
        try{
	        fileReader = new FileReader(file.getAbsolutePath());
	        fileReader.read();
	        fileReader.close();
	    } catch (Exception e) {
	    	System.out.println("Exception when checked file can read with message: " + e.getMessage());
	        return false;
	    }
        
        return true;
	}
	
	public void create_file(String datatofile){
		
		if ( is_writable() ){

			String text = datatofile;
	        try {
	          file = new File(_mcur_dir + "input/" + _mfile_name);
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
	          output.write(text);
	          output.close();
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
	        
		}else{
			System.out.println("filename: " + _mfile_name + " is not writable " + _mcur_dir + "input/"); 
		}
	}
	

	public String parse_data(){
		if ( is_readable() ){
			return read_file();
		}else{
			System.out.println("The filename: " + _mfile_name + " is not readable " + _mcur_dir + "input/" + _mfile_name);
			return null;
		}
		
	}
	
	private String read_file(){
		
		String parsed_text = read_textfile();
		
//		result = parsed_text.split("\n"); 
//		for(int i = 0; i < result.length; i++) {
//			
//			String[] res = result[i].split("\\s");
//		
//			 out = out + " " +res[2];
////			 out = out + " " + res[0] + "," +res[1]+ ","+ res[2] ;
//		}
//		
		return parsed_text;
        
	}
	
	public String read_textfile() {
	    String text = "";
	    int read, N = 1024 * 1024;
	    char[] buffer = new char[N];

	    try {
	        FileReader fr = new FileReader(_mcur_dir + _mfile_name);
	        BufferedReader br = new BufferedReader(fr);

	        while(true) {
	            read = br.read(buffer, 0, N);
	            text += new String(buffer, 0, read);

	            if(read < N) {
	                break;
	            }
	        }
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }

	    return text;
	}
	
}
