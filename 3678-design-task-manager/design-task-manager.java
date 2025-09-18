
class TaskManager {
    
 class Pair {
        int priority;
        int taskId;
        Pair(int priority  , int taskId){
            this.priority  = priority;
            this.taskId = taskId;
        }
     }

     HashMap<Integer , Integer> task_priority_map = new HashMap<>();
     HashMap<Integer , Integer> task_user_map = new HashMap<>();
     PriorityQueue<Pair> heap;
    public TaskManager(List<List<Integer>> tasks) {
        heap = new PriorityQueue<>((a,b) -> {if(a.priority == b.priority){
            return Integer.compare(b.taskId , a.taskId);
        }
        else{
            return Integer.compare(b.priority , a.priority);
        }});
        
        for(List<Integer> list : tasks){
            task_priority_map.put(list.get(1) , list.get(2));
            task_user_map.put(list.get(1) , list.get(0));

            Pair pair = new Pair(list.get(2) , list.get(1));
            heap.add(pair);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
         task_priority_map.put(taskId , priority);
          task_user_map.put(taskId , userId);
          Pair p = new Pair(priority , taskId);
          heap.add(p);

    }
    
    public void edit(int taskId, int newPriority) {
         task_priority_map.put(taskId , newPriority);
          Pair p = new Pair(newPriority , taskId);
          heap.add(p);
        
    }
    
    public void rmv(int taskId) {
         task_priority_map.remove(taskId);
           task_user_map.remove(taskId);
        
    }
    
    public int execTop() {

        while(heap.isEmpty() == false && (task_priority_map.containsKey(heap.peek().taskId) == false ||
        heap.peek().priority != task_priority_map.get(heap.peek().taskId))){
            heap.poll();
        }

        if(heap.isEmpty()) return -1;

        Pair p = heap.poll();
        int user = task_user_map.get(p.taskId);
 task_priority_map.remove(p.taskId);
           task_user_map.remove(p.taskId);

           return user;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */