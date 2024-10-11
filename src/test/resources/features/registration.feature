Feature: Registering for to select products to cart
  I as a user want registering for to select products to cart

  @regression_registration
  Scenario Outline: Registration and ticketing sales by entering the url
    Given that login with the '<urlRegistration>'
    * that the user open the registering page
      | userRegistration   | passwordRegistration   |
      | <userRegistration> | <passwordRegistration> |
    When I fill in the whole form with the following data, selecting items from the first option
      | name_minor   | phone_number   | gender   | address   | city   | state   | zip_code   | signature_waiver   |
      | <name_minor> | <phone_number> | <gender> | <address> | <city> | <state> | <zip_code> | <signature_waiver> |
    * now choose how you want to participate
      | option_team   | team_name   | team_fundraising_goal   |
      | <option_team> | <team_name> | <team_fundraising_goal> |
    * now swag bag selection
    * would you like to buy 2 something?
    * would you like to make a donation
      | donation_value   | donation_period   | employer_match   | end_date_donation   |
      | <donation_value> | <donation_period> | <employer_match> | <end_date_donation> |
    And I fill in the payment and billing details
      | number_card   | expiry_date   | security_code   | country   | full_name_billing   | address_line_billing   | city_billing   | state_billing   | zip_code_billing   |
      | <number_card> | <expiry_date> | <security_code> | <country> | <full_name_billing> | <address_line_billing> | <city_billing> | <state_billing> | <zip_code_billing> |
    Then Payment confirmation is successful

    Examples:
      | urlRegistration                                                                                                   | userRegistration             | passwordRegistration | name_minor | phone_number | gender | address       | city   | state | zip_code | signature_waiver | option_team   | team_name     | team_fundraising_goal | donation_value | donation_period | end_date_donation | employer_match | number_card         | expiry_date | security_code | country        | full_name_billing | address_line_billing | city_billing | state_billing | zip_code_billing |
      | https://possum-kingdom-open-water-swim-4lzlpd.public-staging.colliegives.com/experience/cm1gu0wdu039n0alb8jel9br0 | kimdawn0614@gmail.com        | Gobi0501             |            | 5122332233   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kim       | Create a team | Team kimberly | 1000                  | 50             | One-Time        |                   |                | 4242 4242 4242 4242 | 10 / 25     | 123           | Estados Unidos | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | https://possum-kingdom-open-water-swim-4lzlpd.public-staging.colliegives.com/experience/cm1gu0wdu039n0alb8jel9br0 | kimberlydawn3+pgh1@gmail.com | Gobi0501             |            | 5122332233   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kim       | Create a team | Team kimberly | 1000                  | 50             | One-Time        |                   |                | 4242 4242 4242 4242 | 10 / 25     | 123           | Estados Unidos | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
