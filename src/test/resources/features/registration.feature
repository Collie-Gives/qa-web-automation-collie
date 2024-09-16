Feature: Registering for to select products to cart
  I as a user want registering for to select products to cart

  @regression
  Scenario Outline: Registration and ticketing selecting a campaign
    Given that login with the following credentials '<userLogin>'
    * selecting the campaign '<select_campaign_name>' and experience '<select_experience_name>' for registration and ticketing
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
    And I fill in the payment and billing details
      | number_card   | expiry_date   | security_code   | country   | full_name_billing   | address_line_billing   | city_billing   | state_billing   | zip_code_billing   |
      | <number_card> | <expiry_date> | <security_code> | <country> | <full_name_billing> | <address_line_billing> | <city_billing> | <state_billing> | <zip_code_billing> |
    #Then Payment confirmation is successful

    Examples:
      | userLogin | userRegistration      | passwordRegistration | select_campaign_name | select_experience_name | name_minor | phone_number | gender | address     | city  | state   | zip_code | signature_waiver | option_team             | team_name | team_fundraising_goal | number_card         | expiry_date | security_code | country  | full_name_billing | address_line_billing | city_billing | state_billing | zip_code_billing |
      | USER_ERIK | kimdawn0614@gmail.com | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 | Jacob Cook | 5122332233   | Female | 123 Main St | Miami | Florida | 33101    | waiver agudelo   | Continue without a team |           |                       | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| USER_ERIK | kimberlydawn3+adamwoods@gmail.com  | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 2142142142   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Create a team           | Team Name Test | 3000                  | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| USER_ERIK | kimberlydawn3+andrecoyle@gmail.com | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 2142142142   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Join a team             | Team Woods     | 1000                  | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| USER_ERIK | kimdawn0614@gmail.com              | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 5122332233   | Female | 123 Main St   | Austin | Texas | 78731    | waiver kimdawn0614              | Join a team             | Join a team    |                       | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |


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
    And I fill in the payment and billing details
      | number_card   | expiry_date   | security_code   | country   | full_name_billing   | address_line_billing   | city_billing   | state_billing   | zip_code_billing   |
      | <number_card> | <expiry_date> | <security_code> | <country> | <full_name_billing> | <address_line_billing> | <city_billing> | <state_billing> | <zip_code_billing> |
    #Then Payment confirmation is successful

    Examples:
      | urlRegistration | userRegistration       | passwordRegistration | select_campaign_name | select_experience_name | name_minor | phone_number | gender | address             | city   | state | zip_code | signature_waiver   | option_team             | team_name | team_fundraising_goal | number_card         | expiry_date | security_code | country  | full_name_billing | address_line_billing | city_billing | state_billing | zip_code_billing |
      #| URL_REGISTER    | agudelo.0312@gmail.com | Sebastian18+         | Ciclada Silletera    | Ciclada Silletera 2024 |            | 5122332233   | Male   | Calle 75 sur 53 148 | Austin | Texas | 78731    | waiver kimdawn0614 | Continue without a team |           |                       | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      | URL_REGISTER    | kimdawn0614@gmail.com | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 | Jacob Cook | 5122332233   | Female | 123 Main St | Austin | Texas | 78731    | waiver kimdawn0614 | Continue without a team |           |                       | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| URL_REGISTER | kimberlydawn3+adamwoods@gmail.com  | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 2142142142   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Create a team           | Team Name Test | 3000                  | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| URL_REGISTER | kimberlydawn3+andrecoyle@gmail.com | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 2142142142   | Male   | 587 North Ave | Austin | Texas | 78731    | waiver kimberlydawn3+andrecoyle | Join a team             | Team Woods     | 1000                  | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
      #| URL_REGISTER | kimdawn0614@gmail.com              | Gobi0501             | Ciclada Silletera    | Ciclada Silletera 2024 |            | 5122332233   | Female | 123 Main St   | Austin | Texas | 78731    | waiver kimdawn0614              | Join a team             | Join a team    |                       | 4242 4242 4242 4242 | 10 / 25     | 123           | Colombia | Allan Pacheco     | 1395 Brickell        | Miami        | Florida       | 33101            |
