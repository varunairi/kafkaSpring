This project handles Kafka Producer and Consumer from Spring Boot. It has a command Line Runner that launches a producer and produces a message every second. The Consumer also starts up with listening on same topic. 
This demo shows 
  the Producer Configuration through Beans that set up a Producer Factory and Kafka Template . It also can inject multiple "NewTopic" objects corresponding to all the topics that you'd want to "auto create" or join if they are created. 
   the Producer, which injects KafkaTemplate and sends messages (its threadsafe by Spring)
   
   The Consumer Configuration that sets up a Listener for 1 or more topics, and sets up consumber group ID as well to handle multiple partitions.
   
There are examples in Branch "PropertyConfigs" to push some of the configs over to properties file

and "Advanced" which shows some of the more complex examples

