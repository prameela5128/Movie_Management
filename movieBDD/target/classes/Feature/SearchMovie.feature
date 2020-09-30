Feature: search movie in movie management

@SearchMovie
Scenario: search movie using name
Given User is on search page
When User enter valid movie name
Then User get the movie details


@MovieNotAvailable
Scenario: View movie using invalid movie name
Given User is on search page
When User enter invalid movie name
Then User get the message Movie with Name Not Found.