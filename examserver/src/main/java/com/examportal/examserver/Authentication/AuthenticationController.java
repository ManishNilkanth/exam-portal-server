package com.examportal.examserver.Authentication;


import com.examportal.examserver.Model.Role;
import com.examportal.examserver.Model.User;
import com.examportal.examserver.Model.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  //create user
  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthenticationResponse createUser(@RequestBody User user) throws Exception {
    Role role = new Role();
    role.setRoleId(10L);
    role.setRoleName("NORMAL");

    UserRole userRole = new UserRole();
    userRole.setUser(user);
    userRole.setRole(role);

    Set<UserRole> roles = new HashSet<>();
    roles.add(userRole);

    return authenticationService.createUser(user,roles);
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    authenticationService.refreshToken(request, response);
  }

  @PatchMapping("/change-password")
  public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
  ) {
    authenticationService.changePassword(request, connectedUser);
    return ResponseEntity.ok().build();
  }


}
