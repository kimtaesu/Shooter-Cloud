package com.hucet.user_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseInitializer {


//    @Autowired
//    MongoTemplate mongoTemplate;

    @Transactional
    public void populate() {
        // Clear existing data

//        repository.save(new UserEvent(1, "test1.com", "hostgator1.com"));
//        repository.save(new UserEvent(2, "test2.com", "hostgator2.com"));
//        repository.save(new UserEvent(3, "test3.com", "hostgator1.com"));
//        repository.save(new UserEvent(2, "test4.com", "hostgator2.com"));
//        repository.save(new UserEvent(5, "test5.com", "hostgator1.com"));
//        repository.save(new UserEvent(2, "test6.com", "hostgator2.com"));
//        repository.save(new UserEvent(7, "test7.com", "hostgator7.com"));

//        Aggregation agg = newAggregation(
//                match(Criteria.where("_id").lt(5)),
//                group("hosting").count().as("total"),
//                project("total").and("hosting").previousOperation(),
//                sort(Sort.Direction.DESC, "total")
//        );
//
////        Convert the aggregation result into a List
//        AggregationResults<HostingCount> groupResults
//                = mongoTemplate.aggregate(agg, UserEvent.class, HostingCount.class);
//        List<HostingCount> result = groupResults.getMappedResults();

//        repository.save(new UserEvent((long) 2, UserEventType.LOGIN));
    }
}
