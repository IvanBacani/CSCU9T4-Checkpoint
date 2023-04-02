// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

/**
 *
 * @author Ivan Bacani
 */
public class TrainingRecord {
	private List<Entry> tr;

	
	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} 

	public void addEntry(Entry e) {
		tr.add(e);
	} 

	public String lookupEntry(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result = current.getEntry();
		}
		return result;
	} 


	public int getNumberOfEntries() {
		return tr.size();
	}

	public void clearAllEntries() {
		tr.clear();
	}

	public String findAllEntry(int d, int m, int y) {
		
	       ListIterator<Entry> iter = tr.listIterator();
	       String result = "";
	       while (iter.hasNext()) {
	           Entry current = iter.next();
	           if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) {
	              result += current.getEntry();
	           }
	       }
	       if (result.isEmpty()) {
	    	   result = "No entries found";
	       }
	       return result;
	   }
	
	public void removeEntry(String name, int d, int m, int y) {
		
		List<Entry> iter = new ArrayList<>();
		for (Entry entry : tr) {
			if (entry.getName().equals(name) && entry.getDay() == d && entry.getMonth() == m && entry.getYear() == y) {
				
				iter.add(entry);
				
			}
			
				tr.removeAll(iter);
		}
	}
}
// TrainingRecord