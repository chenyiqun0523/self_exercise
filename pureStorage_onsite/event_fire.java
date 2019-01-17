//Single Thread
public class event_stack {
    private boolean fired_flag;
    private Queue<Event> event_queue;

    public event_stack() {
        fired_flag = false;
        event_queue = new LinkedList<>();
    }

    public void register(Event event) {
        if (fired_flag) {
            event.call();
        } else {
            event_queue.offer(event);
        }
    }

    public void fire_event() {
        fired_flag = true;
        while (!event_queue.isEmpty()) {
            event_queue.poll().call();
        }
    }
}

//Multi Thread #1
public class event_stack {
    private boolean fired_flag;
    private Queue<Event> event_queue;

    public event_stack() {
        fired_flag = false;
        event_queue = new LinkedList<>();
    }

    public synchronized void register(Event event) {
        if (fired_flag) {
            event.call();
        } else {
            event_queue.offer(event);
        }
    }

    public synchronized void fire_event() {
        fired_flag = true;
        while (!event_queue.isEmpty()) {
            event_queue.poll().call();
        }
    }
}

//Multi Thread #2
public class event_stack {
    private boolean fired_flag;
    private Queue<Event> event_queue;
    private final ReentrantLock lockA = new ReentrantLock();

    public event_stack() {
        fired_flag = false;
        event_queue = new LinkedList<>();
    }

    public void register(Event event) {
        lockA.lock();
        if (fired_flag) {
            lockA.unlock();
            event.call();
        } else {
            event_queue.offer(event);
            lockA.unlock();
        }
    }

    public void fire_event() {
        lockA.lock();
        while (!event_queue.isEmpty()) {
            Event cur_event = event_queue.poll();
            lockA.unlock();
            cur_event.call();
            lockA.lock();
        } 
        fired_flag = true;
        lockA.unlock();
    }
}

//Multi Thread #3
//ReentrantreadwriteLock

//#4
boolean isFired = false;
Queue<Callback> q = new LinkedList<Callback>();
Mutex L = new Mutex();
ConditionalVariable cv = new CV();

void register(Callback cb) {
     L.lock();
     if (!isFired) {
         q.offer();
          L.unlock();
     } else {
          L.unlock();
          cv.wait(another lock);
          cb.execute();
     }
}

void event_fired() {
     L.lock();
     isFired = true;
     L.unlock();
     while (!q.isEmpty()) {
          Callback cb = q.poll();
          cb.execute();
     }
     cv.notify();
}