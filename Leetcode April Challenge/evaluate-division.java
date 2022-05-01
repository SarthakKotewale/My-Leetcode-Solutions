class Solution 
{
    class node
    {
        String d;
        double v;
        node(String d , double v)
        {
            this.d = d;
            this.v = v;
        }
    }
    double result;
    int count;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) 
    {
        double ans[] = new double[queries.size()];
        HashMap<String , ArrayList<node>> adj = new HashMap<>();
        String x , y;
        
        for(int i=0 ; i<equations.size() ; i++)
        {
            x = equations.get(i).get(0);
            y = equations.get(i).get(1);
            
            if(!adj.containsKey(x))
                adj.put(x , new ArrayList<>());
            if(!adj.containsKey(y))
                adj.put(y , new ArrayList<>());
            
            adj.get(x).add(new node(y , values[i]));
            adj.get(y).add(new node(x , 1.0/values[i]));
        }
        
        HashSet<String> visited = new HashSet<>();
        for(int i=0 ; i<ans.length ; i++)
        {
            visited = new HashSet<>();
            x = queries.get(i).get(0);
            y = queries.get(i).get(1);
            
            if(!adj.containsKey(x))
                ans[i] = -1.0;
            else
            {
                result = -1.0;
                count = 0;
                util(adj , visited , x , y, 1.0);
                
                if(count<=1)   // If Single ans can be determined i.e. we can reach y in 1 or less ways
                ans[i] = result;
                else     // If there are multiple ways to reach  y then single ans can not be determined and so we will put -1.0
                ans[i] = -1.0;
            }   
        }
        return ans;
    }
    
    void util(HashMap<String , ArrayList<node>> adj ,HashSet<String> visited, String s , String d, double mul)
    {
        if(s.equals(d))
        {
            count++;
            result = mul;
        }
        visited.add(s);
        for(node x : adj.get(s))
        {
            if(!visited.contains(x.d))
            util(adj, visited, x.d, d, mul*x.v);
        }
    }
}