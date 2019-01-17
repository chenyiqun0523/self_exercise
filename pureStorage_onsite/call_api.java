//#0 Single Thread
public class call_api {
    private Queue<ID> queue = new LinkedList<>();

    public ID get_one_id() {
        if (queue.isEmpty()) {
            addIDs();
        }
        ID cur_id = queue.poll();
        return cur_id;
    }

    public void addIDs() {
        List<ID> id_list = get_ids();
        for (int i = 0; i < 100; i++) {
            queue.offer(id_list.get(i));
        }
    }
} 

//#1 Multi Thread
public class call_api {
    private Queue<ID> queue = new LinkedList<>();
    private Lock lockA = new Lock();

    public ID get_one_id() {
        lockA.lock();
        if (queue.isEmpty()) {
            addIDs();
        }
        ID cur_id = queue.poll();
        lockA.unlock();
        return cur_id;
    }

    public void addIDs() {
        List<ID> id_list = get_ids();
        for (int i = 0; i < 100; i++) {
            queue.offer(id_list.get(i));
        }
    }
} 

//#2 Multi Thread
public class call_api {
    private Queue<ID> queue = new LinkedList<>();
    private Lock lockA = new Lock();

    public ID get_one_id() {
        lockA.lock();
        if (queue.isEmpty()) {
            List<ID> id_list = get_ids();
            for (int i = 0; i < 100; i++) {
                queue.offer(id_list.get(i));
            }
        }
        ID cur_id = queue.poll();
        lockA.unlock();
        return cur_id;
    }

    public void addIDs() {
        
    }
} 



//#1
public class call_api {
    private Queue<ID> queue = new LinkedList<>();
    private final ReentrantLock lockA = new ReentrantLock();

    public void monitor_queue() {
        if (queue.size() < 100) {
            List<ID> id_list= get_ids();

            for (int i = 0; i < 100; i++) {
                lockA.lock();
                queue.offer(id_list.get(i));
                lockA.unlock();
            }
        }
    }

    public ID get_one_id() {
        lockA.lock();
        ID cur_id = queue.poll();
        lockA.unlock();
        return cur_id;
    }

    public List<ID> get_ids() {
        List<ID> alist = new ArrayList<>();
        return alist;
    }
}

//#2
public class call_api {
    private Queue<ID> queue = new LinkedList<>();
    private final ReentrantLock lockA = new ReentrantLock();
    Condition condition = lockA.newCondition();

    public void monitor_queue() {
        if (queue.isEmpty()) {
            List<ID> id_list= get_ids();
            lockA.lock();
            try{
                for (int i = 0; i < 100; i++) {
                    queue.offer(id_list.get(i));
                }
                condition.signalAll();
            } finally {
                lockA.unlock();
            }
            
        }
    }

    public ID get_one_id() {
        lockA.lock();
        try{
            while (queue.isEmpty()) {
                condition.await();
            }
        }
        finally{
            return 0;
            lock.unlock();
        }
        ID cur_id = queue.poll();
        lockA.unlock();
        return cur_id;
    }

    public List<ID> get_ids() {
        List<ID> alist = new ArrayList<>();
        return alist;
    }
}

/*
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Queue<ID> queue = new LinkedList<>();
        Monitor_Queue_Thread monitor_queue = new Monitor_Queue_Thread(queue);

        monitor_queue.start();
        
    }

    public static class ID_Queue {
        private Queue<ID> queue = new LinkedList<>();
        public ID get_one_id() {
            cur_ID = queue.poll();
            return cur_ID;
        }

        public int get_queue_size() {
            return queue.size();
        }

        public int 
    }

    public static class Monitor_Queue_Thread extends Thread {
        private Queue<ID> queue;

        public Monitor_Queue_Thread(Queue<ID> queue) {
            this.queue = queue;
        }
        public void run() {
            while (1) {
                if (queue.isEmpty()) {
                    List<ID> id_list= get_ids();
                    for (int i = 0; i < 100; i++) {
                        queue.offer(id_list.get(i));
                    }
                }
            }
        }
    }
    
    



}
*/