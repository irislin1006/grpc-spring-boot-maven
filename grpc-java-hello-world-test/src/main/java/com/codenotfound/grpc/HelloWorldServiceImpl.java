package com.codenotfound.grpc;

import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codenotfound.grpc.helloworld.Greeting;
import com.codenotfound.grpc.helloworld.Sentence;
import com.codenotfound.grpc.helloworld.HelloWorldServiceGrpc;
import com.codenotfound.grpc.helloworld.Person;
import io.grpc.stub.StreamObserver;

@GRpcService
public class HelloWorldServiceImpl
    extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(HelloWorldServiceImpl.class);

  @Override
  public void sayHello(Person request,
      StreamObserver<Greeting> responseObserver) {
    LOGGER.info("server received {}", request);

    String message = "Hello " + request.getFirstName() + " "
        + request.getLastName() + "!";
    Greeting greeting =
        Greeting.newBuilder().setMessage(message).build();
    LOGGER.info("server responded {}", greeting);

    //return the Greeting
    responseObserver.onNext(greeting);
    //tell gRPC that we’ve finished writing responses
    responseObserver.onCompleted();
  }

  @Override
  public void palindrome(Sentence request,
      StreamObserver<Greeting> responseObserver) {
    LOGGER.info("server received {}", request);

    //System.out.println("DEBUG", request.getMessage().getClass());
    String message = new StringBuilder(request.getMessage()).reverse().toString();
    //"Hello " + request.getFirstName() + " " + request.getLastName() + "!";
    Greeting greeting =
        Greeting.newBuilder().setMessage(message).build();
    LOGGER.info("server responded {}", greeting);

    //return the Greeting
    responseObserver.onNext(greeting);
    //tell gRPC that we’ve finished writing responses
    responseObserver.onCompleted();
  }
}
