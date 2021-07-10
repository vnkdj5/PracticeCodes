class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        //MinHeap
        PriorityQueue<Integer> queue=new PriorityQueue<>();//Store in ascending order
        
        //Add elements to heap
        for(int num: nums){
            queue.add(num);
        }
        
        int i=0;
        //Negate first K elements of Priority Queue and push them back to queue.
        while(!queue.isEmpty() && i<k){
            int num=queue.poll();
           
          queue.offer(-num);
          i++;   
        }
        //Find sum
        int sum=0;
        while(!queue.isEmpty())
            sum+=queue.poll();
        
        return sum;
    }
}
