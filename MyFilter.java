import java.io.FileFilter;
import java.io.File;
class MyFilter implements FileFilter {
	public boolean accept(File f) {	
		if(f.getName().endsWith(".txt")) {
			return true;
		}
		else {
			return false;
		}
	}
}