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
    #Then Payment confirmation is successful

    Examples:
      | urlRegistration | userRegistration                   | passwordRegistration | name_minor | phone_number | gender | address             | city   | state | zip_code | signature_waiver                | option_team             | team_name      | team_fundraising_goal | donation_value | donation_period | end_date_donation | employer_match | number_card         | expiry_date | security_code | country        | full_name_billing | address_line_billing | city_billing | state_billing | zip_code_billing |
      #| URL_REGISTER    | agudelo.0312@gmail.com             | Sebastian18+         |            | 5122332233   | Male   | Calle 75 sur 53 148 | Austin | Texas | 78731    | Erik Agudelo                    | Continue without a team |                |                       | 50             | One-Time        |                   | Duke Energy    | 4242 4242 4242 4242 | 10 / 25     | 123           | Estados Unidos | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | URL_REGISTER    | kimdawn0614@gmail.com              | Gobi0501             | Jacob Cook | 5122332233   | Female | 123 Main St         | Austin | Texas | 78731    | waiver kimdawn0614              | Continue without a team |                |                       | 75             | Monthly         |                   | Duke Energy    | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia       | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | URL_REGISTER    | kimberlydawn3+adamwoods@gmail.com  | Gobi0501             |            | 2142142142   | Male   | 587 North Ave       | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Create a team           | Team Name Test | 3000                  | 100            | Quarterly       |                   |                | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia       | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | URL_REGISTER    | kimberlydawn3+andrecoyle@gmail.com | Gobi0501             |            | 2142142142   | Male   | 587 North Ave       | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Join a team             | Team Woods     | 1000                  | 150            | Semi-Annually   |                   |                | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia       | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | URL_REGISTER    | kimdawn0614@gmail.com              | Gobi0501             |            | 5122332233   | Female | 123 Main St         | Austin | Texas | 78731    | waiver kimdawn0614              | Join a team             | Join a team    |                       | 500            | Annually        | 01/17/2025        |                | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia       | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
