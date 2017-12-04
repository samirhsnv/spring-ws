package com.example;

import com.samirhasanov.spring.ws.config.WsConfig;
import com.samirhasanov.spring.ws.domain.GetUsersResponse;
import com.samirhasanov.spring.ws.domain.User;
import java.util.List;
import javax.xml.transform.Source;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.test.client.MockWebServiceServer;
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;
import org.springframework.xml.transform.StringSource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {WsConfig.class, WsTestConfig.class})
@ActiveProfiles("test")
@SpringBootTest
public class BasicApplicationTests {
        private MockWebServiceServer mockWebServiceServer;
    
        @Autowired
        private UserClient client;
        
        @Before
        public void init() {
            this.mockWebServiceServer = MockWebServiceServer.createServer(client);
        }
        
	@Test
	public void testGetUsers() {
            Source requestPayload = new StringSource(
                "<dom:GetUsersRequest xmlns:dom=\"http://samirhasanov.com/spring/ws/domain\" />");

            Source responsePayload = new StringSource(
                    "<ns2:GetUsersResponse xmlns:ns2=\"http://samirhasanov.com/spring/ws/domain\">" +
                    "         <ns2:User>" +
                    "            <ns2:id>1</ns2:id>" +
                    "            <ns2:fullname>Samir Hasanov</ns2:fullname>" +
                    "            <ns2:age>28</ns2:age>" +
                    "         </ns2:User>" +
                    "         <ns2:User>" +
                    "            <ns2:id>2</ns2:id>" +
                    "            <ns2:fullname>Murad Rzayev</ns2:fullname>" +
                    "            <ns2:age>28</ns2:age>" +
                    "         </ns2:User>" +
                    "      </ns2:GetUsersResponse>");

            mockWebServiceServer
                    .expect(payload(requestPayload))
                    .andRespond(withPayload(responsePayload));
            
            GetUsersResponse response = client.getUsers();
            assertNotNull(response);

            List<User> list = response.getUser();
            assertEquals(2, list.size());
	}

}
