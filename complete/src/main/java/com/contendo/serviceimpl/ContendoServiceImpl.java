package com.contendo.serviceimpl;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.contendo.dao.ContendoDAO;
import com.contendo.service.ContendoService;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.PasswordProfile;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ContendoServiceImpl implements ContendoService {

    @Value("client.id")
    private String clientId;
    @Value("client.secret")
    private String clientSecret;
    @Value("tenant.id")
    private String tenantId;
    private String scope = "https://graph.microsoft.com/.default"; // this is the real value instead of an exmaple value

    @Autowired
    ContendoDAO contendoDAO;

    @Override
    public void createUser() {
        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId("45401557-ee84-4e62-a9a2-fd6a92d1c2f5")
                .clientSecret("~SJ7Q~6NhKq_ICBky0nwtbWzEJEvcIuAJAhMV") //required for web apps, do not set for native apps
                .tenantId("74109ac4-691f-4d54-bd8a-f6aff63f37f3")
                .build();

        final TokenCredentialAuthProvider tokenCredentialAuthProvider = new TokenCredentialAuthProvider(Arrays.asList(scope), clientSecretCredential);

        GraphServiceClient graphClient = GraphServiceClient.builder()
                .authenticationProvider(tokenCredentialAuthProvider)
                .buildClient();

        User user = new User();
        user.accountEnabled = true;
        user.displayName = "Max Mustermann";
        user.mailNickname = "MaxMu";
        user.userPrincipalName = "hello@gmail.com"; // abc is the AD B2C name
        user.passwordPolicies = "DisablePasswordExpiration"; // optional
        PasswordProfile passwordProfile = new PasswordProfile();
        passwordProfile.forceChangePasswordNextSignIn = true; // false if the user does not need to change password
        passwordProfile.password = "xWwvJ]6NMw+bWH-d";
        user.passwordProfile = passwordProfile;

        graphClient.users()
                .buildRequest()
                .post(user);
    }

    @Override
    public void sendInvite(String senderId) {
    }
}