class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Bucket sort approch
       Map<Integer, Integer> countMap=new HashMap<>();
        
        //Make <Number, Count> map
        for(int  num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        
        //Form array with count as index and list of numbers haveing that count as its value
        //Count cannot be greater than size of nums
        List<Integer>[] countToNums=new ArrayList[nums.length+1];
        
        for(var pair: countMap.entrySet()){
            var list=countToNums[pair.getValue()];
           if(list==null){
               list=new ArrayList<>();
           }
            list.add(pair.getKey());
            countToNums[pair.getValue()]=list;
        }
        
        
        
        int result[]=new int[k];
        
        //Iterate from last till we get K elements in ArrayRev
        for(int i=nums.length; i>0 & k>0 ; i--){
            var list=countToNums[i];
            if(list!=null && list.size()>0){
                for(int j=0; j<list.size() && k>0; j++){
                    result[--k]=list.get(j);
                }
            }
        }
        
        return result;
    }
    
    
    
     public int[] topKFrequentUsingPriorityQueue(int[] nums, int k) {
        
       Map<Integer, Integer> countMap=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        
        for(int  num: nums){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        
        Queue<Integer> pq=new PriorityQueue<>((a,b) -> Integer.compare(countMap.get(a), countMap.get(b)));
        for(var key: countMap.keySet()){
           pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
            
        }
        
        return pq.stream().mapToInt(i -> i).toArray();
    }
}
