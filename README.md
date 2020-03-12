# PaytmLabs SDEChallenge
## Coding Question
Algorithm is based on a storing elements in an array of size n, where n - number of last elements in array.
Implementation guaranties O(1) time complexity.
When trying to add new element to an array of size n, algorithm would replace first element in an array with
newly added element. Next added element would replace second element in an array and so on.
This behaviour is described in field "pivot" and local variable "freeSlot".
Pivot is incrementing when element added to array and circularly would start from 0 when reaching the n element.
"freeSlot" is previous slot, before pivot.

  Example: array of size 4 to calculate average value
  Step 1. Adding first value

    freeSlot  pivot
          |   |

        |___|___|___|___|
   index  0   1   2   3

   freeSlot==0, pivot==1

  Step 2. Adding 2nd value

      freeSlot     pivot
              |   |

        |___|___|___|___|
   index  0   1   2   3

   freeSlot==1, pivot==2

   Step 3. Adding 3d value

           freeSlot   pivot
                  |    |

        |___|___|___|___|
   index  0   1   2   3

   freeSlot==2, pivot==3

   Step 4. Adding 3d value

         pivot    freeSlot
          |           |

        |___|___|___|___|
   index  0   1   2   3

   freeSlot==3, pivot==0

## Design Question
There are numerous of available implementations for this task, but I would focus on the one with high scalability and go serverless.
For this task I would use Amazon Web Services products. Google Cloud Platform does have similar products as well.

High Level architecture:

Visitor Browser --> Amazon API Gateway --> AWS Lambda --> Amazon Kinesis Data Streams --> Amazon Kineses Firehose -->

--> Amazon S3 --> Amazon Athena --> Cube.js --> Analytics Browser

Description:
User Opens browser and push XHR request to API Gateway. Shortly request passed to Lambda where data is written into Kinesis Data Stream.
Kinesis Firehorse uses the Kinesis Data Stream as input and writes processed parquet files to S3.
Amazon Athena is used to query data from S3. Cube.js is used to generate SQL queries for analytics and provide API to
be available in browser. We can use React to build a UI so user can analyze dashboards and metrics.
System is able to process terabytes per hour. S3 can be used to reproduce historical data in case of bugs.