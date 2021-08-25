package verifications;

import java.io.File;
import java.util.Date;

public class FoldersCreation 
{

	public static void main(String[] args)
	{
		String projectPath = System.getProperty("user.dir");
		
		Date dt  =new Date();
		String screenShotFolder = dt.toString().replace(':', '_').replace(' ', '_');
		String  mainFolder = projectPath+"//Reports//"+screenShotFolder +"//screenshots//";
		
		File f = new File(mainFolder);
		f.mkdirs();

	}

}
