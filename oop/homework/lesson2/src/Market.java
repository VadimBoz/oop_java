import java.util.ArrayList;
import java.util.List;

public class Market implements MarketBehavior, QueueBehavior{

    private ArrayList<Actor> queue;

    public Market(){
        this.queue = new ArrayList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " вошел в магазин");
        takeInQueuery(actor);
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueuery();
    }


    @Override
    public void takeInQueuery(Actor actor) {
        this.queue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }


    @Override
    public void takeOrders() {
        for(Actor actor: queue){
            if(!actor.isMakeOrder()){
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }


    @Override
    public void giveOrders() {
        for(Actor actor: queue){
            if(!actor.isTakeOrder()){
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }


    @Override
    public void releaseFromQueuery() {
        List<Actor> releasedActors = new ArrayList<>();
        for(Actor actor: queue){
            if(actor.isTakeOrder()){
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди");
            }
        }
        releaseFromMarket(releasedActors);
    }


    @Override
    public void releaseFromMarket(List<Actor> releasedActors) {
        for(Actor actor: releasedActors){
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }



}
