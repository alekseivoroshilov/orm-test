package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    //private final Map<String, UserProfile> loginToProfile;
    //private final Map<String, UserProfile> sessionIdToProfile;
    private final DBService dbService;

    public AccountService(DBService dbService) {
        //loginToProfile = new HashMap<>();
        //sessionIdToProfile = new HashMap<>();
        this.dbService = dbService;
    }

    public void addNewUser(UsersDataSet userProfile) throws DBException {
        dbService.addUser(userProfile.getName(), userProfile.getPassword());
    }

    public UsersDataSet getUserByLogin(String login) throws DBException {
        return dbService.getUserByLogin(login);
    }

    /*public UsersDataSet getUserBySessionId(String sessionId) {

        return sessionIdToProfile.get(sessionId);
    }*/

    /*public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }*/
}
