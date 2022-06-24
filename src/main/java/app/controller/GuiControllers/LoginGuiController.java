package app.controller.GuiControllers;

import app.controller.AuthController;
import app.domain.shared.Constants;
import app.ui.console.AdminUI;
import app.ui.console.CoordinatorUi;
import app.ui.console.MenuItem;
import app.ui.console.NurseUI;
import app.ui.console.SnsUser.SnsUserUi;
import app.ui.console.receptionist.ReceptionistUi;
import app.ui.console.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Popup;
import javafx.stage.Stage;
import pt.isep.lei.esoft.auth.mappers.dto.UserRoleDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LoginGuiController {

    /**
     * Controller Class of the graphical user interface for the login page
     *
     * @author Pedro Campos <1211511@isep.ipp.pt> */

    @FXML
    private Button backButton;

    @FXML
    private TextField emailField;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    private UserRoleDTO selectsRole(List<UserRoleDTO> roles)
    {
        if (roles.size() == 1)
            return roles.get(0);
        else
            return (UserRoleDTO) Utils.showAndSelectOne(roles, "Select the role you want to adopt in this session:");
    }
    private List<MenuItem> getMenuItemForRoles()
    {
        List<MenuItem> rolesUI = new ArrayList<>();
        rolesUI.add(new MenuItem(Constants.ROLE_ADMIN, new AdminUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_RECEPTIONIST, new ReceptionistUi()));
        rolesUI.add(new MenuItem(Constants.ROLE_SNS_USER, new SnsUserUi()));
        rolesUI.add(new MenuItem(Constants.ROLE_NURSE, new NurseUI()));
        rolesUI.add(new MenuItem(Constants.ROLE_COORDINATOR,new CoordinatorUi()));
        // To complete with other user roles and related RoleUI

        //
        return rolesUI;
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.hide();

        Scene scene = new Scene(root);
        Stage login = new Stage();
        login.setScene(scene);
        login.setTitle("Main");
        login.show();
    }

    @FXML
    void doLogin(ActionEvent event) throws IOException {

        AuthController ctrl = new AuthController();


        Stage stage = (Stage) loginButton.getScene().getWindow();
        String id = emailField.getText();
        String pwd = passwordField.getText();
        boolean success = ctrl.doLogin(id, pwd);
        if (!success)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid email or password, please try again.");
            alert.showAndWait();


        }
        if (success)
        {
            List<UserRoleDTO> roles = ctrl.getUserRoles();
            if ( (roles == null) || (roles.isEmpty()) )
            {
                System.out.println("User has not any role assigned.");
            }
            else
            {
                UserRoleDTO role = selectsRole(roles);
                if (!Objects.isNull(role))
                {
                    List<MenuItem> rolesUI = getMenuItemForRoles();
                    if (role.getDescription().equals("COORDINATOR")){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Coordinator.fxml"));
                        Parent root = loader.load();
                        stage.hide();

                        Scene scene = new Scene(root);
                        Stage coordinator = new Stage();
                        coordinator.setScene(scene);
                        coordinator.setTitle("Coordinator Menu");
                        coordinator.setAlwaysOnTop(true);
                        coordinator.show();

                    } else if (role.getDescription().equals("NURSE")){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Nurse.fxml"));
                        Parent root = loader.load();
                        stage.hide();

                        Scene scene = new Scene(root);
                        Stage nurse = new Stage();
                        nurse.setScene(scene);
                        nurse.setTitle("Nurse Menu");
                        nurse.setAlwaysOnTop(true);
                        nurse.show();

                    } else if (role.getDescription().equals("ADMIN")){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Admin.fxml"));
                        Parent root = loader.load();
                        stage.hide();

                        Scene scene = new Scene(root);
                        Stage admin = new Stage();
                        admin.setScene(scene);
                        admin.setTitle("Admin Menu");
                        admin.setAlwaysOnTop(true);
                        admin.show();

                    } else if (role.getDescription().equals("RECEPTIONIST")){
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Receptionist.fxml"));
                        Parent root = loader.load();
                        stage.hide();

                        Scene scene = new Scene(root);
                        Stage receptionist = new Stage();
                        receptionist.setScene(scene);
                        receptionist.setTitle("Receptionist Menu");
                        receptionist.setAlwaysOnTop(true);
                        receptionist.show();

                    }
                }
                else
                {
                    System.out.println("User did not select a role.");
                }
            }
        }


    }

}
