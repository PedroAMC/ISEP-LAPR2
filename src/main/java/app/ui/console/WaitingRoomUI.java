package app.ui.console;
import app.controller.center.WaitingRoomController;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.shared.Constants;
import app.domain.utils.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * Class of the user interface for US05
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */
public class WaitingRoomUI implements Runnable {
    private final WaitingRoomController controller;
    List<Pair<SnsUserDto, HourDto>> snsUsersArrived;

    /**
     * Constructor of the ui class
     */

    public WaitingRoomUI() {
        this.controller = new WaitingRoomController();
    }

    /**
     * Run method to run the ui necessary to display the list of users in the waiting room
     */

    @Override
    public void run() {
        String vaccinationCenterName="teste";

        Properties props = new Properties();
        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            vaccinationCenterName = (String)(props.get(Constants.VACCINATION_CENTER));
            in.close();
        }
        catch(
                IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("-------------WAITING ROOM:-------------");

        snsUsersArrived = controller.displayWaitingRoom(vaccinationCenterName);

        for (Pair<SnsUserDto, HourDto> p : snsUsersArrived) {
            System.out.println();
            System.out.println("Name:\n" + p.getFirst().getName());
            System.out.println("Address:\n" + p.getFirst().getAddress());
            System.out.println("Sex:\n" + p.getFirst().getSex());
            System.out.println("Phone Number:\n" + p.getFirst().getPhoneNumber());
            System.out.println("Email:\n" + p.getFirst().getEmail());
            System.out.println("BirthDate:\n" + p.getFirst().getBirthDate());
            System.out.println("Sns Number:\n" + p.getFirst().getSnsNumber());
            System.out.println("Citizen Card Number\n" + p.getFirst().getCitizenCardNumber());
            System.out.println("Sms Permission:\n" + p.getFirst().getSmsPermission());
            System.out.println("Arrival Hours:" + p.getSecond().toString());
            System.out.println();
        }

    }
}

