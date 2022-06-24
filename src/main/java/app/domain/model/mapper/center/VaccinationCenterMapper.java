package app.domain.model.mapper.center;

import app.domain.model.data.centers.CommunityMassVaccinationCenter;
import app.domain.model.data.centers.HealthCareCenter;
import app.domain.model.data.centers.VaccinationCenter;
import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.centers.CommunityMassVaccinationCenterDto;
import app.domain.model.dto.centers.HealthCareCenterDto;
import app.domain.model.dto.centers.VaccinationCenterDto;
import app.domain.model.dto.snsuser.SnsUserDto;
import app.domain.model.dto.utils.HourDto;
import app.domain.model.mapper.Utils.HourMapper;
import app.domain.model.mapper.snsuser.SnsUserMapper;
import app.domain.shared.CenterAssociations;
import app.domain.utils.Hour;
import app.domain.utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Class with the mapper if the class vaccination center
 */
public class VaccinationCenterMapper {

    /**
     * Method to transform an object dto vaccination center to a vaccination center
     * @param dto object with all the information
     * @return healthcare center or mass vacination center
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static VaccinationCenter toVaccinationCenter(VaccinationCenterDto dto) {

        if (dto instanceof CommunityMassVaccinationCenterDto) {

            return new CommunityMassVaccinationCenter(dto.getName(), dto.getAddress(), dto.getPhoneNumber(), dto.getEmail(), dto.getFax(), dto.getWebsiteAddress()
                    , dto.getCenterCoordinator(), dto.getOpenHour(), dto.getCloseHour(), dto.getSlotDuration(), dto.getCapacity(),
                    ((CommunityMassVaccinationCenterDto) dto).getAvaiableTypes(),dto.getDailyVaccinated());

        } else if (dto instanceof HealthCareCenterDto) {

            return new HealthCareCenter(dto.getName(), dto.getAddress(), dto.getPhoneNumber(), dto.getEmail(), dto.getFax(), dto.getWebsiteAddress()
                    , dto.getCenterCoordinator(), dto.getOpenHour(), dto.getCloseHour(), dto.getSlotDuration(), dto.getCapacity(),
                    ((HealthCareCenterDto) dto).getAvaiableTypes(), ((HealthCareCenterDto) dto).getAssociatedTo(),dto.getDailyVaccinated());
        }

        throw new IllegalArgumentException("The Vaccination center should be either a Community mass Vaccination center or a Health Care center");
    }

    /**
     * Method to return a list of user arrivals dto
     * @param userArrivedlist list with the user arrivals
     * @return list with the arrivals
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static List<Pair<SnsUserDto, HourDto>> usersArrivaltoDto(List<Pair<SnsUser, Hour>> userArrivedlist) {
        List<Pair<SnsUserDto, HourDto>> snsUsersArrivedDto = new ArrayList<>();

        for (Pair<SnsUser, Hour> p : userArrivedlist) {
            SnsUser snsUser = p.getFirst();
            Hour hour = p.getSecond();
            SnsUserDto snsUserDto = SnsUserMapper.toSnsUserDto(snsUser);
            HourDto hourDto = HourMapper.toHourDto(hour);
            Pair<SnsUserDto, HourDto> pairDto = new Pair<>(snsUserDto, hourDto);
            snsUsersArrivedDto.add(pairDto);
        }
        return snsUsersArrivedDto;
    }

    /**
     * Method to transform a vaccination center list to a dto list
     * @param centers list with the centers
     * @return list with the centers dto
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static List<VaccinationCenterDto> listToDto (List<VaccinationCenter> centers){

        List<VaccinationCenterDto> centersDto = new ArrayList<>();

        for(VaccinationCenter center : centers){

            centersDto.add(VaccinationCenterMapper.centerToDto(center));

        }


        return centersDto;
    }

    /**
     * Method to transform a center into an object dto with the same information
     * @param vaccinationCenter vaccination center
     * @return vaccination center dto
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static VaccinationCenterDto centerToDto (VaccinationCenter vaccinationCenter){

        if (vaccinationCenter instanceof CommunityMassVaccinationCenter) {
            CommunityMassVaccinationCenterDto center = new CommunityMassVaccinationCenterDto(vaccinationCenter.getName(), vaccinationCenter.getAddress(), vaccinationCenter.getPhoneNumber(), vaccinationCenter.getEmail().getEmail(), vaccinationCenter.getFax(), vaccinationCenter.getWebsiteAddress()
                    , vaccinationCenter.getHours().getOpeningHour(), vaccinationCenter.getHours().getClosingHour(), vaccinationCenter.getSlot().getSlotDuration(), vaccinationCenter.getSlot().getCapacity(),
                    ((CommunityMassVaccinationCenter) vaccinationCenter).getAvaiableTypes(),vaccinationCenter.getDailyVaccinated());
            center.setCenterCoordinator(vaccinationCenter.getCenterCoordinator());

            return center;

        } else if (vaccinationCenter instanceof HealthCareCenter) {

            HealthCareCenterDto center = new HealthCareCenterDto(vaccinationCenter.getName(), vaccinationCenter.getAddress(), vaccinationCenter.getPhoneNumber(), vaccinationCenter.getEmail().getEmail(), vaccinationCenter.getFax(), vaccinationCenter.getWebsiteAddress(),vaccinationCenter.getHours().getOpeningHour()
                    , vaccinationCenter.getHours().getClosingHour(), vaccinationCenter.getSlot().getSlotDuration(), vaccinationCenter.getSlot().getCapacity(),
                    ((HealthCareCenter) vaccinationCenter).getAvaiableTypes(), CenterAssociations.getIndex(((HealthCareCenter) vaccinationCenter).getAssociatedTo()),vaccinationCenter.getDailyVaccinated());

            center.setCenterCoordinator(vaccinationCenter.getCenterCoordinator());

            return center;
        }

        throw new IllegalArgumentException("The Vaccination center should be either a Community mass Vaccination center or a Health Care center");
    }
}
