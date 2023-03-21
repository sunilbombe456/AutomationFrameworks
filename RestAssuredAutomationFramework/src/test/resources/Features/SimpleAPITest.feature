Feature: Validation Place API's

#Scenario: Verify if place is being successfully added using AddPlaceAPI
#Given Add Place Payload
#When users calls "AddPlaceAPI" with post htttp request
#Then the API call got success with status code 200
#And "status" in response body is "OK"


@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When users calls "AppPlaceAPI" with "post" http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_id  created maps to "<name>" using "getPlaceAPI"

Examples:
|name   |language| address		   |
|AAhouse| English|Word cross center|
|BBhouse| Spanish|Pune Word cross center|


@deletePlace
Scenario: Verify if Delete place functionality is working
Given DeletePlace Payload
When users calls "deletePlaceAPI" with "post" http request
Then the API call got success with status code 200
#And "status" in response body is "OK"