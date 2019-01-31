package serviceDAO;

import java.time.Year;
import java.util.List;

import javax.ejb.Local;

import entity.Activity;

@Local
public interface DaoActivity {

	public Activity addActivity(Activity a);

	public Activity updateActivity(Activity a);

	public void removeActivity(Activity p);

	public Activity findActivityById(long id);
	
	public List<Activity> findActivityByYear(Year year );
	
	public List<Activity> findActivityByNature(String nature);
	
	public List<Activity> findActivityByTitle(String title);

	public List<Activity> findAllActivity();

}
