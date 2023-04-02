package com.stir.cscu9t4practical1;

/**
*
* @author Ivan Bacani
*/
class SwimEntry extends Entry {
    private String where;
    
    public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String w){
        super(n, d, m, y, h, min, s, dist);
        where = w;
    }
    
    public String getWhere(){
            return where;
    }
    
   @Override
   public String getEntry (){
    String result = getName()+ " swim " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
    }
}
