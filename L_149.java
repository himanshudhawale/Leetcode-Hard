class Solution {

    public int maxPoints(int[][] points) {
        int max=0;
        if(points.length==0 || points==null)
        {
            return 0; 
        }
        if(points.length==1)
        {
            return 1;
        }
    
        HashMap<Double, Integer> myMap= new HashMap<Double, Integer>();
        
        for(int i=0;i<points.length;i++)
        {
            int xPoint=1; 
            int yPoint=0;
          
            for(int j=i+1; j<points.length;j++)
            {
               int[] thePoint=points[i];
               int[] checkPoint=points[j];
                if(thePoint[0]==checkPoint[0])
                {
                    if(thePoint[1]==checkPoint[1])
                    {
                        xPoint++;
                    }
                    else
                    {
                        yPoint++;
                    }
                }
                //outside of if
                else
                {
                                       

                    double slope=0;
                    if(checkPoint[1]-thePoint[1]==0)
                    {
                       slope=0;
                    }
                    else
                    {
                      slope=(checkPoint[1]-thePoint[1])/(checkPoint[0]-thePoint[0]);
                    }

                    
                    
                    
                    if(myMap.get(slope)!=null)
                    {
                        myMap.put(slope,myMap.get(slope)+1);
                    }
                    else
                    {
                        myMap.put(slope,1);
                    }
                    
                }
                //outside of else
            }
            //outside of for loop j
       /*     for(Integer x: myMap.values())
            {
                if(x+xPoint>max)
                {
                    max=x+xPoint;
                }
            }
            
            */
           // max=Math.max(xPoint+yPoint,max);
            myMap.clear();
        }
        return max;
    }
}