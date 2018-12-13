

// Generated by Akka gRPC. DO NOT EDIT.
package com.example.helloworld

import akka.NotUsed
import akka.Done
import akka.grpc.GrpcClientSettings
import akka.grpc.internal._
import akka.grpc.scaladsl._
import akka.stream.scaladsl.Source
import akka.stream.Materializer
import scala.concurrent.{ ExecutionContext, Future, Promise }

import io.grpc._

// Not sealed so users can extend to write their stubs
trait GreeterServiceClient extends GreeterService with GreeterServiceClientPowerApi with AkkaGrpcClient

object GreeterServiceClient {
  def apply(settings: GrpcClientSettings)(implicit mat: Materializer, ex: ExecutionContext): GreeterServiceClient =
    new DefaultGreeterServiceClient(settings)
}

final class DefaultGreeterServiceClient(settings: GrpcClientSettings)(implicit mat: Materializer, ex: ExecutionContext) extends GreeterServiceClient {
  import DefaultGreeterServiceClient._

  private val options = NettyClientUtils.callOptions(settings)
  private val clientState = new ClientState(settings)

  
    private def sayHelloRequestBuilder(channel:Future[ManagedChannel]) = {
      
        new ScalaUnaryRequestBuilder(sayHelloDescriptor, channel, options, settings)
      
    }
  
    private def sayHelloToAllRequestBuilder(channel:Future[ManagedChannel]) = {
      
        val fqName = ".GreeterService.SayHelloToAll"
        
          new ScalaBidirectionalStreamingRequestBuilder(sayHelloToAllDescriptor, fqName, channel, options, settings)
        
      
    }
  

  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer sayHello(com.example.helloworld.HelloRequest) if possible.
     */
    
      override def sayHello(): SingleResponseRequestBuilder[com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply] =
        clientState.withChannel(sayHelloRequestBuilder _)
    

    /**
     * For access to method metadata use the parameterless version of sayHello
     */
    def sayHello(in: com.example.helloworld.HelloRequest): Future[com.example.helloworld.HelloReply] =
      sayHello().invoke(in)
  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer sayHelloToAll(Source[com.example.helloworld.HelloRequest, NotUsed]) if possible.
     */
    
      override def sayHelloToAll(): StreamResponseRequestBuilder[Source[com.example.helloworld.HelloRequest, NotUsed], com.example.helloworld.HelloReply] =
        clientState.withChannel(sayHelloToAllRequestBuilder _)
    

    /**
     * For access to method metadata use the parameterless version of sayHelloToAll
     */
    def sayHelloToAll(in: Source[com.example.helloworld.HelloRequest, NotUsed]): Source[com.example.helloworld.HelloReply, NotUsed] =
      sayHelloToAll().invoke(in)
  

  override def close(): Future[Done] = clientState.close()
  override def closed(): Future[Done] = clientState.closed()

}



private object DefaultGreeterServiceClient {

  def apply(settings: GrpcClientSettings)(implicit mat: Materializer, ex: ExecutionContext): GreeterServiceClient =
    new DefaultGreeterServiceClient(settings)

  import GreeterService.Serializers._

  
    private val sayHelloDescriptor: MethodDescriptor[com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply] =
      MethodDescriptor.newBuilder()
        .setType(
   MethodDescriptor.MethodType.UNARY 
  
  
  
)
        .setFullMethodName(MethodDescriptor.generateFullMethodName(".GreeterService", "SayHello"))
        .setRequestMarshaller(new Marshaller(HelloRequestSerializer))
        .setResponseMarshaller(new Marshaller(HelloReplySerializer))
        .setSampledToLocalTracing(true)
        .build()
  
    private val sayHelloToAllDescriptor: MethodDescriptor[com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply] =
      MethodDescriptor.newBuilder()
        .setType(
  
  
  
  MethodDescriptor.MethodType.BIDI_STREAMING 
)
        .setFullMethodName(MethodDescriptor.generateFullMethodName(".GreeterService", "SayHelloToAll"))
        .setRequestMarshaller(new Marshaller(HelloRequestSerializer))
        .setResponseMarshaller(new Marshaller(HelloReplySerializer))
        .setSampledToLocalTracing(true)
        .build()
  
}

trait GreeterServiceClientPowerApi {
  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer sayHello(com.example.helloworld.HelloRequest) if possible.
     */
    
      def sayHello(): SingleResponseRequestBuilder[com.example.helloworld.HelloRequest, com.example.helloworld.HelloReply] = ???
    
  
    /**
     * Lower level "lifted" version of the method, giving access to request metadata etc.
     * prefer sayHelloToAll(Source[com.example.helloworld.HelloRequest, NotUsed]) if possible.
     */
    
      def sayHelloToAll(): StreamResponseRequestBuilder[Source[com.example.helloworld.HelloRequest, NotUsed], com.example.helloworld.HelloReply] = ???
    
  

}
