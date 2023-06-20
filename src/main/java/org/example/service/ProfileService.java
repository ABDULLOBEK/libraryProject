package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.conroller.AdminController;
import org.example.conroller.MainController;
import org.example.conroller.StudentController;
import org.example.container.ComponentContainer;
import org.example.entity.Book;
import org.example.entity.Profile;
import org.example.enums.ProfileRole;
import org.example.enums.ProfileStatus;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Getter
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private Profile profileObj;
    @Autowired
    private StudentController studentController;
    @Autowired
    private AdminController adminController;
    public void login(String login, String password) {
        Profile profile= profileRepository.login(login, password);
        if(profile==null){
            System.out.println("login or password is incorrect!");
            return;

        }else if(profile.getStatus().equals(ProfileStatus.BLOCK)){
            System.out.println("your account is blocked!");
        }else {
            System.out.println("you have logged in successfully!");
            profileObj=profile;
            if(profile.getRole().equals(ProfileRole.STUDENT)){
                studentController.start();
                System.out.println("Welcome user");
            }else {
                adminController.start();
                System.out.println("Welcome admin");
            }
        }

    }

    public void register(Profile profile) {
        String phone= profile.getPhone();
        if(phone.length()<12){
            System.out.println("Enter valid phone number");
            return;
        } else if (!phone.startsWith("998")) {
            System.out.println("Enter valid phone number");
            return;
        } else if (profileRepository.getProfileByPhone(profile.getPhone())!=null) {
            System.out.println("This phone is already registered");
            return;
        } else if ( profileRepository.getProfileByLogin(profile.getLogin())!=null) {
            System.out.println("This login is already taken");
            return;
        }

        profile.setCratedDate(LocalDate.now());
        profile.setRole(ProfileRole.STUDENT);
        profile.setStatus(ProfileStatus.ACTIVE);
        boolean result= profileRepository.addProfile(profile);
        if(result){
            System.out.println("you have successfully registered");
            System.out.println("Login to your account!");
            MainController mainController= new MainController();
            mainController.login();
        }else {
            System.out.println("Something went wrong");
            MainController mainController= new MainController();
            mainController.start();
        }
    }


}
