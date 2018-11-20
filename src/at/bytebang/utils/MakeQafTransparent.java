package at.bytebang.utils;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeQafTransparent
{
	public static void main(String[] args)
	{
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/tmp/qaf-in"), "*.*"))
        {
	        for (Path entry : stream) 
	        {
	        	QafFile f = new QafFile(entry.toString());
	        	if(f.containsUseableImage())
	        	{
		        	System.out.println(f);
		        	f.saveAsTransparentPng("/tmp/qaf-out/" + entry.getFileName() + ".png");
	        	}	
	        }
        }
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
