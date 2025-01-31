import com.app.controller.MainController;
import com.app.controller.MainMenuController;
import com.app.controller.UserAuthenticationControllerV2;

public class Main {

    public static void main(String[] args) {

        //Run the program:

        UserAuthenticationControllerV2 uaController = new UserAuthenticationControllerV2();
        MainMenuController mMController = new MainMenuController();

        MainController mainController = new MainController(uaController, mMController);
        
        mainController.startMainController();







        //Run the program:
        //Intialize view, model, controller.

        /*
        Users model = new Users();  //Model
        UserAuthenticationView uaView = new UserAuthenticationView(); //View
        new UserAuthenticationControllerV2(model, uaView); //Controller
         */


    }

}
