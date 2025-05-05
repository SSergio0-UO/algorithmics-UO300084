package algstudent.s3.Calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
	String[] participants;
	int size ; // particpants.length
	public String[][] makeCalendar(){
		String[][] calendar = new String[size][size];
		List<String> used = new ArrayList<String>();
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				for(int p = 0; p<size;p++) {
					used.clear();
					if(!used.contains(participants[i]) && j!=p)
						calendar[j][i] = participants[p];
					used.add(participants[p]);
				}
				
			}
		}
		return null;
		
	}
	public void
	public void mc(int day,start,end) {
		if(start + 1 == end) {
			
		}
		int mid = start / end;
		return mc(a,start,mid) + mc(day,mid,start);
	}
}
