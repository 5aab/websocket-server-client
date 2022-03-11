<h1>Websocket Server Client</h1>
A server client web socket application to demo connection via proxy and using Key Clock as identity server

<h1>Steps to start the application</h1>
<ol type="1">
  <li>start Identity Server by running <i>AuthorizationServerApp.java</i></li>
  <ol>
  <li>Keycloak identity server will be started at <a href="http://localhost:8083/auth">KeyClock Local URL</a> </li>
  <li>Read more details about <a href="https://medium.com/devops-dudes/securing-spring-boot-rest-apis-with-keycloak-1d760b2004e">KeyClock Server</a></li>
  <li>KeyClock <i>Realm, Client, Roles</i> are setup automatically from <i>super-realm.json</i></li>  
  <li>Go to <a href="http://localhost:8083/auth">KeyClock Local URL</a> and login using user/password : <b>super-admin/pass</b></li>
  <li>Click Users on left and Add user <I>wsauth-user</I>, set password as <I>wsauth-password</I> and assign all available roles</li>
  <li>make sure to switch off the temporary password option while resetting the password. if you missed doing that, go to details sub-tab after resetting the password and remove all <u>Required User Actions</u></li>
  <li>if you don't follow above step, user setup will not be considered complete</li>
</ol>
<li>Now start service discovery  at port <b>8888</b> by running <i>EurekaServerApplication.java</i></li>
<li>Start Gateway proxy at port <b>8760</b> by running <i>WebsocketsGatewayApplication.java</i></li>
<li>Start Zookeeper and Kafka at default port numbers. if you choose to use custom ports, you will need to update same in <u>application.yml</u> of WebSocket Server</li>
<li>Start Web-Socket Server at port <b>9090</b> by running <i>WebsocketsServerApplication.java</i></li>
<li>Now start the WebSocket Client by Running <i>StompClient.java</i></li>

<h1>Conclusion</h1>
You will be able to see server and clients exchanging messages over web sockets bi-directionally in client's logs
</ol>

