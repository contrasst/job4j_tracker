package ru.job4j.ex;

import java.util.Objects;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User needUser = null;
        for (User user : users) {
            if (Objects.equals(user.getUsername(), login)) {
                needUser = user;
                break;
            }
        }
        if (needUser == null) {
            throw new UserNotFoundException("User with login " + login + " is not found");
        }
        return needUser;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException("" + user + " is invalid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Ivan Ivanov", true),
                new User("Sasha Sidorov", true),
                new User("Will Smitt", false)
        };
        String login = "Will Smitt";
        try {
            User user = findUser(users, login);
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}