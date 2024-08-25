package com.example.userservice.core.handler;

import com.example.components.usercontract.UserInsertRoleRequest;
import com.example.components.usercontract.UserRequest;
import com.example.components.usercontract.UserView;
import org.springframework.stereotype.Component;

@Component
public class UserControllerHandler {
    private final DeleteUserByIdHandler deleteUserByIdHandler;
    private final FindUserByIdHandler findUserByIdHandler;
    private final InsertUserRoleHandler insertUserRoleHandler;
    private final SaveUserHandler saveUserHandler;

    public UserControllerHandler(DeleteUserByIdHandler deleteUserByIdHandler,
                                 FindUserByIdHandler findUserByIdHandler,
                                 InsertUserRoleHandler insertUserRoleHandler,
                                 SaveUserHandler saveUserHandler){
        this.deleteUserByIdHandler = deleteUserByIdHandler;
        this.findUserByIdHandler = findUserByIdHandler;
        this.insertUserRoleHandler = insertUserRoleHandler;
        this.saveUserHandler = saveUserHandler;
    }

    public UserView save(UserRequest req) {
        return saveUserHandler.handle(req);
    }

    public UserView findById(Integer id) {
        return findUserByIdHandler.handle(id);
    }

    public UserView insertUserRole(Integer userId, UserInsertRoleRequest req) {
        return insertUserRoleHandler.handle(userId, req);
    }
    public void deleteById(Integer bookId) {
        deleteUserByIdHandler.handle(bookId);
    }
}
