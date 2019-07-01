# SlackProject
Slack Automation project


Hi,

I have implemented the 3 functionalities that were mentioned in the Coding Challenge as an Example.
1) Weather of a particular city.
2) Generate a random playing card.
3) Message to a channel when someone likes a message with emoji "Thumbsup with skintone:4"

For Weather, I have used https://openweathermap.org/api which is a public API and parsed the response in java and only displaying the temperate(in Celsius).
Also, I have hardcoded the location to US as some cities like San Jose is in multiple countries.
In order to test this functionality, try an example something like type /weather Milpitas on the slack general channel and you will be able to see the temperature in that location.

To generate a random card, I have found some images on github that were uploaded by some user. I have dumped them in S3 and used random code generator to generate both the card number as well as the Card Suit and displaying the corresponding card on the channel.


For displaying a message on the channel when someone likes a message with emoji "Thumbsup with skintone:4", I have subscribed to this event and when there is an event that matches what I am looking for then I will post a message onto general channel in the Slack.

I have deployed the project on EC2 instance which will be up and running till you evaluate the assessment.
You might experience a slight latency as the EC2 instance that I was using this project is in Virginia location.

Shared my app with all the email addresses that were mentioned to me in the document.

Steps to follow if you are running this project locally:

1) Clone this git repository.
2) Have a local tomcat server and ensure that its up and running.
3) Go to api.slack.com and change the Slash Commands, edit the Command and then change the EC2 endpoint to point to local host.
4) Do the above change for Event Subscriptions as well.

Below are some of the things that I would have done if I had more time :

1) Adding Unit tests and generating code coverage reports.
2) Pushing data on to Sonar and find Code Smells and Vulnerabilities.
3) Would have covered most of the Slack API Features (The work I have done is just a testimonial to demonstrate my understanding and knowledge on the APIs).

