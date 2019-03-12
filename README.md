# Load tests
For first load test I choose [Web Performance](https://www.webperformance.com/)

For second load test I choose [NBA](https://nba.com)

## Tests Running
> mvn clean gatling:test 

from there you will get question about which Simulution you want to run and describe it

## Test Results
I attach 2 zip files which are results of my load tests, there you can find 
* `Global Information`
* `Assertions information` 
* `Statistics on every request type`
* `Error types`

tables with required stats

Also you can find:
 * `Active Users along the Simulation`
 * `Response Time Distribution`
 * `Response Time Percentiles over Time (OK)` 
 * `Number of requests per second`
 * `Number of responses per second`
  
  charts which should be helpful to see impact in big picture 

Both tests are checking load of main pages with css, js, image and font files from these domains. I add my asserts for Response Time and Failed Requests percentage. Other resources inside were loading from other CDNs or were static resources so they were excluded
 