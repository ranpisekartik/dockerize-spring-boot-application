This is a demo project to showing how to dockerize spring application and integrate with mongo db image.
Some important commands for reference run (run them in the below sequence)
  1. docker-compose -f mongo-docker-compose.yaml up -d
     This command is a prerequisite because for spring application to interact with mongodb, mongo image should be deployed, Hence this docker compose yaml file is describig on the details of how to deploye these images.
  2. docker build -t employee-api .
     
     This command builds the image on the basis of details dwefined in Dockerfile.
  4. docker run -d --network=dockerize-spring-boot-application_app-network -p 8080:8080 --name=employee-api-container employee-api
     This command make sure that our spring boot application actually boots up with port exposed on container as 8080 for external world and 8080 internally as well. And that the application should belong to the same network to what mongo has. So they communicate on the basis of thier conatiner names.

To run in the debug mode make sure to attach the remote debugger from intellij by adding information as below. Before proceeding for remote debugging make sure to add command for running jar in debugging mode with a debug port attached.
  1. Dockerfile run configuation
      ![image](https://github.com/user-attachments/assets/b9ba5b26-d5cd-4d2a-90e8-3eea5bb1884e)
  2. Remote debugging configruations
     ![image](https://github.com/user-attachments/assets/60091489-25d0-4cf3-b431-80037e4f64ac)


FYI, there are two ENTRYPOINT specified in the Dockerfile, the one commented is for executing the artifact on the assgined container normally, but the uncommented one is the shell command which alsi execute the artifact but also attached a break point for debugging purpose.
refer below screenshot
1. Dockerfile contents
     ![image](https://github.com/user-attachments/assets/5995c509-dc10-4535-a121-b3c3d4e376bb)
2. entrypoint.sh contents
     ![image](https://github.com/user-attachments/assets/246f940b-b59d-410d-84a2-baabbe78575d)

