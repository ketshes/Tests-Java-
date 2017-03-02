import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;



public class TestRunner {

	public static void main(String[] args) {
		
		
		String fileSeparator = System.getProperty("file.separator");
		String absoluteFilePath = fileSeparator + "home" + 
		fileSeparator + "yuriy" + fileSeparator + "report.txt";
		File file = new File(absoluteFilePath);
        System.out.println("Файл report.txt создан. Путь к файлу:" + absoluteFilePath );
        
        
        ArrayList <Class> tests = new ArrayList <Class>();
        tests.add(Test1.class);
        tests.add(Test2.class);
        
                
        ArrayList <String> testNames = new ArrayList <String>();
        testNames.add("Test 1");
        testNames.add("Test 2");
        
        ArrayList <String> descriptions = new ArrayList <String>();
        descriptions.add("Tests if changing the city causes phone number change");
        descriptions.add("Testing if social networks links are working properly");
         
		String testName;
        Result result;
                
        for (int i =0; i < 2; i++){
        	
         result = JUnitCore.runClasses(tests.get(i));
        	
        	try(FileWriter writer = new FileWriter(absoluteFilePath, true))
            {      			
    		    
        		testName = testNames.get(i);
    			writer.write(testName);
    			writer.append('\n');
    			
    			    			
    			
    			writer.write(descriptions.get(i));
    			writer.append('\n');
    			writer.append('\n');
    			
                String total = "Number of tests  = " + result.getRunCount();
                writer.write(total);
                writer.append('\n');
            	writer.append('\n');
                
                String failed = "Number of tests failed = " + result.getFailureCount();
                writer.write(failed);
                writer.append('\n');
            	writer.append('\n');
               
                 
                writer.flush();
            }
            catch(IOException ex){
                 
                System.out.println(ex.getMessage());
            } 
        	
        	
        }
        
       
		
		
	}
	}


