package org.example.conroller;

import lombok.Getter;
import lombok.Setter;
import org.example.container.ComponentContainer;
import org.example.entity.Profile;
import org.example.service.BookService;
import org.example.service.ProfileService;
import org.example.util.GetAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Setter

public class MainController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private BookService bookService;
    public void start(){
        boolean t=true;
        while (t){
            show();
            switch (GetAction.getAction()){

                case 1->bookList();
                case 2->search();
                case 3->login();
                case 4->registration();
                case 0 ->t=false;
            }
        }
    }
//sdfd
    private void bookList() {
//        1. BookList  -> id, title, author, category
        bookService.bookList();
    }

    private void search() {
    }

    public void login() {
        System.out.println("Enter your login: ");
        String login= ComponentContainer.stringScanner.nextLine();
        System.out.println("Enter your password");
        String password=ComponentContainer.stringScanner.nextLine();
        profileService.login(login, password);
    }

    private void registration() {
        System.out.println("Enter your name: ");
        String name= ComponentContainer.stringScanner.nextLine();
        System.out.println("Enter your surname:");
        String surname= ComponentContainer.stringScanner.nextLine();
        System.out.println("Enter your phone:");
        String phone= ComponentContainer.stringScanner.nextLine();
        System.out.println("Enter your login:");
        String login= ComponentContainer.stringScanner.nextLine();
        System.out.println("Enter your password:");
        String password= ComponentContainer.stringScanner.nextLine();


        Profile profile= new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setPhone(phone);
        profile.setLogin(login);
        profile.setPassword(password);

        profileService.register(profile);
    }


    public void show(){
        System.out.println("**MENU**");
        System.out.println("1. Book List.");
        System.out.println("2. Search->");
        System.out.println("3. Login");
        System.out.println("4. Registration");
        System.out.println("0. Exit.");

    }
}
