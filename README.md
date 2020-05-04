This project handles Kafka Producer and Consumer from Spring Boot. It has a command Line Runner that launches a producer and produces a message every second. The Consumer also starts up with listening on same topic. 
This demo shows
 In Advanced ,
 1) Test one is to have 2 consumers on same topic and same consumer group . it works by rebalancing partitions between the 2 consumers as expected
 2) Test 2 is to Filter the messages. In this case the offset still moves forward, just that consumer does not handle the message.
    Also, we need consumerConfig in this case, all other cases we were able to handle through properties
 3) Test 3 is to have one consumer subscribe to specifically 1 or multiple partitions and start from offsets


