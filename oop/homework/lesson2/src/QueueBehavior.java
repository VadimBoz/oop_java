public interface QueueBehavior {
    void takeInQueuery(Actor actor);
    void releaseFromQueuery();
    void update();

}
