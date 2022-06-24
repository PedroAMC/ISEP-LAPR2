package app.domain.model.mapper.snsuser;

import app.domain.model.data.snsuser.SnsUser;
import app.domain.model.dto.snsuser.SnsUserDto;

/**
 * Class that deals with the dto objects that carry the information
 * of SNS Users
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */

public class SnsUserMapper {

    /**
     * Method to transform a dto carrying the information of a SNS User into a
     * SNS USer object
     *
     * @param dto Object that carries all the information of a SNS user
     *
     * @return SNS User
     */
    public static SnsUser toSnsUser(SnsUserDto dto){

        return new SnsUser(dto.getName(),dto.getAddress(),dto.getSex(),dto.getPhoneNumber(),dto.getEmail(),dto.getBirthDate(),dto.getSnsNumber(),dto.getCitizenCardNumber(),dto.getSmsPermission());
    }
    public static SnsUserDto toSnsUserDto(SnsUser snsUser){

        return new SnsUserDto(snsUser.getName(), snsUser.getAddress(), snsUser.getSex(), snsUser.getPhoneNumber(),snsUser.getEmail().getEmail(), snsUser.getBirthDate(), snsUser.getSnsNumber(), snsUser.getCitizenCardNumber(), snsUser.getSmsPermission());
    }
}
