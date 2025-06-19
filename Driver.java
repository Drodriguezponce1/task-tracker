public class Driver {
    public static void main(String[] args) {

        TaskManager manager = new TaskManager();
        manager.add("Buy groceries");
        manager.add("Buy g");
        manager.add("Buy f");
        manager.add("Buy r");
        manager.add("Buy h");
        manager.printAll();

        System.out.println("===========================================================");

        manager.updateDescription(3, "fadasdasdasdads");
        manager.delete(11);
        manager.printAll();
    }
}
