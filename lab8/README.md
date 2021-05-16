## lab8 - Continuous Integration with Jenkins

Starting by creating a simple Job, that builds the maven project from the `lab1/P2Euromillions` and scheduling a build as it can be seen on the next images:

![image1](./images/image1.png)

![image2](./images/image2.png)

The build was successful, shown by the following logs of the Job ran: 

![image3](./images/image3.png)

After building manually this pipeline, now a pipeline will be scheduled to be ran every 15 minutes, with the help of a `Jenkinsfile`, that tests maven and java installation:

![image4](./images/image5.png)

The Build was successful has we may seen:

![image6](./images/image6.png)

Nextly, the pipeline was updated to allow not only the testing of java and maven, but also testing the Maven Project:

![image7](./images/image7.png)

![image8](./images/image8.png)

I had some issues concerning this pipeline, due to missing permission from jenkins to access the files, and therefore in the next image it will be possible to see failed jobs from this pipeline:

![image9](./images/image9.png)

After this, a new test with the intent of failed was added so that we could check a pipeline failing, due to failing tests:

![image10](./images/image10.png)

Which as we can see, it has failed:

![image11](/home/danielgomes/Desktop/TQS/PraticalTQS/lab8/images/image11.png)

After installing the Blue Ocean plugin on Jenkins, the dashboard contains also the preview done pipelines, on the endpoint `/blue`:

![image12](./images/image12.png)

The following image shows the process of creation of the Dashboard, when running Jenkins - Blue Ocean with Docker:

![image13](./images/image13.png)

The first pipeline on the repository has failed since the Jenkinsfile created was not using the Docker agent, which has been fixed:

![image14](./images/image14.png)

![image14](./images/image15.png)

Finally, the pipeline on Docker has been successfully ran:

![image16](./images/image16.png)