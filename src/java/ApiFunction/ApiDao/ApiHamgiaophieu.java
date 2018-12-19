 
package ApiFunction.ApiDao;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

 
public class ApiHamgiaophieu {


        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://rest.dongamoneytransfer.com.vn/ServerRestKieuhoi/webresources";


    public ApiHamgiaophieu() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("hamxuly");
    }
        

        public <T> T layThongUser(Class<T> responseType, String user) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("laythongtinuser/{0}", new Object[]{user}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public void putJson(Object requestEntity) throws ClientErrorException {
            webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        }

        public String timtheodktongcn(String user, String chuoitk, String thuoctinh, String chinhanh) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("timtheodktongcn/{0}/{1}/{2}/{3}", new Object[]{user, chuoitk, thuoctinh, chinhanh}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String capnhatgiaophieu(String khoa, String chuoitk) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("capnhatgiaophieu/{0}/{1}", new Object[]{khoa, chuoitk}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String capnhatphgiaophieu(String khoa, String chuoitk) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("capnhatphgiaophieu/{0}/{1}", new Object[]{khoa, chuoitk}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String getValidateLogin(String user, String pass) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("loginkieuhoisys/{0}/{1}", new Object[]{user, pass}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String capnhatchuyenhsvehoiso(String khoa, String chuoitk) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("capnhatchuyenhsvehoiso/{0}/{1}", new Object[]{khoa, chuoitk}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String capnhatcmnd(String khoa, String chuoitk) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("capnhatcmnd/{0}/{1}", new Object[]{khoa, chuoitk}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String timkhangdktongcn(String user, String chuoitk, String thuoctinh, String chinhanh) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("timkhachhang/{0}/{1}/{2}/{3}", new Object[]{user, chuoitk, thuoctinh, chinhanh}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String capnhatxacminh(String khoa, String chuoitk) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path(java.text.MessageFormat.format("capnhatxacminh/{0}/{1}", new Object[]{khoa, chuoitk}));
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public String getJson() throws ClientErrorException {
            WebTarget resource = webTarget;
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }

        public void close() {
            client.close();
        }

        
    }
    
