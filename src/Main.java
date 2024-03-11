import controller.FoodManagement;
import View.UserView;
import Repository.FileWork;

public class Main {
    public static void main(String[] args) {
        FileWork.createFile();
        FoodManagement fm = new FoodManagement();
        UserView view = new UserView(fm);
        view.run();
    }
}