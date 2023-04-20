package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {
    private String baseApiUrl;
    private AuthenticatedUser currentUser;
    private RestTemplate restTemplate;
    private String authToken;

    public void setCurrentUser(AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
    }

    public TransferService(String baseApiUrl, AuthenticatedUser currentUser) {
        this.baseApiUrl = baseApiUrl;
        this.currentUser = currentUser;
        this.restTemplate = new RestTemplate();
    }

    public AuthenticatedUser getCurrentUser() {
        return currentUser;
    }

    public void setAuthToken (String authToken) {
        this.authToken = authToken;
    }

    public User[] listUsers(){
        ResponseEntity<User[]> response = restTemplate.exchange(baseApiUrl + "transfer/users", HttpMethod.GET, getAuthEntity(), User[].class);
        return response.getBody();
    }

    public boolean postNewTransfer(int transferTo, BigDecimal transferAmount){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        Transfer transfer = new Transfer(0,2,2,convertUserIdToAccountId(currentUser.getUser().getId()), convertUserIdToAccountId(transferTo), transferAmount);
        HttpEntity<Transfer> entityForGet = new HttpEntity<>(transfer, headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(baseApiUrl+ "transfer/send", HttpMethod.POST,entityForGet, Boolean.class);
        return response.getBody();
    }

    public int convertUserIdToAccountId(int id){
        ResponseEntity<Integer> response = restTemplate.exchange(baseApiUrl+"account/"+id,HttpMethod.GET, getAuthEntity(), Integer.class);
        return response.getBody();
    }

    public Transfer[] displayListOfTransfers(){
        ResponseEntity<Transfer[]> response = restTemplate.exchange(baseApiUrl+"/transfer/list", HttpMethod.GET, getAuthEntity(), Transfer[].class);
        return response.getBody();
    }

    public String getUserName(int id){
        ResponseEntity<User> response = restTemplate.exchange(baseApiUrl+"transfer/getuser/"+id,HttpMethod.GET, getAuthEntity(),User.class);
        return response.getBody().getUsername();
    }

    public Transfer getTransferById(int id){
        ResponseEntity<Transfer> response = restTemplate.exchange(baseApiUrl+"transfer/"+id, HttpMethod.GET, getAuthEntity(), Transfer.class);
        return response.getBody();
    }

    public HttpEntity<Void> getAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }
}
