public abstract class Actor implements ActorBehavior {

        protected String name;

        public Actor(String name) {
                this.name = name;
        }

        protected boolean isMakeOrder;
        protected boolean isTakeOrder;

        abstract String getName();


}
