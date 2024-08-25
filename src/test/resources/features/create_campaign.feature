Feature: Create campaign in colliegives.com application

  @smoke
  Scenario Outline: Create a successful draft campaign
    Given that login with the following credentials '<user>'
    When create a new campaign with the following data
      | city   | state   | star_date   | end_date   | fundraising   | attendees   | teams   |
      | <city> | <state> | <star_date> | <end_date> | <fundraising> | <attendees> | <teams> |
    #Then verify that the campaign has been created successfully

    Examples:
      | user      | city  | state   | star_date  | end_date   | fundraising | attendees | teams |
      | USER_ERIK | Miami | Florida | 09/10/2024 | 09/20/2024 | 100         | 20        | 5     |